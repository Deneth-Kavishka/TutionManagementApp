package com.project.tuitionmanagementapp.admin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.project.tuitionmanagementapp.R

class AdminAccountActivity : AppCompatActivity() {

    private lateinit var btnAddStudent: Button
    private lateinit var btnAddTeacher: Button
    private lateinit var btnManageClassCategories: Button
    private lateinit var btnViewAllStudents: Button
    private lateinit var btnViewAllTeachers: Button
    private lateinit var cvStudentCard: CardView
    private lateinit var cvTeacherCard: CardView
    private lateinit var tvStudentCount: TextView
    private lateinit var tvTeacherCount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_account)

        initializeViews()
        setupClickListeners()
        loadCounts()
    }

    private fun initializeViews() {
        btnAddStudent = findViewById(R.id.btnAddStudent)
        btnAddTeacher = findViewById(R.id.btnAddTeacher)
        btnManageClassCategories = findViewById(R.id.btnManageClassCategories)
        btnViewAllStudents = findViewById(R.id.btnViewAllStudents)
        btnViewAllTeachers = findViewById(R.id.btnViewAllTeachers)
        cvStudentCard = findViewById(R.id.cvStudentCard)
        cvTeacherCard = findViewById(R.id.cvTeacherCard)
        tvStudentCount = findViewById(R.id.tvStudentCount)
        tvTeacherCount = findViewById(R.id.tvTeacherCount)
    }

    private fun setupClickListeners() {
        btnAddStudent.setOnClickListener {
            val intent = Intent(this, AddStudentActivity::class.java)
            startActivity(intent)
        }

        btnAddTeacher.setOnClickListener {
            val intent = Intent(this, AddTeacherActivity::class.java)
            startActivity(intent)
        }

        btnManageClassCategories.setOnClickListener {
            val intent = Intent(this, ManageClassCategoriesActivity::class.java)
            startActivity(intent)
        }

        btnViewAllStudents.setOnClickListener {
            // Navigate to all students activity
            // val intent = Intent(this, AllStudentsActivity::class.java)
            // startActivity(intent)
        }

        btnViewAllTeachers.setOnClickListener {
            // Navigate to all teachers activity
            // val intent = Intent(this, AllTeachersActivity::class.java)
            // startActivity(intent)
        }

        cvStudentCard.setOnClickListener {
            btnViewAllStudents.performClick()
        }

        cvTeacherCard.setOnClickListener {
            btnViewAllTeachers.performClick()
        }
    }

    private fun loadCounts() {
        // Load student and teacher counts from Firestore
        // This will be updated with real data when Firebase is fully integrated
        tvStudentCount.text = "Loading..."
        tvTeacherCount.text = "Loading..."
    }

    override fun onResume() {
        super.onResume()
        loadCounts()
    }
}
