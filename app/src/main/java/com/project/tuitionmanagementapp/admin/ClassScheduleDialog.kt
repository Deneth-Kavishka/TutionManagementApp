package com.project.tuitionmanagementapp.admin

import android.app.AlertDialog
import android.app.TimePickerDialog
import android.content.Context
import android.view.LayoutInflater
import android.widget.*
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.firestore.FirebaseFirestore
import com.project.tuitionmanagementapp.R
import java.text.SimpleDateFormat
import java.util.*

class ClassScheduleDialog(
    private val context: Context,
    private val selectedDate: Long,
    private val existingSchedule: ClassSchedule? = null,
    private val onSave: (ClassSchedule) -> Unit
) {
    private lateinit var dialog: AlertDialog
    private lateinit var spinnerClass: AutoCompleteTextView
    private lateinit var spinnerTeacher: AutoCompleteTextView
    private lateinit var edtStartTime: TextInputEditText
    private lateinit var edtEndTime: TextInputEditText
    private lateinit var edtRoomNumber: TextInputEditText
    private lateinit var checkboxRecurring: CheckBox
    private lateinit var checkboxNotification: CheckBox

    private var startTime: Long = 0
    private var endTime: Long = 0
    private val firestore = FirebaseFirestore.getInstance()

    fun show() {
        val view = LayoutInflater.from(context).inflate(R.layout.dialog_schedule_class, null)
        initializeViews(view)
        setupTimeSelectors()
        loadTeachersAndClasses()
        loadExistingData()

        dialog = AlertDialog.Builder(context)
            .setView(view)
            .setCancelable(true)
            .create()

        view.findViewById<Button>(R.id.btnSave).setOnClickListener {
            if (validateInputs()) {
                val schedule = createScheduleFromInputs()
                onSave(schedule)
                dialog.dismiss()
            }
        }

        view.findViewById<Button>(R.id.btnCancel).setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun initializeViews(view: android.view.View) {
        spinnerClass = view.findViewById(R.id.spinnerClass)
        spinnerTeacher = view.findViewById(R.id.spinnerTeacher)
        edtStartTime = view.findViewById(R.id.edtStartTime)
        edtEndTime = view.findViewById(R.id.edtEndTime)
        edtRoomNumber = view.findViewById(R.id.edtRoomNumber)
        checkboxRecurring = view.findViewById(R.id.checkboxRecurring)
        checkboxNotification = view.findViewById(R.id.checkboxNotification)
    }

    private fun setupTimeSelectors() {
        edtStartTime.setOnClickListener {
            showTimePicker(true)
        }

        edtEndTime.setOnClickListener {
            showTimePicker(false)
        }
    }

    private fun showTimePicker(isStartTime: Boolean) {
        val calendar = Calendar.getInstance()

        TimePickerDialog(
            context,
            { _, hourOfDay, minute ->
                calendar.timeInMillis = selectedDate
                calendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
                calendar.set(Calendar.MINUTE, minute)

                val time = calendar.timeInMillis
                val timeString = SimpleDateFormat("hh:mm a", Locale.getDefault())
                    .format(calendar.time)

                if (isStartTime) {
                    startTime = time
                    edtStartTime.setText(timeString)
                } else {
                    endTime = time
                    edtEndTime.setText(timeString)
                }
            },
            calendar.get(Calendar.HOUR_OF_DAY),
            calendar.get(Calendar.MINUTE),
            false
        ).show()
    }

    private fun loadTeachersAndClasses() {
        // Load teachers
        firestore.collection("teachers")
            .get()
            .addOnSuccessListener { documents ->
                val teachers = documents.mapNotNull { it.getString("name") }
                val teacherAdapter = ArrayAdapter(context,
                    android.R.layout.simple_dropdown_item_1line, teachers)
                spinnerTeacher.setAdapter(teacherAdapter)
            }

        // Load classes
        firestore.collection("classes")
            .get()
            .addOnSuccessListener { documents ->
                val classes = documents.mapNotNull { it.getString("name") }
                val classAdapter = ArrayAdapter(context,
                    android.R.layout.simple_dropdown_item_1line, classes)
                spinnerClass.setAdapter(classAdapter)
            }
    }

    private fun loadExistingData() {
        existingSchedule?.let { schedule ->
            spinnerClass.setText(schedule.className)
            spinnerTeacher.setText(schedule.teacherName)
            edtRoomNumber.setText(schedule.roomNumber)
            checkboxRecurring.isChecked = schedule.recurring
            checkboxNotification.isChecked = schedule.notificationEnabled

            // Set times
            startTime = schedule.startTime
            endTime = schedule.endTime
            val sdf = SimpleDateFormat("hh:mm a", Locale.getDefault())
            edtStartTime.setText(sdf.format(Date(startTime)))
            edtEndTime.setText(sdf.format(Date(endTime)))
        }
    }

    private fun validateInputs(): Boolean {
        if (spinnerClass.text.isNullOrBlank()) {
            Toast.makeText(context, "Please select a class", Toast.LENGTH_SHORT).show()
            return false
        }
        if (spinnerTeacher.text.isNullOrBlank()) {
            Toast.makeText(context, "Please select a teacher", Toast.LENGTH_SHORT).show()
            return false
        }
        if (startTime == 0L) {
            Toast.makeText(context, "Please select start time", Toast.LENGTH_SHORT).show()
            return false
        }
        if (endTime == 0L) {
            Toast.makeText(context, "Please select end time", Toast.LENGTH_SHORT).show()
            return false
        }
        if (endTime <= startTime) {
            Toast.makeText(context, "End time must be after start time", Toast.LENGTH_SHORT).show()
            return false
        }
        if (edtRoomNumber.text.isNullOrBlank()) {
            Toast.makeText(context, "Please enter room number", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    private fun createScheduleFromInputs(): ClassSchedule {
        return ClassSchedule(
            id = existingSchedule?.id,
            className = spinnerClass.text.toString(),
            teacherName = spinnerTeacher.text.toString(),
            startTime = startTime,
            endTime = endTime,
            roomNumber = edtRoomNumber.text.toString(),
            recurring = checkboxRecurring.isChecked,
            notificationEnabled = checkboxNotification.isChecked
        )
    }
}
