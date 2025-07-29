package com.project.tuitionmanagementapp.admin

import android.app.Dialog
import android.os.Bundle
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart){
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    changeEventDateBtn.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            //end
            //popup clock (start time)
            //start time
            val timePicker = Dialog(this)
            timePicker.setContentView(R.layout.pick_time_set)
            val startTiBot = view.findViewById<Button>(R.id.timeShowBottom)//start time trigger button
            val timeUI: TimePicker = timePicker.findViewById(R.id.timePickerUI)//start date
            val setTimeBtn: Button = timePicker.findViewById(R.id.setTimeButton)//start date
            startTiBot.setOnClickListener {
                timePicker.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePicker.setCancelable(false)
                timePicker.show()
            }
            timeUI.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                startTiBot.setText(selectedTime)
            }
            setTimeBtn.setOnClickListener {
                timePicker.dismiss()
            }
            //end
            //popup clock (end time)
            val timePickerEnd = Dialog(this)
            timePickerEnd.setContentView(R.layout.pick_time_end)
            val endTiBot = view.findViewById<Button>(R.id.timeShowEndBottom)//end time trigger button
            val timeUIEnd: TimePicker = timePickerEnd.findViewById(R.id.timePickerUIEnd)//end
            val setTimeBtnEnd: Button = timePickerEnd.findViewById(R.id.setTimeButtonEnd)//end
            endTiBot.setOnClickListener {
                timePickerEnd.window?.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                timePickerEnd.setCancelable(false)
                timePickerEnd.show()
            }
            timeUIEnd.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                endTiBot.setText(selectedTime)
            }
            setTimeBtnEnd.setOnClickListener {
                timePickerEnd.dismiss()
            }
            //end
            val dismissButton = view.findViewById<Button>(R.id.CancelBtn)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
            // set cancelable to avoid closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)
            // set content view to our view.
            dialog.setContentView(view)
            // call a show method to display a dialog
            dialog.show()
        }
    }
}