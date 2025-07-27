package com.project.tuitionmanagementapp.admin

data class ClassSchedule(
    var id: String? = null,
    var className: String = "",
    var teacherName: String = "",
    var startTime: Long = 0,
    var endTime: Long = 0,
    var roomNumber: String = "",
    var recurring: Boolean = false,
    var notificationEnabled: Boolean = true,
    var studentsEnrolled: List<String> = listOf()
)
