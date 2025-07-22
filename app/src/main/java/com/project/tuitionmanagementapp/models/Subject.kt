package com.project.tuitionmanagementapp.models

data class Subject(
    val id: String,
    val name: String,
    val code: String,
    val description: String,
    val creditHours: Int
)