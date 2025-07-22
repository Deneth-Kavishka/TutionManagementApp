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

        val attendanceCard = findViewById<LinearLayout>(R.id.attendence1)
        attendanceCard.setOnClickListener {
            startActivity(Intent(this, AttendanceActivity::class.java))
        }

        val assignmentsCard = findViewById<LinearLayout>(R.id.assignments1)
        assignmentsCard.setOnClickListener {
            startActivity(Intent(this, AssignmentActivity::class.java))
        }

        val resultsCard = findViewById<LinearLayout>(R.id.results1)
        resultsCard.setOnClickListener {
            startActivity(Intent(this, ResultActivity::class.java))
        }

        val materialsCard = findViewById<LinearLayout>(R.id.materials1)
        materialsCard.setOnClickListener {
            startActivity(Intent(this, MaterialActivity::class.java))
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.selectedItemId = R.id.nav_home

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> true
                R.id.nav_attendance -> {
                    startActivity(Intent(this, AttendanceActivity::class.java))
                    finish()
                    overridePendingTransition(0, 0)
                    true
                }
                R.id.nav_assignments -> {
                    startActivity(Intent(this, AssignmentActivity::class.java))
                    finish()
                    overridePendingTransition(0, 0)
                    true
                }
                R.id.nav_profile -> {
                    startActivity(Intent(this, ProfileActivity::class.java))
                    finish()
                    overridePendingTransition(0, 0)
                    true
                }
                else -> false
            }
        }
    }
}
