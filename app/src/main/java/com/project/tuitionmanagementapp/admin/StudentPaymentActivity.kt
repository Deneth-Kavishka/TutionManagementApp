package com.project.tuitionmanagementapp.admin

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.project.tuitionmanagementapp.R
import com.project.tuitionmanagementapp.models.Payment
import com.project.tuitionmanagementapp.models.PaymentMethod
import com.project.tuitionmanagementapp.models.PaymentStatus
import com.project.tuitionmanagementapp.models.Student
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class StudentPaymentActivity : AppCompatActivity() {

    private lateinit var btnBack: ImageView
    private lateinit var tvStudentName: TextView
    private lateinit var tvStudentId: TextView
    private lateinit var tvClass: TextView
    private lateinit var tvPaymentStatus: TextView
    private lateinit var tvDueDate: TextView
    private lateinit var tvAmountDue: TextView
    private lateinit var imgStudentPhoto: ImageView
    private lateinit var btnScanQR: MaterialButton
    private lateinit var btnSelectByClass: MaterialButton
    private lateinit var btnSelectById: MaterialButton
    private lateinit var etPaymentAmount: TextInputEditText
    private lateinit var dropdownPaymentMethod: AutoCompleteTextView
    private lateinit var etPaymentReference: TextInputEditText
    private lateinit var etPaymentNote: TextInputEditText
    private lateinit var btnProcessPayment: MaterialButton
    private lateinit var rvPaymentHistory: RecyclerView

    private val db = FirebaseFirestore.getInstance()
    private var studentId: String? = null
    private var student: Student? = null
    private var pendingAmount: Double = 0.0
    private var nextDueDate: Date? = null

    companion object {
        private const val QR_SCAN_REQUEST_CODE = 101
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_payment)

        initializeViews()
        setupClickListeners()
        setupPaymentMethodDropdown()

        // Get student ID from intent if available
        studentId = intent.getStringExtra("student_id")
        if (studentId != null) {
            loadStudentData(studentId!!)
        }
    }

    private fun initializeViews() {
        btnBack = findViewById(R.id.btnBack)
        tvStudentName = findViewById(R.id.tvStudentName)
        tvStudentId = findViewById(R.id.tvStudentId)
        tvClass = findViewById(R.id.tvClass)
        tvPaymentStatus = findViewById(R.id.tvPaymentStatus)
        tvDueDate = findViewById(R.id.tvDueDate)
        tvAmountDue = findViewById(R.id.tvAmountDue)
        imgStudentPhoto = findViewById(R.id.imgStudentPhoto)
        btnScanQR = findViewById(R.id.btnScanQR)
        btnSelectByClass = findViewById(R.id.btnSelectByClass)
        btnSelectById = findViewById(R.id.btnSelectById)
        etPaymentAmount = findViewById(R.id.etPaymentAmount)
        dropdownPaymentMethod = findViewById(R.id.dropdownPaymentMethod)
        etPaymentReference = findViewById(R.id.etPaymentReference)
        etPaymentNote = findViewById(R.id.etPaymentNote)
        btnProcessPayment = findViewById(R.id.btnProcessPayment)
        rvPaymentHistory = findViewById(R.id.rvPaymentHistory)

        rvPaymentHistory.layoutManager = LinearLayoutManager(this)
    }

    private fun setupClickListeners() {
        btnBack.setOnClickListener { finish() }

        btnScanQR.setOnClickListener {
            val intent = Intent(this, QRScannerActivity::class.java)
            intent.putExtra("scan_type", "student_payment")
            startActivityForResult(intent, QR_SCAN_REQUEST_CODE)
        }

        btnProcessPayment.setOnClickListener {
            if (validatePaymentInput()) {
                showPaymentConfirmationDialog()
            }
        }

        btnSelectByClass.setOnClickListener {
            showClassSelectionDialog()
        }

        btnSelectById.setOnClickListener {
            showStudentIdSelectionDialog()
        }
    }

    private fun setupPaymentMethodDropdown() {
        val paymentMethods = PaymentMethod.values().map { it.displayName }
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, paymentMethods)
        dropdownPaymentMethod.setAdapter(adapter)
        dropdownPaymentMethod.setText(PaymentMethod.CASH.displayName, false)
    }

    private fun loadStudentData(studentId: String) {
        db.collection("students").document(studentId)
            .get()
            .addOnSuccessListener { document ->
                if (document != null && document.exists()) {
                    student = document.toObject(Student::class.java)?.copy(id = document.id)
                    updateStudentUI()
                    loadPaymentHistory(studentId)
                    calculatePaymentStatus(studentId)
                } else {
                    Toast.makeText(this, "Student not found", Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error loading student: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun updateStudentUI() {
        student?.let { student ->
            tvStudentName.text = student.fullName
            tvStudentId.text = "ID: ${student.studentId}"
            tvClass.text = "Class: ${student.currentGrade}"

            // Load student photo if available
            if (student.profileImageUrl.isNotEmpty()) {
                // Use image loading library like Glide
                // Glide.with(this).load(student.profileImageUrl).into(imgStudentPhoto)
            }

            // Set default payment amount (you can calculate this based on student fees)
            etPaymentAmount.setText(student.pendingAmount.toString())
            pendingAmount = student.pendingAmount
        }
    }

    private fun calculatePaymentStatus(studentId: String) {
        val currentMonth = SimpleDateFormat("yyyy-MM", Locale.getDefault()).format(Date())

        db.collection("payments")
            .whereEqualTo("studentId", studentId)
            .orderBy("paymentDate", Query.Direction.DESCENDING)
            .limit(1)
            .get()
            .addOnSuccessListener { documents ->
                if (!documents.isEmpty) {
                    val lastPayment = documents.documents[0].toObject(Payment::class.java)

                    // Calculate next due date
                    val calendar = Calendar.getInstance()
                    lastPayment?.paymentDate?.let {
                        calendar.time = it
                        calendar.add(Calendar.MONTH, 1)
                        nextDueDate = calendar.time
                    }

                    // Determine payment status
                    val lastPaymentMonth = lastPayment?.paymentMonth ?: ""
                    if (lastPaymentMonth == currentMonth) {
                        // Paid for current month
                        updatePaymentStatusUI(PaymentStatus.PAID)
                    } else {
                        // Check if overdue
                        if (nextDueDate != null && nextDueDate!! < Date()) {
                            updatePaymentStatusUI(PaymentStatus.OVERDUE)
                        } else {
                            updatePaymentStatusUI(PaymentStatus.PENDING)
                        }
                    }
                } else {
                    // No previous payments found
                    updatePaymentStatusUI(PaymentStatus.PENDING)
                }
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error loading payment status: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun updatePaymentStatusUI(status: PaymentStatus) {
        tvPaymentStatus.text = "Payment Status: ${status.displayName}"
        tvPaymentStatus.setTextColor(status.colorResId)

        if (nextDueDate != null) {
            val dateFormat = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())
            tvDueDate.text = "Due Date: ${dateFormat.format(nextDueDate!!)}"
        } else {
            tvDueDate.text = "Due Date: Immediate"
        }

        tvAmountDue.text = "Amount Due: ₹$pendingAmount"
    }

    private fun loadPaymentHistory(studentId: String) {
        db.collection("payments")
            .whereEqualTo("studentId", studentId)
            .orderBy("paymentDate", Query.Direction.DESCENDING)
            .get()
            .addOnSuccessListener { documents ->
                val payments = documents.map { doc ->
                    doc.toObject(Payment::class.java).copy(id = doc.id)
                }

                if (payments.isNotEmpty()) {
                    val adapter = PaymentHistoryAdapter(payments) { payment ->
                        // Handle payment item click - maybe show details dialog
                        showPaymentDetailsDialog(payment)
                    }
                    rvPaymentHistory.adapter = adapter
                } else {
                    // No payment history yet
                    val emptyList = emptyList<Payment>()
                    rvPaymentHistory.adapter = PaymentHistoryAdapter(emptyList) { }
                }
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error loading payment history: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun showPaymentDetailsDialog(payment: Payment) {
        val dateFormat = SimpleDateFormat("MMM dd, yyyy HH:mm", Locale.getDefault())
        val dialog = AlertDialog.Builder(this)
            .setTitle("Payment Details")
            .setMessage("""
                Amount: ₹${payment.amount}
                Date: ${dateFormat.format(payment.paymentDate)}
                Method: ${payment.paymentMethod}
                Reference: ${payment.referenceNumber}
                Status: ${payment.status}
                Note: ${payment.note}
                Processed by: ${payment.processedBy}
            """.trimIndent())
            .setPositiveButton("OK", null)
            .create()
        dialog.show()
    }

    private fun validatePaymentInput(): Boolean {
        if (student == null) {
            Toast.makeText(this, "Please select a student first", Toast.LENGTH_SHORT).show()
            return false
        }

        val amountText = etPaymentAmount.text.toString()
        if (amountText.isEmpty()) {
            etPaymentAmount.error = "Please enter payment amount"
            return false
        }

        val amount = amountText.toDoubleOrNull()
        if (amount == null || amount <= 0) {
            etPaymentAmount.error = "Please enter a valid amount"
            return false
        }

        val paymentMethod = dropdownPaymentMethod.text.toString()
        if (paymentMethod.isEmpty()) {
            Toast.makeText(this, "Please select a payment method", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    private fun showPaymentConfirmationDialog() {
        val amount = etPaymentAmount.text.toString().toDouble()
        val paymentMethod = dropdownPaymentMethod.text.toString()
        val reference = etPaymentReference.text.toString()

        AlertDialog.Builder(this)
            .setTitle("Confirm Payment")
            .setMessage("Process payment of ₹$amount from ${student?.fullName} using $paymentMethod?")
            .setPositiveButton("Confirm") { _, _ ->
                processPayment()
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    private fun processPayment() {
        val amount = etPaymentAmount.text.toString().toDouble()
        val paymentMethod = dropdownPaymentMethod.text.toString()
        val reference = etPaymentReference.text.toString()
        val note = etPaymentNote.text.toString()
        val currentUserId = FirebaseAuth.getInstance().currentUser?.uid ?: "unknown"
        val currentDate = Date()
        val paymentMonth = SimpleDateFormat("yyyy-MM", Locale.getDefault()).format(currentDate)

        val payment = Payment(
            studentId = studentId ?: "",
            amount = amount,
            paymentMethod = paymentMethod,
            referenceNumber = reference,
            paymentDate = currentDate,
            paymentMonth = paymentMonth,
            note = note,
            processedBy = currentUserId,
            status = "Completed",
            lastUpdated = currentDate
        )

        // Save payment to Firestore
        db.collection("payments")
            .add(payment.toMap())
            .addOnSuccessListener { documentReference ->
                // Update student payment status
                updateStudentPaymentStatus(amount)

                Toast.makeText(this, "Payment processed successfully", Toast.LENGTH_SHORT).show()

                // Clear payment form and reload payment history
                clearPaymentForm()
                loadPaymentHistory(studentId!!)
                calculatePaymentStatus(studentId!!)
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error processing payment: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun updateStudentPaymentStatus(paymentAmount: Double) {
        student?.let { student ->
            // Calculate new pending amount
            val newPendingAmount = (student.pendingAmount - paymentAmount).coerceAtLeast(0.0)
            val newPaidAmount = student.paidAmount + paymentAmount

            val updates = hashMapOf<String, Any>(
                "pendingAmount" to newPendingAmount,
                "paidAmount" to newPaidAmount,
                "paymentStatus" to PaymentStatus.PAID.displayName,
                "lastUpdated" to Timestamp.now()
            )

            db.collection("students").document(student.id)
                .update(updates)
                .addOnSuccessListener {
                    // Update local student object
                    this.student = this.student?.copy(
                        pendingAmount = newPendingAmount,
                        paidAmount = newPaidAmount,
                        paymentStatus = PaymentStatus.PAID.displayName
                    )

                    // Schedule next payment status update
                    scheduleNextPaymentStatusUpdate(student.id)

                    // Generate and show receipt
                    generateReceipt(paymentAmount)
                }
                .addOnFailureListener { e ->
                    Toast.makeText(this, "Error updating student status: ${e.message}", Toast.LENGTH_SHORT).show()
                }
        }
    }

    private fun generateReceipt(amount: Double) {
        val receiptDialog = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogView = inflater.inflate(R.layout.dialog_payment_receipt, null)

        // Set receipt information
        dialogView.findViewById<TextView>(R.id.tvReceiptNumber).text = "Receipt #: ${System.currentTimeMillis()}"
        dialogView.findViewById<TextView>(R.id.tvReceiptDate).text = "Date: ${SimpleDateFormat("dd MMM yyyy, HH:mm", Locale.getDefault()).format(Date())}"
        dialogView.findViewById<TextView>(R.id.tvStudentNameReceipt).text = "Student: ${student?.fullName}"
        dialogView.findViewById<TextView>(R.id.tvStudentIdReceipt).text = "ID: ${student?.studentId}"
        dialogView.findViewById<TextView>(R.id.tvClassReceipt).text = "Class: ${student?.currentGrade}"
        dialogView.findViewById<TextView>(R.id.tvTeacherNameReceipt).text = "Teacher: ${getTeacherName()}"
        dialogView.findViewById<TextView>(R.id.tvAmountReceipt).text = "Amount Paid: ₹$amount"
        dialogView.findViewById<TextView>(R.id.tvPaymentMethodReceipt).text = "Method: ${dropdownPaymentMethod.text}"
        dialogView.findViewById<TextView>(R.id.tvReferenceReceipt).text = "Reference: ${etPaymentReference.text}"

        // Add print and share buttons
        val btnPrint = dialogView.findViewById<Button>(R.id.btnPrintReceipt)
        val btnShare = dialogView.findViewById<Button>(R.id.btnShareReceipt)

        receiptDialog.setView(dialogView)
            .setCancelable(true)
            .setTitle("Payment Receipt")

        val dialog = receiptDialog.create()

        btnPrint.setOnClickListener {
            Toast.makeText(this, "Printing receipt...", Toast.LENGTH_SHORT).show()
            // Implement printing functionality here
            dialog.dismiss()
        }

        btnShare.setOnClickListener {
            // Share receipt as text
            val receiptText = """
                PAYMENT RECEIPT
                ------------------------------
                Receipt #: ${System.currentTimeMillis()}
                Date: ${SimpleDateFormat("dd MMM yyyy, HH:mm", Locale.getDefault()).format(Date())}
                
                Student: ${student?.fullName}
                ID: ${student?.studentId}
                Class: ${student?.currentGrade}
                
                Amount Paid: ₹$amount
                Method: ${dropdownPaymentMethod.text}
                Reference: ${etPaymentReference.text}
                
                Thank you for your payment!
                ACADEMIX Tuition Center
            """.trimIndent()

            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, receiptText)
                type = "text/plain"
            }
            startActivity(Intent.createChooser(shareIntent, "Share Receipt"))
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun scheduleNextPaymentStatusUpdate(studentId: String) {
        // In a real app, you would use a WorkManager or similar to schedule this
        // For this example, we'll just add a field to the student document

        val calendar = Calendar.getInstance()
        calendar.add(Calendar.MONTH, 1)
        calendar.set(Calendar.DAY_OF_MONTH, 1) // First day of next month
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)

        val nextStatusUpdateDate = calendar.time

        db.collection("students").document(studentId)
            .update("nextPaymentStatusUpdateDate", Timestamp(nextStatusUpdateDate))
            .addOnSuccessListener {
                // This would be used by a scheduled job to update payment status
                Toast.makeText(this, "Next payment due on ${SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(nextStatusUpdateDate)}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun clearPaymentForm() {
        etPaymentAmount.setText("")
        dropdownPaymentMethod.setText(PaymentMethod.CASH.displayName, false)
        etPaymentReference.setText("")
        etPaymentNote.setText("")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == QR_SCAN_REQUEST_CODE && resultCode == RESULT_OK) {
            val scannedStudentId = data?.getStringExtra("scanned_data")
            if (!scannedStudentId.isNullOrEmpty()) {
                studentId = scannedStudentId
                loadStudentData(scannedStudentId)
                Toast.makeText(this, "Student found via QR scan", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showClassSelectionDialog() {
        // Get list of available classes from Firestore
        db.collection("students")
            .whereEqualTo("isActive", true)
            .get()
            .addOnSuccessListener { documents ->
                val classes = documents.mapNotNull { doc ->
                    doc.toObject(Student::class.java).currentGrade
                }.distinct().sorted()

                if (classes.isNotEmpty()) {
                    val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, classes)
                    AlertDialog.Builder(this)
                        .setTitle("Select Class")
                        .setAdapter(adapter) { _, which ->
                            val selectedClass = classes[which]
                            showStudentsInClass(selectedClass)
                        }
                        .setNegativeButton("Cancel", null)
                        .show()
                } else {
                    Toast.makeText(this, "No classes found", Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error loading classes: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun showStudentsInClass(className: String) {
        db.collection("students")
            .whereEqualTo("currentGrade", className)
            .whereEqualTo("isActive", true)
            .get()
            .addOnSuccessListener { documents ->
                val students = documents.map { doc ->
                    doc.toObject(Student::class.java).copy(id = doc.id)
                }

                if (students.isNotEmpty()) {
                    val studentNames = students.map { "${it.fullName} (${it.studentId})" }
                    val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, studentNames)

                    AlertDialog.Builder(this)
                        .setTitle("Select Student from $className")
                        .setAdapter(adapter) { _, which ->
                            val selectedStudent = students[which]
                            studentId = selectedStudent.id
                            loadStudentData(selectedStudent.id)
                            Toast.makeText(this, "Selected: ${selectedStudent.fullName}", Toast.LENGTH_SHORT).show()
                        }
                        .setNegativeButton("Back") { _, _ ->
                            showClassSelectionDialog()
                        }
                        .show()
                } else {
                    Toast.makeText(this, "No students found in $className", Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error loading students: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun showStudentIdSelectionDialog() {
        val editText = com.google.android.material.textfield.TextInputEditText(this)
        editText.hint = "Enter Student ID (e.g., STU001)"

        val inputLayout = com.google.android.material.textfield.TextInputLayout(this)
        inputLayout.addView(editText)
        inputLayout.setPadding(50, 0, 50, 0)

        AlertDialog.Builder(this)
            .setTitle("Enter Student ID")
            .setView(inputLayout)
            .setPositiveButton("Search") { _, _ ->
                val enteredId = editText.text.toString().trim()
                if (enteredId.isNotEmpty()) {
                    searchStudentById(enteredId)
                } else {
                    Toast.makeText(this, "Please enter a student ID", Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    private fun searchStudentById(studentIdInput: String) {
        db.collection("students")
            .whereEqualTo("studentId", studentIdInput)
            .whereEqualTo("isActive", true)
            .get()
            .addOnSuccessListener { documents ->
                if (!documents.isEmpty) {
                    val student = documents.documents[0].toObject(Student::class.java)?.copy(id = documents.documents[0].id)
                    student?.let {
                        studentId = it.id
                        loadStudentData(it.id)
                        Toast.makeText(this, "Found: ${it.fullName}", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "Student with ID '$studentIdInput' not found", Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error searching student: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun getTeacherName(): String {
        // In a real app, you would fetch this from the database or session
        return "John Doe"
    }
}
