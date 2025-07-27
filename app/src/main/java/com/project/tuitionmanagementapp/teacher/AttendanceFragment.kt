package com.project.tuitionmanagementapp.teacher

import android.app.Activity
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
import java.text.SimpleDateFormat
import java.util.*

class AttendanceFragment : Fragment() {
    private lateinit var btnScanQr: Button
    private lateinit var recyclerAttendance: RecyclerView
    private val attendanceList = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_attendance_teacher, container, false)

        btnScanQr = view.findViewById(R.id.btnScanQr)
        recyclerAttendance = view.findViewById(R.id.recyclerAttendance)

        // Set up RecyclerView and other functionality
        recyclerAttendance.layoutManager = LinearLayoutManager(requireContext())
        recyclerAttendance.adapter = AttendanceAdapter(attendanceList)

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

                    Toast.makeText(requireContext(), "Marked Present: $name", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(requireContext(), "Student not found in DB", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(requireContext(), "Error fetching student", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
