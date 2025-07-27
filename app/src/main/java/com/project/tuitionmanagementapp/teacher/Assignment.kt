package com.project.tuitionmanagementapp.teacher

data class Assignment(
    val id: String? = null,
    val title: String = "",
    val description: String = "",
    val dueDate: Long = 0,
    val className: String = "",
    val attachmentUrl: String? = null,
    val teacherId: String = "",
    val createdAt: Long = System.currentTimeMillis(),
    val status: String = "active"  // active, completed, or expired
)
