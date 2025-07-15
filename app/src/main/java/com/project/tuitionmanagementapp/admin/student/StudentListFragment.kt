package com.project.tuitionmanagementapp.admin.student


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.tuitionmanagementapp.R
import com.project.tuitionmanagementapp.common.adapters
import com.project.tuitionmanagementapp.common.models.StudentViewModel

class StudentListFragment : Fragment() {

    private lateinit var studentRecyclerView: RecyclerView
    private lateinit var studentViewModel: StudentViewModel
    private lateinit var studentAdapter: StudentAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_student_list, container, false)

        studentRecyclerView = view.findViewById(R.id.recyclerViewStudents)
        studentRecyclerView.layoutManager = LinearLayoutManager(context)
        studentAdapter = StudentAdapter(requireContext(), emptyList())
        studentRecyclerView.adapter = studentAdapter

        studentViewModel = ViewModelProvider(this)[StudentViewModel::class.java]
        studentViewModel.getAllStudents().observe(viewLifecycleOwner) { studentList ->
            if (studentList != null) {
                studentAdapter.updateList(studentList)
            } else {
                Toast.makeText(context, "No students found.", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}