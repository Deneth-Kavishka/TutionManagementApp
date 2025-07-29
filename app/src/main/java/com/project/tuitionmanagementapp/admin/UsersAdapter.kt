package com.project.tuitionmanagementapp.admin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.project.tuitionmanagementapp.R
import com.project.tuitionmanagementapp.models.Student
import com.project.tuitionmanagementapp.models.Teacher

class UsersAdapter(
    private val users: MutableList<Any>,
    private val onActionClick: (Any, String) -> Unit
) : RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameText: TextView = itemView.findViewById(R.id.tvUserName)
        val typeText: TextView = itemView.findViewById(R.id.tvUserType)
        val idText: TextView = itemView.findViewById(R.id.tvUserId)
        val emailText: TextView = itemView.findViewById(R.id.tvUserEmail)
        val btnEdit: MaterialButton = itemView.findViewById(R.id.btnEdit)
        val btnDelete: MaterialButton = itemView.findViewById(R.id.btnDelete)
        val btnView: MaterialButton = itemView.findViewById(R.id.btnView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user_account, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]

        when (user) {
            is Student -> {
                holder.nameText.text = "Name: ${user.fullName}"
                holder.typeText.text = "Account Type: Student"
                holder.idText.text = "Account ID: ${user.id}"
                holder.emailText.text = "Email: ${user.email}"
            }
            is Teacher -> {
                holder.nameText.text = "Name: ${user.fullName}"
                holder.typeText.text = "Account Type: Teacher"
                holder.idText.text = "Account ID: ${user.id}"
                holder.emailText.text = "Email: ${user.email}"
            }
        }

        // Set click listeners for action buttons
        holder.btnEdit.setOnClickListener {
            onActionClick(user, "edit")
        }

        holder.btnDelete.setOnClickListener {
            onActionClick(user, "delete")
        }

        holder.btnView.setOnClickListener {
            onActionClick(user, "view")
        }
    }

    override fun getItemCount(): Int = users.size
}
