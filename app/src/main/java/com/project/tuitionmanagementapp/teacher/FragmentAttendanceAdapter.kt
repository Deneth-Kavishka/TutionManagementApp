package com.project.tuitionmanagementapp.teacher

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.tuitionmanagementapp.R
import com.project.tuitionmanagementapp.teacher.AttendanceFragment.AttendanceRecord

class FragmentAttendanceAdapter(private val attendanceList: List<AttendanceRecord>) :
    RecyclerView.Adapter<FragmentAttendanceAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvStudentName: TextView = view.findViewById(R.id.tvStudentName)
        val tvTimestamp: TextView = view.findViewById(R.id.tvTimestamp)
        val tvStatus: TextView = view.findViewById(R.id.tvStatus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_attendance, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val record = attendanceList[position]
        holder.tvStudentName.text = record.studentName
        holder.tvTimestamp.text = record.timestamp
        holder.tvStatus.text = record.status
    }

    override fun getItemCount() = attendanceList.size
}
