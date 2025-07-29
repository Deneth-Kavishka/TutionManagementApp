package com.project.tuitionmanagementapp.teacher

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.firestore.FirebaseFirestore
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult
import com.project.tuitionmanagementapp.R
import java.text.SimpleDateFormat
import java.util.*

class QRAttendanceActivity : AppCompatActivity() {

    private lateinit var btnBack: ImageView
    private lateinit var btnFlashlight: ImageView
    private lateinit var recyclerAttendance: RecyclerView
    private lateinit var bottomNavigation: BottomNavigationView
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase
    private lateinit var firestore: FirebaseFirestore
    private lateinit var attendanceRef: DatabaseReference

    private val attendanceList = mutableListOf<AttendanceRecord>()
    private lateinit var attendanceAdapter: AttendanceRecordAdapter

    data class AttendanceRecord(
        val studentId: String = "",
        val studentName: String = "",
        val timestamp: String = "",
        val status: String = "Present",
        val paymentStatus: String = "",
        val pendingAmount: Double = 0.0
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qr_attendance)

        // Initialize Firebase - Use Realtime Database for attendance
        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        firestore = FirebaseFirestore.getInstance() // Still use for student data

        val today = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
        attendanceRef = database.reference.child("attendance").child(today)

        initViews()
        setupBottomNavigation()
        setupRecyclerView()
        setupClickListeners()
        setupRealtimeAttendanceListener()

