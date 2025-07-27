package com.project.tuitionmanagementapp.teacher

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.project.tuitionmanagementapp.R
import java.text.SimpleDateFormat
import java.util.*

class AssignmentAdapter(
    private val assignments: List<Assignment>,
    private val onViewSubmissions: (Assignment) -> Unit,
    private val onEdit: (Assignment) -> Unit,
    private val onDelete: (Assignment) -> Unit
) : RecyclerView.Adapter<AssignmentAdapter.AssignmentViewHolder>() {

    inner class AssignmentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView: CardView = itemView.findViewById(R.id.cardAssignment)
        val title: TextView = itemView.findViewById(R.id.tvAssignmentTitle)
        val description: TextView = itemView.findViewById(R.id.tvAssignmentDescription)
        val dueDate: TextView = itemView.findViewById(R.id.tvDueDate)
        val className: TextView = itemView.findViewById(R.id.tvClassName)
        val btnSubmissions: ImageButton = itemView.findViewById(R.id.btnViewSubmissions)
        val btnEdit: ImageButton = itemView.findViewById(R.id.btnEdit)
        val btnDelete: ImageButton = itemView.findViewById(R.id.btnDelete)
        val status: TextView = itemView.findViewById(R.id.tvStatus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssignmentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_assignment_teacher, parent, false)
        return AssignmentViewHolder(view)
    }

    override fun onBindViewHolder(holder: AssignmentViewHolder, position: Int) {
        val assignment = assignments[position]

        holder.title.text = assignment.title
        holder.description.text = assignment.description
        holder.dueDate.text = formatDate(assignment.dueDate)
        holder.className.text = assignment.className

        // Set status color based on due date
        val now = System.currentTimeMillis()
        val statusColor = when {
            assignment.status == "completed" -> holder.itemView.context.getColor(R.color.green)
            now > assignment.dueDate -> holder.itemView.context.getColor(R.color.red)
            else -> holder.itemView.context.getColor(R.color.purple_700)
        }
        holder.status.setTextColor(statusColor)

        // Set status text
        holder.status.text = when {
            assignment.status == "completed" -> "Completed"
            now > assignment.dueDate -> "Expired"
            else -> "Active"
        }

        // Setup click listeners
        holder.btnSubmissions.setOnClickListener { onViewSubmissions(assignment) }
        holder.btnEdit.setOnClickListener { onEdit(assignment) }
        holder.btnDelete.setOnClickListener { onDelete(assignment) }
    }

    override fun getItemCount() = assignments.size

    private fun formatDate(timestamp: Long): String {
        val sdf = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())
        return sdf.format(Date(timestamp))
    }
}
