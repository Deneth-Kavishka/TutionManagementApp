package com.project.tuitionmanagementapp.repository

import com.project.tuitionmanagementapp.models.ClassSchedule

object ClassRepository {
    private val classSchedules = mutableListOf<ClassSchedule>()

    init {
        classSchedules.addAll(listOf(
            ClassSchedule(
                id = "CLS001",
                studentId = "STD001",
                subjectId = "SUB001",
                subjectName = "Mathematics",
                teacherId = "TCH001",
                teacherName = "Dr. Wilson",
                classTime = "09:00 - 10:00",
                classDay = "Monday, Wednesday, Friday",
                room = "Room 101"
            ),
            ClassSchedule(
                id = "CLS002",
                studentId = "STD001",
                subjectId = "SUB002",
                subjectName = "Physics",
                teacherId = "TCH002",
                teacherName = "Prof. Anderson",
                classTime = "10:00 - 11:00",
                classDay = "Tuesday, Thursday",
                room = "Lab 201"
            ),
            ClassSchedule(
                id = "CLS003",
                studentId = "STD001",
                subjectId = "SUB003",
                subjectName = "Chemistry",
                teacherId = "TCH003",
                teacherName = "Dr. Martinez",
                classTime = "11:00 - 12:00",
                classDay = "Monday, Wednesday",
                room = "Lab 202"
            ),
            ClassSchedule(
                id = "CLS004",
                studentId = "STD002",
                subjectId = "SUB001",
                subjectName = "Mathematics",
                teacherId = "TCH001",
                teacherName = "Dr. Wilson",
                classTime = "08:00 - 09:00",
                classDay = "Tuesday, Thursday",
                room = "Room 102"
            )
        ))
    }

    fun getClassesByStudentId(studentId: String): List<ClassSchedule> {
        return classSchedules.filter { it.studentId == studentId }
    }

    fun addClassSchedule(schedule: ClassSchedule): Boolean {
        return classSchedules.add(schedule)
    }
}