        // Start scanner automatically
        startQRScanner()
    }

    private fun initViews() {
        btnBack = findViewById(R.id.btnBack)
        btnFlashlight = findViewById(R.id.btnFlashlight)
        recyclerAttendance = findViewById(R.id.recyclerAttendance)
        bottomNavigation = findViewById(R.id.bottomNavigation)
    }

    private fun setupBottomNavigation() {
        bottomNavigation.selectedItemId = R.id.nav_qr
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, TeacherDashboardActivity::class.java))
                    finish()
                    true
                }
                R.id.nav_assignment -> {
                    startActivity(Intent(this, AssignmentActivity::class.java))
                    finish()
                    true
                }
                R.id.nav_materials -> {
                    startActivity(Intent(this, TeacherMaterialsManagementActivity::class.java))
                    finish()
                    true
                }
                R.id.nav_result -> {
                    startActivity(Intent(this, UploadResultActivity::class.java))
                    finish()
                    true
                }
                R.id.nav_qr -> true // Stay on current page
                else -> false
            }
        }
    }

    private fun setupRecyclerView() {
        attendanceAdapter = AttendanceRecordAdapter(attendanceList)
        recyclerAttendance.layoutManager = LinearLayoutManager(this)
        recyclerAttendance.adapter = attendanceAdapter
    }

    private fun setupClickListeners() {
        btnBack.setOnClickListener {
            finish()
        }

        btnFlashlight.setOnClickListener {
            Toast.makeText(this, "Flashlight toggled", Toast.LENGTH_SHORT).show()
        }

        // Enable scan again functionality
        findViewById<androidx.cardview.widget.CardView>(R.id.btnScanAgain).setOnClickListener {
            startQRScanner()
        }
    }

    private fun startQRScanner() {
        val integrator = IntentIntegrator(this)
        integrator.setPrompt("Scan Student QR Code for Attendance")
        integrator.setBeepEnabled(true)
        integrator.setOrientationLocked(true)
        integrator.setCameraId(0) // Use back camera
        integrator.setBarcodeImageEnabled(true)
        integrator.initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result: IntentResult? = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)

        if (result != null) {
            if (result.contents == null) {
                Toast.makeText(this, "Scan cancelled", Toast.LENGTH_SHORT).show()
                finish() // Go back to previous screen
            } else {
                try {
                    val studentId = result.contents.trim()
                    Toast.makeText(this, "QR Scanned: $studentId", Toast.LENGTH_LONG).show()
                    processScannedStudentId(studentId)
                } catch (e: Exception) {
                    Toast.makeText(this, "Error processing QR: ${e.message}", Toast.LENGTH_LONG).show()
                    e.printStackTrace()
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    private fun processScannedStudentId(studentId: String) {
        // Show immediate feedback
        Toast.makeText(this, "Processing student ID: $studentId", Toast.LENGTH_SHORT).show()

        // Check if student already marked present today
        if (isStudentAlreadyMarked(studentId)) {
            Toast.makeText(this, "Student already marked present today", Toast.LENGTH_LONG).show()
            return
        }

        // Fetch student details and record attendance
        fetchStudentDetailsAndRecordAttendance(studentId)
    }

    private fun isStudentAlreadyMarked(studentId: String): Boolean {
        return attendanceList.any { record -> record.studentId == studentId }
    }

    private fun fetchStudentDetailsAndRecordAttendance(studentId: String) {
        Toast.makeText(this, "Fetching student details...", Toast.LENGTH_SHORT).show()

        // Get student from Firestore (for detailed info)
        firestore.collection("students")
            .document(studentId)
            .get()
            .addOnSuccessListener { document ->
                if (document.exists()) {
                    val studentName = document.getString("name") ?: "Unknown Student"
                    val paymentStatus = document.getString("paymentStatus") ?: "UNKNOWN"
                    val pendingAmount = document.getDouble("pendingAmount") ?: 0.0

                    // Show student details popup instead of auto-marking
                    showStudentDetailsDialog(studentId, studentName, paymentStatus, pendingAmount)
                } else {
                    // Student not found in Firestore, check Realtime Database
                    checkStudentInRealtimeDatabase(studentId)
                }
            }
            .addOnFailureListener {
                checkStudentInRealtimeDatabase(studentId)
            }
    }

    private fun checkStudentInRealtimeDatabase(studentId: String) {
        database.reference.child("students").child(studentId)
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        val studentName = snapshot.child("name").getValue(String::class.java) ?: "Student $studentId"
                        val paymentStatus = snapshot.child("paymentStatus").getValue(String::class.java) ?: "UNKNOWN"
                        val pendingAmount = snapshot.child("pendingAmount").getValue(Double::class.java) ?: 0.0

                        showStudentDetailsDialog(studentId, studentName, paymentStatus, pendingAmount)
                    } else {
                        showStudentDetailsDialog(studentId, "Student $studentId", "UNKNOWN", 0.0)
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    showStudentDetailsDialog(studentId, "Student $studentId", "UNKNOWN", 0.0)
                }
            })
    }

    private fun showStudentDetailsDialog(studentId: String, studentName: String, paymentStatus: String, pendingAmount: Double) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_student_attendance)
        dialog.setCancelable(true)

        // Find views in dialog
        val tvStudentName = dialog.findViewById<TextView>(R.id.tvDialogStudentName)
        val tvStudentId = dialog.findViewById<TextView>(R.id.tvDialogStudentId)
        val tvPaymentStatus = dialog.findViewById<TextView>(R.id.tvDialogPaymentStatus)
        val tvPaymentAmount = dialog.findViewById<TextView>(R.id.tvDialogPaymentAmount)
        val paymentWarningCard = dialog.findViewById<CardView>(R.id.paymentWarningCard)
        val btnCloseDialog = dialog.findViewById<ImageView>(R.id.btnCloseDialog)
        val btnMarkPresent = dialog.findViewById<Button>(R.id.btnMarkPresent)
        val btnMarkLate = dialog.findViewById<Button>(R.id.btnMarkLate)
        val btnScanNext = dialog.findViewById<Button>(R.id.btnScanNext)
        val btnViewList = dialog.findViewById<Button>(R.id.btnViewList)

        // Set student information
        tvStudentName.text = studentName
        tvStudentId.text = "ID: $studentId"

        // Set payment status with colors and warnings
        when (paymentStatus) {
            "PAID" -> {
                tvPaymentStatus.text = "✅ PAID"
                tvPaymentStatus.setTextColor(getColor(android.R.color.holo_green_dark))
                paymentWarningCard.visibility = android.view.View.GONE
            }
            "PENDING" -> {
                tvPaymentStatus.text = "⚠️ PENDING"
                tvPaymentStatus.setTextColor(getColor(android.R.color.holo_orange_dark))
                tvPaymentAmount.text = "Outstanding: Rs.${String.format("%.2f", pendingAmount)}"
                tvPaymentAmount.visibility = android.view.View.VISIBLE
                paymentWarningCard.visibility = android.view.View.VISIBLE
            }
            "OVERDUE" -> {
                tvPaymentStatus.text = "❌ OVERDUE"
                tvPaymentStatus.setTextColor(getColor(android.R.color.holo_red_dark))
                tvPaymentAmount.text = "Overdue: Rs.${String.format("%.2f", pendingAmount)}"
                tvPaymentAmount.visibility = android.view.View.VISIBLE
                paymentWarningCard.visibility = android.view.View.VISIBLE
            }
            else -> {
                tvPaymentStatus.text = "ℹ️ UNKNOWN"
                tvPaymentStatus.setTextColor(getColor(android.R.color.darker_gray))
                paymentWarningCard.visibility = android.view.View.GONE
            }
        }

        // Set click listeners
        btnCloseDialog.setOnClickListener {
            dialog.dismiss()
        }

        btnMarkPresent.setOnClickListener {
            markAttendance(studentId, studentName, "Present", paymentStatus, pendingAmount)
            dialog.dismiss()
        }

        btnMarkLate.setOnClickListener {
            markAttendance(studentId, studentName, "Late", paymentStatus, pendingAmount)
            dialog.dismiss()
        }

        btnScanNext.setOnClickListener {
            dialog.dismiss()
            startQRScanner() // Start scanner for next student
        }

        btnViewList.setOnClickListener {
            dialog.dismiss()
            // Scroll to attendance list (already visible on screen)
            recyclerAttendance.smoothScrollToPosition(0)
        }

        dialog.show()
    }

    private fun markAttendance(studentId: String, studentName: String, status: String, paymentStatus: String, pendingAmount: Double) {
        val currentTime = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date())
        val attendanceRecord = AttendanceRecord(
            studentId = studentId,
            studentName = studentName,
            timestamp = currentTime,
            status = status,
            paymentStatus = paymentStatus,
            pendingAmount = pendingAmount
        )

        // Save to Realtime Database for instant sync
        saveAttendanceToRealtime(attendanceRecord)

        // Show success message
        val statusIcon = if (status == "Present") "✅" else "⏰"
        val paymentInfo = when (paymentStatus) {
            "PAID" -> " | Payment: ✅ Up to date"
            "PENDING" -> " | Payment: ⚠️ Rs.${String.format("%.0f", pendingAmount)} pending"
            "OVERDUE" -> " | Payment: ❌ Rs.${String.format("%.0f", pendingAmount)} overdue"
            else -> ""
        }
        Toast.makeText(this, "$statusIcon $studentName marked as $status$paymentInfo", Toast.LENGTH_LONG).show()
    }

    private fun saveAttendanceToRealtime(record: AttendanceRecord) {
        val teacherId = auth.currentUser?.uid ?: return

        val attendanceData = hashMapOf(
            "studentId" to record.studentId,
            "studentName" to record.studentName,
            "timestamp" to record.timestamp,
            "status" to record.status,
            "paymentStatus" to record.paymentStatus,
            "pendingAmount" to record.pendingAmount,
            "teacherId" to teacherId,
            "date" to SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date()),
            "time" to SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())
        )

        // Save to Realtime Database for instant updates
        val recordKey = attendanceRef.push().key
        if (recordKey != null) {
            attendanceRef.child(recordKey).setValue(attendanceData)
                .addOnSuccessListener {
                    Toast.makeText(this, "✅ Attendance recorded for ${record.studentName}", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { exception ->
                    Toast.makeText(this, "❌ Failed to record attendance: ${exception.message}", Toast.LENGTH_SHORT).show()
                }
        }
    }

    private fun setupRealtimeAttendanceListener() {
        val teacherId = auth.currentUser?.uid ?: return

        // Listen for real-time attendance updates
        attendanceRef.orderByChild("teacherId").equalTo(teacherId)
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    attendanceList.clear()
                    for (recordSnapshot in snapshot.children) {
                        val record = recordSnapshot.getValue(AttendanceRecord::class.java)
                        record?.let { attendanceList.add(it) }
                    }
                    // Sort by timestamp (newest first)
                    attendanceList.sortByDescending { it.timestamp }
                    attendanceAdapter.notifyDataSetChanged()
                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(this@QRAttendanceActivity, "Failed to load attendance: ${error.message}", Toast.LENGTH_SHORT).show()
                }
            })
    }

    override fun onResume() {
        super.onResume()
        // Load today's attendance on resume
        // This may be redundant with real-time updates, but ensures local state is updated
        loadTodayAttendance()
    }

    private fun loadTodayAttendance() {
        val teacherId = auth.currentUser?.uid ?: return
        val today = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())

        firestore.collection("attendance")
            .whereEqualTo("teacherId", teacherId)
            .whereEqualTo("date", today)
            .get()
            .addOnSuccessListener { documents ->
                attendanceList.clear()
                for (document in documents) {
                    val record = AttendanceRecord(
                        studentId = document.getString("studentId") ?: "",
                        studentName = document.getString("studentName") ?: "",
                        timestamp = document.getString("timestamp") ?: "",
                        status = document.getString("status") ?: "Present"
                    )
                    attendanceList.add(record)
                }
                // Sort by timestamp (newest first)
                attendanceList.sortByDescending { it.timestamp }
                attendanceAdapter.notifyDataSetChanged()
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this, "Failed to load attendance: ${exception.message}", Toast.LENGTH_SHORT).show()
            }
    }
}
