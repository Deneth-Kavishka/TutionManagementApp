package com.project.tuitionmanagementapp.student


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.tuitionmanagementapp.R

class ResultAdapter(private val resultList: List<Result>) :
    RecyclerView.Adapter<ResultAdapter.ResultViewHolder>() {

    class ResultViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val subjectText: TextView = itemView.findViewById(R.id.tvSubject)
        val marksText: TextView = itemView.findViewById(R.id.tvMarks)
        val gradeText: TextView = itemView.findViewById(R.id.tvGrade)
        val commentText: TextView = itemView.findViewById(R.id.tvComment)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_result, parent, false)
        return ResultViewHolder(view)
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        val item = resultList[position]
        holder.subjectText.text = item.subject
        holder.marksText.text = "${item.marks} marks"
        holder.gradeText.text = "Grade: ${item.grade}"
        holder.commentText.text = item.comment
    }

    override fun getItemCount() = resultList.size
}
