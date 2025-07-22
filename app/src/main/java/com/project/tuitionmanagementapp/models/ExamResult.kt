package com.project.tuitionmanagementapp.models

import java.util.*

data class ExamResult(
    val id: String,
    val studentId: String,
    val subjectId: String,
    val subjectName: String,
    val examType: String, // MIDTERM, FINAL, QUIZ, etc.
    val examDate: Date,
    val totalMarks: Int,
    val obtainedMarks: Int,
    val grade: String,
    val percentage: Double,
    val remarks: String
)
