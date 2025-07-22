package com.project.tuitionmanagementapp.models

data class ClassSchedule(
    val id: String,
    val studentId: String,
    val subjectId: String,
    val subjectName: String,
    val teacherId: String,
    val teacherName: String,
    val classTime: String,
    val classDay: String,
    val room: String
)