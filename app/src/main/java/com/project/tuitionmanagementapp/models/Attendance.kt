package com.project.tuitionmanagementapp.models

import java.util.*

data class Attendance(
    val id: String,
    val studentId: String,
    val date: Date,
    val status: String, // PRESENT, ABSENT, LATE
    val classSubject: String,
    val teacherId: String,
    val remarks: String?
)