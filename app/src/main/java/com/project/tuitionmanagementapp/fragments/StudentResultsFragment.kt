package com.project.tuitionmanagementapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.tuitionmanagementapp.R
import com.project.tuitionmanagementapp.adapters.ExamResultsAdapter
import com.project.tuitionmanagementapp.models.*
import com.project.tuitionmanagementapp.repository.*

class StudentResultsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ExamResultsAdapter
    private var studentId: String? = null

    companion object {
        private const val ARG_STUDENT_ID = "student_id"

        fun newInstance(studentId: String): StudentResultsFragment {
            val fragment = StudentResultsFragment()
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
        return inflater.inflate(R.layout.fragment_student_results, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.rvExamResults)
        recyclerView.layoutManager = LinearLayoutManager(context)

        loadResultData()
    }

    private fun loadResultData() {
        studentId?.let { id ->
            val results = ExamRepository.getResultsByStudentId(id)
            adapter = ExamResultsAdapter(results)
            recyclerView.adapter = adapter
        }
    }
}