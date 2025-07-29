package com.project.tuitionmanagementapp.teacher

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.project.tuitionmanagementapp.R
import android.content.Intent

class CalendarActivity : AppCompatActivity() {

    private lateinit var bottomNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calender)

        initViews()
        setupBottomNavigation()
    }

    private fun initViews() {
        bottomNavigation = findViewById(R.id.bottomNavigation)

        // Back button
        findViewById<ImageView>(R.id.backButton)?.setOnClickListener {
            finish()
        }
    }

    private fun setupBottomNavigation() {
        bottomNavigation.selectedItemId = R.id.nav_home // No specific calendar tab, so keep home selected
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, TeacherDashboardActivity::class.java))
                    finish()
                    true
                }
                R.id.nav_assignment -> {
                    startActivity(Intent(this, AssignmentActivity::class.java))
                    finish()
                    true
                }
                R.id.nav_materials -> {
                    startActivity(Intent(this, TeacherMaterialsManagementActivity::class.java))
                    finish()
                    true
                }
                R.id.nav_result -> {
                    startActivity(Intent(this, UploadResultActivity::class.java))
                    finish()
                    true
                }
                R.id.nav_qr -> {
                    startActivity(Intent(this, QRAttendanceActivity::class.java))
                    finish()
                    true
                }
                else -> false
            }
        }
    }
}
