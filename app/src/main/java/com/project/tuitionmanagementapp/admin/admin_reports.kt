package com.project.tuitionmanagementapp.admin

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.project.tuitionmanagementapp.R
import java.text.SimpleDateFormat
import java.util.*

class admin_reports : Fragment() {

    private val reportsList = mutableListOf(
        "Monthly Revenue Report - December 2024",
        "Student Attendance Report - Week 50",
        "Teacher Performance Report - Q4 2024",
        "Payment Status Report - Current Month",
        "Class Enrollment Report - 2024"
    )

    private val reportTypes = arrayOf(
        "Revenue Report",
        "Attendance Report",
        "Student Performance Report",
        "Teacher Performance Report",
        "Payment Status Report"
    )

    private val classList = arrayOf(
        "Grade 10 Mathematics",
        "Grade 9 Science",
        "Grade 11 Physics",
        "Grade 8 English",
        "A/L Biology"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_admin_reports, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupReportDropdowns(view)
        setupDateButtons(view)
        setupActionButtons(view)
    }

    private fun setupReportDropdowns(view: View) {
        // Setup report type dropdown
        val reportTypeAutoComplete = view.findViewById<AutoCompleteTextView>(R.id.autoCompleteReportType)
        val reportTypeAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, reportTypes)
        reportTypeAutoComplete.setAdapter(reportTypeAdapter)

        // Setup class dropdown
        val classAutoComplete = view.findViewById<AutoCompleteTextView>(R.id.autoCompleteClass)
        val classAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, classList)
        classAutoComplete.setAdapter(classAdapter)
    }

    private fun setupDateButtons(view: View) {
        // Set up date selection buttons
        view.findViewById<Button>(R.id.DateShowStart)?.setOnClickListener {
            showDatePickerDialog("Start Date")
        }

        view.findViewById<Button>(R.id.DateShowEnd)?.setOnClickListener {
            showDatePickerDialog("End Date")
        }
    }

    private fun setupActionButtons(view: View) {
        // Generate report button
        view.findViewById<Button>(R.id.btnAddStudent)?.setOnClickListener {
            generateReport()
        }

        // View all reports button
        view.findViewById<Button>(R.id.viewAllReports)?.setOnClickListener {
            try {
                val intent = Intent(activity, AllReports::class.java)
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(context, "All reports feature coming soon", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showDatePickerDialog(title: String) {
        Toast.makeText(context, "$title picker will be implemented", Toast.LENGTH_SHORT).show()
    }

    private fun generateReport() {
        val reportType = view?.findViewById<AutoCompleteTextView>(R.id.autoCompleteReportType)?.text.toString()
        val selectedClass = view?.findViewById<AutoCompleteTextView>(R.id.autoCompleteClass)?.text.toString()

        if (reportType.isEmpty() || selectedClass.isEmpty()) {
            Toast.makeText(context, "Please select report type and class", Toast.LENGTH_SHORT).show()
            return
        }

        val newReport = "$reportType for $selectedClass - ${getCurrentDate()}"
        reportsList.add(0, newReport)
        Toast.makeText(context, "Report generated successfully", Toast.LENGTH_SHORT).show()

        // Show dialog with generated report info
        showReportDetailsDialog(newReport)
    }

    private fun showReportDetailsDialog(report: String) {
        val options = arrayOf("View", "Download", "Delete")

        val builder = android.app.AlertDialog.Builder(requireContext())
        builder.setTitle(report)
        builder.setItems(options) { _, which ->
            when (which) {
                0 -> Toast.makeText(context, "Opening report: $report", Toast.LENGTH_SHORT).show()
                1 -> Toast.makeText(context, "Downloading report: $report", Toast.LENGTH_SHORT).show()
                2 -> {
                    reportsList.remove(report)
                    Toast.makeText(context, "Report deleted", Toast.LENGTH_SHORT).show()
                }
            }
        }
        builder.show()
    }


    private fun getCurrentDate(): String {
        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        return sdf.format(Date())
    }
}