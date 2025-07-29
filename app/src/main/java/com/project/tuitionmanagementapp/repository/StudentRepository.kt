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
        // Sample students using the enhanced Student model
        students.addAll(listOf(
            Student(
                id = "STD001",
                firstName = "John",
                lastName = "Doe",
                dateOfBirth = "2008-05-15",
                gender = "Male",
                nicNumber = "",
                studentPhone = "123-456-7890",
                studentEmail = "john.doe@email.com",
                address = "123 Main St, City",
                city = "Colombo",
                studentId = "STU001",
                classCategories = listOf("MATH_10", "SCI_10"),
                currentGrade = "Grade 10",
                admissionDate = "2023-01-15",
                guardianName = "Robert Doe",
                guardianPhone = "987-654-3210",
                guardianEmail = "robert.doe@email.com",
                guardianAddress = "123 Main St, City",
                totalFees = 5000.0,
                paidAmount = 5000.0,
                pendingAmount = 0.0,
                paymentStatus = "PAID",
                attendanceRate = 92.0,
                gradeAverage = 85.5,
                photoUrl = "",
                medicalConditions = "",
                notes = "",
                studentUserId = "auth_user_001",
                guardianUserId = "auth_guardian_001",
                isActive = true,
                registrationDate = "2023-01-15 10:00:00",
                lastUpdated = "2023-01-15 10:00:00",
                registeredBy = "Admin"
            ),
            Student(
                id = "STD002",
                firstName = "Jane",
                lastName = "Smith",
                dateOfBirth = "2009-03-22",
                gender = "Female",
                nicNumber = "",
                studentPhone = "123-456-7891",
                studentEmail = "jane.smith@email.com",
                address = "456 Oak Ave, City",
                city = "Kandy",
                studentId = "STU002",
                classCategories = listOf("ENG_9", "MATH_9"),
                currentGrade = "Grade 9",
                admissionDate = "2023-02-01",
                guardianName = "Mary Smith",
                guardianPhone = "987-654-3211",
                guardianEmail = "mary.smith@email.com",
                guardianAddress = "456 Oak Ave, City",
                totalFees = 4500.0,
                paidAmount = 3000.0,
                pendingAmount = 1500.0,
                paymentStatus = "PENDING",
                attendanceRate = 88.0,
                gradeAverage = 78.2,
                photoUrl = "",
                medicalConditions = "",
                notes = "",
                studentUserId = "auth_user_002",
                guardianUserId = "auth_guardian_002",
                isActive = true,
                registrationDate = "2023-02-01 09:30:00",
                lastUpdated = "2023-02-01 09:30:00",
                registeredBy = "Admin"
            ),
            Student(
                id = "STD003",
                firstName = "Mike",
                lastName = "Johnson",
                dateOfBirth = "2007-12-10",
                gender = "Male",
                nicNumber = "",
                studentPhone = "123-456-7892",
                studentEmail = "mike.johnson@email.com",
                address = "789 Pine St, City",
                city = "Galle",
                studentId = "STU003",
                classCategories = listOf("MATH_11", "BIO_11"),
                currentGrade = "Grade 11",
                admissionDate = "2022-01-15",
                guardianName = "David Johnson",
                guardianPhone = "987-654-3212",
                guardianEmail = "david.johnson@email.com",
                guardianAddress = "789 Pine St, City",
                totalFees = 5500.0,
                paidAmount = 2000.0,
                pendingAmount = 3500.0,
                paymentStatus = "OVERDUE",
                attendanceRate = 78.0,
                gradeAverage = 65.5,
                photoUrl = "",
                medicalConditions = "",
                notes = "",
                studentUserId = "auth_user_003",
                guardianUserId = "auth_guardian_003",
                isActive = true,
                registrationDate = "2022-01-15 10:00:00",
                lastUpdated = "2022-01-15 10:00:00",
                registeredBy = "Admin"
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
                note = "Tuition Fee - Semester 1",
                status = "COMPLETED",
                referenceNumber = "RCP001",
                paymentMonth = "2025-07"
            ),
            Payment(
                id = "PAY002",
                studentId = "STD001",
                amount = 2500.0,
                paymentDate = Calendar.getInstance().apply { add(Calendar.MONTH, -1) }.time,
                paymentMethod = "Bank Transfer",
                note = "Tuition Fee - Semester 2",
                status = "COMPLETED",
                referenceNumber = "RCP002",
                paymentMonth = "2025-06"
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
            it.fullName.contains(query, ignoreCase = true) ||
                    it.id.contains(query, ignoreCase = true) ||
                    it.studentId.contains(query, ignoreCase = true) ||
                    it.studentEmail.contains(query, ignoreCase = true)
        }
    }
}