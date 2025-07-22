package com.project.tuitionmanagementapp.student

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
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

        val bottomNavigationView = view.findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.selectedItemId = R.id.nav_assignments

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(requireContext(), StudentDashboardActivity::class.java))
                    true
                }
                R.id.nav_attendance -> {
                    startActivity(Intent(requireContext(), AttendanceActivity::class.java))
                    true
                }
                R.id.nav_assignments -> true
                R.id.nav_profile -> {
                    startActivity(Intent(requireContext(), ProfileActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }

    private fun loadAssignmentsFromFirebase(studentId: String) {
        val dbRef = FirebaseDatabase.getInstance().getReference("assignments").child(studentId)

        dbRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                assignmentList.clear()
                for (child in snapshot.children) {
                    val assignment = child.getValue(Assignment::class.java)
                    assignment?.let { assignmentList.add(it) }
                }
                assignmentAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(requireContext(), "Failed to load assignments", Toast.LENGTH_SHORT).show()
                Log.e("AssignmentsFragment", "Error: ${error.message}")
            }
        })
    }
}
