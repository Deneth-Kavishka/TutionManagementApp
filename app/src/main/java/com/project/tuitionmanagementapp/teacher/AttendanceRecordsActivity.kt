package com.project.tuitionmanagementapp.teacher

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.project.tuitionmanagementapp.R
import java.text.SimpleDateFormat
import java.util.*

class AttendanceRecordsActivity : AppCompatActivity() {

    private lateinit var btnBack: ImageView
    private lateinit var tvTitle: TextView
    private lateinit var tvSubtitle: TextView
    private lateinit var recyclerAttendance: RecyclerView
    private lateinit var bottomNavigation: BottomNavigationView

    private lateinit var auth: FirebaseAuth
    private lateinit var firestore: FirebaseFirestore

    private val attendanceDatesList = mutableListOf<AttendanceDateRecord>()
    private lateinit var attendanceDatesAdapter: AttendanceDatesAdapter

    private val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    private val displayDateFormat = SimpleDateFormat("EEEE, MMMM dd, yyyy", Locale.getDefault())

    data class AttendanceDateRecord(
        val date: String,
        val displayDate: String,
        val totalStudents: Int,
        val presentCount: Int,
        val lateCount: Int,
        val paidCount: Int,
        val pendingPayments: Int
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attendance_records)

        // Initialize Firebase
        auth = FirebaseAuth.getInstance()
        firestore = FirebaseFirestore.getInstance()

        initViews()
        setupRecyclerView()
        setupClickListeners()
        loadAttendanceHistory()
    }

    private fun initViews() {
        btnBack = findViewById(R.id.btnBack)
        tvTitle = findViewById(R.id.tvTitle)
        tvSubtitle = findViewById(R.id.tvSubtitle)
        recyclerAttendance = findViewById(R.id.recyclerAttendance)
        bottomNavigation = findViewById(R.id.bottomNavigation)

        // Set titles for main screen
        tvTitle.text = "Attendance History"
        tvSubtitle.text = "Select a date to view detailed attendance records"
    }

    private fun setupRecyclerView() {
        attendanceDatesAdapter = AttendanceDatesAdapter(attendanceDatesList) { dateRecord ->
            // Navigate to detailed view for the selected date
            try {
                val intent = Intent(this@AttendanceRecordsActivity, AttendanceDetailActivity::class.java)
                intent.putExtra("selected_date", dateRecord.date)
                intent.putExtra("display_date", dateRecord.displayDate)
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this@AttendanceRecordsActivity, "Error opening details: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
        recyclerAttendance.layoutManager = LinearLayoutManager(this)
        recyclerAttendance.adapter = attendanceDatesAdapter
    }

    private fun setupClickListeners() {
        btnBack.setOnClickListener {
            finish()
        }

        // Setup bottom navigation
        bottomNavigation.selectedItemId = R.id.nav_home
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    finish()
                    true
                }
                R.id.nav_assignment -> {
                    Toast.makeText(this, "Assignments", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_materials -> {
                    Toast.makeText(this, "Materials", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_result -> {
                    Toast.makeText(this, "Results", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_qr -> {
                    startActivity(Intent(this, QRAttendanceActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }

    private fun loadAttendanceHistory() {
        val teacherId = auth.currentUser?.uid ?: return

        // Show loading state
        tvSubtitle.text = "Loading attendance history..."

        firestore.collection("attendance")
            .whereEqualTo("teacherId", teacherId)
            .get()
            .addOnSuccessListener { documents ->
                val attendanceByDate = mutableMapOf<String, MutableList<QRAttendanceActivity.AttendanceRecord>>()

                // Group attendance records by date
                for (document in documents) {
                    val date = document.getString("date") ?: continue
                    val record = QRAttendanceActivity.AttendanceRecord(
                        studentId = document.getString("studentId") ?: "",
                        studentName = document.getString("studentName") ?: "",
                        timestamp = document.getString("timestamp") ?: "",
                        status = document.getString("status") ?: "Present",
                        paymentStatus = document.getString("paymentStatus") ?: "",
                        pendingAmount = document.getDouble("pendingAmount") ?: 0.0
                    )

                    if (!attendanceByDate.containsKey(date)) {
                        attendanceByDate[date] = mutableListOf()
                    }
                    attendanceByDate[date]?.add(record)
                }

                // Convert to date records with statistics
                attendanceDatesList.clear()
                for ((date, records) in attendanceByDate) {
                    val totalStudents = records.size
                    val presentCount = records.count { it.status == "Present" }
                    val lateCount = records.count { it.status == "Late" }
                    val paidCount = records.count { it.paymentStatus == "PAID" }
                    val pendingPayments = records.count {
                        it.paymentStatus == "PENDING" || it.paymentStatus == "OVERDUE"
                    }

                    val displayDate = try {
                        val parsedDate = dateFormat.parse(date)
                        parsedDate?.let { displayDateFormat.format(it) } ?: date
                    } catch (e: Exception) {
                        date
                    }

                    attendanceDatesList.add(AttendanceDateRecord(
                        date = date,
                        displayDate = displayDate,
                        totalStudents = totalStudents,
                        presentCount = presentCount,
                        lateCount = lateCount,
                        paidCount = paidCount,
                        pendingPayments = pendingPayments
                    ))
                }

                // Sort by date (newest first)
                attendanceDatesList.sortByDescending { it.date }
                attendanceDatesAdapter.notifyDataSetChanged()

                // Update subtitle
                tvSubtitle.text = if (attendanceDatesList.isEmpty()) {
                    "No attendance records found. Start taking attendance to see history."
                } else {
                    "Found ${attendanceDatesList.size} days with attendance records"
                }
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this, "Failed to load attendance history: ${exception.message}", Toast.LENGTH_SHORT).show()
                tvSubtitle.text = "Error loading attendance history"
            }
    }
}
