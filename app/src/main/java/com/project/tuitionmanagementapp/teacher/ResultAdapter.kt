package com.project.tuitionmanagementapp.teacher

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

class ResultAdapter(
    private val results: List<ResultModel>,
    private val onEdit: (ResultModel) -> Unit
) : RecyclerView.Adapter<ResultAdapter.ResultViewHolder>() {

    inner class ResultViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView: CardView = itemView.findViewById(R.id.cardResult)
        val studentName: TextView = itemView.findViewById(R.id.tvStudentName)
        val subject: TextView = itemView.findViewById(R.id.tvSubject)
        val marks: TextView = itemView.findViewById(R.id.tvMarks)
        val grade: TextView = itemView.findViewById(R.id.tvGrade)
        val date: TextView = itemView.findViewById(R.id.tvDate)
        val btnEdit: ImageButton = itemView.findViewById(R.id.btnEdit)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_result_teacher, parent, false)
        return ResultViewHolder(view)
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        val result = results[position]

        holder.studentName.text = result.studentName
        holder.subject.text = result.subject
        holder.marks.text = "${result.marks}/${result.totalMarks}"
        holder.grade.text = result.grade
        holder.date.text = formatDate(result.examDate)

        // Set grade color based on result
        val gradeColor = when {
            result.marks >= (result.totalMarks * 0.8) -> holder.itemView.context.getColor(R.color.green)
            result.marks >= (result.totalMarks * 0.4) -> holder.itemView.context.getColor(R.color.purple_700)
            else -> holder.itemView.context.getColor(R.color.red)
        }
        holder.grade.setTextColor(gradeColor)

        // Edit button click
        holder.btnEdit.setOnClickListener { onEdit(result) }
    }

    override fun getItemCount() = results.size

    private fun formatDate(timestamp: Long): String {
        val sdf = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())
        return sdf.format(Date(timestamp))
    }
}
