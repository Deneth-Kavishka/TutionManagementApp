package com.project.tuitionmanagementapp.student

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.project.tuitionmanagementapp.R
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.journeyapps.barcodescanner.BarcodeEncoder

class ProfileFragment : Fragment() {

    private lateinit var imgProfile: ImageView
    private lateinit var imgQrCode: ImageView
    private lateinit var tvDisplayName: TextView
    private lateinit var edtName: EditText
    private lateinit var edtUsername: EditText
    private lateinit var edtPassword: EditText
    private lateinit var edtEmail: EditText
    private lateinit var edtPhone: EditText
    private lateinit var btnSave: Button
    private lateinit var btnLogout: Button

    private var studentId: String = "S001"  // Fallback

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile_student, container, false)

        setupToolbar(view)
        bindViews(view)
        loadIntentData()
        setupListeners()

        return view
    }

    private fun setupToolbar(view: View) {
        val toolbar = view.findViewById<Toolbar>(R.id.toolbarStudent)
        (activity as AppCompatActivity).setSupportActionBar(toolbar as androidx.appcompat.widget.Toolbar?)
        (activity as AppCompatActivity).supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = "Edit Student Profile"
        }
    }

    private fun bindViews(view: View) {
        imgProfile = view.findViewById(R.id.imgStudentProfile)
        imgQrCode = view.findViewById(R.id.imgStudentQrCode)
        tvDisplayName = view.findViewById(R.id.tvStudentDisplayName)
        edtName = view.findViewById(R.id.edtStudentName)
        edtUsername = view.findViewById(R.id.edtStudentUsername)
        edtPassword = view.findViewById(R.id.edtStudentPassword)
        edtEmail = view.findViewById(R.id.edtStudentEmail)
        edtPhone = view.findViewById(R.id.edtStudentPhone)
        btnSave = view.findViewById(R.id.btnSaveStudentProfile)
        btnLogout = view.findViewById(R.id.btnLogout)
    }

    private fun loadIntentData() {
        val studentName = activity?.intent?.getStringExtra("student_name") ?: "Student"
        val studentUsername = activity?.intent?.getStringExtra("student_username") ?: ""
        val studentEmail = activity?.intent?.getStringExtra("student_email") ?: ""
        val studentPhone = activity?.intent?.getStringExtra("student_phone") ?: ""
        studentId = activity?.intent?.getStringExtra("student_id") ?: "S001"

        val attendance = activity?.intent?.getStringExtra("student_attendance") ?: "Not Available"
        val result = activity?.intent?.getStringExtra("student_result") ?: "Not Available"
        val payment = activity?.intent?.getStringExtra("student_payment") ?: "Not Available"

        tvDisplayName.text = studentName
        edtName.setText(studentName)
        edtUsername.setText(studentUsername)
        edtEmail.setText(studentEmail)
        edtPhone.setText(studentPhone)

        // ✅ QR includes full info
        val qrData = """
            {
                "id": "$studentId",
                "name": "$studentName",
                "email": "$studentEmail",
                "attendance": "$attendance",
                "result": "$result",
                "payment": "$payment"
            }
        """.trimIndent()

        generateQrCode(qrData)
    }

    private fun setupListeners() {
        tvDisplayName.setOnClickListener {
            tvDisplayName.visibility = View.GONE
            edtName.visibility = View.VISIBLE
            edtName.requestFocus()
        }

        btnSave.setOnClickListener {
            val name = edtName.text.toString().trim()
            val username = edtUsername.text.toString().trim()
            val password = edtPassword.text.toString().trim()
            val email = edtEmail.text.toString().trim()
            val phone = edtPhone.text.toString().trim()

            if (name.isBlank() || username.isBlank() || password.isBlank() || email.isBlank() || phone.isBlank()) {
                Toast.makeText(context, "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            saveProfileToFirebase(name, username, password, email, phone)
        }

        btnLogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(activity, StudentDashboardActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            activity?.finish()
        }
    }

    private fun generateQrCode(data: String) {
        try {
            val barcodeEncoder = BarcodeEncoder()
            val bitmap: Bitmap = barcodeEncoder.encodeBitmap(data, BarcodeFormat.QR_CODE, 400, 400)
            imgQrCode.setImageBitmap(bitmap)
        } catch (e: WriterException) {
            e.printStackTrace()
            Toast.makeText(context, "Failed to generate QR code", Toast.LENGTH_SHORT).show()
        }
    }

    private fun saveProfileToFirebase(name: String, username: String, password: String, email: String, phone: String) {
        val database = FirebaseDatabase.getInstance().reference
        val studentRef = database.child("students").child(studentId)

        val profileData = mapOf(
            "name" to name,
            "username" to username,
            "password" to password,
            "email" to email,
            "phone" to phone
        )

        studentRef.setValue(profileData)
            .addOnSuccessListener {
                Toast.makeText(context, "Profile updated!", Toast.LENGTH_SHORT).show()
                tvDisplayName.text = name
                tvDisplayName.visibility = View.VISIBLE
                edtName.visibility = View.GONE
            }
            .addOnFailureListener {
                Toast.makeText(context, "Failed to save profile", Toast.LENGTH_SHORT).show()
            }
    }

    fun onSupportNavigateUp(): Boolean {
        activity?.finish()
        return true
    }
}
