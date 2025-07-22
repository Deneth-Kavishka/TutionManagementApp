package com.project.tuitionmanagementapp.repository

import com.project.tuitionmanagementapp.models.Attendance
import java.util.*

object AttendanceRepository {
    private val attendanceRecords = mutableListOf<Attendance>()

    init {
        val calendar = Calendar.getInstance()
        for (i in 1..30) {
            calendar.add(Calendar.DAY_OF_MONTH, -1)
            attendanceRecords.add(
                Attendance(
                    id = "ATT${String.format("%03d", i)}",
                    studentId = if (i % 3 == 0) "STD002" else "STD001",
                    date = calendar.time.clone() as Date,
                    status = if (i % 10 == 0) "ABSENT" else "PRESENT",
                    classSubject = when (i % 3) {
                        0 -> "Physics"
                        1 -> "Mathematics"
                        else -> "Chemistry"
                    },
                    teacherId = "TCH00${(i % 3) + 1}",
                    remarks = if (i % 10 == 0) "Absent without notice" else null
                )
            )
        }
    }

    fun getAttendanceByStudentId(studentId: String): List<Attendance> {
        return attendanceRecords.filter { it.studentId == studentId }
    }

    fun addAttendance(attendance: Attendance): Boolean {
        return attendanceRecords.add(attendance)
    }
}