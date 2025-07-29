package com.project.tuitionmanagementapp.models

data class ClassCategory(
    val id: String = "",
    val categoryName: String = "", // e.g., "Grade 10 Mathematics", "A/L Physics"
    val grade: String = "", // e.g., "10", "12", "13"
    val subject: String = "", // e.g., "Mathematics", "Physics", "Chemistry"
    val level: String = "", // e.g., "O/L", "A/L", "Grade 1-5"
    val description: String = "",
    val maxStudents: Int = 30,
    val currentStudents: Int = 0,
    val fees: Double = 0.0,
    val schedule: List<ClassScheduleSlot> = emptyList(),
    val teacherId: String = "",
    val teacherName: String = "",
    val isActive: Boolean = true,
    val createdDate: String = "",
    val startDate: String = "",
    val endDate: String = ""
)

data class ClassScheduleSlot(
    val day: String, // Monday, Tuesday, etc.
    val startTime: String, // 09:00
    val endTime: String, // 11:00
    val duration: Int = 120 // minutes
)
