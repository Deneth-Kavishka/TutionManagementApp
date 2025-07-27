package com.project.tuitionmanagementapp.admin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.project.tuitionmanagementapp.R

class AttendanceAdapter(
    private val students: List<AttendanceRecord>,
    private val onStatusChange: (String, String) -> Unit // studentId, status
) : RecyclerView.Adapter<AttendanceAdapter.AttendanceViewHolder>() {

    inner class AttendanceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val studentName: TextView = itemView.findViewById(R.id.tvStudentName)
        val studentId: TextView = itemView.findViewById(R.id.tvStudentId)
        val statusGroup: RadioGroup = itemView.findViewById(R.id.statusGroup)
        val btnPresent: RadioButton = itemView.findViewById(R.id.btnPresent)
        val btnAbsent: RadioButton = itemView.findViewById(R.id.btnAbsent)
        val btnLate: RadioButton = itemView.findViewById(R.id.btnLate)
        val notes: EditText = itemView.findViewById(R.id.edtNotes)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttendanceViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_attendance_student_row, parent, false)
        return AttendanceViewHolder(view)
    }

    override fun onBindViewHolder(holder: AttendanceViewHolder, position: Int) {
        val record = students[position]

        holder.studentName.text = record.studentName
        holder.studentId.text = "ID: ${record.studentId}"
        holder.notes.setText(record.notes)

        // Set initial status
        when (record.status) {
            "present" -> holder.btnPresent.isChecked = true
            "absent" -> holder.btnAbsent.isChecked = true
            "late" -> holder.btnLate.isChecked = true
        }

        // Handle status changes
        holder.statusGroup.setOnCheckedChangeListener { _, checkedId ->
            val status = when (checkedId) {
                R.id.btnPresent -> "present"
                R.id.btnAbsent -> "absent"
                R.id.btnLate -> "late"
                else -> "absent"
            }
            onStatusChange(record.studentId, status)
        }

        // Apply theme colors
        holder.btnPresent.setTextColor(holder.itemView.context.getColor(R.color.green))
        holder.btnAbsent.setTextColor(holder.itemView.context.getColor(R.color.red))
        holder.btnLate.setTextColor(holder.itemView.context.getColor(R.color.yellow))
    }

    override fun getItemCount() = students.size

    fun markAllAs(status: String) {
        students.forEach { student ->
            onStatusChange(student.studentId, status)
        }
        notifyDataSetChanged()
    }
}
