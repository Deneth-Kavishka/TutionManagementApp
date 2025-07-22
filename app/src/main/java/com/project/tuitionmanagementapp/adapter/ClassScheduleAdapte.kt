package com.project.tuitionmanagementapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.tuitionmanagementapp.R
import com.project.tuitionmanagementapp.models.ClassSchedule

class ClassScheduleAdapter(private val classSchedules: List<ClassSchedule>) :
    RecyclerView.Adapter<ClassScheduleAdapter.ClassScheduleViewHolder>() {

    inner class ClassScheduleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvSubject: TextView = itemView.findViewById(R.id.tvSubject)
        val tvTeacher: TextView = itemView.findViewById(R.id.tvTeacher)
        val tvTime: TextView = itemView.findViewById(R.id.tvTime)
        val tvDays: TextView = itemView.findViewById(R.id.tvDays)
        val tvRoom: TextView = itemView.findViewById(R.id.tvRoom)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassScheduleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_class_schedule, parent, false)
        return ClassScheduleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ClassScheduleViewHolder, position: Int) {
        val schedule = classSchedules[position]

        holder.tvSubject.text = schedule.subjectName
        holder.tvTeacher.text = "Taught by: ${schedule.teacherName}"
        holder.tvTime.text = schedule.classTime
        holder.tvDays.text = schedule.classDay
        holder.tvRoom.text = schedule.room
    }

    override fun getItemCount(): Int = classSchedules.size
}