package com.project.tuitionmanagementapp.admin

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.project.tuitionmanagementapp.fragments.*
import com.project.tuitionmanagementapp.models.*
import com.project.tuitionmanagementapp.repository.*
import com.project.tuitionmanagementapp.R

class StudentDetailsActivity : AppCompatActivity() {

    private lateinit var btnBack: ImageView
    private lateinit var btnEdit: ImageView
    private lateinit var btnPayment: ImageView  // Added Payment button
    private lateinit var imgStudentPhoto: ImageView
    private lateinit var tvStudentName: TextView
    private lateinit var tvStudentId: TextView
    private lateinit var tvStudentClass: TextView
    private lateinit var tvAttendanceRate: TextView
    private lateinit var tvPaymentStatus: TextView
    private lateinit var imgPaymentStatus: ImageView
    private lateinit var tvGradeAverage: TextView
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2

    private var student: Student? = null
    private var studentId: String? = null
    private var scannedFromQR: Boolean = false

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details_admin)

        getIntentData()
        initializeViews()
        setupClickListeners()
        loadStudentData()
        setupTabs()
    }

    private fun getIntentData() {
        studentId = intent.getStringExtra("student_id")
        scannedFromQR = intent.getBooleanExtra("scanned_from_qr", false)

        if (studentId == null) {
            Toast.makeText(this, "Invalid student ID", Toast.LENGTH_SHORT).show()
            finish()
            return
        }
    }

    private fun initializeViews() {
        btnBack = findViewById(R.id.btnBack)
        btnEdit = findViewById(R.id.btnEdit)
        btnPayment = findViewById(R.id.btnPayment)  // Initialize Payment button
        imgStudentPhoto = findViewById(R.id.imgStudentPhoto)
        tvStudentName = findViewById(R.id.tvStudentName)
        tvStudentId = findViewById(R.id.tvStudentId)
        tvStudentClass = findViewById(R.id.tvStudentClass)
        tvAttendanceRate = findViewById(R.id.tvAttendanceRate)
        tvPaymentStatus = findViewById(R.id.tvPaymentStatus)
        imgPaymentStatus = findViewById(R.id.imgPaymentStatus)
        tvGradeAverage = findViewById(R.id.tvGradeAverage)
        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)
    }

    private fun setupClickListeners() {
        btnBack.setOnClickListener {
            finish()
        }

        btnEdit.setOnClickListener {
            // Navigate to edit student activity
            // startActivity(Intent(this, EditStudentActivity::class.java).apply {
            //     putExtra("student_id", studentId)
            // })
            Toast.makeText(this, "Edit functionality to be implemented", Toast.LENGTH_SHORT).show()
        }

        btnPayment.setOnClickListener {
            // Navigate to payment activity
            val intent = Intent(this, StudentPaymentActivity::class.java)
            intent.putExtra("student_id", studentId)
            startActivity(intent)
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun loadStudentData() {
        // In a real app, this would fetch from database/API
        student = StudentRepository.getStudentById(studentId!!)

        if (student == null) {
            Toast.makeText(this, "Student not found", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        updateUI()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun updateUI() {
        student?.let { student ->
            tvStudentName.text = student.fullName
            tvStudentId.text = "ID: ${student.studentId}"
            tvStudentClass.text = student.currentGrade
            // Use placeholder values for properties that don't exist yet
            tvAttendanceRate.text = "95%" // Default attendance rate
            tvGradeAverage.text = "B+" // Default grade average

            // Update payment status with default values
            tvPaymentStatus.text = "Paid"
            tvPaymentStatus.setTextColor(getColor(R.color.colorSuccess))
            imgPaymentStatus.setImageResource(R.drawable.ic_payment_success)
            imgPaymentStatus.setColorFilter(getColor(R.color.colorSuccess))

            // Load student photo if available
            if (student.profileImageUrl.isNotEmpty()) {
                // Use image loading library like Glide or Picasso
                // Glide.with(this).load(student.profileImageUrl).into(imgStudentPhoto)
            }

            if (scannedFromQR) {
                Toast.makeText(this, "Student details loaded from QR scan", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupTabs() {
        val adapter = StudentDetailsPagerAdapter(this)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Details"
                1 -> "Payments"
                2 -> "Attendance"
                3 -> "Classes"
                4 -> "Results"
                else -> "Tab ${position + 1}"
            }
        }.attach()
    }

    private inner class StudentDetailsPagerAdapter(activity: AppCompatActivity) :
        FragmentStateAdapter(activity) {

        override fun getItemCount(): Int = 5

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> StudentDetailsFragment.newInstance(studentId!!)
                1 -> StudentPaymentsFragment.newInstance(studentId!!)
                2 -> StudentAttendanceFragment.newInstance(studentId!!)
                3 -> StudentClassesFragment.newInstance(studentId!!)
                4 -> StudentResultsFragment.newInstance(studentId!!)
                else -> StudentDetailsFragment.newInstance(studentId!!)
            }
        }
    }
}