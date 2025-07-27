package com.project.tuitionmanagementapp.admin

import android.app.Dialog
import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.project.tuitionmanagementapp.R

class ClassCalender : AppCompatActivity() {

    private lateinit var calendarView: CalendarView
    private lateinit var rvEvents: RecyclerView
    private lateinit var fabAddEvent: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calender)

        initializeViews()
        setupEventListeners()
    }

    private fun initializeViews() {
        calendarView = findViewById(R.id.calendarView)
        rvEvents = findViewById(R.id.rvEvents)
        fabAddEvent = findViewById(R.id.fabAddEvent)

        // Setup back button
        findViewById<ImageView>(R.id.backButton).setOnClickListener {
            finish()
        }
    }

    private fun setupEventListeners() {
        // Create calendar event using FloatingActionButton
        fabAddEvent.setOnClickListener {
            showCreateEventDialog()
        }

        // Calendar date change listener
        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            // Handle date selection
            Toast.makeText(this, "Selected: $dayOfMonth/${month + 1}/$year", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showCreateEventDialog() {
        val dialog = BottomSheetDialog(this)
        val view = layoutInflater.inflate(R.layout.admin_class_edit, null)

        // Setup date picker dialog
        setupDatePicker(view)

        // Setup time pickers
        setupTimePickers(view)

        dialog.setContentView(view)
        dialog.show()
    }

    private fun setupDatePicker(view: android.view.View) {
        val datePickerDialog = Dialog(this)
        datePickerDialog.setContentView(R.layout.picker_start_date)

        val changeEventDateBtn = view.findViewById<Button>(R.id.dateForEditClass)
        val dateUI: DatePicker = datePickerDialog.findViewById(R.id.datePickerStart)
        val dateActionBtn: Button = datePickerDialog.findViewById(R.id.setDateStart)

        changeEventDateBtn?.setOnClickListener {
            datePickerDialog.window?.setLayout(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            datePickerDialog.setCancelable(false)
            datePickerDialog.show()
        }

        dateActionBtn?.setOnClickListener {
            with(dateUI) {
                val day = dayOfMonth
                val month = month + 1 // Month is 0-based
                val year = year
                changeEventDateBtn?.text = "$day/$month/$year"
            }
            datePickerDialog.dismiss()
        }
    }

    private fun setupTimePickers(view: android.view.View) {
        // Start time picker
        setupStartTimePicker(view)

        // End time picker
        setupEndTimePicker(view)
    }

    private fun setupStartTimePicker(view: android.view.View) {
        val timePicker = Dialog(this)
        timePicker.setContentView(R.layout.pick_time_set)

        val startTimeBtn = view.findViewById<Button>(R.id.timeShowBottom)
        val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)
        val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)

        startTimeBtn?.setOnClickListener {
            timePicker.window?.setLayout(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            timePicker.setCancelable(false)
            timePicker.show()
        }

        timeUI?.setOnTimeChangedListener { _, hourOfDay, minute ->
            val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
            startTimeBtn?.text = selectedTime
        }

        setTimeBtn?.setOnClickListener {
            timePicker.dismiss()
        }
    }

    private fun setupEndTimePicker(view: android.view.View) {
        val timePickerEnd = Dialog(this)
        timePickerEnd.setContentView(R.layout.pick_time_end)

        val endTimeBtn = view.findViewById<Button>(R.id.timeShowEndBottom)
        val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)
        val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)

        endTimeBtn?.setOnClickListener {
            timePickerEnd.window?.setLayout(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            timePickerEnd.setCancelable(false)
            timePickerEnd.show()
        }

        timeUIEnd?.setOnTimeChangedListener { _, hourOfDay, minute ->
            val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
            endTimeBtn?.text = selectedTime
        }

        setTimeBtnEnd?.setOnClickListener {
            timePickerEnd.dismiss()
        }
    }
}