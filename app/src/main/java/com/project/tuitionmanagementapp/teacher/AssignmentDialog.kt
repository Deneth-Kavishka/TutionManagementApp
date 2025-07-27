package com.project.tuitionmanagementapp.teacher

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.Context
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import com.google.android.material.textfield.TextInputEditText
import com.project.tuitionmanagementapp.R
import java.text.SimpleDateFormat
import java.util.*

class AssignmentDialog(
    private val context: Context,
    private val existingAssignment: Assignment? = null,
    private val onSave: (Assignment) -> Unit
) {
    private lateinit var dialog: AlertDialog
    private lateinit var titleInput: TextInputEditText
    private lateinit var descriptionInput: TextInputEditText
    private lateinit var dueDateInput: TextInputEditText
    private lateinit var classSpinner: AutoCompleteTextView
    private var selectedDueDate: Long = 0

    fun show() {
        val view = LayoutInflater.from(context).inflate(R.layout.dialog_create_assignment, null)
        initializeViews(view)
        setupDatePicker()
        setupClassSpinner()
        loadExistingAssignment()

        dialog = AlertDialog.Builder(context)
            .setView(view)
            .setCancelable(true)
            .create()

        // Handle save button click
        view.findViewById<Button>(R.id.btnSave).setOnClickListener {
            if (validateInputs()) {
                val assignment = createAssignmentFromInputs()
                onSave(assignment)
                dialog.dismiss()
            }
        }

        // Handle cancel button click
        view.findViewById<Button>(R.id.btnCancel).setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun initializeViews(view: android.view.View) {
        titleInput = view.findViewById(R.id.edtAssignmentTitle)
        descriptionInput = view.findViewById(R.id.edtAssignmentDescription)
        dueDateInput = view.findViewById(R.id.edtDueDate)
        classSpinner = view.findViewById(R.id.spinnerClass)
    }

    private fun setupDatePicker() {
        dueDateInput.setOnClickListener {
            val calendar = Calendar.getInstance()

            DatePickerDialog(
                context,
                { _, year, month, day ->
                    calendar.set(year, month, day)
                    selectedDueDate = calendar.timeInMillis
                    dueDateInput.setText(formatDate(selectedDueDate))
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }

    private fun setupClassSpinner() {
        // Sample class list - Replace with actual class list from your database
        val classes = listOf("Class A", "Class B", "Class C")
        val adapter = ArrayAdapter(context, android.R.layout.simple_dropdown_item_1line, classes)
        classSpinner.setAdapter(adapter)
    }

    private fun loadExistingAssignment() {
        existingAssignment?.let { assignment ->
            titleInput.setText(assignment.title)
            descriptionInput.setText(assignment.description)
            dueDateInput.setText(formatDate(assignment.dueDate))
            selectedDueDate = assignment.dueDate
            classSpinner.setText(assignment.className, false)
        }
    }

    private fun validateInputs(): Boolean {
        var isValid = true

        if (titleInput.text.isNullOrBlank()) {
            titleInput.error = "Title is required"
            isValid = false
        }

        if (descriptionInput.text.isNullOrBlank()) {
            descriptionInput.error = "Description is required"
            isValid = false
        }

        if (selectedDueDate == 0L) {
            dueDateInput.error = "Due date is required"
            isValid = false
        }

        if (classSpinner.text.isNullOrBlank()) {
            classSpinner.error = "Class is required"
            isValid = false
        }

        return isValid
    }

    private fun createAssignmentFromInputs(): Assignment {
        return Assignment(
            id = existingAssignment?.id,
            title = titleInput.text.toString(),
            description = descriptionInput.text.toString(),
            dueDate = selectedDueDate,
            className = classSpinner.text.toString(),
            attachmentUrl = existingAssignment?.attachmentUrl,
            teacherId = existingAssignment?.teacherId ?: "", // Set actual teacher ID
            createdAt = existingAssignment?.createdAt ?: System.currentTimeMillis(),
            status = existingAssignment?.status ?: "active"
        )
    }

    private fun formatDate(timestamp: Long): String {
        val sdf = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())
        return sdf.format(Date(timestamp))
    }
}
