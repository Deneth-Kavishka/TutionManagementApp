package com.project.tuitionmanagementapp.teacher

data class ResultModel(
    val studentId: String = "",
    val grade: String = "",
    val subject: String = "",
    val result: String = ""  // e.g. "85 - A"
)
