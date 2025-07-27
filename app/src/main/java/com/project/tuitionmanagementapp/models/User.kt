package com.project.tuitionmanagementapp.models

data class User(
    val userId: String = "",
    val fullName: String = "",
    val email: String = "",
    val password: String = "",
    val phoneNumber: String = "",
    val address: String = "",
    val nic: String = "",
    val dob: String = "",
    val role: String = ""
)