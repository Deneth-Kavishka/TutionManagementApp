package com.project.tuitionmanagementapp.admin

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.button.MaterialButton
import com.google.firebase.database.*
import com.project.tuitionmanagementapp.R
import java.text.SimpleDateFormat
import java.util.*

class admin_classes : Fragment() {

    // Firebase database reference
    private lateinit var database: DatabaseReference

    // Lists for dropdowns
    private val classesList = mutableListOf<ClassModel>()
    private val teachersList = mutableListOf<TeacherModel>()
    private val hallsList = listOf("Hall 01", "Hall 02", "Hall 03", "Hall 04", "Hall 05")
    private val classCategories = listOf(
        "2025 A/L Combined Maths",
        "2025 A/L Physics",
        "2025 A/L Chemistry",
        "2025 A/L Biology",
        "2024 A/L Combined Maths",
        "2024 A/L Physics",
        "2024 A/L Chemistry",
        "2024 A/L Biology",
        "Grade 11 Science",
        "Grade 11 Maths",
        "Grade 10 Science",
        "Grade 10 Maths"
    )

    // Selected time values
    private var startTimeHour = 8
    private var startTimeMinute = 0
    private var endTimeHour = 10
    private var endTimeMinute = 0

    // Selected date values
    private val calendar = Calendar.getInstance()
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_admin_classes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize Firebase
        database = FirebaseDatabase.getInstance().reference

        // Load initial data
        loadTeachers()
        loadClasses()

