package com.project.tuitionmanagementapp.admin.student

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.tuitionmanagementapp.R
import com.project.tuitionmanagementapp.common.adapters.StudentAdapter
import com.project.tuitionmanagementapp.common.models.Student
import com.project.tuitionmanagementapp.common.models.StudentViewModel

class PendingStudentListFragment : Fragment() {

    private lateinit var recyclerViewPending: RecyclerView
    private lateinit var viewModel: StudentViewModel
    private lateinit var adapter: StudentAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_pending_students, container, false)

        recyclerViewPending = view.findViewById(R.id.recyclerViewPendingStudents)
        recyclerViewPending.layoutManager = LinearLayoutManager(context)
        adapter = StudentAdapter(requireContext(), emptyList(), isApprovalMode = true) { student, approve ->
            if (approve) {
                viewModel.approveStudent(student.id)
                Toast.makeText(context, "Approved: ${student.name}", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.deleteStudent(student.id)
                Toast.makeText(context, "Rejected: ${student.name}", Toast.LENGTH_SHORT).show()
            }
        }
        recyclerViewPending.adapter = adapter

        viewModel = ViewModelProvider(this)[StudentViewModel::class.java]
        viewModel.getPendingRegistrations().observe(viewLifecycleOwner) { pendingList ->
            if (pendingList != null) {
                adapter.updateList(pendingList)
            } else {
                Toast.makeText(context, "No pending students found.", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}
