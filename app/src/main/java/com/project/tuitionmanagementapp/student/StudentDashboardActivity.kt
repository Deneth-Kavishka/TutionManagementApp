// StudentDashboardActivity.kt
package com.project.tuitionmanagementapp.student

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.project.tuitionmanagementapp.R

class StudentDashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_dashboard)

        // Find the bottom navigation view
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.selectedItemId = R.id.nav_home

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> true
                R.id.nav_attendance -> {
                    startActivity(Intent(this, AttendanceActivity::class.java))
                    overridePendingTransition(0, 0)
                    true
                }
                R.id.nav_assignments -> {
                    startActivity(Intent(this, AssignmentActivity::class.java))
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

        // Set up dashboard card click listeners
        findViewById<LinearLayout>(R.id.attendance_card)?.setOnClickListener {
            startActivity(Intent(this, AttendanceActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.assignments_card)?.setOnClickListener {
            startActivity(Intent(this, AssignmentActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.profile_card)?.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }
}
