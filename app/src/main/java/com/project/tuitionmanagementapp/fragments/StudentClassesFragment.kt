package com.project.tuitionmanagementapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.tuitionmanagementapp.R
import com.project.tuitionmanagementapp.adapters.ClassScheduleAdapter
import com.project.tuitionmanagementapp.models.*
import com.project.tuitionmanagementapp.repository.*

class StudentClassesFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ClassScheduleAdapter
    private var studentId: String? = null

    companion object {
        private const val ARG_STUDENT_ID = "student_id"

        fun newInstance(studentId: String): StudentClassesFragment {
            val fragment = StudentClassesFragment()
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
        return inflater.inflate(R.layout.fragment_student_classes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.rvClassSchedule)
        recyclerView.layoutManager = LinearLayoutManager(context)

        loadClassData()
    }

    private fun loadClassData() {
        studentId?.let { id ->
            val classes = ClassRepository.getClassesByStudentId(id)
            adapter = ClassScheduleAdapter(classes)
            recyclerView.adapter = adapter
        }
    }
}