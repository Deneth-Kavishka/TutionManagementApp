package com.project.tuitionmanagementapp.admin

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.google.firebase.firestore.FirebaseFirestore
import com.project.tuitionmanagementapp.R
import java.text.SimpleDateFormat
import java.util.*

class AttendanceSheetActivity : AppCompatActivity() {

    private lateinit var firestore: FirebaseFirestore
    private lateinit var pieChart: PieChart
    private lateinit var recyclerView: RecyclerView
    private lateinit var tvTotalStudents: TextView
    private lateinit var tvPresent: TextView
    private lateinit var tvAbsent: TextView
    private lateinit var tvClassName: TextView
    private lateinit var tvDate: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attendance_sheet)

        initializeViews()
        setupPieChart()

        // Get data from intent
        val classId = intent.getStringExtra("classId") ?: return
        val date = intent.getLongExtra("date", System.currentTimeMillis())

        loadAttendanceData(classId, date)

        // Back button
        findViewById<ImageView>(R.id.backButton).setOnClickListener {
            finish()
        }
    }

    private fun initializeViews() {
        firestore = FirebaseFirestore.getInstance()
        pieChart = findViewById(R.id.pieChartAttendance)
        recyclerView = findViewById(R.id.rvAttendance)
        tvTotalStudents = findViewById(R.id.tvTotalStudents)
        tvPresent = findViewById(R.id.tvPresent)
        tvAbsent = findViewById(R.id.tvAbsent)
        tvClassName = findViewById(R.id.tvClassName)
        tvDate = findViewById(R.id.tvDate)
    }

    private fun setupPieChart() {
        pieChart.apply {
            description.isEnabled = false
            setUsePercentValues(true)
            setDrawEntryLabels(false)
            legend.isEnabled = true
            legend.textSize = 12f
            legend.textColor = context.getColor(R.color.purple_700)
            setEntryLabelColor(context.getColor(R.color.white))
            setHoleColor(context.getColor(R.color.white))
            setTransparentCircleColor(context.getColor(R.color.white))
        }
    }

    private fun loadAttendanceData(classId: String, date: Long) {
        firestore.collection("attendance")
            .whereEqualTo("classScheduleId", classId)
            .whereEqualTo("date", date)
            .get()
            .addOnSuccessListener { documents ->
                val records = documents.toObjects(AttendanceRecord::class.java)
                updateUI(records)
                updatePieChart(records)
                setupRecyclerView(records)
            }
    }

    private fun updateUI(records: List<AttendanceRecord>) {
        val totalStudents = records.size
        val presentCount = records.count { it.status == "present" }
        val absentCount = records.count { it.status == "absent" }

        tvTotalStudents.text = "Total Students: $totalStudents"
        tvPresent.text = "Present: $presentCount"
        tvAbsent.text = "Absent: $absentCount"

        if (records.isNotEmpty()) {
            tvClassName.text = records.first().className
            tvDate.text = SimpleDateFormat("MMMM dd, yyyy", Locale.getDefault())
                .format(Date(records.first().date))
        }
    }

    private fun updatePieChart(records: List<AttendanceRecord>) {
        val entries = ArrayList<PieEntry>()

        val presentCount = records.count { it.status == "present" }
        val absentCount = records.count { it.status == "absent" }
        val lateCount = records.count { it.status == "late" }

        if (presentCount > 0) entries.add(PieEntry(presentCount.toFloat(), "Present"))
        if (absentCount > 0) entries.add(PieEntry(absentCount.toFloat(), "Absent"))
        if (lateCount > 0) entries.add(PieEntry(lateCount.toFloat(), "Late"))

        val dataSet = PieDataSet(entries, "Attendance").apply {
            colors = listOf(
                getCompatColor(R.color.green),
                getCompatColor(R.color.red),
                getCompatColor(R.color.yellow)
            )
            valueTextSize = 14f
            valueTextColor = getCompatColor(R.color.white)
        }

        pieChart.data = PieData(dataSet)
        pieChart.invalidate()
    }

    private fun setupRecyclerView(records: List<AttendanceRecord>) {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = AttendanceAdapter(records) { _, _ -> }
    }

    private fun getCompatColor(colorRes: Int): Int {
        return ContextCompat.getColor(this, colorRes)
    }
}
