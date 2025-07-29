package com.project.tuitionmanagementapp.admin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.tuitionmanagementapp.R
import com.project.tuitionmanagementapp.models.Teacher

class RecentTeachersAdapter(
    private val teachers: List<Teacher>,
    private val onItemClick: (Teacher) -> Unit
) : RecyclerView.Adapter<RecentTeachersAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTeacherName: TextView = view.findViewById(R.id.tvTeacherName)
        val tvTeacherId: TextView = view.findViewById(R.id.tvTeacherId)
        val tvSubjects: TextView = view.findViewById(R.id.tvSubjects)
        val tvJoiningDate: TextView = view.findViewById(R.id.tvJoiningDate)
        val tvEmploymentType: TextView = view.findViewById(R.id.tvEmploymentType)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recent_teacher, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val teacher = teachers[position]

        holder.tvTeacherName.text = teacher.fullName
        holder.tvTeacherId.text = "ID: ${teacher.teacherId}"
        holder.tvSubjects.text = teacher.subjects.joinToString(", ")
        holder.tvJoiningDate.text = "Joined: ${teacher.joiningDate}"
        holder.tvEmploymentType.text = teacher.employmentType

        holder.itemView.setOnClickListener { onItemClick(teacher) }
    }

    override fun getItemCount() = teachers.size
}
