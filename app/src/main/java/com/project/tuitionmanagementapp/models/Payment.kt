package com.project.tuitionmanagementapp.models

import java.util.*

data class Payment(
    val id: String,
    val studentId: String,
    val amount: Double,
    val paymentDate: Date,
    val paymentMethod: String,
    val description: String,
    val status: String, // COMPLETED, PENDING, FAILED
    val receiptNumber: String,
    val dueDate: Date
)