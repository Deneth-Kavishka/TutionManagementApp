package com.project.tuitionmanagementapp.teacher

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.tuitionmanagementapp.R

class AttendanceDatesAdapter(
    private val datesList: List<AttendanceRecordsActivity.AttendanceDateRecord>,
    private val onDateClick: (AttendanceRecordsActivity.AttendanceDateRecord) -> Unit
) : RecyclerView.Adapter<AttendanceDatesAdapter.DateViewHolder>() {

    class DateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvDate: TextView = itemView.findViewById(R.id.tvDate)
        val tvTotalStudents: TextView = itemView.findViewById(R.id.tvTotalStudents)
        val tvPresentCount: TextView = itemView.findViewById(R.id.tvPresentCount)
        val tvLateCount: TextView = itemView.findViewById(R.id.tvLateCount)
        val tvPaymentStatus: TextView = itemView.findViewById(R.id.tvPaymentStatus)
        val tvAttendanceRate: TextView = itemView.findViewById(R.id.tvAttendanceRate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_attendance_date, parent, false)
        return DateViewHolder(view)
    }

    override fun onBindViewHolder(holder: DateViewHolder, position: Int) {
        val dateRecord = datesList[position]

        holder.tvDate.text = dateRecord.displayDate
        holder.tvTotalStudents.text = "Total: ${dateRecord.totalStudents}"
        holder.tvPresentCount.text = "Present: ${dateRecord.presentCount}"
        holder.tvLateCount.text = "Late: ${dateRecord.lateCount}"

        // Calculate attendance rate
        val attendanceRate = if (dateRecord.totalStudents > 0) {
            ((dateRecord.presentCount + dateRecord.lateCount).toFloat() / dateRecord.totalStudents * 100).toInt()
        } else {
            0
        }
        holder.tvAttendanceRate.text = "Attendance: $attendanceRate%"

        // Set attendance rate color
        when {
            attendanceRate >= 90 -> holder.tvAttendanceRate.setTextColor(
                holder.itemView.context.getColor(android.R.color.holo_green_dark)
            )
            attendanceRate >= 75 -> holder.tvAttendanceRate.setTextColor(
                holder.itemView.context.getColor(android.R.color.holo_orange_dark)
            )
            else -> holder.tvAttendanceRate.setTextColor(
                holder.itemView.context.getColor(android.R.color.holo_red_dark)
            )
        }

        // Payment status
        val paymentText = if (dateRecord.pendingPayments > 0) {
            "⚠️ ${dateRecord.pendingPayments} payment issues"
        } else {
            "✅ All payments up to date"
        }
        holder.tvPaymentStatus.text = paymentText

        // Set payment status color
        if (dateRecord.pendingPayments > 0) {
            holder.tvPaymentStatus.setTextColor(
                holder.itemView.context.getColor(android.R.color.holo_orange_dark)
            )
        } else {
            holder.tvPaymentStatus.setTextColor(
                holder.itemView.context.getColor(android.R.color.holo_green_dark)
            )
        }

        // Set click listener
        holder.itemView.setOnClickListener {
            onDateClick(dateRecord)
        }
    }

    override fun getItemCount(): Int = datesList.size
}
