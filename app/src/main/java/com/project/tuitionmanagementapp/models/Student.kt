package com.project.tuitionmanagementapp.models

data class Student(
    val id: String = "",
    val firstName: String = "",
    val lastName: String = "",
    val dateOfBirth: String = "",
    val gender: String = "",
    val nicNumber: String = "",
    val studentPhone: String = "",
    val studentEmail: String = "",
    val address: String = "",
    val city: String = "",
    val studentId: String = "",
    val classCategories: List<String> = emptyList(),
    val currentGrade: String = "",
    val admissionDate: String = "",
    val guardianName: String = "",
    val guardianPhone: String = "",
    val guardianEmail: String = "",
    val guardianAddress: String = "",
    val medicalConditions: String = "",
    val notes: String = "",
    val studentUserId: String = "",
    val guardianUserId: String = "",
    val registrationDate: String = "",
    val lastUpdated: String = "",
    val registeredBy: String = "",
    val profileImageUrl: String = "",
    val isActive: Boolean = true,
    // Financial properties
    val totalFees: Double = 0.0,
    val paidAmount: Double = 0.0,
    val pendingAmount: Double = 0.0,
    // Additional properties for StudentRepository
    val paymentStatus: String = "",
    val attendanceRate: Double = 0.0,
    val gradeAverage: Double = 0.0,
    val photoUrl: String = profileImageUrl,
    // Keep backward compatibility for existing code
    val email: String = studentEmail,
    val grade: String = currentGrade,
    val phone: String = studentPhone,
    val enrollmentDate: String = admissionDate,
    val school: String = ""
) {
    val fullName: String
        get() = "$firstName $lastName"

    fun getDisplayInfo(): String = "$firstName $lastName - $currentGrade"
}
