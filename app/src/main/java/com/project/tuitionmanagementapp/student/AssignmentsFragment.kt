package com.project.tuitionmanagementapp.student

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.project.tuitionmanagementapp.R

class AssignmentsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var assignmentAdapter: AssignmentAdapter
    private val assignmentList = ArrayList<Assignment>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_assignments_student, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.rvAssignments)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        assignmentAdapter = AssignmentAdapter(assignmentList) {
            Toast.makeText(requireContext(), "Submit: ${it.title}", Toast.LENGTH_SHORT).show()
        }

        recyclerView.adapter = assignmentAdapter

        val studentId = arguments?.getString("studentId") ?: "S001"
        loadAssignmentsFromFirebase(studentId)
    }

    private fun loadAssignmentsFromFirebase(studentId: String) {
        val database = FirebaseDatabase.getInstance()
        val assignmentsRef = database.getReference("assignments")

        assignmentsRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                assignmentList.clear()

                for (assignmentSnapshot in snapshot.children) {
                    val assignment = assignmentSnapshot.getValue(Assignment::class.java)
                    assignment?.let {
                        assignmentList.add(it)
                    }
                }

                // If no assignments found, add sample data
                if (assignmentList.isEmpty()) {
                    assignmentList.add(Assignment("Math Homework", "2025-07-30"))
                    assignmentList.add(Assignment("Science Project", "2025-08-05"))
                    assignmentList.add(Assignment("English Essay", "2025-08-10"))
                }

                assignmentAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(requireContext(), "Failed to load assignments", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
