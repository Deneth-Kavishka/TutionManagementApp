package com.project.tuitionmanagementapp.admin

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.project.tuitionmanagementapp.R
import com.project.tuitionmanagementapp.admin.admin_account
import com.project.tuitionmanagementapp.databinding.FragmentAdminHomeBinding
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class admin_home : Fragment() {
    private var _binding: FragmentAdminHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAdminHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup analytics charts
        setupRevenueChart()
        setupStudentDistributionChart()
        setupQuickStats()
        setupRecentActivities()

        // Notification button - Handle gracefully if not found
        try {
            val notificationButton = view.findViewById<View>(R.id.notificationButton)
            notificationButton?.setOnClickListener {
                try {
                    startActivity(Intent(requireContext(), Notifications::class.java))
                } catch (e: Exception) {
                    Toast.makeText(context, "Notifications feature will be implemented", Toast.LENGTH_SHORT).show()
                }
            }
        } catch (e: Exception) {
            Log.d("AdminHome", "Notification button not found in layout")
        }

        // Quick action buttons with improved error handling
        setupQuickActionButtons()

        // Refresh data button
        try {
            binding.btnRefresh.setOnClickListener {
                refreshDashboardData()
                Toast.makeText(context, "Dashboard refreshed", Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception) {
            Log.d("AdminHome", "Refresh button not found")
        }
    }

    private fun setupQuickActionButtons() {
        try {
            binding.cardAddStudent.setOnClickListener {
                try {
                    Log.d("AdminHome", "Add Student button clicked")
                    val intent = Intent(requireActivity(), AddStudentActivity::class.java)
                    startActivity(intent)
                } catch (e: Exception) {
                    Log.e("AdminHome", "Error starting AddStudentActivity", e)
                    Toast.makeText(context, "Add Student feature is currently unavailable: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        } catch (e: Exception) {
            Log.d("AdminHome", "Add student card not found", e)
        }

        try {
            binding.cardAddTeacher.setOnClickListener { 
                try {
                    Log.d("AdminHome", "Add Teacher button clicked")
                    val intent = Intent(requireActivity(), AddTeacherActivity::class.java)
                    startActivity(intent)
                } catch (e: Exception) {
                    Log.e("AdminHome", "Error starting AddTeacherActivity", e)
                    Toast.makeText(context, "Add Teacher feature is currently unavailable: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        } catch (e: Exception) {
            Log.d("AdminHome", "Add teacher card not found", e)
        }

        try {
            binding.cardQrScanner.setOnClickListener {
                try {
                    val intent = Intent(requireContext(), QRScannerActivity::class.java)
                    startActivity(intent)
                } catch (e: Exception) {
                    Toast.makeText(context, "QR Scanner feature will be implemented", Toast.LENGTH_SHORT).show()
                }
            }
        } catch (e: Exception) {
            Log.d("AdminHome", "QR Scanner card not found")
        }

        try {
            binding.cardMakePayment.setOnClickListener {
                try {
                    // Launch the correct StudentPaymentActivity
                    val intent = Intent(requireActivity(), StudentPaymentActivity::class.java)
                    startActivity(intent)
                } catch (e: Exception) {
                    Log.e("AdminHome", "Error starting StudentPaymentActivity", e)
                    Toast.makeText(context, "Payment feature error: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        } catch (e: Exception) {
            Log.d("AdminHome", "Make payment card not found")
        }

        try {
            binding.cardParentPortal.setOnClickListener { openParentPortal() }
        } catch (e: Exception) {
            Log.d("AdminHome", "Parent portal card not found")
        }

        try {
            binding.cardViewStudents.setOnClickListener {
                try {
                    // Launch the StudentDetailsActivity to view students
                    val intent = Intent(requireActivity(), StudentDetailsActivity::class.java)
                    // You can pass a default student ID if needed
                    intent.putExtra("student_id", "STD001")
                    startActivity(intent)
                } catch (e: Exception) {
                    Log.e("AdminHome", "Error starting StudentDetailsActivity", e)
                    Toast.makeText(context, "View Students feature error: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        } catch (e: Exception) {
            Log.d("AdminHome", "View students card not found")
        }
    }

    private fun setupRevenueChart() {
        val barChart: BarChart = binding.revenueChart
        val entries = ArrayList<BarEntry>()

        // Sample data - replace with actual revenue data
        entries.add(BarEntry(0f, 12000f))
        entries.add(BarEntry(1f, 18000f))
        entries.add(BarEntry(2f, 15000f))
        entries.add(BarEntry(3f, 21000f))
        entries.add(BarEntry(4f, 19000f))
        entries.add(BarEntry(5f, 23000f))

        val barDataSet = BarDataSet(entries, "Monthly Revenue")
        barDataSet.colors = ColorTemplate.MATERIAL_COLORS.toList()
        barDataSet.valueTextColor = Color.BLACK
        barDataSet.valueTextSize = 12f

        val data = BarData(barDataSet)
        barChart.data = data

        // Customize chart appearance
        barChart.setFitBars(true)
        barChart.description.text = "Last 6 Months Revenue (LKR)"
        barChart.animateY(1000)
        barChart.legend.isEnabled = false

        val months = arrayOf("Jan", "Feb", "Mar", "Apr", "May", "Jun")
        val xAxis = barChart.xAxis
        xAxis.valueFormatter = IndexAxisValueFormatter(months)
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.granularity = 1f
        xAxis.setDrawGridLines(false)

        barChart.axisLeft.setDrawGridLines(false)
        barChart.axisRight.isEnabled = false
    }

    private fun setupStudentDistributionChart() {
        val pieChart: PieChart = binding.studentDistributionChart

        val entries = ArrayList<PieEntry>()
        entries.add(PieEntry(120f, "Grade 6"))
        entries.add(PieEntry(95f, "Grade 7"))
        entries.add(PieEntry(80f, "Grade 8"))
        entries.add(PieEntry(65f, "Grade 9"))
        entries.add(PieEntry(110f, "Grade 10"))
        entries.add(PieEntry(75f, "Grade 11"))
        entries.add(PieEntry(60f, "AL Students"))

        val dataSet = PieDataSet(entries, "Student Distribution")
        dataSet.colors = ColorTemplate.COLORFUL_COLORS.toList()
        dataSet.valueTextColor = Color.BLACK
        dataSet.valueTextSize = 12f

        val data = PieData(dataSet)
        pieChart.data = data
        pieChart.description.text = "Student Distribution by Grade"
        pieChart.centerText = "Total Students\n545"
        pieChart.animateY(1000)
        pieChart.legend.isEnabled = true
    }

    private fun setupQuickStats() {
        // Update quick stats cards
        binding.tvTotalStudents.text = "545"
        binding.tvActiveTeachers.text = "28"
        binding.tvPendingPayments.text = "42"
        binding.tvTodayClasses.text = "19"

        // Set progress bars
        binding.paymentProgress.progress = 78 // 78% payments completed
        binding.attendanceProgress.progress = 92 // 92% attendance
    }

    private fun setupRecentActivities() {
        val activities = listOf(
            "New student registration - Kamal Perera",
            "Payment received - Rs. 12,500 from Nimali Silva",
            "New class scheduled - Grade 10 Mathematics",
            "Teacher added - Mrs. Samantha Rathnayake",
            "Parent portal access granted - Sunil Fernando"
        )

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, activities)
        binding.listRecentActivities.adapter = adapter
    }

    private fun showAddStudentDialog() {
        val dialog = BottomSheetDialog(requireContext())
        val view = layoutInflater.inflate(R.layout.fragment_new_student, null)

        // Setup date picker and other fields
        val dateButton = view.findViewById<Button>(R.id.dateForDOB)
        dateButton.setOnClickListener { showDatePicker(dateButton) }

        view.findViewById<Button>(R.id.closeCreateAccStuPanel).setOnClickListener {
            dialog.dismiss()
        }

        dialog.setContentView(view)
        dialog.show()
    }

    private fun showAddTeacherDialog() {
        val dialog = BottomSheetDialog(requireContext())
        val view = layoutInflater.inflate(R.layout.fragment_new_teacher, null)

        // Setup date picker and other fields
        val dateButton = view.findViewById<Button>(R.id.dateForDOBTeacher)
        dateButton.setOnClickListener { showDatePicker(dateButton) }

        view.findViewById<Button>(R.id.closeCreateAccTeaPanel).setOnClickListener {
            dialog.dismiss()
        }

        dialog.setContentView(view)
        dialog.show()
    }

    private fun showDatePicker(button: Button) {
        val datePickerDialog = Dialog(requireContext())
        datePickerDialog.setContentView(R.layout.picker_start_date)

        val datePicker = datePickerDialog.findViewById<DatePicker>(R.id.datePickerStart)
        val setButton = datePickerDialog.findViewById<Button>(R.id.setDateStart)

        setButton.setOnClickListener {
            val day = datePicker.dayOfMonth
            val month = datePicker.month + 1 // Months are 0-based
            val year = datePicker.year
            button.text = "$day/$month/$year"
            datePickerDialog.dismiss()
        }

        datePickerDialog.show()
    }

    private fun launchQrScanner() {
        try {
            val intent = Intent(requireContext(), QRScannerActivity::class.java)
            startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(context, "Error launching QR Scanner: ${e.message}", Toast.LENGTH_SHORT).show()
            e.printStackTrace()
        }
    }


    private fun openParentPortal() {
        // Implement parent portal functionality
        Toast.makeText(context, "Parent portal opened", Toast.LENGTH_SHORT).show()
        // You would typically start a parent portal activity here
    }

    private fun showStudentInfoDialog() {
        val dialog = BottomSheetDialog(requireContext())
        val view = layoutInflater.inflate(R.layout.student_acc_info_admin, null)

        view.findViewById<Button>(R.id.closeAccInfoBtn).setOnClickListener {
            dialog.dismiss()
        }

        dialog.setContentView(view)
        dialog.show()
    }

    private fun refreshDashboardData() {
        // Implement data refresh logic
        setupRevenueChart()
        setupStudentDistributionChart()
        setupQuickStats()
        setupRecentActivities()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}