// AttendanceActivity.kt
package com.project.tuitionmanagementapp.student

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.database.FirebaseDatabase
import com.project.tuitionmanagementapp.MainActivity
import com.project.tuitionmanagementapp.R

class AttendanceActivity : AppCompatActivity() {

    private lateinit var attendanceList: ArrayList<Attendance>
    private lateinit var adapter: AttendanceAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_attendance_student)

        recyclerView = findViewById(R.id.rvAttendance)
        attendanceList = arrayListOf()
        adapter = AttendanceAdapter(attendanceList)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val studentId = "S001" // TODO: Replace with actual student ID from login
        loadAttendanceFromFirebase(studentId)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.selectedItemId = R.id.nav_attendance

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, StudentDashboardActivity::class.java))
                    overridePendingTransition(0, 0)
                    true
                }
                R.id.nav_attendance -> true // You're already in this activity
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

    }

    private fun loadAttendanceFromFirebase(studentId: String) {
        val dbRef = FirebaseDatabase.getInstance().getReference("attendance").child(studentId)

        dbRef.get().addOnSuccessListener { snapshot ->
            attendanceList.clear()
            for (record in snapshot.children) {
                val attendance = record.getValue(Attendance::class.java)
                attendance?.let { attendanceList.add(it) }
            }
            adapter.notifyDataSetChanged()
        }.addOnFailureListener {
            Toast.makeText(this, "Failed to load attendance", Toast.LENGTH_SHORT).show()
        }
    }
}