        // Setup UI components
        setupDropdowns(view)
        setupTimePickers(view)
        setupDatePicker(view)
        setupButtons(view)
    }

    private fun loadTeachers() {
        database.child("teachers").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                teachersList.clear()
                for (teacherSnapshot in snapshot.children) {
                    val teacher = teacherSnapshot.getValue(TeacherModel::class.java)
                    teacher?.let {
                        it.id = teacherSnapshot.key ?: ""
                        teachersList.add(it)
                    }
                }
                // Update teacher dropdown if view exists
                view?.let { setupTeacherDropdown(it) }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "Failed to load teachers: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun loadClasses() {
        database.child("classes").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                classesList.clear()
                for (classSnapshot in snapshot.children) {
                    val classModel = classSnapshot.getValue(ClassModel::class.java)
                    classModel?.let {
                        it.id = classSnapshot.key ?: ""
                        classesList.add(it)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "Failed to load classes: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun setupDropdowns(view: View) {
        setupHallDropdown(view)
        setupTeacherDropdown(view)
        setupClassCategoryDropdown(view)
    }

    private fun setupHallDropdown(view: View) {
        val hallAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, hallsList)
        val autoCompleteHall = view.findViewById<AutoCompleteTextView>(R.id.autoCompleteIDHall)
        autoCompleteHall.setAdapter(hallAdapter)
    }

    private fun setupTeacherDropdown(view: View) {
        val teacherNames = teachersList.map { "${it.name} - ${it.subject}" }
        val teacherAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, teacherNames)
        val autoCompleteTeacher = view.findViewById<AutoCompleteTextView>(R.id.autoCompleteIDTeacher)
        autoCompleteTeacher.setAdapter(teacherAdapter)
    }

    private fun setupClassCategoryDropdown(view: View) {
        // Replace the weekday dropdown with class category dropdown
        val classCategoryAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, classCategories)
        val autoCompleteClassCategory = view.findViewById<AutoCompleteTextView>(R.id.autoCompleteIDDay)
        autoCompleteClassCategory.setAdapter(classCategoryAdapter)

        // Update hint text for class category
        val classLabelTextView = view.findViewById<TextView>(R.id.textViewDayLabel)
        classLabelTextView?.text = "Class Category"
    }

    private fun setupDatePicker(view: View) {
        // Set default date to current date
        calendar.time = Date()

        // Set up the Select Date button
        val btnSelectDate = view.findViewById<MaterialButton>(R.id.btnSelectDate)
        btnSelectDate.setOnClickListener {
            showDatePickerDialog()
        }

        // Set up the Calendar button (📅 icon)
        val btnCalendar = view.findViewById<MaterialButton>(R.id.btnCalendar)
        btnCalendar.setOnClickListener {
            showCalendarView()
        }

        // Update the date display initially
        updateDateDisplay(btnSelectDate)

        // Remove the long press functionality from View Classes button
        // (No longer needed since we have dedicated date buttons)

        // Show current date info as a toast when fragment loads
        Toast.makeText(context, "Current class date: ${getFormattedDate()}", Toast.LENGTH_SHORT).show()
    }

    private fun updateDateDisplay(button: MaterialButton) {
        val formattedDate = getFormattedDate()
        val dayOfWeek = SimpleDateFormat("EEE", Locale.getDefault()).format(calendar.time)
        button.text = "$dayOfWeek, $formattedDate"
    }

    private fun showDatePickerDialog() {
        val datePicker = DatePickerDialog(
            requireContext(),
            { _, year, month, dayOfMonth ->
                calendar.set(Calendar.YEAR, year)
                calendar.set(Calendar.MONTH, month)
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                val selectedDate = getFormattedDate()
                val dayOfWeek = SimpleDateFormat("EEEE", Locale.getDefault()).format(calendar.time)

                Toast.makeText(
                    context,
                    "📅 Date set to: $selectedDate ($dayOfWeek)",
                    Toast.LENGTH_LONG
                ).show()
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )

        // Set minimum date to today (can't create classes in the past)
        datePicker.datePicker.minDate = System.currentTimeMillis()

        // Set maximum date to 1 year from now
        val maxCalendar = Calendar.getInstance()
        maxCalendar.add(Calendar.YEAR, 1)
        datePicker.datePicker.maxDate = maxCalendar.timeInMillis

        datePicker.show()
    }

    private fun showCalendarView() {
        try {
            val intent = Intent(requireContext(), ClassCalender::class.java)
            intent.putExtra("CURRENT_DATE", dateFormat.format(calendar.time))
            startActivity(intent)
        } catch (e: Exception) {
            // Fallback: Show a simple month view dialog
            showMonthViewDialog()
        }
    }

    private fun showMonthViewDialog() {
        val currentMonth = SimpleDateFormat("MMMM yyyy", Locale.getDefault()).format(calendar.time)
        val message = """
            📅 Current Selected Date: ${getFormattedDate()}
            📆 Month: $currentMonth
            📌 Day: ${SimpleDateFormat("EEEE", Locale.getDefault()).format(calendar.time)}
            
            Use 'Change Date' option to select a different date.
        """.trimIndent()

        AlertDialog.Builder(requireContext())
            .setTitle("Calendar View")
            .setMessage(message)
            .setPositiveButton("Change Date") { _, _ -> showDatePickerDialog() }
            .setNegativeButton("Close", null)
            .show()
    }

    private fun getFormattedDate(): String {
        return SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(calendar.time)
    }

    private fun getFormattedDateWithDay(): String {
        val date = SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(calendar.time)
        val day = SimpleDateFormat("EEEE", Locale.getDefault()).format(calendar.time)
        return "$day, $date"
    }

    private fun setupTimePickers(view: View) {
        val timeShowStart = view.findViewById<MaterialButton>(R.id.timeShow)
        timeShowStart.setOnClickListener {
            showTimePickerDialog(true)
        }

        val timeShowEnd = view.findViewById<MaterialButton>(R.id.timeShowEnd)
        timeShowEnd.setOnClickListener {
            showTimePickerDialog(false)
        }

        // Set default time display
        updateTimeDisplay(timeShowStart, startTimeHour, startTimeMinute)
        updateTimeDisplay(timeShowEnd, endTimeHour, endTimeMinute)
    }

    private fun showTimePickerDialog(isStartTime: Boolean) {
        val hour = if (isStartTime) startTimeHour else endTimeHour
        val minute = if (isStartTime) startTimeMinute else endTimeMinute

        val timePickerDialog = TimePickerDialog(
            context,
            { _, selectedHour, selectedMinute ->
                if (isStartTime) {
                    startTimeHour = selectedHour
                    startTimeMinute = selectedMinute
                    view?.findViewById<MaterialButton>(R.id.timeShow)?.let {
                        updateTimeDisplay(it, selectedHour, selectedMinute)
                    }
                } else {
                    endTimeHour = selectedHour
                    endTimeMinute = selectedMinute
                    view?.findViewById<MaterialButton>(R.id.timeShowEnd)?.let {
                        updateTimeDisplay(it, selectedHour, selectedMinute)
                    }
                }
            },
            hour,
            minute,
            false
        )
        timePickerDialog.show()
    }

    private fun updateTimeDisplay(button: MaterialButton, hour: Int, minute: Int) {
        val timeFormat = SimpleDateFormat("hh:mm a", Locale.getDefault())
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, hour)
        calendar.set(Calendar.MINUTE, minute)
        button.text = timeFormat.format(calendar.time)
    }

    private fun setupButtons(view: View) {
        // Calendar/Schedule button
        view.findViewById<Button>(R.id.btnNewButton)?.setOnClickListener {
            try {
                val intent = Intent(requireContext(), ClassCalender::class.java)
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(context, "Calendar feature coming soon", Toast.LENGTH_SHORT).show()
            }
        }

        // View classes button
        view.findViewById<Button>(R.id.btnViewClasses)?.setOnClickListener {
            showAllClassesDialog()
        }

        // Add class button
        view.findViewById<Button>(R.id.btnAddStudent)?.setOnClickListener {
            createNewClass()
        }
    }

    private fun createNewClass() {
        // Get input values
        val className = view?.findViewById<EditText>(R.id.className)?.text.toString().trim()
        val description = view?.findViewById<EditText>(R.id.descrionClass)?.text.toString().trim()
        val hall = view?.findViewById<AutoCompleteTextView>(R.id.autoCompleteIDHall)?.text.toString()
        val teacher = view?.findViewById<AutoCompleteTextView>(R.id.autoCompleteIDTeacher)?.text.toString()
        val classCategory = view?.findViewById<AutoCompleteTextView>(R.id.autoCompleteIDDay)?.text.toString()

        // Validate inputs
        if (className.isEmpty() || description.isEmpty() || hall.isEmpty() || teacher.isEmpty() || classCategory.isEmpty()) {
            Toast.makeText(context, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            return
        }

        // Format times
        val timeFormat = SimpleDateFormat("hh:mm a", Locale.getDefault())
        val startCalendar = Calendar.getInstance()
        startCalendar.set(Calendar.HOUR_OF_DAY, startTimeHour)
        startCalendar.set(Calendar.MINUTE, startTimeMinute)

        val endCalendar = Calendar.getInstance()
        endCalendar.set(Calendar.HOUR_OF_DAY, endTimeHour)
        endCalendar.set(Calendar.MINUTE, endTimeMinute)

        val startTime = timeFormat.format(startCalendar.time)
        val endTime = timeFormat.format(endCalendar.time)

        // Get day of week from calendar
        val dayOfWeek = SimpleDateFormat("EEEE", Locale.getDefault()).format(calendar.time)

        // Get teacher ID from selection
        val selectedTeacherName = teacher.split(" - ")[0]
        val selectedTeacher = teachersList.find { it.name == selectedTeacherName }
        val teacherId = selectedTeacher?.id ?: ""

        if (teacherId.isEmpty()) {
            Toast.makeText(context, "Invalid teacher selection", Toast.LENGTH_SHORT).show()
            return
        }

        // Create class model
        val newClass = ClassModel(
            id = "",
            name = className,
            description = description,
            hall = hall,
            teacherId = teacherId,
            teacherName = selectedTeacherName,
            weekDay = dayOfWeek,
            startTime = startTime,
            endTime = endTime,
            classDate = dateFormat.format(calendar.time),
            classCategory = classCategory,
            createdAt = System.currentTimeMillis()
        )

        // Save to Firebase
        saveClassToDatabase(newClass)
    }

    private fun saveClassToDatabase(classModel: ClassModel) {
        val classId = database.child("classes").push().key

        if (classId == null) {
            Toast.makeText(context, "Failed to create class", Toast.LENGTH_SHORT).show()
            return
        }

        classModel.id = classId

        val classUpdates = hashMapOf<String, Any>(
            "/classes/$classId" to classModel
        )

        // Also assign this class to the teacher
        classUpdates["/teachers/${classModel.teacherId}/assignedClasses/$classId"] = true

        // Add class to class category
        classUpdates["/classCategories/${classModel.classCategory}/classes/$classId"] = true

        database.updateChildren(classUpdates)
            .addOnSuccessListener {
                Toast.makeText(context, "Class created successfully", Toast.LENGTH_SHORT).show()

                // Clear form fields
                view?.findViewById<EditText>(R.id.className)?.text?.clear()
                view?.findViewById<EditText>(R.id.descrionClass)?.text?.clear()
                view?.findViewById<AutoCompleteTextView>(R.id.autoCompleteIDHall)?.text?.clear()
                view?.findViewById<AutoCompleteTextView>(R.id.autoCompleteIDTeacher)?.text?.clear()
                view?.findViewById<AutoCompleteTextView>(R.id.autoCompleteIDDay)?.text?.clear()

                // Show dialog to assign students
                showAssignStudentsDialog(classId, classModel.name, classModel.classCategory)
            }
            .addOnFailureListener { e ->
                Toast.makeText(context, "Error creating class: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun showAssignStudentsDialog(classId: String, className: String, classCategory: String) {
        AlertDialog.Builder(requireContext())
            .setTitle("Class Created")
            .setMessage("Do you want to assign students from the '$classCategory' category to this class?")
            .setPositiveButton("Yes") { _, _ ->
                navigateToAssignStudents(classId, classCategory)
            }
            .setNegativeButton("Later", null)
            .show()
    }

    private fun navigateToAssignStudents(classId: String, classCategory: String) {
        try {
            val intent = Intent(context, StudentAssignmentActivity::class.java)
            intent.putExtra("CLASS_ID", classId)
            intent.putExtra("CLASS_CATEGORY", classCategory)
            startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(context, "Student assignment will be implemented soon", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showAllClassesDialog() {
        if (classesList.isEmpty()) {
            Toast.makeText(context, "No classes available", Toast.LENGTH_SHORT).show()
            return
        }

        val classNames = classesList.map {
            "${it.name} - ${it.weekDay} ${it.startTime}"
        }.toTypedArray()

        val dialog = AlertDialog.Builder(requireContext())
        dialog.setTitle("All Classes")
        dialog.setItems(classNames) { _, which ->
            showClassDetailsDialog(classesList[which])
        }
        dialog.setPositiveButton("Close", null)
        dialog.show()
    }

    private fun showClassDetailsDialog(classModel: ClassModel) {
        val message = """
            Name: ${classModel.name}
            Description: ${classModel.description}
            Teacher: ${classModel.teacherName}
            Category: ${classModel.classCategory}
            Day: ${classModel.weekDay}
            Date: ${classModel.classDate}
            Time: ${classModel.startTime} - ${classModel.endTime}
            Hall: ${classModel.hall}
        """.trimIndent()

        val options = arrayOf("Edit", "Delete", "Assign Students", "View Students")

        AlertDialog.Builder(requireContext())
            .setTitle("Class Details")
            .setMessage(message)
            .setItems(options) { _, which ->
                when (which) {
                    0 -> editClass(classModel)
                    1 -> deleteClass(classModel)
                    2 -> navigateToAssignStudents(classModel.id, classModel.classCategory)
                    3 -> viewAssignedStudents(classModel)
                }
            }
            .setPositiveButton("Close", null)
            .show()
    }

    private fun editClass(classModel: ClassModel) {
        // Populate form fields with class data for editing
        view?.findViewById<EditText>(R.id.className)?.setText(classModel.name)
        view?.findViewById<EditText>(R.id.descrionClass)?.setText(classModel.description)
        view?.findViewById<AutoCompleteTextView>(R.id.autoCompleteIDHall)?.setText(classModel.hall)

        // Find teacher and set text properly
        val teacherSubject = teachersList.find { teacher -> teacher.id == classModel.teacherId }?.subject ?: ""
        view?.findViewById<AutoCompleteTextView>(R.id.autoCompleteIDTeacher)?.setText("${classModel.teacherName} - $teacherSubject")
        view?.findViewById<AutoCompleteTextView>(R.id.autoCompleteIDDay)?.setText(classModel.classCategory)

        // Parse and set date values if available
        try {
            if (classModel.classDate.isNotEmpty()) {
                val date = dateFormat.parse(classModel.classDate)
                if (date != null) {
                    calendar.time = date
                    // Show toast since we don't have a datePickerButton in the layout
                    Toast.makeText(context, "Class date loaded: ${getFormattedDate()}", Toast.LENGTH_SHORT).show()
                }
            }
        } catch (e: Exception) {
            // Handle date parsing error
            Toast.makeText(context, "Error parsing class date", Toast.LENGTH_SHORT).show()
        }

        // Parse and set time values
        val timeFormat = SimpleDateFormat("hh:mm a", Locale.getDefault())
        try {
            val startDate = timeFormat.parse(classModel.startTime)
            val endDate = timeFormat.parse(classModel.endTime)

            if (startDate != null) {
                val startCalendar = Calendar.getInstance()
                startCalendar.time = startDate
                startTimeHour = startCalendar.get(Calendar.HOUR_OF_DAY)
                startTimeMinute = startCalendar.get(Calendar.MINUTE)
            }

            if (endDate != null) {
                val endCalendar = Calendar.getInstance()
                endCalendar.time = endDate
                endTimeHour = endCalendar.get(Calendar.HOUR_OF_DAY)
                endTimeMinute = endCalendar.get(Calendar.MINUTE)
            }

            view?.findViewById<MaterialButton>(R.id.timeShow)?.let {
                updateTimeDisplay(it, startTimeHour, startTimeMinute)
            }
            view?.findViewById<MaterialButton>(R.id.timeShowEnd)?.let {
                updateTimeDisplay(it, endTimeHour, endTimeMinute)
            }
        } catch (e: Exception) {
            // Handle time parsing error
            Toast.makeText(context, "Error parsing class times", Toast.LENGTH_SHORT).show()
        }

        // Change button text to indicate editing mode
        view?.findViewById<Button>(R.id.btnAddStudent)?.text = "Update Class"

        // Set a click listener for update
        view?.findViewById<Button>(R.id.btnAddStudent)?.setOnClickListener {
            updateClass(classModel.id)
        }

        Toast.makeText(context, "Edit class data and press 'Update Class' to save changes", Toast.LENGTH_LONG).show()
    }

    private fun updateClass(classId: String) {
        // Similar to createNewClass but updates existing record
        // Get input values
        val className = view?.findViewById<EditText>(R.id.className)?.text.toString().trim()
        val description = view?.findViewById<EditText>(R.id.descrionClass)?.text.toString().trim()
        val hall = view?.findViewById<AutoCompleteTextView>(R.id.autoCompleteIDHall)?.text.toString()
        val teacher = view?.findViewById<AutoCompleteTextView>(R.id.autoCompleteIDTeacher)?.text.toString()
        val classCategory = view?.findViewById<AutoCompleteTextView>(R.id.autoCompleteIDDay)?.text.toString()

        if (className.isEmpty() || description.isEmpty() || hall.isEmpty() || teacher.isEmpty() || classCategory.isEmpty()) {
            Toast.makeText(context, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            return
        }

        // Format times
        val timeFormat = SimpleDateFormat("hh:mm a", Locale.getDefault())
        val startCalendar = Calendar.getInstance()
        startCalendar.set(Calendar.HOUR_OF_DAY, startTimeHour)
        startCalendar.set(Calendar.MINUTE, startTimeMinute)

        val endCalendar = Calendar.getInstance()
        endCalendar.set(Calendar.HOUR_OF_DAY, endTimeHour)
        endCalendar.set(Calendar.MINUTE, endTimeMinute)

        val startTime = timeFormat.format(startCalendar.time)
        val endTime = timeFormat.format(endCalendar.time)

        // Get day of week from calendar
        val dayOfWeek = SimpleDateFormat("EEEE", Locale.getDefault()).format(calendar.time)

        // Get teacher ID from selection
        val selectedTeacherName = teacher.split(" - ")[0]
        val selectedTeacher = teachersList.find { it.name == selectedTeacherName }
        val teacherId = selectedTeacher?.id ?: ""

        if (teacherId.isEmpty()) {
            Toast.makeText(context, "Invalid teacher selection", Toast.LENGTH_SHORT).show()
            return
        }

        // Find old class to get its previous data
        val oldClass = classesList.find { it.id == classId }
        val oldTeacherId = oldClass?.teacherId ?: ""
        val oldClassCategory = oldClass?.classCategory ?: ""

        // Create updated class model
        val updatedClass = ClassModel(
            id = classId,
            name = className,
            description = description,
            hall = hall,
            teacherId = teacherId,
            teacherName = selectedTeacherName,
            weekDay = dayOfWeek,
            startTime = startTime,
            endTime = endTime,
            classDate = dateFormat.format(calendar.time),
            classCategory = classCategory,
            createdAt = oldClass?.createdAt ?: System.currentTimeMillis()
        )

        // Update in Firebase
        val updates = hashMapOf<String, Any?>(
            "/classes/$classId" to updatedClass
        )

        // Remove from old teacher if teacher changed
        if (oldTeacherId.isNotEmpty() && oldTeacherId != teacherId) {
            updates["/teachers/$oldTeacherId/assignedClasses/$classId"] = null
        }

        // Assign to new teacher
        updates["/teachers/$teacherId/assignedClasses/$classId"] = true

        // Update class category if changed
        if (oldClassCategory.isNotEmpty() && oldClassCategory != classCategory) {
            updates["/classCategories/$oldClassCategory/classes/$classId"] = null
            updates["/classCategories/$classCategory/classes/$classId"] = true
        }

        database.updateChildren(updates)
            .addOnSuccessListener {
                Toast.makeText(context, "Class updated successfully", Toast.LENGTH_SHORT).show()

                // Reset form and button
                view?.findViewById<EditText>(R.id.className)?.text?.clear()
                view?.findViewById<EditText>(R.id.descrionClass)?.text?.clear()
                view?.findViewById<AutoCompleteTextView>(R.id.autoCompleteIDHall)?.text?.clear()
                view?.findViewById<AutoCompleteTextView>(R.id.autoCompleteIDTeacher)?.text?.clear()
                view?.findViewById<AutoCompleteTextView>(R.id.autoCompleteIDDay)?.text?.clear()

                // Reset button text and listener
                view?.findViewById<Button>(R.id.btnAddStudent)?.text = "Add Class"
                view?.findViewById<Button>(R.id.btnAddStudent)?.setOnClickListener {
                    createNewClass()
                }
            }
            .addOnFailureListener { e ->
                Toast.makeText(context, "Error updating class: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun deleteClass(classModel: ClassModel) {
        AlertDialog.Builder(requireContext())
            .setTitle("Delete Class")
            .setMessage("Are you sure you want to delete '${classModel.name}'? This will remove all associated student assignments.")
            .setPositiveButton("Delete") { _, _ ->
                // Remove class from database
                val updates = hashMapOf<String, Any?>(
                    "/classes/${classModel.id}" to null,
                    "/teachers/${classModel.teacherId}/assignedClasses/${classModel.id}" to null,
                    "/classCategories/${classModel.classCategory}/classes/${classModel.id}" to null
                )

                // Also remove from students (would need to query students assigned to this class)
                database.child("students")
                    .orderByChild("assignedClasses/${classModel.id}")
                    .equalTo(true)
                    .addListenerForSingleValueEvent(object : ValueEventListener {
                        override fun onDataChange(snapshot: DataSnapshot) {
                            for (studentSnapshot in snapshot.children) {
                                updates["/students/${studentSnapshot.key}/assignedClasses/${classModel.id}"] = null
                            }

                            // Perform the deletion
                            database.updateChildren(updates)
                                .addOnSuccessListener {
                                    Toast.makeText(context, "Class deleted successfully", Toast.LENGTH_SHORT).show()
                                }
                                .addOnFailureListener { e ->
                                    Toast.makeText(context, "Error deleting class: ${e.message}", Toast.LENGTH_SHORT).show()
                                }
                        }

                        override fun onCancelled(error: DatabaseError) {
                            Toast.makeText(context, "Error: ${error.message}", Toast.LENGTH_SHORT).show()
                        }
                    })
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    private fun viewAssignedStudents(classModel: ClassModel) {
        database.child("students")
            .orderByChild("assignedClasses/${classModel.id}")
            .equalTo(true)
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val studentsList = mutableListOf<String>()

                    for (studentSnapshot in snapshot.children) {
                        val name = studentSnapshot.child("name").getValue(String::class.java) ?: "Unknown Student"
                        studentsList.add(name)
                    }

                    if (studentsList.isEmpty()) {
                        Toast.makeText(context, "No students assigned to this class", Toast.LENGTH_SHORT).show()
                        return
                    }

                    AlertDialog.Builder(requireContext())
                        .setTitle("Students in ${classModel.name}")
                        .setItems(studentsList.toTypedArray(), null)
                        .setPositiveButton("Close", null)
                        .show()
                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(context, "Error loading students: ${error.message}", Toast.LENGTH_SHORT).show()
                }
            })
    }
}

// Data models
data class ClassModel(
    var id: String = "",
    val name: String = "",
    val description: String = "",
    val hall: String = "",
    val teacherId: String = "",
    val teacherName: String = "",
    val weekDay: String = "",
    val startTime: String = "",
    val endTime: String = "",
    val classDate: String = "",
    val classCategory: String = "",
    val createdAt: Long = 0
)

data class TeacherModel(
    var id: String = "",
    val name: String = "",
    val subject: String = "",
    val email: String = "",
    val phone: String = ""
)
