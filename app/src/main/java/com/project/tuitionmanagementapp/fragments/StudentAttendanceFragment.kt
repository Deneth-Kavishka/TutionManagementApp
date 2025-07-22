package com.project.tuitionmanagementapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.tuitionmanagementapp.R
import com.project.tuitionmanagementapp.adapters.AttendanceHistoryAdapter
import com.project.tuitionmanagementapp.models.*
import com.project.tuitionmanagementapp.repository.*

class StudentAttendanceFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AttendanceHistoryAdapter
    private var studentId: String? = null

    companion object {
        private const val ARG_STUDENT_ID = "student_id"

        fun newInstance(studentId: String): StudentAttendanceFragment {
            val fragment = StudentAttendanceFragment()
            val args = Bundle()
            args.putString(ARG_STUDENT_ID, studentId)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            studentId = it.getString(ARG_STUDENT_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_student_attendance, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.rvAttendanceHistory)
        recyclerView.layoutManager = LinearLayoutManager(context)

        loadAttendanceData()
    }

    private fun loadAttendanceData() {
        studentId?.let { id ->
            val attendanceRecords = AttendanceRepository.getAttendanceByStudentId(id)
            adapter = AttendanceHistoryAdapter(attendanceRecords)
            recyclerView.adapter = adapter
        }
    }
}