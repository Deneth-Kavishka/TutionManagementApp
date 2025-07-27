package com.project.tuitionmanagementapp.admin

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

class ScheduleAdapter(
    private val schedules: List<ClassSchedule>,
    private val onEdit: (ClassSchedule) -> Unit,
    private val onDelete: (ClassSchedule) -> Unit,
    private val onAttendance: (ClassSchedule) -> Unit
) : RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder>() {

    inner class ScheduleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView: CardView = itemView.findViewById(R.id.cardSchedule)
        val className: TextView = itemView.findViewById(R.id.tvClassName)
        val teacherName: TextView = itemView.findViewById(R.id.tvTeacherName)
        val timeSlot: TextView = itemView.findViewById(R.id.tvTimeSlot)
        val roomNumber: TextView = itemView.findViewById(R.id.tvRoomNumber)
        val btnEdit: ImageButton = itemView.findViewById(R.id.btnEdit)
        val btnDelete: ImageButton = itemView.findViewById(R.id.btnDelete)
        val btnAttendance: ImageButton = itemView.findViewById(R.id.btnAttendance)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_schedule, parent, false)
        return ScheduleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        val schedule = schedules[position]

        holder.className.text = schedule.className
        holder.teacherName.text = schedule.teacherName
        holder.timeSlot.text = formatTimeSlot(schedule.startTime, schedule.endTime)
        holder.roomNumber.text = "Room ${schedule.roomNumber}"

        // Set recurring indicator if applicable
        if (schedule.recurring) {
            holder.timeSlot.setCompoundDrawablesWithIntrinsicBounds(
                R.drawable.ic_recurring, 0, 0, 0)
        }

        // Action buttons
        holder.btnEdit.setOnClickListener { onEdit(schedule) }
        holder.btnDelete.setOnClickListener { onDelete(schedule) }
        holder.btnAttendance.setOnClickListener { onAttendance(schedule) }

        // Visual indication for past classes
        val now = System.currentTimeMillis()
        if (schedule.endTime < now) {
            holder.cardView.alpha = 0.7f
        } else {
            holder.cardView.alpha = 1.0f
        }
    }

    override fun getItemCount() = schedules.size

    private fun formatTimeSlot(startTime: Long, endTime: Long): String {
        val sdf = SimpleDateFormat("hh:mm a", Locale.getDefault())
        return "${sdf.format(Date(startTime))} - ${sdf.format(Date(endTime))}"
    }
}
