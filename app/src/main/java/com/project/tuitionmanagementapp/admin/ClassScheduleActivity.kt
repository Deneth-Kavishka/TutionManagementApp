package com.project.tuitionmanagementapp.admin

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.firestore.FirebaseFirestore
import com.project.tuitionmanagementapp.R
import java.text.SimpleDateFormat
import java.util.*

class ClassScheduleActivity : AppCompatActivity() {

    private lateinit var calendarView: CalendarView
    private lateinit var recyclerView: RecyclerView
    private lateinit var fabAddClass: FloatingActionButton
    private lateinit var adapter: ScheduleAdapter
    private lateinit var firestore: FirebaseFirestore
    private lateinit var notificationHelper: NotificationHelper
    private var selectedDate: Long = System.currentTimeMillis()
    private val scheduleList = ArrayList<ClassSchedule>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_schedule)

        notificationHelper = NotificationHelper(this)
        initializeViews()
        setupCalendar()
        setupRecyclerView()
        loadScheduleForDate(selectedDate)

        // Back button
        findViewById<ImageView>(R.id.backButton).setOnClickListener {
            finish()
        }

        // Add class button
        fabAddClass.setOnClickListener {
            showAddClassDialog()
        }
    }

    private fun initializeViews() {
        firestore = FirebaseFirestore.getInstance()
        calendarView = findViewById(R.id.calendarView)
        recyclerView = findViewById(R.id.rvSchedule)
        fabAddClass = findViewById(R.id.fabAddClass)
    }

    private fun setupCalendar() {
        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val calendar = Calendar.getInstance()
            calendar.set(year, month, dayOfMonth)
            selectedDate = calendar.timeInMillis
            loadScheduleForDate(selectedDate)
        }
    }

    private fun setupRecyclerView() {
        adapter = ScheduleAdapter(
            schedules = scheduleList,
            onEdit = { schedule -> showEditClassDialog(schedule) },
            onDelete = { schedule -> deleteSchedule(schedule) },
            onAttendance = { schedule -> showAttendanceSheet(schedule) }
        )
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun loadScheduleForDate(date: Long) {
        val startOfDay = getStartOfDay(date)
        val endOfDay = getEndOfDay(date)

        firestore.collection("class_schedules")
            .whereGreaterThanOrEqualTo("startTime", startOfDay)
            .whereLessThanOrEqualTo("startTime", endOfDay)
            .get()
            .addOnSuccessListener { documents ->
                scheduleList.clear()
                for (document in documents) {
                    val schedule = document.toObject(ClassSchedule::class.java).apply {
                        id = document.id
                    }
                    scheduleList.add(schedule)
                }
                scheduleList.sortBy { it.startTime }
                adapter.notifyDataSetChanged()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Failed to load schedule", Toast.LENGTH_SHORT).show()
            }
    }

    private fun showAddClassDialog() {
        val dialog = ClassScheduleDialog(this, selectedDate) { schedule ->
            saveSchedule(schedule)
        }
        dialog.show()
    }

    private fun showEditClassDialog(schedule: ClassSchedule) {
        val dialog = ClassScheduleDialog(this, selectedDate, schedule) { updatedSchedule ->
            saveSchedule(updatedSchedule)
        }
        dialog.show()
    }

    private fun saveSchedule(schedule: ClassSchedule) {
        val scheduleMap = hashMapOf(
            "className" to schedule.className,
            "teacherName" to schedule.teacherName,
            "startTime" to schedule.startTime,
            "endTime" to schedule.endTime,
            "roomNumber" to schedule.roomNumber,
            "recurring" to schedule.recurring,
            "notificationEnabled" to schedule.notificationEnabled
        )

        val collection = firestore.collection("class_schedules")
        val task = if (schedule.id != null) {
            collection.document(schedule.id!!).set(scheduleMap)
        } else {
            collection.add(scheduleMap)
        }

        task.addOnSuccessListener {
            Toast.makeText(this, "Schedule saved successfully", Toast.LENGTH_SHORT).show()
            if (schedule.notificationEnabled) {
                notificationHelper.scheduleClassNotification(schedule)
            }
            loadScheduleForDate(selectedDate)
        }.addOnFailureListener {
            Toast.makeText(this, "Failed to save schedule", Toast.LENGTH_SHORT).show()
        }
    }

    private fun deleteSchedule(schedule: ClassSchedule) {
        schedule.id?.let { id ->
            firestore.collection("class_schedules")
                .document(id)
                .delete()
                .addOnSuccessListener {
                    Toast.makeText(this, "Schedule deleted successfully", Toast.LENGTH_SHORT).show()
                    loadScheduleForDate(selectedDate)
                }
                .addOnFailureListener {
                    Toast.makeText(this, "Failed to delete schedule", Toast.LENGTH_SHORT).show()
                }
        }
    }

    private fun showAttendanceSheet(schedule: ClassSchedule) {
        val dialog = android.app.AlertDialog.Builder(this)
            .setView(R.layout.dialog_attendance_sheet)
            .create()

        dialog.show()

        // Initialize dialog views
        val className = dialog.findViewById<TextView>(R.id.tvClassName)
        val date = dialog.findViewById<TextView>(R.id.tvDate)
        val time = dialog.findViewById<TextView>(R.id.tvTime)
        val recyclerView = dialog.findViewById<RecyclerView>(R.id.rvStudents)
        val btnMarkAllPresent = dialog.findViewById<Button>(R.id.btnMarkAllPresent)
        val btnMarkAllAbsent = dialog.findViewById<Button>(R.id.btnMarkAllAbsent)
        val btnSave = dialog.findViewById<Button>(R.id.btnSave)

        // Set class info
        className?.text = schedule.className
        date?.text = SimpleDateFormat("MMMM dd, yyyy", Locale.getDefault())
            .format(Date(schedule.startTime))
        time?.text = "${SimpleDateFormat("hh:mm a", Locale.getDefault())
            .format(Date(schedule.startTime))} - ${SimpleDateFormat("hh:mm a", Locale.getDefault())
            .format(Date(schedule.endTime))}"

        // Load students and setup adapter
        val attendanceRecords = ArrayList<AttendanceRecord>()
        firestore.collection("students")
            .whereEqualTo("class", schedule.className)
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    val studentId = document.id
                    val studentName = document.getString("name") ?: "Unknown"
                    attendanceRecords.add(
                        AttendanceRecord(
                            classScheduleId = schedule.id ?: "",
                            className = schedule.className,
                            studentId = studentId,
                            studentName = studentName
                        )
                    )
                }

                val adapter = AttendanceAdapter(attendanceRecords) { studentId, status ->
                    // Update status in the list
                    attendanceRecords.find { it.studentId == studentId }?.let { record ->
                        record.status = status
                    }
                }
                recyclerView?.adapter = adapter
                recyclerView?.layoutManager = LinearLayoutManager(this)

                // Setup mark all buttons
                btnMarkAllPresent?.setOnClickListener {
                    adapter.markAllAs("present")
                }
                btnMarkAllAbsent?.setOnClickListener {
                    adapter.markAllAs("absent")
                }
            }

        // Save attendance
        btnSave?.setOnClickListener {
            saveAttendanceRecords(attendanceRecords, dialog)
        }
    }

    private fun saveAttendanceRecords(records: List<AttendanceRecord>, dialog: android.app.AlertDialog) {
        val batch = firestore.batch()

        records.forEach { record ->
            val docRef = firestore.collection("attendance").document()
            batch.set(docRef, record)
        }

        batch.commit()
            .addOnSuccessListener {
                Toast.makeText(this, "Attendance saved successfully", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Failed to save attendance", Toast.LENGTH_SHORT).show()
            }
    }

    private fun getStartOfDay(timestamp: Long): Long {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = timestamp
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        return calendar.timeInMillis
    }

    private fun getEndOfDay(timestamp: Long): Long {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = timestamp
        calendar.set(Calendar.HOUR_OF_DAY, 23)
        calendar.set(Calendar.MINUTE, 59)
        calendar.set(Calendar.SECOND, 59)
        return calendar.timeInMillis
    }
}
