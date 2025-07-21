package com.project.tuitionmanagementapp.student

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.project.tuitionmanagementapp.R
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.journeyapps.barcodescanner.BarcodeEncoder
import com.project.tuitionmanagementapp.MainActivity

class ProfileActivity : AppCompatActivity() {

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_profile_student)

        setupToolbar()
        bindViews()
        loadIntentData()
        setupListeners()
    }

    private fun setupToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbarStudent)
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = "Edit Student Profile"
        }
    }

    private fun bindViews() {
        imgProfile = findViewById(R.id.imgStudentProfile)
        imgQrCode = findViewById(R.id.imgStudentQrCode)
        tvDisplayName = findViewById(R.id.tvStudentDisplayName)
        edtName = findViewById(R.id.edtStudentName)
        edtUsername = findViewById(R.id.edtStudentUsername)
        edtPassword = findViewById(R.id.edtStudentPassword)
        edtEmail = findViewById(R.id.edtStudentEmail)
        edtPhone = findViewById(R.id.edtStudentPhone)
        btnSave = findViewById(R.id.btnSaveStudentProfile)
        btnLogout = findViewById(R.id.btnLogout)
    }

    private fun loadIntentData() {
        val studentName = intent.getStringExtra("student_name") ?: "Student"
        val studentUsername = intent.getStringExtra("student_username") ?: ""
        val studentEmail = intent.getStringExtra("student_email") ?: ""
        val studentPhone = intent.getStringExtra("student_phone") ?: ""
        studentId = intent.getStringExtra("student_id") ?: "S001"

        val attendance = intent.getStringExtra("student_attendance") ?: "Not Available"
        val result = intent.getStringExtra("student_result") ?: "Not Available"
        val payment = intent.getStringExtra("student_payment") ?: "Not Available"

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
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            saveProfileToFirebase(name, username, password, email, phone)
        }

        btnLogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }

    private fun generateQrCode(data: String) {
        try {
            val barcodeEncoder = BarcodeEncoder()
            val bitmap: Bitmap = barcodeEncoder.encodeBitmap(data, BarcodeFormat.QR_CODE, 400, 400)
            imgQrCode.setImageBitmap(bitmap)
        } catch (e: WriterException) {
            e.printStackTrace()
            Toast.makeText(this, "Failed to generate QR code", Toast.LENGTH_SHORT).show()
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
                Toast.makeText(this, "Profile updated!", Toast.LENGTH_SHORT).show()
                tvDisplayName.text = name
                tvDisplayName.visibility = View.VISIBLE
                edtName.visibility = View.GONE
            }
            .addOnFailureListener {
                Toast.makeText(this, "Failed to save profile", Toast.LENGTH_SHORT).show()
            }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
