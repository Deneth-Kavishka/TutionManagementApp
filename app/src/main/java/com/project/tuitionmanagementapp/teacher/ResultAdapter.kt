package com.project.tuitionmanagementapp.teacher

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.tuitionmanagementapp.R

class ResultAdapter(
    private val resultList: List<ResultModel>,
    private val onEdit: (ResultModel, String) -> Unit,
    private val onDelete: (String) -> Unit
) : RecyclerView.Adapter<ResultAdapter.ResultViewHolder>() {

    private val keyList = mutableListOf<String>()

    fun setKeys(keys: List<String>) {
        keyList.clear()
        keyList.addAll(keys)
    }

    class ResultViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvStudentId: TextView = itemView.findViewById(R.id.tvStudentId)
        val tvMark: TextView = itemView.findViewById(R.id.tvMark)
        val tvGrade: TextView = itemView.findViewById(R.id.tvGrade)
        val btnEdit: ImageView = itemView.findViewById(R.id.btnEdit)
        val btnDelete: ImageView = itemView.findViewById(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_result_row, parent, false)
        return ResultViewHolder(view)
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        val item = resultList[position]
        val key = keyList[position]

        holder.tvStudentId.text = item.studentId
        val parts = item.result.split(" - ")
        holder.tvMark.text = parts.getOrNull(0) ?: "-"
        holder.tvGrade.text = parts.getOrNull(1) ?: "-"

        holder.btnEdit.setOnClickListener { onEdit(item, key) }
        holder.btnDelete.setOnClickListener { onDelete(key) }
    }

    override fun getItemCount(): Int = resultList.size
}
