package com.project.tuitionmanagementapp.repository

import com.project.tuitionmanagementapp.models.ExamResult
import java.util.*

object ExamRepository {
    private val examResults = mutableListOf<ExamResult>()

    init {
        examResults.addAll(listOf(
            ExamResult(
                id = "RES001",
                studentId = "STD001",
                subjectId = "SUB001",
                subjectName = "Mathematics",
                examType = "MIDTERM",
                examDate = Calendar.getInstance().apply { add(Calendar.MONTH, -1) }.time,
                totalMarks = 100,
                obtainedMarks = 85,
                grade = "A",
                percentage = 85.0,
                remarks = "Excellent performance"
            ),
            ExamResult(
                id = "RES002",
                studentId = "STD001",
                subjectId = "SUB002",
                subjectName = "Physics",
                examType = "MIDTERM",
                examDate = Calendar.getInstance().apply { add(Calendar.MONTH, -1) }.time,
                totalMarks = 100,
                obtainedMarks = 78,
                grade = "B+",
                percentage = 78.0,
                remarks = "Good work"
            ),
            ExamResult(
                id = "RES003",
                studentId = "STD001",
                subjectId = "SUB003",
                subjectName = "Chemistry",
                examType = "QUIZ",
                examDate = Calendar.getInstance().apply { add(Calendar.WEEK_OF_YEAR, -2) }.time,
                totalMarks = 50,
                obtainedMarks = 42,
                grade = "B",
                percentage = 84.0,
                remarks = "Well done"
            ),
            ExamResult(
                id = "RES004",
                studentId = "STD002",
                subjectId = "SUB001",
                subjectName = "Mathematics",
                examType = "MIDTERM",
                examDate = Calendar.getInstance().apply { add(Calendar.MONTH, -1) }.time,
                totalMarks = 100,
                obtainedMarks = 92,
                grade = "A+",
                percentage = 92.0,
                remarks = "Outstanding performance"
            )
        ))
    }

    fun getResultsByStudentId(studentId: String): List<ExamResult> {
        return examResults.filter { it.studentId == studentId }
    }

    fun addExamResult(result: ExamResult): Boolean {
        return examResults.add(result)
    }
}