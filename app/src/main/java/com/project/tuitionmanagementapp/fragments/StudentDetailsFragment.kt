package com.project.tuitionmanagementapp.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.project.tuitionmanagementapp.models.Student
import com.project.tuitionmanagementapp.repository.StudentRepository
import com.project.tuitionmanagementapp.R

class StudentDetailsFragment : Fragment() {

    private lateinit var tvEmail: TextView
    private lateinit var tvPhone: TextView
    private lateinit var tvAddress: TextView
    private lateinit var tvDateOfBirth: TextView
    private lateinit var tvGender: TextView
    private lateinit var tvRollNumber: TextView
    private lateinit var tvAdmissionDate: TextView
    private lateinit var tvParentName: TextView
    private lateinit var tvParentPhone: TextView
    private lateinit var tvParentEmail: TextView
    private lateinit var tvTotalFees: TextView
    private lateinit var tvPaidAmount: TextView
    private lateinit var tvPendingAmount: TextView

    private var studentId: String? = null
    private var student: Student? = null

    companion object {
        private const val ARG_STUDENT_ID = "student_id"

        fun newInstance(studentId: String): StudentDetailsFragment {
            val fragment = StudentDetailsFragment()
            val args = Bundle()
            args.putString(ARG_STUDENT_ID, studentId)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            studentId = it.getString(ARG_STUDENT_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_student_details_admin, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeViews(view)
        loadStudentData()
    }

    private fun initializeViews(view: View) {
        tvEmail = view.findViewById(R.id.tvEmail)
        tvPhone = view.findViewById(R.id.tvPhone)
        tvAddress = view.findViewById(R.id.tvAddress)
        tvDateOfBirth = view.findViewById(R.id.tvDateOfBirth)
        tvGender = view.findViewById(R.id.tvGender)
        tvRollNumber = view.findViewById(R.id.tvRollNumber)
        tvAdmissionDate = view.findViewById(R.id.tvAdmissionDate)
        tvParentName = view.findViewById(R.id.tvParentName)
        tvParentPhone = view.findViewById(R.id.tvParentPhone)
        tvParentEmail = view.findViewById(R.id.tvParentEmail)
        tvTotalFees = view.findViewById(R.id.tvTotalFees)
        tvPaidAmount = view.findViewById(R.id.tvPaidAmount)
        tvPendingAmount = view.findViewById(R.id.tvPendingAmount)
    }

    private fun loadStudentData() {
        studentId?.let { id ->
            student = StudentRepository.getStudentById(id)
            updateUI()
        }
    }

    private fun updateUI() {
        student?.let { student ->
            tvEmail.text = student.studentEmail
            tvPhone.text = student.studentPhone
            tvAddress.text = student.address
            tvDateOfBirth.text = student.dateOfBirth
            tvGender.text = student.gender
            tvRollNumber.text = student.studentId
            tvAdmissionDate.text = student.admissionDate
            tvParentName.text = student.guardianName
            tvParentPhone.text = student.guardianPhone
            tvParentEmail.text = student.guardianEmail
            tvTotalFees.text = "$${student.totalFees}"
            tvPaidAmount.text = "$${student.paidAmount}"
            tvPendingAmount.text = "$${student.pendingAmount}"
        }
    }
}