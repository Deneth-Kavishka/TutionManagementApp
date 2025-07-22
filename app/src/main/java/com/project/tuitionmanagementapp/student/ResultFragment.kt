package com.project.tuitionmanagementapp.student

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.database.FirebaseDatabase
import com.project.tuitionmanagementapp.R

class ResultActivity : AppCompatActivity() {

    private lateinit var resultRecyclerView: RecyclerView
    private lateinit var resultList: ArrayList<StudentResult>
    private lateinit var adapter: ResultAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_result_student)

        resultRecyclerView = findViewById(R.id.recyclerViewResults)
        resultRecyclerView.layoutManager = LinearLayoutManager(this)

        resultList = arrayListOf()
        adapter = ResultAdapter(resultList)
        resultRecyclerView.adapter = adapter

        val studentId = "S001" // TODO: Make dynamic based on login
        loadResultsFromFirebase(studentId)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.selectedItemId = R.id.nav_home // fallback default

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, StudentDashboardActivity::class.java))
                    overridePendingTransition(0, 0)
                    true
                }
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
    }

    private fun loadResultsFromFirebase(studentId: String) {
        val dbRef = FirebaseDatabase.getInstance().getReference("results").child(studentId)

        dbRef.get().addOnSuccessListener { snapshot ->
            resultList.clear()
            for (record in snapshot.children) {
                val result = record.getValue(StudentResult::class.java)
                result?.let { resultList.add(it) }
            }
            adapter.notifyDataSetChanged()
        }.addOnFailureListener {
            Toast.makeText(this, "Failed to load results", Toast.LENGTH_SHORT).show()
        }
    }
}
