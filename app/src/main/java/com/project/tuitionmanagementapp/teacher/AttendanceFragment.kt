package com.project.tuitionmanagementapp.teacher

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.zxing.integration.android.IntentIntegrator
import com.project.tuitionmanagementapp.R
import com.google.firebase.database.*
import com.google.firebase.firestore.FirebaseFirestore
import java.text.SimpleDateFormat
import java.util.*

class AttendanceFragment : Fragment() {
    private lateinit var btnScanQr: Button
    private lateinit var recyclerAttendance: RecyclerView
    private val attendanceRecords = mutableListOf<AttendanceRecord>()
    private lateinit var adapter: FragmentAttendanceAdapter

    data class AttendanceRecord(
        val studentId: String = "",
        val studentName: String = "",
        val timestamp: String = "",
        val status: String = "Present"
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_attendance_teacher, container, false)

        btnScanQr = view.findViewById(R.id.btnScanQr)
        recyclerAttendance = view.findViewById(R.id.recyclerAttendance)

        // Set up RecyclerView with the fragment's own adapter
        adapter = FragmentAttendanceAdapter(attendanceRecords)
        recyclerAttendance.layoutManager = LinearLayoutManager(requireContext())
        recyclerAttendance.adapter = adapter

        btnScanQr.setOnClickListener {
            // Initialize QR scanner
            val integrator = IntentIntegrator.forSupportFragment(this)
            integrator.setPrompt("Scan student QR code")
            integrator.setBeepEnabled(true)
            integrator.setOrientationLocked(true)
            integrator.captureActivity = CaptureActivityPortrait::class.java
            integrator.initiateScan()
        }

        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) {
                Toast.makeText(requireContext(), "Scan cancelled", Toast.LENGTH_SHORT).show()
            } else {
                val studentId = result.contents.trim()
                fetchStudentDetailsAndMarkAttendance(studentId)
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    private fun fetchStudentDetailsAndMarkAttendance(studentId: String) {
        // Get the Firestore instance
        val firestore = FirebaseFirestore.getInstance()

        // Fetch student details
        firestore.collection("students")
            .document(studentId)
            .get()
            .addOnSuccessListener { document ->
                if (document.exists()) {
                    val studentName = document.getString("name") ?: "Unknown Student"
                    markAttendance(studentId, studentName)
                } else {
                    Toast.makeText(requireContext(), "Student not found", Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener {
                Toast.makeText(requireContext(), "Failed to fetch student details", Toast.LENGTH_SHORT).show()
            }
    }

    private fun markAttendance(studentId: String, studentName: String) {
        val timestamp = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date())

        // Create attendance record
        val record = AttendanceRecord(
            studentId = studentId,
            studentName = studentName,
            timestamp = timestamp
        )

        // Add to local list and update adapter
        attendanceRecords.add(record)
        adapter.notifyDataSetChanged()

        // Save to Firestore
        val firestore = FirebaseFirestore.getInstance()
        val attendanceMap = HashMap<String, Any>()
        attendanceMap["studentId"] = studentId
        attendanceMap["studentName"] = studentName
        attendanceMap["timestamp"] = timestamp
        attendanceMap["status"] = "Present"

        firestore.collection("attendance")
            .add(attendanceMap)
            .addOnSuccessListener {
                Toast.makeText(requireContext(), "Attendance marked: $studentName", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(requireContext(), "Failed to mark attendance", Toast.LENGTH_SHORT).show()
            }
    }
}
