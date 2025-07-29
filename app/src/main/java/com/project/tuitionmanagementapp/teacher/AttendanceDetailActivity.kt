package com.project.tuitionmanagementapp.teacher

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.project.tuitionmanagementapp.R
import java.text.SimpleDateFormat
import java.util.*

class AttendanceDetailActivity : AppCompatActivity() {

    private lateinit var btnBack: ImageView
    private lateinit var tvDate: TextView
    private lateinit var tvStatistics: TextView
    private lateinit var tvAnalysis: TextView
    private lateinit var recyclerDetailedAttendance: RecyclerView
    private lateinit var bottomNavigation: BottomNavigationView

    private lateinit var auth: FirebaseAuth
    private lateinit var firestore: FirebaseFirestore

    private val attendanceList = mutableListOf<QRAttendanceActivity.AttendanceRecord>()
    private lateinit var attendanceAdapter: AttendanceRecordAdapter

    private var selectedDate: String = ""
    private var displayDate: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attendance_detail)

        // Get data from intent
        selectedDate = intent.getStringExtra("selected_date") ?: ""
        displayDate = intent.getStringExtra("display_date") ?: ""

        // Initialize Firebase
        auth = FirebaseAuth.getInstance()
        firestore = FirebaseFirestore.getInstance()

        initViews()
        setupRecyclerView()
        setupClickListeners()
        loadDetailedAttendance()
    }

    private fun initViews() {
        btnBack = findViewById(R.id.btnBack)
        tvDate = findViewById(R.id.tvDate)
        tvStatistics = findViewById(R.id.tvStatistics)
        tvAnalysis = findViewById(R.id.tvAnalysis)
        recyclerDetailedAttendance = findViewById(R.id.recyclerDetailedAttendance)
        bottomNavigation = findViewById(R.id.bottomNavigation)

        // Set date
        tvDate.text = displayDate
    }

    private fun setupRecyclerView() {
        attendanceAdapter = AttendanceRecordAdapter(attendanceList)
        recyclerDetailedAttendance.layoutManager = LinearLayoutManager(this)
        recyclerDetailedAttendance.adapter = attendanceAdapter
    }

    private fun setupClickListeners() {
        btnBack.setOnClickListener {
            finish()
        }

        // Setup bottom navigation
        bottomNavigation.selectedItemId = R.id.nav_home
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    finish()
                    true
                }
                R.id.nav_assignment -> {
                    Toast.makeText(this, "Assignments", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_materials -> {
                    Toast.makeText(this, "Materials", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_result -> {
                    Toast.makeText(this, "Results", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_qr -> {
                    Toast.makeText(this, "QR Scanner", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }

    private fun loadDetailedAttendance() {
        val teacherId = auth.currentUser?.uid ?: return

        // Show loading state
        tvStatistics.text = "Loading attendance details..."

        firestore.collection("attendance")
            .whereEqualTo("teacherId", teacherId)
            .whereEqualTo("date", selectedDate)
            .get()
            .addOnSuccessListener { documents ->
                attendanceList.clear()

                for (document in documents) {
                    val record = QRAttendanceActivity.AttendanceRecord(
                        studentId = document.getString("studentId") ?: "",
                        studentName = document.getString("studentName") ?: "",
                        timestamp = document.getString("timestamp") ?: "",
                        status = document.getString("status") ?: "Present",
                        paymentStatus = document.getString("paymentStatus") ?: "",
                        pendingAmount = document.getDouble("pendingAmount") ?: 0.0
                    )
                    attendanceList.add(record)
                }

                // Sort by timestamp (earliest first for daily view)
                attendanceList.sortBy { it.timestamp }
                attendanceAdapter.notifyDataSetChanged()

                // Calculate and display statistics
                calculateAndDisplayAnalysis()
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this, "Failed to load detailed attendance: ${exception.message}", Toast.LENGTH_SHORT).show()
                tvStatistics.text = "Error loading data"
            }
    }

    private fun calculateAndDisplayAnalysis() {
        val totalStudents = attendanceList.size
        val presentCount = attendanceList.count { it.status == "Present" }
        val lateCount = attendanceList.count { it.status == "Late" }
        val paidCount = attendanceList.count { it.paymentStatus == "PAID" }
        val pendingCount = attendanceList.count { it.paymentStatus == "PENDING" }
        val overdueCount = attendanceList.count { it.paymentStatus == "OVERDUE" }

        // Calculate attendance rate
        val attendanceRate = if (totalStudents > 0) {
            ((presentCount + lateCount).toFloat() / totalStudents * 100).toInt()
        } else {
            0
        }

        // Calculate payment completion rate
        val paymentRate = if (totalStudents > 0) {
            (paidCount.toFloat() / totalStudents * 100).toInt()
        } else {
            0
        }

        // Statistics summary
        val statisticsText = "Total: $totalStudents | Present: $presentCount | Late: $lateCount | Attendance Rate: $attendanceRate%"
        tvStatistics.text = statisticsText

        // Detailed analysis
        val analysisBuilder = StringBuilder()
        analysisBuilder.append("📊 ATTENDANCE ANALYSIS\n\n")

        // Attendance Performance
        analysisBuilder.append("🎯 Attendance Performance: ")
        when {
            attendanceRate >= 95 -> analysisBuilder.append("Excellent (${attendanceRate}%)")
            attendanceRate >= 85 -> analysisBuilder.append("Good (${attendanceRate}%)")
            attendanceRate >= 75 -> analysisBuilder.append("Average (${attendanceRate}%)")
            else -> analysisBuilder.append("Needs Improvement (${attendanceRate}%)")
        }
        analysisBuilder.append("\n\n")

        // Payment Status Analysis
        analysisBuilder.append("💰 Payment Status:\n")
        analysisBuilder.append("• Paid: $paidCount students (${paymentRate}%)\n")
        if (pendingCount > 0) {
            analysisBuilder.append("• Pending: $pendingCount students\n")
        }
        if (overdueCount > 0) {
            analysisBuilder.append("• Overdue: $overdueCount students ⚠️\n")
        }
        analysisBuilder.append("\n")

        // Time Analysis
        val timeAnalysis = analyzeAttendanceTime()
        if (timeAnalysis.isNotEmpty()) {
            analysisBuilder.append("⏰ Time Analysis:\n")
            analysisBuilder.append(timeAnalysis)
            analysisBuilder.append("\n")
        }

        // Recommendations
        analysisBuilder.append("💡 Recommendations:\n")
        if (attendanceRate < 85) {
            analysisBuilder.append("• Follow up with absent students\n")
        }
        if (lateCount > totalStudents * 0.2) {
            analysisBuilder.append("• Consider discussing punctuality\n")
        }
        if (pendingCount + overdueCount > 0) {
            analysisBuilder.append("• Follow up on payment issues\n")
        }
        if (attendanceRate >= 90 && paymentRate >= 90) {
            analysisBuilder.append("• Great job! Class is performing well\n")
        }

        tvAnalysis.text = analysisBuilder.toString()
    }

    private fun analyzeAttendanceTime(): String {
        if (attendanceList.isEmpty()) return ""

        val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
        val fullTimeFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())

        try {
            val times = attendanceList.mapNotNull { record ->
                fullTimeFormat.parse(record.timestamp)?.let { timeFormat.format(it) }
            }

            if (times.isNotEmpty()) {
                val earliestTime = times.minOrNull()
                val latestTime = times.maxOrNull()
                return "• First attendance: $earliestTime\n• Last attendance: $latestTime\n"
            }
        } catch (e: Exception) {
            // Handle date parsing errors
        }

        return ""
    }
}
