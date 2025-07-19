package com.project.tuitionmanagementapp


import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.project.tuitionmanagementapp.R
import com.project.tuitionmanagementapp.parent.FeeStatusActivity
import com.project.tuitionmanagementapp.parent.LoginActivity
import com.project.tuitionmanagementapp.parent.ResultActivity


class ParentPortalActivity : AppCompatActivity() {

    // UI references
    private lateinit var tvAttendance: TextView
    private lateinit var tvResults: TextView
    private lateinit var tvFees: TextView
    private lateinit var tvEvent1: TextView
    private lateinit var tvEvent2: TextView

    private lateinit var logoutIcon: ImageView
    private lateinit var resultIcon: ImageView
    private lateinit var feesIcon: ImageView

    // Firebase reference
    private lateinit var database: DatabaseReference
    private val currentStudentId = "student123" // 🔁 Replace with actual user or student ID

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_parent_portal)

        // Bind Views
        tvAttendance = findViewById(R.id.tvAttendance)
        tvResults = findViewById(R.id.tvResults)
        tvFees = findViewById(R.id.tvFees)
        tvEvent1 = findViewById(R.id.tvEvent1)
        tvEvent2 = findViewById(R.id.tvEvent2)

        logoutIcon = findViewById(R.id.nav_logout)
        resultIcon = findViewById(R.id.nav_result) // 💡 You'll need to give result icon an id
        feesIcon = findViewById(R.id.nav_fees)     // 💡 You'll need to give fee icon an id

        // Connect to Firebase
        database = FirebaseDatabase.getInstance().getReference("students").child(currentStudentId)

        // Load data from Firebase
        loadDashboardData()

        // Handle navigation
        logoutIcon.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        resultIcon.setOnClickListener {
            startActivity(Intent(this, ResultActivity::class.java))
        }

        feesIcon.setOnClickListener {
            startActivity(Intent(this, FeeStatusActivity::class.java))
        }
    }

    private fun loadDashboardData() {
        database.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                // Load values from Firebase
                val attendance = snapshot.child("attendance").getValue(String::class.java)
                val results = snapshot.child("results").getValue(String::class.java)
                val fees = snapshot.child("fees").getValue(String::class.java)
                val event1 = snapshot.child("event1").getValue(String::class.java)
                val event2 = snapshot.child("event2").getValue(String::class.java)

                // Display on screen
                tvAttendance.text = attendance ?: "No attendance data"
                tvResults.text = results ?: "No results data"
                tvFees.text = fees ?: "No fee data"
                tvEvent1.text = event1 ?: "No upcoming event"
                tvEvent2.text = event2 ?: ""
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@ParentPortalActivity, "Failed to load data", Toast.LENGTH_SHORT).show()
            }
        })
    }
}


