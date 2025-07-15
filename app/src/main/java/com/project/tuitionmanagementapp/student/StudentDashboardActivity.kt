package com.example.studentapplication

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class StudentDashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_dashboard)

        // Attendance card click
        val attendanceCard = findViewById<LinearLayout>(R.id.attendence1)
        attendanceCard.setOnClickListener {
            val intent = Intent(this, AttendanceActivity::class.java)
            startActivity(intent)
        }

        // Assignments card click (optional: if you have a card in layout)
        val assignmentsCard = findViewById<LinearLayout>(R.id.assignments1)
        assignmentsCard?.setOnClickListener {
            val intent = Intent(this, Assignments::class.java)
            startActivity(intent)
        }

        // Bottom Navigation setup
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.selectedItemId = R.id.nav_home

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> true // Already here

                R.id.nav_attendance -> {
                    startActivity(Intent(this, AttendanceActivity::class.java))
                    overridePendingTransition(0, 0)
                    true
                }

                R.id.nav_assignments -> {
                    startActivity(Intent(this, Assignments::class.java))
                    overridePendingTransition(0, 0)
                    true
                }

                R.id.nav_profile -> {
                    startActivity(Intent(this, ProfileActivity::class.java))
                    overridePendingTransition(0, 0)
                    true
                }

                else -> false
            }
        }
    }
}
