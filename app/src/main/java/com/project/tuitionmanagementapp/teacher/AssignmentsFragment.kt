package com.project.tuitionmanagementapp.teacher

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.firestore.FirebaseFirestore
import com.project.tuitionmanagementapp.R
import java.util.*

class AssignmentsFragment : Fragment() {

    private lateinit var firestore: FirebaseFirestore
    private lateinit var recyclerView: RecyclerView
    private lateinit var fabAdd: FloatingActionButton
    private lateinit var assignmentsList: ArrayList<Assignment>
    private lateinit var adapter: AssignmentAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_assignments_teacher, container, false)

        initViews(view)
        setupRecyclerView()
        loadAssignments()

        return view
    }

    private fun initViews(view: View) {
        firestore = FirebaseFirestore.getInstance()
        recyclerView = view.findViewById(R.id.rvAssignments)
        fabAdd = view.findViewById(R.id.fabAddAssignment)
        assignmentsList = ArrayList()

        fabAdd.setOnClickListener {
            showAddAssignmentDialog()
        }
    }

    private fun setupRecyclerView() {
        adapter = AssignmentAdapter(
            assignments = assignmentsList,
            onViewSubmissions = { assignment ->
                // Show submissions for this assignment
                showSubmissionsDialog(assignment)
            },
            onEdit = { assignment ->
                // Edit assignment
                showEditAssignmentDialog(assignment)
            },
            onDelete = { assignment ->
                // Delete assignment
                deleteAssignment(assignment)
            }
        )
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
    }

    private fun loadAssignments() {
        firestore.collection("assignments")
            .get()
            .addOnSuccessListener { documents ->
                assignmentsList.clear()
                for (document in documents) {
                    val assignment = document.toObject(Assignment::class.java)
                    assignmentsList.add(assignment)
                }
                assignmentsList.sortByDescending { it.dueDate }
                adapter.notifyDataSetChanged()
            }
            .addOnFailureListener {
                Toast.makeText(context, "Failed to load assignments", Toast.LENGTH_SHORT).show()
            }
    }

    private fun showAddAssignmentDialog() {
        val dialog = AssignmentDialog(requireContext(), null) { assignment ->
            // Save new assignment
            saveAssignment(assignment)
        }
        dialog.show()
    }

    private fun showEditAssignmentDialog(assignment: Assignment) {
        val dialog = AssignmentDialog(requireContext(), assignment) { updatedAssignment ->
            // Update existing assignment
            updateAssignment(updatedAssignment)
        }
        dialog.show()
    }

    private fun saveAssignment(assignment: Assignment) {
        firestore.collection("assignments")
            .add(assignment)
            .addOnSuccessListener {
                Toast.makeText(context, "Assignment created successfully", Toast.LENGTH_SHORT).show()
                loadAssignments()
            }
            .addOnFailureListener {
                Toast.makeText(context, "Failed to create assignment", Toast.LENGTH_SHORT).show()
            }
    }

    private fun updateAssignment(assignment: Assignment) {
        assignment.id?.let { id ->
            firestore.collection("assignments")
                .document(id)
                .set(assignment)
                .addOnSuccessListener {
                    Toast.makeText(context, "Assignment updated successfully", Toast.LENGTH_SHORT).show()
                    loadAssignments()
                }
                .addOnFailureListener {
                    Toast.makeText(context, "Failed to update assignment", Toast.LENGTH_SHORT).show()
                }
        }
    }

    private fun deleteAssignment(assignment: Assignment) {
        assignment.id?.let { id ->
            firestore.collection("assignments")
                .document(id)
                .delete()
                .addOnSuccessListener {
                    Toast.makeText(context, "Assignment deleted successfully", Toast.LENGTH_SHORT).show()
                    loadAssignments()
                }
                .addOnFailureListener {
                    Toast.makeText(context, "Failed to delete assignment", Toast.LENGTH_SHORT).show()
                }
        }
    }

    private fun showSubmissionsDialog(assignment: Assignment) {
        // Show submissions in a dialog or navigate to submissions screen
        Toast.makeText(context, "Viewing submissions for ${assignment.title}", Toast.LENGTH_SHORT).show()
    }
}
