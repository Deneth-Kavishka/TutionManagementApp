package com.example.tuitionapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.project.tuitionmanagementapp.R
import com.project.tuitionmanagementapp.parent.FeesStatusActivity
import com.project.tuitionmanagementapp.parent.LoginActivity
import com.project.tuitionmanagementapp.parent.ParentHomeActivity

class ParentDashboardActivity : AppCompatActivity() {

    // Views
    private lateinit var tvParentName: TextView
    private lateinit var tvMathMarks: TextView
    private lateinit var tvMathStatus: TextView
    private lateinit var tvScienceMarks: TextView
    private lateinit var tvScienceStatus: TextView
    private lateinit var tvEnglishMarks: TextView
    private lateinit var tvEnglishStatus: TextView

    private lateinit var navHome: ImageView
    private lateinit var navResult: ImageView
    private lateinit var navFees: ImageView
    private lateinit var navLogout: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_shoresult_parent) // Make sure this XML file exists

        // Initialize views
        tvParentName = findViewById(R.id.tvParentName)
        tvMathMarks = findViewById(R.id.tvMathMarks)
        tvMathStatus = findViewById(R.id.tvMathStatus)
        tvScienceMarks = findViewById(R.id.tvScienceMarks)
        tvScienceStatus = findViewById(R.id.tvScienceStatus)
        tvEnglishMarks = findViewById(R.id.tvEnglishMarks)
        tvEnglishStatus = findViewById(R.id.tvEnglishStatus)

        navHome = findViewById(R.id.nav_home)
        navResult = findViewById(R.id.nav_result)
        navFees = findViewById(R.id.nav_fees)
        navLogout = findViewById(R.id.nav_logout)

        // Set static parent name
        tvParentName.text = "Welcome, Mrs. Nethra"

        // Load sample result data
        loadResults()

        // Setup bottom navigation actions
        setupBottomNavigation()
    }

    private fun loadResults() {
        // Math
        tvMathMarks.text = "85%"
        tvMathStatus.text = "↑ Increased"
        tvMathStatus.setTextColor(ContextCompat.getColor(this, android.R.color.holo_green_dark))

        // Science
        tvScienceMarks.text = "55%"
        tvScienceStatus.text = "↓ Decreased"
        tvScienceStatus.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_dark))

        // English
        tvEnglishMarks.text = "70%"
        tvEnglishStatus.text = "→ No Change"
        tvEnglishStatus.setTextColor(ContextCompat.getColor(this, android.R.color.darker_gray))
    }

    private fun setupBottomNavigation() {
        navHome.setOnClickListener {
            startActivity(Intent(this, ParentHomeActivity::class.java))
        }

        navResult.setOnClickListener {
            // You are already here or show message
        }

        navFees.setOnClickListener {
            startActivity(Intent(this, FeesStatusActivity::class.java))
        }

        navLogout.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}
