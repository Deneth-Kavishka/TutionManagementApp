package com.example.studentapplication

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AttendanceAdapter(private val attendanceList: List<Attendance>) :
    RecyclerView.Adapter<AttendanceAdapter.AttendanceViewHolder>() {

    class AttendanceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dateText: TextView = itemView.findViewById(R.id.tvDate)
        val subjectText: TextView = itemView.findViewById(R.id.tvSubject)
        val statusText: TextView = itemView.findViewById(R.id.tvStatus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttendanceViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_attendance, parent, false)
        return AttendanceViewHolder(view)
    }

    override fun onBindViewHolder(holder: AttendanceViewHolder, position: Int) {
        val item = attendanceList[position]
        holder.dateText.text = item.date
        holder.subjectText.text = item.subject
        holder.statusText.text = item.status

        holder.statusText.setTextColor(
            if (item.status == "Present") Color.parseColor("#4CAF50") else Color.RED
        )
    }

    override fun getItemCount() = attendanceList.size
}
