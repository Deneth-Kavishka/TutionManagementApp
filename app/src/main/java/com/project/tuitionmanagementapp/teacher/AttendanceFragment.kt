package com.project.tuitionmanagementapp.teacher

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.zxing.integration.android.IntentIntegrator
import com.project.tuitionmanagementapp.R
import com.google.firebase.database.*
import java.text.SimpleDateFormat
import java.util.*


class AttendanceActivity : AppCompatActivity() {
    private lateinit var btnScanQr: Button
    private lateinit var recyclerAttendance: RecyclerView
    private val attendanceList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_attendance_teacher)

        btnScanQr = findViewById(R.id.btnScanQr)
        recyclerAttendance = findViewById(R.id.recyclerAttendance)

        // Recycler setup
        recyclerAttendance.layoutManager = LinearLayoutManager(this)
        recyclerAttendance.adapter = AttendanceAdapter(attendanceList)

        btnScanQr.setOnClickListener {
            startQRScanner()
        }
    }

    private fun startQRScanner() {
        val integrator = IntentIntegrator(this)
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
        integrator.setPrompt("Scan student QR code")
        integrator.setBeepEnabled(true)
        integrator.setOrientationLocked(true)
        integrator.captureActivity = CaptureActivityPortrait::class.java
        integrator.initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) {
                Toast.makeText(this, "Scan cancelled", Toast.LENGTH_SHORT).show()
            } else {
                val studentId = result.contents.trim()
                fetchStudentDetailsAndMarkAttendance(studentId)
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    private fun fetchStudentDetailsAndMarkAttendance(studentId: String) {
        val studentRef = FirebaseDatabase.getInstance().getReference("students").child(studentId)

        studentRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    val name = snapshot.child("name").getValue(String::class.java) ?: "Unknown"
                    val timestamp = SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.getDefault()).format(Date())
                    val status = "Present"

                    val record = "$studentId - $name - $status at $timestamp"
                    attendanceList.add(record)
                    recyclerAttendance.adapter?.notifyItemInserted(attendanceList.size - 1)

                    Toast.makeText(this@AttendanceActivity, "Marked Present: $name", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@AttendanceActivity, "Student not found in DB", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@AttendanceActivity, "Error fetching student", Toast.LENGTH_SHORT).show()
            }
        })
    }

}
