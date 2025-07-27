// AttendanceFragment.kt
package com.project.tuitionmanagementapp.student

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.FirebaseDatabase
import com.project.tuitionmanagementapp.R
import java.text.SimpleDateFormat
import java.util.*

class AttendanceFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var attendanceList: ArrayList<Attendance>
    private lateinit var adapter: AttendanceAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_attendance_student, container, false)

        recyclerView = view.findViewById(R.id.rvAttendance)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        attendanceList = arrayListOf()
        adapter = AttendanceAdapter(attendanceList)
        recyclerView.adapter = adapter

        val studentId = "S001" // TODO: Make dynamic based on login
        loadAttendanceFromFirebase(studentId)

        return view
    }

    private fun loadAttendanceFromFirebase(studentId: String) {
        val database = FirebaseDatabase.getInstance()
        val attendanceRef = database.getReference("attendance").child(studentId)

        attendanceRef.get().addOnSuccessListener { snapshot ->
            attendanceList.clear()
            for (attendanceSnapshot in snapshot.children) {
                val attendance = attendanceSnapshot.getValue(Attendance::class.java)
                attendance?.let {
                    attendanceList.add(it)
                }
            }

            // If no attendance records found, add sample data
            if (attendanceList.isEmpty()) {
                // Current month sample data
                val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                val calendar = Calendar.getInstance()

                // Add some past dates
                calendar.add(Calendar.DAY_OF_MONTH, -5)
                attendanceList.add(Attendance(dateFormat.format(calendar.time), "Mathematics", "Present"))

                calendar.add(Calendar.DAY_OF_MONTH, 1)
                attendanceList.add(Attendance(dateFormat.format(calendar.time), "Science", "Present"))

                calendar.add(Calendar.DAY_OF_MONTH, 1)
                attendanceList.add(Attendance(dateFormat.format(calendar.time), "English", "Absent"))

                calendar.add(Calendar.DAY_OF_MONTH, 1)
                attendanceList.add(Attendance(dateFormat.format(calendar.time), "Mathematics", "Present"))

                calendar.add(Calendar.DAY_OF_MONTH, 1)
                attendanceList.add(Attendance(dateFormat.format(calendar.time), "Science", "Present"))

                // Today
                calendar.time = Date()
                attendanceList.add(Attendance(dateFormat.format(calendar.time), "English", "Present"))
            }

            // Sort by date descending (most recent first)
            attendanceList.sortByDescending { it.date }
            adapter.notifyDataSetChanged()
        }.addOnFailureListener {
            Toast.makeText(requireContext(), "Failed to load attendance", Toast.LENGTH_SHORT).show()
        }
    }
}
