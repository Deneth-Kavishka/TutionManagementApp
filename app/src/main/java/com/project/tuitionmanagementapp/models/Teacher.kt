package com.project.tuitionmanagementapp.models

data class Teacher(
    val id: String = "",
    val firstName: String = "",
    val lastName: String = "",
    val dateOfBirth: String = "",
    val gender: String = "",
    val nicNumber: String = "",
    val email: String = "",
    val phone: String = "",
    val emergencyContact: String = "",
    val emergencyContactName: String = "",
    val address: String = "",
    val city: String = "",
    val teacherId: String = "",
    val subjects: List<String> = emptyList(),
    val classCategories: List<String> = emptyList(),
    val experience: String = "",
    val specializations: List<String> = emptyList(),
    val joiningDate: String = "",
    val employmentType: String = "",
    val salary: String = "",
    val workingDays: List<String> = emptyList(),
    val bio: String = "",
    val notes: String = "",
    val teacherUserId: String = "",
    val createdDate: String = "",
    val lastUpdated: String = "",
    val createdBy: String = "",
    val profileImageUrl: String = "",
    val isActive: Boolean = true,
    // Keep backward compatibility for existing code
    val subject: String = subjects.firstOrNull() ?: "",
    val qualification: String = "",
    val joinDate: String = joiningDate
) {
    val fullName: String
        get() = "$firstName $lastName"

    fun getDisplayInfo(): String = "$firstName $lastName - $subject"
}
