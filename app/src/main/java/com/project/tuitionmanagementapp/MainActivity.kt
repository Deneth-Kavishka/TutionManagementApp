package com.example.studentapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dashboardButton = findViewById<Button>(R.id.btnGoToDashboard)

        dashboardButton.setOnClickListener {
            val intent = Intent(this, StudentDashboardActivity::class.java)
            startActivity(intent)
        }
    }
}
