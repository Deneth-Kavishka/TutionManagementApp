package com.project.tuitionmanagementapp.admin

data class AttendanceRecord(
    val id: String? = null,
    val classScheduleId: String = "",
    val className: String = "",
    val date: Long = System.currentTimeMillis(),
    val studentId: String = "",
    val studentName: String = "",
    var status: String = "present", // present, absent, late
    val markedBy: String = "",
    val markedAt: Long = System.currentTimeMillis(),
    val notes: String = ""
)
