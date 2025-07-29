package com.project.tuitionmanagementapp.teacher

import com.google.firebase.Timestamp

data class ResultModel(
    val id: String = "",
    val studentId: String = "",
    val studentName: String = "",
    val rollNumber: String = "",
    val subject: String = "",
    val className: String = "",
    val marks: Int = 0,
    val grade: String = "",
    val comments: String = "",
    val teacherId: String = "",
    val uploadDate: Timestamp? = null,
    val academicYear: String = "2025"
) {
    fun calculateGrade(): String {
        return when {
            marks >= 90 -> "A+"
            marks >= 80 -> "A"
            marks >= 70 -> "B+"
            marks >= 60 -> "B"
            marks >= 50 -> "C"
            marks >= 40 -> "D"
            else -> "F"
        }
    }

    fun getPercentage(): Float {
        return marks.toFloat()
    }
}
