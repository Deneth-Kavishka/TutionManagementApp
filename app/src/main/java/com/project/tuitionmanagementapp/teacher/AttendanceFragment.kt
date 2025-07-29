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
            // Navigate to QR Attendance Activity instead of scanning in fragment
            startActivity(Intent(requireContext(), QRAttendanceActivity::class.java))
        }

        // Load attendance records when fragment is created
        loadAttendanceRecords()

        return view
    }

    private fun loadAttendanceRecords() {
        val firestore = FirebaseFirestore.getInstance()
        val today = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())

        // Get current teacher's attendance records for today
        firestore.collection("attendance")
            .whereEqualTo("date", today)
            .get()
            .addOnSuccessListener { documents ->
                attendanceRecords.clear()
                for (document in documents) {
                    val record = AttendanceRecord(
                        studentId = document.getString("studentId") ?: "",
                        studentName = document.getString("studentName") ?: "",
                        timestamp = document.getString("timestamp") ?: "",
                        status = document.getString("status") ?: "Present"
                    )
                    attendanceRecords.add(record)
                }
                // Sort by timestamp (newest first)
                attendanceRecords.sortByDescending { it.timestamp }

                // Create new adapter with updated data
                adapter = FragmentAttendanceAdapter(attendanceRecords)
                recyclerAttendance.adapter = adapter

                if (attendanceRecords.isEmpty()) {
                    Toast.makeText(requireContext(), "No attendance records for today", Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener { exception ->
                Toast.makeText(requireContext(), "Failed to load attendance: ${exception.message}", Toast.LENGTH_SHORT).show()
            }
    }

    override fun onResume() {
        super.onResume()
        // Reload attendance records when returning to fragment
        loadAttendanceRecords()
    }
}
