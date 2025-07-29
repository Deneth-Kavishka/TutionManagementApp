package com.project.tuitionmanagementapp.repository

import com.project.tuitionmanagementapp.models.Payment
import java.util.*

object PaymentRepository {
    private val payments = mutableListOf<Payment>()

    init {
        // Initialize with mock data
        payments.addAll(listOf(
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
            ),
            Payment(
                id = "PAY003",
                studentId = "STD002",
                amount = 1500.0,
                paymentDate = Date(),
                paymentMethod = "Cash",
                note = "Tuition Fee - Partial",
                status = "COMPLETED",
                referenceNumber = "RCP003",
                paymentMonth = "2025-07"
            )
        ))
    }

    fun getPaymentsByStudentId(studentId: String): List<Payment> {
        return payments.filter { it.studentId == studentId }
    }

    fun addPayment(payment: Payment): Boolean {
        return payments.add(payment)
    }
}