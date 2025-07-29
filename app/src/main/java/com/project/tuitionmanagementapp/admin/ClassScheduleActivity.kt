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
                    val schedule = document.toObject(ClassSchedule::class.java)
                    schedule.id = document.id
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
        val dialog = android.app.AlertDialog.Builder(this, R.style.Theme_MaterialComponents_DayNight_Dialog)
