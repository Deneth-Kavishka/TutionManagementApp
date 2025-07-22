package com.project.tuitionmanagementapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.tuitionmanagementapp.R
import com.project.tuitionmanagementapp.models.ExamResult
import java.text.SimpleDateFormat
import java.util.*

class ExamResultsAdapter(private val examResults: List<ExamResult>) :
    RecyclerView.Adapter<ExamResultsAdapter.ExamResultViewHolder>() {

    private val dateFormat = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())

    inner class ExamResultViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvSubject: TextView = itemView.findViewById(R.id.tvSubject)
        val tvExamType: TextView = itemView.findViewById(R.id.tvExamType)
        val tvDate: TextView = itemView.findViewById(R.id.tvDate)
        val tvMarks: TextView = itemView.findViewById(R.id.tvMarks)
        val tvGrade: TextView = itemView.findViewById(R.id.tvGrade)
        val tvRemarks: TextView = itemView.findViewById(R.id.tvRemarks)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExamResultViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_exam_result, parent, false)
        return ExamResultViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExamResultViewHolder, position: Int) {
        val result = examResults[position]

        holder.tvSubject.text = result.subjectName
        holder.tvExamType.text = result.examType
        holder.tvDate.text = dateFormat.format(result.examDate)
        holder.tvMarks.text = "${result.obtainedMarks}/${result.totalMarks} (${result.percentage}%)"
        holder.tvGrade.text = result.grade
        holder.tvRemarks.text = result.remarks

        // Set grade color based on performance
        when (result.grade) {
            "A+", "A" -> holder.tvGrade.setTextColor(holder.itemView.context.getColor(R.color.colorSuccess))
            "B+", "B" -> holder.tvGrade.setTextColor(holder.itemView.context.getColor(R.color.colorAccent))
            else -> holder.tvGrade.setTextColor(holder.itemView.context.getColor(R.color.colorAccent))
        }
    }

    override fun getItemCount(): Int = examResults.size
}