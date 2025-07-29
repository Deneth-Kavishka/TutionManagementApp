package com.project.tuitionmanagementapp.teacher

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.tuitionmanagementapp.R
import java.text.SimpleDateFormat
import java.util.*

class AttendanceRecordAdapter(
    private val attendanceList: List<QRAttendanceActivity.AttendanceRecord>
) : RecyclerView.Adapter<AttendanceRecordAdapter.AttendanceViewHolder>() {

    class AttendanceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvStudentName: TextView = itemView.findViewById(R.id.tvStudentName)
        val tvStudentId: TextView = itemView.findViewById(R.id.tvStudentId)
        val tvTimestamp: TextView = itemView.findViewById(R.id.tvTimestamp)
        val tvStatus: TextView = itemView.findViewById(R.id.tvStatus)
        val tvPaymentStatus: TextView = itemView.findViewById(R.id.tvPaymentStatus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttendanceViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_attendance_record, parent, false)
        return AttendanceViewHolder(view)
    }

    override fun onBindViewHolder(holder: AttendanceViewHolder, position: Int) {
        val record = attendanceList[position]

        holder.tvStudentName.text = record.studentName
        holder.tvStudentId.text = "ID: ${record.studentId}"

        // Format timestamp to show time only
        try {
            val inputFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
            val outputFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
            val date = inputFormat.parse(record.timestamp)
            holder.tvTimestamp.text = date?.let { outputFormat.format(it) } ?: record.timestamp
        } catch (e: Exception) {
            holder.tvTimestamp.text = record.timestamp
        }

        holder.tvStatus.text = record.status

        // Set status color
        when (record.status) {
            "Present" -> holder.tvStatus.setTextColor(
                holder.itemView.context.getColor(android.R.color.holo_green_dark)
            )
            "Absent" -> holder.tvStatus.setTextColor(
                holder.itemView.context.getColor(android.R.color.holo_red_dark)
            )
            "Late" -> holder.tvStatus.setTextColor(
                holder.itemView.context.getColor(android.R.color.holo_orange_dark)
            )
            else -> holder.tvStatus.setTextColor(
                holder.itemView.context.getColor(android.R.color.black)
            )
        }

        // Display payment status with colors and icons
        when (record.paymentStatus) {
            "PAID" -> {
                holder.tvPaymentStatus.text = "✅ PAID"
                holder.tvPaymentStatus.setTextColor(
                    holder.itemView.context.getColor(android.R.color.holo_green_dark)
                )
            }
            "PENDING" -> {
                holder.tvPaymentStatus.text = "⚠️ PENDING (Rs.${String.format("%.0f", record.pendingAmount)})"
                holder.tvPaymentStatus.setTextColor(
                    holder.itemView.context.getColor(android.R.color.holo_orange_dark)
                )
            }
            "OVERDUE" -> {
                holder.tvPaymentStatus.text = "❌ OVERDUE (Rs.${String.format("%.0f", record.pendingAmount)})"
                holder.tvPaymentStatus.setTextColor(
                    holder.itemView.context.getColor(android.R.color.holo_red_dark)
                )
            }
            else -> {
                holder.tvPaymentStatus.text = "ℹ️ Payment status unknown"
                holder.tvPaymentStatus.setTextColor(
                    holder.itemView.context.getColor(android.R.color.darker_gray)
                )
            }
        }
    }

    override fun getItemCount(): Int = attendanceList.size
}
