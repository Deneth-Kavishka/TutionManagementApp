package com.project.tuitionmanagementapp.admin

import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.project.tuitionmanagementapp.R
import com.project.tuitionmanagementapp.models.ClassCategory
import com.project.tuitionmanagementapp.models.ClassScheduleSlot
import java.text.SimpleDateFormat
import java.util.*

class ManageClassCategoriesActivity : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()
    private lateinit var etCategoryName: EditText
    private lateinit var spGrade: Spinner
    private lateinit var spSubject: Spinner
    private lateinit var spLevel: Spinner
    private lateinit var etDescription: EditText
    private lateinit var etMaxStudents: EditText
    private lateinit var etFees: EditText
    private lateinit var rvScheduleSlots: RecyclerView
    private lateinit var btnAddScheduleSlot: Button
    private lateinit var btnSaveCategory: Button
    private lateinit var btnViewAllCategories: Button

    private val scheduleSlots = mutableListOf<ClassScheduleSlot>()
    private lateinit var scheduleAdapter: ScheduleSlotAdapter

    private val grades = arrayOf("Select Grade", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13")
    private val subjects = arrayOf("Select Subject", "Mathematics", "Physics", "Chemistry", "Biology",
        "English", "Sinhala", "Tamil", "History", "Geography", "Economics", "Accounting",
        "Business Studies", "ICT", "Art", "Music", "Drama")
    private val levels = arrayOf("Select Level", "Primary (1-5)", "Junior Secondary (6-9)",
        "O/L (10-11)", "A/L (12-13)")
    private val days = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage_class_categories)

        initializeViews()
        setupSpinners()
        setupRecyclerView()
        setupClickListeners()
    }

    private fun initializeViews() {
        etCategoryName = findViewById(R.id.etCategoryName)
        spGrade = findViewById(R.id.spGrade)
        spSubject = findViewById(R.id.spSubject)
        spLevel = findViewById(R.id.spLevel)
        etDescription = findViewById(R.id.etDescription)
        etMaxStudents = findViewById(R.id.etMaxStudents)
        etFees = findViewById(R.id.etFees)
        rvScheduleSlots = findViewById(R.id.rvScheduleSlots)
        btnAddScheduleSlot = findViewById(R.id.btnAddScheduleSlot)
        btnSaveCategory = findViewById(R.id.btnSaveCategory)
        btnViewAllCategories = findViewById(R.id.btnViewAllCategories)
    }

    private fun setupSpinners() {
        val gradeAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, grades)
        gradeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spGrade.adapter = gradeAdapter

        val subjectAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, subjects)
        subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spSubject.adapter = subjectAdapter

        val levelAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, levels)
        levelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spLevel.adapter = levelAdapter
    }

    private fun setupRecyclerView() {
        scheduleAdapter = ScheduleSlotAdapter(scheduleSlots) { position ->
            scheduleSlots.removeAt(position)
            scheduleAdapter.notifyItemRemoved(position)
        }
        rvScheduleSlots.layoutManager = LinearLayoutManager(this)
        rvScheduleSlots.adapter = scheduleAdapter
    }

    private fun setupClickListeners() {
        btnAddScheduleSlot.setOnClickListener { showAddScheduleSlotDialog() }
        btnSaveCategory.setOnClickListener { saveClassCategory() }
        btnViewAllCategories.setOnClickListener { viewAllCategories() }
    }

    private fun showAddScheduleSlotDialog() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_add_schedule_slot, null)
        val spDay = dialogView.findViewById<Spinner>(R.id.spDay)
        val etStartTime = dialogView.findViewById<EditText>(R.id.etStartTime)
        val etEndTime = dialogView.findViewById<EditText>(R.id.etEndTime)

        val dayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, days)
        dayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spDay.adapter = dayAdapter

        etStartTime.setOnClickListener { showTimePicker(etStartTime) }
        etEndTime.setOnClickListener { showTimePicker(etEndTime) }

        val dialog = androidx.appcompat.app.AlertDialog.Builder(this)
            .setTitle("Add Schedule Slot")
            .setView(dialogView)
            .setPositiveButton("Add") { _, _ ->
                val day = spDay.selectedItem.toString()
                val startTime = etStartTime.text.toString()
                val endTime = etEndTime.text.toString()

                if (day != "Select Day" && startTime.isNotEmpty() && endTime.isNotEmpty()) {
                    val duration = calculateDuration(startTime, endTime)
                    val scheduleSlot = ClassScheduleSlot(day, startTime, endTime, duration)
                    scheduleSlots.add(scheduleSlot)
                    scheduleAdapter.notifyItemInserted(scheduleSlots.size - 1)
                } else {
                    Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("Cancel", null)
            .create()

        dialog.show()
    }

    private fun showTimePicker(editText: EditText) {
        val calendar = Calendar.getInstance()
        val timePickerDialog = TimePickerDialog(
            this,
            { _, hourOfDay, minute ->
                val time = String.format("%02d:%02d", hourOfDay, minute)
                editText.setText(time)
            },
            calendar.get(Calendar.HOUR_OF_DAY),
            calendar.get(Calendar.MINUTE),
            true
        )
        timePickerDialog.show()
    }

    private fun calculateDuration(startTime: String, endTime: String): Int {
        try {
            val format = SimpleDateFormat("HH:mm", Locale.getDefault())
            val start = format.parse(startTime)
            val end = format.parse(endTime)

            if (start != null && end != null) {
                val diffInMillis = end.time - start.time
                return (diffInMillis / (1000 * 60)).toInt() // Convert to minutes
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return 0
    }

    private fun saveClassCategory() {
        if (!validateForm()) return

        val currentDate = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date())

        val classCategory = ClassCategory(
            id = UUID.randomUUID().toString(),
            categoryName = etCategoryName.text.toString(),
            grade = spGrade.selectedItem.toString(),
            subject = spSubject.selectedItem.toString(),
            level = spLevel.selectedItem.toString(),
            description = etDescription.text.toString(),
            maxStudents = etMaxStudents.text.toString().toIntOrNull() ?: 30,
            currentStudents = 0,
            fees = etFees.text.toString().toDoubleOrNull() ?: 0.0,
            schedule = scheduleSlots.toList(),
            teacherId = "",
            teacherName = "",
            isActive = true,
            createdDate = currentDate,
            startDate = "",
            endDate = ""
        )

        db.collection("classCategories")
            .document(classCategory.id)
            .set(classCategory)
            .addOnSuccessListener {
                Toast.makeText(this, "Class category created successfully!", Toast.LENGTH_SHORT).show()
                clearForm()
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this, "Error creating class category: ${exception.message}",
                    Toast.LENGTH_SHORT).show()
            }
    }

    private fun validateForm(): Boolean {
        if (etCategoryName.text.toString().trim().isEmpty()) {
            etCategoryName.error = "Category name is required"
            etCategoryName.requestFocus()
            return false
        }

        if (spGrade.selectedItemPosition == 0) {
            Toast.makeText(this, "Please select a grade", Toast.LENGTH_SHORT).show()
            return false
        }

        if (spSubject.selectedItemPosition == 0) {
            Toast.makeText(this, "Please select a subject", Toast.LENGTH_SHORT).show()
            return false
        }

        if (spLevel.selectedItemPosition == 0) {
            Toast.makeText(this, "Please select a level", Toast.LENGTH_SHORT).show()
            return false
        }

        if (scheduleSlots.isEmpty()) {
            Toast.makeText(this, "Please add at least one schedule slot", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    private fun clearForm() {
        etCategoryName.text.clear()
        spGrade.setSelection(0)
        spSubject.setSelection(0)
        spLevel.setSelection(0)
        etDescription.text.clear()
        etMaxStudents.text.clear()
        etFees.text.clear()
        scheduleSlots.clear()
        scheduleAdapter.notifyDataSetChanged()
    }

    private fun viewAllCategories() {
        // Navigate to a list view of all class categories
        // This can be implemented as a separate activity or fragment
        Toast.makeText(this, "View All Categories feature to be implemented", Toast.LENGTH_SHORT).show()
    }
}

// Adapter for schedule slots
class ScheduleSlotAdapter(
    private val scheduleSlots: MutableList<ClassScheduleSlot>,
    private val onDeleteClick: (Int) -> Unit
) : RecyclerView.Adapter<ScheduleSlotAdapter.ViewHolder>() {

    class ViewHolder(view: android.view.View) : RecyclerView.ViewHolder(view) {
        val tvDay: TextView = view.findViewById(R.id.tvDay)
        val tvTime: TextView = view.findViewById(R.id.tvTime)
        val tvDuration: TextView = view.findViewById(R.id.tvDuration)
        val btnDelete: Button = view.findViewById(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: android.view.ViewGroup, viewType: Int): ViewHolder {
        val view = android.view.LayoutInflater.from(parent.context)
            .inflate(R.layout.item_schedule_slot, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val slot = scheduleSlots[position]
        holder.tvDay.text = slot.day
        holder.tvTime.text = "${slot.startTime} - ${slot.endTime}"
        holder.tvDuration.text = "${slot.duration} minutes"
        holder.btnDelete.setOnClickListener { onDeleteClick(position) }
    }

    override fun getItemCount() = scheduleSlots.size
}
