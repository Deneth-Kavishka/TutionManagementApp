package com.project.TuitionManagementApp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.project.tuitionmanagementapp.student.StudentDashboardActivity
import com.project.tuitionmanagementapp.R
import com.project.tuitionmanagementapp.ParentPortalActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val dashboardButton = findViewById<Button>(R.id.btnGoToDashboard)

        dashboardButton.setOnClickListener {
            val intent = Intent(this, StudentDashboardActivity::class.java)

        val btnGo = findViewById<Button>(R.id.btnGo)

        btnGo.setOnClickListener {
            // Navigate to ParentPortalActivity
            val intent = Intent(this, ParentPortalActivity::class.java)

            startActivity(intent)
        }
    }
}
