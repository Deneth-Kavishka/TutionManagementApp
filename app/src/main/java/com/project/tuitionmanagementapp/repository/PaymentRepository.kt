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
            ),
            Payment(
                id = "PAY003",
                studentId = "STD002",
                amount = 1500.0,
                paymentDate = Date(),
                paymentMethod = "Cash",
                description = "Tuition Fee - Partial",
                status = "COMPLETED",
                receiptNumber = "RCP003",
                dueDate = Date()
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