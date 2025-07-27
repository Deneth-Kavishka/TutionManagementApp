package com.project.tuitionmanagementapp.student

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.tuitionmanagementapp.R

class AssignmentAdapter(
    private val assignmentList: List<Assignment>,
    private val onSubmitClick: (Assignment) -> Unit
) : RecyclerView.Adapter<AssignmentAdapter.AssignmentViewHolder>() {

    inner class AssignmentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvTitle: TextView = itemView.findViewById(R.id.tvAssignmentTitle)
        private val tvDueDate: TextView = itemView.findViewById(R.id.tvAssignmentDue)
        private val btnSubmit: Button = itemView.findViewById(R.id.btnSubmitAssignment)

        fun bind(assignment: Assignment) {
            tvTitle.text = assignment.title
            tvDueDate.text = "Due: ${assignment.dueDate}"
            btnSubmit.setOnClickListener { onSubmitClick(assignment) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssignmentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_assignment, parent, false)
        return AssignmentViewHolder(view)
    }

    override fun onBindViewHolder(holder: AssignmentViewHolder, position: Int) {
        holder.bind(assignmentList[position])
    }

    override fun getItemCount(): Int = assignmentList.size
}