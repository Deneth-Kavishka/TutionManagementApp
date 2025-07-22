package com.project.tuitionmanagementapp.admin


import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.DatePicker
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.project.tuitionmanagementapp.admin.admin_account
import com.project.tuitionmanagementapp.R
import com.google.android.material.bottomsheet.BottomSheetDialog


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [admin_account.newInstance] factory method to
 * create an instance of this fragment.
 */
class admin_account : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_manage_users, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //notification part
        val notificationIcon = view.findViewById<ImageButton>(R.id.notificationButton)
        notificationIcon.setOnClickListener{
            val intent = Intent(requireContext(), Notifications::class.java) //creates the intent
            startActivity(intent)
        }
        //handle add teacher
        val addTeacherBtn = view.findViewById<Button>(R.id.btnAddTeacher)
        addTeacherBtn.setOnClickListener {
            val dialogView = BottomSheetDialog(requireContext())
            val viewBottom = layoutInflater.inflate(R.layout.fragment_new_teacher, null)
            val closePanelBtn = viewBottom.findViewById<Button>(R.id.closeCreateAccTeaPanel)
            closePanelBtn.setOnClickListener {
                dialogView.dismiss()
            }
            //handle calender part
            //date popup
            val datePickerStart = Dialog(requireContext())
            datePickerStart.setContentView(R.layout.picker_start_date)
            val dateTrigButton = viewBottom.findViewById<Button>(R.id.dateForDOBTeacher)//panel side triger
            val dateUIStart: DatePicker = datePickerStart.findViewById(R.id.datePickerStart)//date ui/ start
            val dateActionBtnStart: Button = datePickerStart.findViewById(R.id.setDateStart)//date select btn/end
            dateTrigButton.setOnClickListener {
                datePickerStart.window?.setLayout(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart) {
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    dateTrigButton.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            dialogView.setCancelable(false)
            dialogView.setContentView(viewBottom)
            dialogView.show()
        }
        //handle add student button
        val addStudentBtn = view.findViewById<Button>(R.id.btnAddStudent)
        addStudentBtn.setOnClickListener {
            val dialogView = BottomSheetDialog(requireContext())
            val viewBottom = layoutInflater.inflate(R.layout.fragment_new_student, null)
            val closePanelBtn = viewBottom.findViewById<Button>(R.id.closeCreateAccStuPanel)
            closePanelBtn.setOnClickListener {
                dialogView.dismiss()
            }
            //date popup
            val datePickerStart = Dialog(requireContext())
            datePickerStart.setContentView(R.layout.picker_start_date)
            val dateTrigButton = viewBottom.findViewById<Button>(R.id.dateForDOB)//panel side triger
            val dateUIStart: DatePicker = datePickerStart.findViewById(R.id.datePickerStart)//date ui/ start
            val dateActionBtnStart: Button = datePickerStart.findViewById(R.id.setDateStart)//date select btn/end
            dateTrigButton.setOnClickListener {
                datePickerStart.window?.setLayout(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                datePickerStart.setCancelable(false)
                datePickerStart.show()
            }
            dateActionBtnStart.setOnClickListener {
                with(dateUIStart) {
                    val day = dayOfMonth
                    val month = month
                    val year = year
                    dateTrigButton.text = "$day/$month/$year"
                }
                datePickerStart.dismiss()
            }
            dialogView.setCancelable(false)
            dialogView.setContentView(viewBottom)
            dialogView.show()
        }
        //handle view student info
        val studentInfoView = view.findViewById<Button>(R.id.studentInfoView)
        studentInfoView.setOnClickListener {
            val dialogViewStuAcc = BottomSheetDialog(requireContext())
            val viewBottomAcc = layoutInflater.inflate(R.layout.student_acc_info_admin, null)
            val closePanelAccInfo = viewBottomAcc.findViewById<Button>(R.id.closeAccInfoBtn)
            closePanelAccInfo.setOnClickListener {
                dialogViewStuAcc.dismiss()
            }
            dialogViewStuAcc.setCancelable(false)
            dialogViewStuAcc.setContentView(viewBottomAcc)
            dialogViewStuAcc.show()
        }
        //handle edit students accounts
        val studentAccEditBtn = view.findViewById<Button>(R.id.editStudentAcc)
        studentAccEditBtn.setOnClickListener {
            val dialogView = BottomSheetDialog(requireContext())
            val viewBottom = layoutInflater.inflate(R.layout.fragment_edit_student, null)
            val closePanelBtn = viewBottom.findViewById<Button>(R.id.closeUpdatePanel)
            closePanelBtn.setOnClickListener {
                dialogView.dismiss()
            }
            dialogView.setCancelable(false)
            dialogView.setContentView(viewBottom)
            dialogView.show()
        }

        val accountTypeDropdown = view?.findViewById<AutoCompleteTextView>(R.id.autoCompleteID)
        // Define dropdown items
        val accountTypes = listOf(
            "Student",
            "Teacher"
        )

        // Create adapter using requireContext()
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, accountTypes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Set adapter to dropdown
        if (accountTypeDropdown != null) {
            accountTypeDropdown.setAdapter(adapter)
        }

        // Set click listener to show dropdown
        if (accountTypeDropdown != null) {
            accountTypeDropdown.setOnClickListener {
                val selectedItem: String = accountTypeDropdown.text.toString()
            }
        }
    }
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            admin_account().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}