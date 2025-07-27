package com.project.tuitionmanagementapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.tuitionmanagementapp.R
import com.project.tuitionmanagementapp.models.Attendance
import java.text.SimpleDateFormat
import java.util.*

class AttendanceHistoryAdapter(private val attendanceList: List<Attendance>) :
    RecyclerView.Adapter<AttendanceHistoryAdapter.AttendanceViewHolder>() {

    private val dateFormat = SimpleDateFormat("EEE, dd MMM yyyy", Locale.getDefault())

    inner class AttendanceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvDate: TextView = itemView.findViewById(R.id.tvDate)
        val tvSubject: TextView = itemView.findViewById(R.id.tvSubject)
        val tvStatus: TextView = itemView.findViewById(R.id.tvStatus)
        val tvTeacher: TextView = itemView.findViewById(R.id.tvTeacher)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttendanceViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_attendance_history, parent, false)
        return AttendanceViewHolder(view)
    }

    override fun onBindViewHolder(holder: AttendanceViewHolder, position: Int) {
        val attendance = attendanceList[position]

        holder.tvDate.text = dateFormat.format(attendance.date)
        holder.tvSubject.text = attendance.classSubject
        holder.tvTeacher.text = "Teacher: ${attendance.teacherId}"

        holder.tvStatus.text = attendance.status
        when (attendance.status) {
            "PRESENT" -> {
                holder.tvStatus.setTextColor(holder.itemView.context.getColor(R.color.colorSuccess))
                holder.tvStatus.setCompoundDrawablesRelativeWithIntrinsicBounds(
                    R.drawable.ic_check_circle, 0, 0, 0
                )
            }
            else -> {
                holder.tvStatus.setTextColor(holder.itemView.context.getColor(R.color.colorAccent))
                holder.tvStatus.setCompoundDrawablesRelativeWithIntrinsicBounds(
                    R.drawable.ic_warning, 0, 0, 0
                )
            }
        }
    }

    override fun getItemCount(): Int = attendanceList.size
}