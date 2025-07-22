package com.project.tuitionmanagementapp.models

data class Teacher(
    val id: String,
    val name: String,
    val email: String,
    val phone: String,
    val subjects: List<String>,
    val qualification: String,
    val joiningDate: String,
    val photoUrl: String
)