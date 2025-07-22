package com.project.tuitionmanagementapp.student

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.project.tuitionmanagementapp.R

class AssignmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_assignmet)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Assignments"

        val studentId = intent.getStringExtra("studentId") ?: "S001"

        val fragment = AssignmentsFragment().apply {
            arguments = Bundle().apply {
                putString("studentId", studentId)
            }
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.assignment_fragment_container, fragment)
            .commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
