package com.project.tuitionmanagementapp.repository

import com.project.tuitionmanagementapp.models.*
import java.util.*

object StudentRepository {

    // Mock data - In a real app, this would come from a database or API
    private val students = mutableListOf<Student>()
    private val paymentHistories = mutableListOf<Payment>()
    private val attendanceRecords = mutableListOf<Attendance>()
    private val classAssignments = mutableListOf<ClassSchedule>()
    private val results = mutableListOf<ExamResult>()

    init {
        initializeMockData()
    }

    private fun initializeMockData() {
        // Sample students
        students.addAll(listOf(
            Student(
                id = "STD001",
                name = "John Doe",
                className = "Grade 10-A",
                grade = "10",
                section = "A",
                rollNumber = "101",
                dateOfBirth = "2008-05-15",
                gender = "Male",
                email = "john.doe@email.com",
                phone = "123-456-7890",
                address = "123 Main St, City",
                parentName = "Robert Doe",
                parentPhone = "987-654-3210",
                parentEmail = "robert.doe@email.com",
                admissionDate = "2023-01-15",
                photoUrl = "",
                attendanceRate = 92,
                paymentStatus = "PAID",
                gradeAverage = "A-",
                totalFees = 5000.0,
                paidAmount = 5000.0,
                pendingAmount = 0.0
            ),
            Student(
                id = "STD002",
                name = "Jane Smith",
                className = "Grade 9-B",
                grade = "9",
                section = "B",
                rollNumber = "202",
                dateOfBirth = "2009-08-22",
                gender = "Female",
                email = "jane.smith@email.com",
                phone = "123-456-7891",
                address = "456 Oak St, City",
                parentName = "Mary Smith",
                parentPhone = "987-654-3211",
                parentEmail = "mary.smith@email.com",
                admissionDate = "2023-01-15",
                photoUrl = "",
                attendanceRate = 85,
                paymentStatus = "PENDING",
                gradeAverage = "B+",
                totalFees = 4500.0,
                paidAmount = 3000.0,
                pendingAmount = 1500.0
            ),
            Student(
                id = "STD003",
                name = "Mike Johnson",
                className = "Grade 11-A",
                grade = "11",
                section = "A",
                rollNumber = "303",
                dateOfBirth = "2007-12-10",
                gender = "Male",
                email = "mike.johnson@email.com",
                phone = "123-456-7892",
                address = "789 Pine St, City",
                parentName = "David Johnson",
                parentPhone = "987-654-3212",
                parentEmail = "david.johnson@email.com",
                admissionDate = "2022-01-15",
                photoUrl = "",
                attendanceRate = 78,
                paymentStatus = "OVERDUE",
                gradeAverage = "C+",
                totalFees = 5500.0,
                paidAmount = 2000.0,
                pendingAmount = 3500.0
            )
        ))

        // Sample payment histories
        paymentHistories.addAll(listOf(
            Payment(
                id = "PAY001",
                studentId = "STD001",
                amount = 2500.0,
                paymentDate = Date(),
                paymentMethod = "Credit Card",
                description = "Tuition Fee - Semester 1",
                status = "COMPLETED",
                receiptNumber = "RCP001",
                dueDate = Date()
            ),
            Payment(
                id = "PAY002",
                studentId = "STD001",
                amount = 2500.0,
                paymentDate = Calendar.getInstance().apply { add(Calendar.MONTH, -1) }.time,
                paymentMethod = "Bank Transfer",
                description = "Tuition Fee - Semester 2",
                status = "COMPLETED",
                receiptNumber = "RCP002",
                dueDate = Date()
            )
        ))

        // Sample attendance records
        val calendar = Calendar.getInstance()
        for (i in 1..30) {
            calendar.add(Calendar.DAY_OF_MONTH, -1)
            attendanceRecords.add(
                Attendance(
                    id = "ATT${String.format("%03d", i)}",
                    studentId = "STD001",
                    date = calendar.time.clone() as Date,
                    status = if (i % 10 == 0) "ABSENT" else "PRESENT",
                    classSubject = "Mathematics",
                    teacherId = "TCH001",
                    remarks = null
                )
            )
        }

        // Sample class assignments
        classAssignments.addAll(listOf(
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
            )
        ))

        // Sample results
        results.addAll(listOf(
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
            )
        ))
    }

    fun getStudentById(studentId: String): Student? {
        return students.find { it.id == studentId }
    }

    fun getAllStudents(): List<Student> {
        return students.toList()
    }

    fun getPaymentHistoryByStudentId(studentId: String): List<Payment> {
        return paymentHistories.filter { it.studentId == studentId }
    }

    fun getAttendanceRecordsByStudentId(studentId: String): List<Attendance> {
        return attendanceRecords.filter { it.studentId == studentId }
    }

    fun getClassAssignmentsByStudentId(studentId: String): List<ClassSchedule> {
        return classAssignments.filter { it.studentId == studentId }
    }

    fun getResultsByStudentId(studentId: String): List<ExamResult> {
        return results.filter { it.studentId == studentId }
    }

    fun addStudent(student: Student): Boolean {
        return try {
            students.add(student)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun updateStudent(student: Student): Boolean {
        return try {
            val index = students.indexOfFirst { it.id == student.id }
            if (index != -1) {
                students[index] = student
                true
            } else {
                false
            }
        } catch (e: Exception) {
            false
        }
    }

    fun deleteStudent(studentId: String): Boolean {
        return try {
            students.removeAll { it.id == studentId }
            true
        } catch (e: Exception) {
            false
        }
    }

    fun searchStudents(query: String): List<Student> {
        return students.filter {
            it.name.contains(query, ignoreCase = true) ||
                    it.id.contains(query, ignoreCase = true) ||
                    it.rollNumber.contains(query, ignoreCase = true)
        }
    }
}