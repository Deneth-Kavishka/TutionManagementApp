package com.project.tuitionmanagementapp.models

import java.util.Date

data class Student(
    val id: String,
    val name: String,
    val className: String,
    val grade: String,
    val section: String,
    val rollNumber: String,
    val dateOfBirth: String,
    val gender: String,
    val email: String,
    val phone: String,
    val address: String,
    val parentName: String,
    val parentPhone: String,
    val parentEmail: String,
    val admissionDate: String,
    val photoUrl: String,
    val attendanceRate: Int,
    val paymentStatus: String, // PAID, PENDING, OVERDUE
    val gradeAverage: String,
    val totalFees: Double,
    val paidAmount: Double,
    val pendingAmount: Double,
    val isActive: Boolean = true
)
