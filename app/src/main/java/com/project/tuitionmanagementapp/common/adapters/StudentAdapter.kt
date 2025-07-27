package com.project.tuitionmanagementapp.common.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.project.tuitionmanagementapp.R
import com.project.tuitionmanagementapp.common.models.Student

class StudentAdapter(
    private val context: Context,
    private var students: List<Student>,
    private val isApprovalMode: Boolean = false,
    private val onApprovalAction: ((Student, Boolean) -> Unit)? = null
) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    fun updateList(newList: List<Student>) {
        students = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.student_item, parent, false)
        return StudentViewHolder(view)
    }

    override fun getItemCount(): Int = students.size

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = students[position]
        holder.bind(student)
    }

    inner class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvName: TextView = itemView.findViewById(R.id.tvStudentName)
        private val tvEmail: TextView = itemView.findViewById(R.id.tvStudentEmail)
        private val tvCourse: TextView = itemView.findViewById(R.id.tvStudentCourse)
        private val btnApprove: Button? = itemView.findViewById(R.id.btnApprove)
        private val btnReject: Button? = itemView.findViewById(R.id.btnReject)

        fun bind(student: Student) {
            tvName.text = student.name
            tvEmail.text = student.email
            tvCourse.text = "Course: ${student.course}"

            if (isApprovalMode) {
                btnApprove?.visibility = View.VISIBLE
                btnReject?.visibility = View.VISIBLE

                btnApprove?.setOnClickListener {
                    onApprovalAction?.invoke(student, true)
                }
                btnReject?.setOnClickListener {
                    onApprovalAction?.invoke(student, false)
                }
            } else {
                btnApprove?.visibility = View.GONE
                btnReject?.visibility = View.GONE
            }
        }
    }
}
