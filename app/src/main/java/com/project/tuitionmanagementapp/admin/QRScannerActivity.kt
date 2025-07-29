package com.project.tuitionmanagementapp.admin

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.database.FirebaseDatabase
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult
import com.project.tuitionmanagementapp.R
import java.text.SimpleDateFormat
import java.util.*

class QRScannerActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var firestore: FirebaseFirestore
    private lateinit var database: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qr_scanner)

        // Initialize Firebase
        auth = FirebaseAuth.getInstance()
        firestore = FirebaseFirestore.getInstance()
        database = FirebaseDatabase.getInstance()

        initViews()
        startQRScanner()
    }

    private fun initViews() {
        findViewById<ImageView>(R.id.btnBack)?.setOnClickListener {
            finish()
        }

        findViewById<Button>(R.id.btnScanAgain)?.setOnClickListener {
            startQRScanner()
        }
    }

    private fun startQRScanner() {
        val integrator = IntentIntegrator(this)
        integrator.setPrompt("Scan Student QR Code for Details & Payment")
        integrator.setBeepEnabled(true)
        integrator.setOrientationLocked(true)
        integrator.setCameraId(0)
        integrator.setBarcodeImageEnabled(true)
        integrator.initiateScan()
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result: IntentResult? = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)

        if (result != null) {
            if (result.contents == null) {
                Toast.makeText(this, "Scan cancelled", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                try {
                    val studentId = result.contents.trim()
                    Toast.makeText(this, "QR Scanned: $studentId", Toast.LENGTH_LONG).show()

                    // Show "Scan Again" button while processing
                    findViewById<Button>(R.id.btnScanAgain)?.visibility = android.view.View.VISIBLE

                    fetchStudentDetailsAndShowDialog(studentId)
                } catch (e: Exception) {
                    Toast.makeText(this, "Error processing QR: ${e.message}", Toast.LENGTH_LONG).show()
                    e.printStackTrace()
                    // Show error dialog instead of just closing
                    showInvalidQRDialog("Error", "Failed to process QR code: ${e.message}")
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    private fun fetchStudentDetailsAndShowDialog(studentId: String) {
        Toast.makeText(this, "Loading student details...", Toast.LENGTH_SHORT).show()

        // Validate QR content first
        if (studentId.isBlank() || studentId.length < 3) {
            showInvalidQRDialog("Invalid QR Code", "The scanned QR code does not contain a valid student ID.")
            return
        }

        // Try Firestore first
        firestore.collection("students")
            .document(studentId)
            .get()
            .addOnSuccessListener { document ->
                if (document.exists()) {
                    val studentName = document.getString("name") ?: "Unknown Student"
                    val email = document.getString("email") ?: ""
                    val grade = document.getString("grade") ?: ""
                    val phone = document.getString("phone") ?: ""
                    val address = document.getString("address") ?: ""
                    val paymentStatus = document.getString("paymentStatus") ?: "UNKNOWN"
                    val pendingAmount = document.getDouble("pendingAmount") ?: 0.0
                    val lastPaymentDate = document.getString("lastPaymentDate") ?: ""
                    val monthlyFee = document.getDouble("monthlyFee") ?: 0.0
                    val parentName = document.getString("parentName") ?: ""
                    val parentPhone = document.getString("parentPhone") ?: ""

                    showStudentDetailsDialog(
                        studentId, studentName, email, grade, phone, address,
                        paymentStatus, pendingAmount, lastPaymentDate, monthlyFee,
                        parentName, parentPhone
                    )
                } else {
                    // Try Realtime Database
                    checkStudentInRealtimeDatabase(studentId)
                }
            }
            .addOnFailureListener {
                checkStudentInRealtimeDatabase(studentId)
            }
    }

    private fun checkStudentInRealtimeDatabase(studentId: String) {
        database.reference.child("students").child(studentId)
            .get()
            .addOnSuccessListener { snapshot ->
                if (snapshot.exists()) {
                    val studentName = snapshot.child("name").getValue(String::class.java) ?: "Student $studentId"
                    val email = snapshot.child("email").getValue(String::class.java) ?: ""
                    val grade = snapshot.child("grade").getValue(String::class.java) ?: ""
                    val phone = snapshot.child("phone").getValue(String::class.java) ?: ""
                    val address = snapshot.child("address").getValue(String::class.java) ?: ""
                    val paymentStatus = snapshot.child("paymentStatus").getValue(String::class.java) ?: "UNKNOWN"
                    val pendingAmount = snapshot.child("pendingAmount").getValue(Double::class.java) ?: 0.0
                    val lastPaymentDate = snapshot.child("lastPaymentDate").getValue(String::class.java) ?: ""
                    val monthlyFee = snapshot.child("monthlyFee").getValue(Double::class.java) ?: 0.0
                    val parentName = snapshot.child("parentName").getValue(String::class.java) ?: ""
                    val parentPhone = snapshot.child("parentPhone").getValue(String::class.java) ?: ""

                    showStudentDetailsDialog(
                        studentId, studentName, email, grade, phone, address,
                        paymentStatus, pendingAmount, lastPaymentDate, monthlyFee,
                        parentName, parentPhone
                    )
                } else {
                    // No student found in either database
                    showInvalidQRDialog(
                        "Student Not Found",
                        "No student found with ID: $studentId\n\nThis QR code may not be from our system or the student may not be registered yet."
                    )
                }
            }
            .addOnFailureListener { exception ->
                showInvalidQRDialog(
                    "Database Error",
                    "Failed to verify student ID: ${exception.message ?: "Unknown error"}\n\nPlease check your internet connection and try again."
                )
            }
    }

    private fun showInvalidQRDialog(title: String, message: String) {
        val dialog = android.app.AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setIcon(android.R.drawable.ic_dialog_alert)
            .setPositiveButton("Scan Again") { _, _ ->
                startQRScanner()
            }
            .setNegativeButton("Cancel") { _, _ ->
                finish()
            }
            .setCancelable(false)
            .create()

        dialog.show()
    }

    private fun showStudentDetailsDialog(
        studentId: String, studentName: String, email: String, grade: String,
        phone: String, address: String, paymentStatus: String, pendingAmount: Double,
        lastPaymentDate: String, monthlyFee: Double, parentName: String, parentPhone: String
    ) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_admin_student_details)
        dialog.setCancelable(true)

        // Find views in dialog
        val tvStudentName = dialog.findViewById<TextView>(R.id.tvStudentName)
        val tvStudentId = dialog.findViewById<TextView>(R.id.tvStudentId)
        val tvEmail = dialog.findViewById<TextView>(R.id.tvEmail)
        val tvGrade = dialog.findViewById<TextView>(R.id.tvGrade)
        val tvPhone = dialog.findViewById<TextView>(R.id.tvPhone)
        val tvAddress = dialog.findViewById<TextView>(R.id.tvAddress)
        val tvPaymentStatus = dialog.findViewById<TextView>(R.id.tvPaymentStatus)
        val tvPendingAmount = dialog.findViewById<TextView>(R.id.tvPendingAmount)
        val tvLastPayment = dialog.findViewById<TextView>(R.id.tvLastPayment)
        val tvMonthlyFee = dialog.findViewById<TextView>(R.id.tvMonthlyFee)
        val tvParentName = dialog.findViewById<TextView>(R.id.tvParentName)
        val tvParentPhone = dialog.findViewById<TextView>(R.id.tvParentPhone)

        val paymentStatusCard = dialog.findViewById<CardView>(R.id.paymentStatusCard)
        val btnCloseDialog = dialog.findViewById<ImageView>(R.id.btnCloseDialog)
        val btnMakePayment = dialog.findViewById<Button>(R.id.btnMakePayment)
        val btnEditStudent = dialog.findViewById<Button>(R.id.btnEditStudent)
        val btnViewHistory = dialog.findViewById<Button>(R.id.btnViewHistory)
        val btnScanNext = dialog.findViewById<Button>(R.id.btnScanNext)

        // Set student information with proper formatting
        tvStudentName.text = studentName
        tvStudentId.text = getString(R.string.student_id_format, studentId)
        tvEmail.text = email.ifEmpty { getString(R.string.not_provided) }
        tvGrade.text = grade.ifEmpty { getString(R.string.not_specified) }
        tvPhone.text = phone.ifEmpty { getString(R.string.not_provided) }
        tvAddress.text = address.ifEmpty { getString(R.string.not_provided) }
        tvMonthlyFee.text = getString(R.string.currency_format, String.format(Locale.getDefault(), "%.2f", monthlyFee))
        tvParentName.text = parentName.ifEmpty { getString(R.string.not_provided) }
        tvParentPhone.text = parentPhone.ifEmpty { getString(R.string.not_provided) }
        tvLastPayment.text = lastPaymentDate.ifEmpty { getString(R.string.no_payment_record) }

        // Set payment status with colors and enable/disable payment button
        when (paymentStatus) {
            "PAID" -> {
                tvPaymentStatus.text = getString(R.string.status_paid)
                tvPaymentStatus.setTextColor(getColor(R.color.payment_paid))
                tvPendingAmount.text = getString(R.string.no_pending_amount)
                paymentStatusCard.setCardBackgroundColor(getColor(R.color.light_gray))
                btnMakePayment.isEnabled = false
                btnMakePayment.text = getString(R.string.payment_up_to_date)
            }
            "PENDING" -> {
                tvPaymentStatus.text = getString(R.string.status_pending)
                tvPaymentStatus.setTextColor(getColor(R.color.payment_pending))
                tvPendingAmount.text = getString(R.string.outstanding_amount, String.format(Locale.getDefault(), "%.2f", pendingAmount))
                paymentStatusCard.setCardBackgroundColor(getColor(R.color.light_blue))
                btnMakePayment.isEnabled = true
                btnMakePayment.text = getString(R.string.process_payment)
            }
            "OVERDUE" -> {
                tvPaymentStatus.text = getString(R.string.status_overdue)
                tvPaymentStatus.setTextColor(getColor(R.color.payment_overdue))
                tvPendingAmount.text = getString(R.string.overdue_amount, String.format(Locale.getDefault(), "%.2f", pendingAmount))
                paymentStatusCard.setCardBackgroundColor(getColor(R.color.light_blue))
                btnMakePayment.isEnabled = true
                btnMakePayment.text = getString(R.string.pay_overdue_amount)
            }
            else -> {
                tvPaymentStatus.text = getString(R.string.status_unknown)
                tvPaymentStatus.setTextColor(getColor(R.color.payment_unknown))
                tvPendingAmount.text = getString(R.string.status_unknown_desc)
                paymentStatusCard.setCardBackgroundColor(getColor(R.color.background_light))
                btnMakePayment.isEnabled = true
                btnMakePayment.text = getString(R.string.set_payment_status)
            }
        }

        // Set click listeners
        btnCloseDialog.setOnClickListener {
            dialog.dismiss()
        }

        btnMakePayment.setOnClickListener {
            dialog.dismiss()
            showPaymentDialog(studentId, studentName, pendingAmount, monthlyFee)
        }

        btnEditStudent.setOnClickListener {
            dialog.dismiss()
            openEditStudentActivity(studentId)
        }

        btnViewHistory.setOnClickListener {
            dialog.dismiss()
            openStudentHistoryActivity()
        }

        btnScanNext.setOnClickListener {
            dialog.dismiss()
            startQRScanner()
        }

        dialog.show()
    }

    private fun showPaymentDialog(studentId: String, studentName: String, pendingAmount: Double, monthlyFee: Double) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_admin_payment)
        dialog.setCancelable(true)

        val tvStudentName = dialog.findViewById<TextView>(R.id.tvPaymentStudentName)
        val tvStudentId = dialog.findViewById<TextView>(R.id.tvPaymentStudentId)
        val etPaymentAmount = dialog.findViewById<TextInputEditText>(R.id.etPaymentAmount)
        val spinnerPaymentType = dialog.findViewById<Spinner>(R.id.spinnerPaymentType)
        val etPaymentNote = dialog.findViewById<TextInputEditText>(R.id.etPaymentNote)
        val btnProcessPayment = dialog.findViewById<Button>(R.id.btnProcessPayment)
        val btnCancelPayment = dialog.findViewById<Button>(R.id.btnCancelPayment)
        val tvPendingAmount = dialog.findViewById<TextView>(R.id.tvPendingAmount)
        val tvMonthlyFee = dialog.findViewById<TextView>(R.id.tvMonthlyFee)

        tvStudentName.text = studentName
        tvStudentId.text = getString(R.string.student_id_format, studentId)
        tvPendingAmount.text = getString(R.string.pending_format, String.format(Locale.getDefault(), "%.2f", pendingAmount))
        tvMonthlyFee.text = getString(R.string.monthly_fee_format, String.format(Locale.getDefault(), "%.2f", monthlyFee))
        etPaymentAmount.setText(pendingAmount.toString())

        // Setup payment type spinner
        val paymentTypes = arrayOf("Cash", "Bank Transfer", "Online Payment", "Cheque")
        spinnerPaymentType.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, paymentTypes)

        btnProcessPayment.setOnClickListener {
            val amount = etPaymentAmount.text.toString().toDoubleOrNull()
            val paymentType = spinnerPaymentType.selectedItem.toString()
            val note = etPaymentNote.text.toString()

            if (amount == null || amount <= 0) {
                Toast.makeText(this, getString(R.string.enter_valid_amount), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            processPayment(studentId, studentName, amount, paymentType, note, dialog)
        }

        btnCancelPayment.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun processPayment(studentId: String, studentName: String, amount: Double,
                              paymentType: String, note: String, dialog: Dialog) {
        val currentTime = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date())
        val paymentId = "PAY_${System.currentTimeMillis()}"

        // Create payment record
        val paymentData = hashMapOf(
            "paymentId" to paymentId,
            "studentId" to studentId,
            "studentName" to studentName,
            "amount" to amount,
            "paymentType" to paymentType,
            "note" to note,
            "timestamp" to currentTime,
            "processedBy" to (auth.currentUser?.email ?: "admin"),
            "status" to "COMPLETED"
        )

        // Save payment to database
        firestore.collection("payments")
            .document(paymentId)
            .set(paymentData)
            .addOnSuccessListener {
                // Update student payment status
                updateStudentPaymentStatus(studentId, amount)
                dialog.dismiss()

                Toast.makeText(this, getString(R.string.payment_success, String.format(Locale.getDefault(), "%.2f", amount), studentName),
                    Toast.LENGTH_LONG).show()

                // Show payment receipt dialog
                showPaymentReceiptDialog(paymentId, studentName, amount, paymentType, currentTime)
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, getString(R.string.payment_failed, e.message), Toast.LENGTH_LONG).show()
            }
    }

    private fun updateStudentPaymentStatus(studentId: String, paidAmount: Double) {
        firestore.collection("students")
            .document(studentId)
            .get()
            .addOnSuccessListener { document ->
                if (document.exists()) {
                    val currentPending = document.getDouble("pendingAmount") ?: 0.0
                    val newPending = (currentPending - paidAmount).coerceAtLeast(0.0)
                    val newStatus = if (newPending <= 0) "PAID" else "PENDING"
                    val currentTime = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())

                    val updates = hashMapOf<String, Any>(
                        "pendingAmount" to newPending,
                        "paymentStatus" to newStatus,
                        "lastPaymentDate" to currentTime
                    )

                    firestore.collection("students")
                        .document(studentId)
                        .update(updates)
                }
            }
    }

    private fun showPaymentReceiptDialog(paymentId: String, studentName: String, amount: Double,
                                       paymentType: String, timestamp: String) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_payment_receipt)
        dialog.setCancelable(true)

        val tvReceiptTitle = dialog.findViewById<TextView>(R.id.tvReceiptTitle)
        val tvReceiptPaymentId = dialog.findViewById<TextView>(R.id.tvReceiptPaymentId)
        val tvReceiptStudentName = dialog.findViewById<TextView>(R.id.tvReceiptStudentName)
        val tvReceiptAmount = dialog.findViewById<TextView>(R.id.tvReceiptAmount)
        val tvReceiptPaymentType = dialog.findViewById<TextView>(R.id.tvReceiptPaymentType)
        val tvReceiptTimestamp = dialog.findViewById<TextView>(R.id.tvReceiptTimestamp)
        val btnPrintReceipt = dialog.findViewById<Button>(R.id.btnPrintReceipt)
        val btnShareReceipt = dialog.findViewById<Button>(R.id.btnShareReceipt)
        val btnCloseReceipt = dialog.findViewById<Button>(R.id.btnCloseReceipt)

        tvReceiptTitle.text = getString(R.string.payment_receipt)
        tvReceiptPaymentId.text = getString(R.string.receipt_id_format, paymentId)
        tvReceiptStudentName.text = getString(R.string.student_name_format, studentName)
        tvReceiptAmount.text = getString(R.string.amount_format, String.format(Locale.getDefault(), "%.2f", amount))
        tvReceiptPaymentType.text = getString(R.string.payment_method_format, paymentType)
        tvReceiptTimestamp.text = getString(R.string.date_time_format, timestamp)

        btnPrintReceipt.setOnClickListener {
            Toast.makeText(this, getString(R.string.print_feature_coming_soon), Toast.LENGTH_SHORT).show()
        }

        btnShareReceipt.setOnClickListener {
            val shareText = getString(R.string.receipt_share_format,
                paymentId, studentName, String.format(Locale.getDefault(), "%.2f", amount), paymentType, timestamp)

            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, shareText)
                type = "text/plain"
            }
            startActivity(Intent.createChooser(shareIntent, getString(R.string.share_receipt)))
        }

        btnCloseReceipt.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun openEditStudentActivity(studentId: String) {
        try {
            val intent = Intent(this, StudentDetailsActivity::class.java)
            intent.putExtra("studentId", studentId)
            startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(this, getString(R.string.edit_student_coming_soon), Toast.LENGTH_SHORT).show()
        }
    }

    private fun openStudentHistoryActivity() {
        Toast.makeText(this, getString(R.string.student_history_coming_soon), Toast.LENGTH_SHORT).show()
    }
}
