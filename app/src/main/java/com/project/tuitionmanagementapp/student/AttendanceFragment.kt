package com.example.studentapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

// Data class for Attendance
data class Attendance(
    val date: String = "",
    val subject: String = "",
    val status: String = ""  // Example: "Present" or "Absent"
)

class AttendanceActivity : AppCompatActivity() {

    private lateinit var attendanceList: ArrayList<Attendance>
    private lateinit var adapter: AttendanceAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_attendance_student)

        // RecyclerView setup
        recyclerView = findViewById(R.id.attendanceRecyclerView)
        attendanceList = arrayListOf()
        adapter = AttendanceAdapter(attendanceList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // Load sample attendance data
        loadSampleAttendance()

        // Setup BottomNavigationView
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.selectedItemId = R.id.nav_attendance

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    overridePendingTransition(0, 0)
                    true
                }
                R.id.nav_attendance -> true // You're already here
                R.id.nav_assignments -> {
                    startActivity(Intent(this, Assignments::class.java))
                    overridePendingTransition(0, 0)
                    true
                }

                else -> false
            }
        }
    }

    private fun loadSampleAttendance() {
        attendanceList.add(Attendance("2025-07-12", "Mathematics", "Present"))
        attendanceList.add(Attendance("2025-07-13", "Science", "Absent"))
        attendanceList.add(Attendance("2025-07-14", "English", "Present"))
        adapter.notifyDataSetChanged()
    }
}
