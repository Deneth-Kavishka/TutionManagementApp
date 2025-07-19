package com.project.tuitionmanagementapp.student

data class Attendance(
    val date: String = "",
    val subject: String = "",
    val status: String = ""  // "Present" or "Absent"
)
