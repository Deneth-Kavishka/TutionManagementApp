package com.project.tuitionmanagementapp.models

import com.google.firebase.Timestamp
import java.util.Date

data class Payment(
    val id: String = "",
    val studentId: String = "",
    val amount: Double = 0.0,
    val paymentMethod: String = "",
    val referenceNumber: String = "",
    val paymentDate: Date = Date(),
    val paymentMonth: String = "", // Format: YYYY-MM
    val note: String = "",
    val processedBy: String = "",
    val status: String = "Completed", // "Completed", "Failed", "Refunded"
    val receiptUrl: String = "",
    val lastUpdated: Date = Date()
) {
    // Calculate next due date (1 month from payment date)
    fun getNextDueDate(): Date {
        val calendar = java.util.Calendar.getInstance()
        calendar.time = paymentDate
        calendar.add(java.util.Calendar.MONTH, 1)
        return calendar.time
    }

    // Convert to Map for Firestore
    fun toMap(): Map<String, Any> {
        return mapOf(
            "studentId" to studentId,
            "amount" to amount,
            "paymentMethod" to paymentMethod,
            "referenceNumber" to referenceNumber,
            "paymentDate" to Timestamp(paymentDate),
            "paymentMonth" to paymentMonth,
            "note" to note,
            "processedBy" to processedBy,
            "status" to status,
            "receiptUrl" to receiptUrl,
            "lastUpdated" to Timestamp(lastUpdated)
        )
    }
}

// Enum class for payment methods
enum class PaymentMethod(val displayName: String) {
    CASH("Cash"),
    CREDIT_CARD("Credit Card"),
    DEBIT_CARD("Debit Card"),
    BANK_TRANSFER("Bank Transfer"),
    MOBILE_PAYMENT("Mobile Payment")
}

// Enum class for payment status
enum class PaymentStatus(val displayName: String, val colorResId: Int) {
    PAID("Paid", android.graphics.Color.GREEN),
    PENDING("Pending", android.graphics.Color.YELLOW),
    OVERDUE("Overdue", android.graphics.Color.RED)
}
