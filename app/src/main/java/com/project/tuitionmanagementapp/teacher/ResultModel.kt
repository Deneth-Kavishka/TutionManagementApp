package com.project.tuitionmanagementapp.teacher

data class ResultModel(
    val id: String? = null,
    val studentId: String = "",
    val studentName: String = "",
    val subject: String = "",
    val marks: Int = 0,
    val totalMarks: Int = 100,
    val grade: String = "",
    val examDate: Long = System.currentTimeMillis(),
    val teacherId: String = "",
    val comment: String = "",
    val className: String = ""
) {
    fun calculateGrade(): String {
        val percentage = (marks.toFloat() / totalMarks) * 100
        return when {
            percentage >= 90 -> "A+"
            percentage >= 80 -> "A"
            percentage >= 70 -> "B+"
            percentage >= 60 -> "B"
            percentage >= 50 -> "C"
            percentage >= 40 -> "D"
            else -> "F"
        }
    }

    fun getPercentage(): Float {
        return (marks.toFloat() / totalMarks) * 100
    }

    fun getStatus(): String {
        return if (marks >= (totalMarks * 0.4)) "Pass" else "Fail"
    }
}
