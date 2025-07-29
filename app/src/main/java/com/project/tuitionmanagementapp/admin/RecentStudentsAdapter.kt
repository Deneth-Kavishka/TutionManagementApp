package com.project.tuitionmanagementapp.admin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.tuitionmanagementapp.R
import com.project.tuitionmanagementapp.models.Student

class RecentStudentsAdapter(
    private val students: List<Student>,
    private val onItemClick: (Student) -> Unit,
    private val onPaymentClick: (Student) -> Unit = {} // Default empty implementation
) : RecyclerView.Adapter<RecentStudentsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvStudentName: TextView = view.findViewById(R.id.tvStudentName)
        val tvStudentId: TextView = view.findViewById(R.id.tvStudentId)
        val tvStudentGrade: TextView = view.findViewById(R.id.tvStudentGrade)
        val tvRegistrationDate: TextView = view.findViewById(R.id.tvRegistrationDate)
        val tvClassCount: TextView = view.findViewById(R.id.tvClassCount)
        val btnViewDetails: ImageButton = view.findViewById(R.id.btnViewDetails)
        val btnMakePayment: ImageButton = view.findViewById(R.id.btnMakePayment)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recent_student, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student = students[position]

        holder.tvStudentName.text = student.fullName
        holder.tvStudentId.text = "ID: ${student.studentId}"
        holder.tvStudentGrade.text = "Grade: ${student.currentGrade}"
        holder.tvRegistrationDate.text = "Registered: ${student.registrationDate.take(10)}"
        holder.tvClassCount.text = "${student.classCategories.size} Classes"

        // Set click listeners for action buttons
        holder.btnViewDetails.setOnClickListener { onItemClick(student) }
        holder.btnMakePayment.setOnClickListener { onPaymentClick(student) }

        // Make entire item clickable for details view
        holder.itemView.setOnClickListener { onItemClick(student) }
    }

    override fun getItemCount() = students.size
}
