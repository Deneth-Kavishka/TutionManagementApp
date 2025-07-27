package com.project.tuitionmanagementapp.teacher

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.firestore.FirebaseFirestore
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult
import com.project.tuitionmanagementapp.R
import java.text.SimpleDateFormat
import java.util.*

class QRAttendanceActivity : AppCompatActivity() {

    private lateinit var btnBack: ImageView
    private lateinit var recyclerAttendance: RecyclerView
    private lateinit var auth: FirebaseAuth
    private lateinit var firestore: FirebaseFirestore
    private lateinit var database: FirebaseDatabase

    private val attendanceList = mutableListOf<AttendanceRecord>()
    private lateinit var attendanceAdapter: AttendanceAdapter

    data class AttendanceRecord(
        val studentId: String = "",
        val studentName: String = "",
        val timestamp: String = "",
        val status: String = "Present"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qr_scanner)

        // Initialize Firebase
        auth = FirebaseAuth.getInstance()
        firestore = FirebaseFirestore.getInstance()
        database = FirebaseDatabase.getInstance()

        initViews()
        setupRecyclerView()
        setupClickListeners()

        // Start scanner automatically
        startQRScanner()
    }

    private fun initViews() {
        btnBack = findViewById(R.id.btnBack)

        // Add RecyclerView to scan results
        // Note: This is not in the current layout, but we'll handle it gracefully
        recyclerAttendance = findViewById<RecyclerView>(R.id.recyclerAttendance)?.apply {
            layoutManager = LinearLayoutManager(this@QRAttendanceActivity)
        } ?: RecyclerView(this).apply {
            layoutManager = LinearLayoutManager(this@QRAttendanceActivity)
        }

        // Setup toolbar
        supportActionBar?.title = "QR Attendance Scanner"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setupRecyclerView() {
        attendanceAdapter = AttendanceAdapter(attendanceList)
        recyclerAttendance.adapter = attendanceAdapter
    }

    private fun setupClickListeners() {
        btnBack.setOnClickListener {
            finish()
        }
    }

    private fun startQRScanner() {
        val integrator = IntentIntegrator(this)
        integrator.setPrompt("Scan Student QR Code for Attendance")
        integrator.setBeepEnabled(true)
        integrator.setOrientationLocked(true)
        integrator.captureActivity = CaptureActivityPortrait::class.java
        integrator.initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result: IntentResult? = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)

        if (result != null) {
            if (result.contents == null) {
                Toast.makeText(this, "Scan cancelled", Toast.LENGTH_SHORT).show()
            } else {
                val studentId = result.contents.trim()
                processScannedStudentId(studentId)
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    private fun processScannedStudentId(studentId: String) {
        // Check if student already marked present today
        if (isStudentAlreadyMarked(studentId)) {
            Toast.makeText(this, "Student already marked present today", Toast.LENGTH_SHORT).show()
            return
        }

        // Fetch student details
        firestore.collection("students")
            .document(studentId)
            .get()
            .addOnSuccessListener { document ->
                if (document.exists()) {
                    val studentName = document.getString("name") ?: "Unknown Student"
                    markAttendance(studentId, studentName)
                } else {
                    Toast.makeText(this, "Student not found", Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener {
                Toast.makeText(this, "Failed to fetch student details", Toast.LENGTH_SHORT).show()
            }
    }

    private fun isStudentAlreadyMarked(studentId: String): Boolean {
        return attendanceList.any { it.studentId == studentId }
    }

    private fun markAttendance(studentId: String, studentName: String) {
        val timestamp = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date())

        val attendanceRecord = AttendanceRecord(
            studentId = studentId,
            studentName = studentName,
            timestamp = timestamp
        )

        // Add to local list
        attendanceList.add(attendanceRecord)
        attendanceAdapter.notifyDataSetChanged()

        // Save to Firebase
        val attendanceMap = HashMap<String, Any>()
        attendanceMap["studentId"] = studentId
        attendanceMap["studentName"] = studentName
        attendanceMap["timestamp"] = timestamp
        attendanceMap["status"] = "Present"

        firestore.collection("attendance")
            .add(attendanceMap)
            .addOnSuccessListener {
                Toast.makeText(this, "Attendance marked: $studentName", Toast.LENGTH_SHORT).show()
                // Start scanner again for the next student
                startQRScanner()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Failed to mark attendance", Toast.LENGTH_SHORT).show()
            }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
