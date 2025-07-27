package com.project.tuitionmanagementapp.student

import android.content.SharedPreferences
import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.google.zxing.qrcode.QRCodeWriter
import com.project.tuitionmanagementapp.R
import java.text.SimpleDateFormat
import java.util.*

class ProfileFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var firestore: FirebaseFirestore
    private lateinit var sharedPreferences: SharedPreferences

    private lateinit var tvStudentName: TextView
    private lateinit var tvStudentEmail: TextView
    private lateinit var tvStudentId: TextView
    private lateinit var tvStudentClass: TextView
    private lateinit var imgQrCode: ImageView
    private lateinit var btnGenerateQR: Button
    private lateinit var imgStudentProfile: ImageView
    private lateinit var edtStudentName: EditText
    private lateinit var edtStudentEmail: EditText
    private lateinit var edtStudentPhone: EditText
    private lateinit var btnEditProfileIcon: ImageButton
    private lateinit var btnSaveProfile: Button
    private lateinit var btnLogout: Button
    private var isEditing: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile_student, container, false)

        // Initialize Firebase
        auth = FirebaseAuth.getInstance()
        firestore = FirebaseFirestore.getInstance()
        sharedPreferences = requireContext().getSharedPreferences("StudentPrefs", android.content.Context.MODE_PRIVATE)

        initViews(view)
        loadStudentProfile()
        setupClickListeners()

        return view
    }

    private fun initViews(view: View) {
        tvStudentName = view.findViewById(R.id.tvStudentDisplayName)
        tvStudentEmail = view.findViewById(R.id.edtStudentEmail)
        tvStudentId = view.findViewById(R.id.tvQrLabel)
        tvStudentClass = view.findViewById(R.id.tvQrLabel)
        imgQrCode = view.findViewById(R.id.imgStudentQrCode)
        btnGenerateQR = view.findViewById(R.id.btnSaveStudentProfile)
        imgStudentProfile = view.findViewById(R.id.imgStudentProfile)
        edtStudentName = view.findViewById(R.id.edtStudentName)
        edtStudentEmail = view.findViewById(R.id.edtStudentEmail)
        edtStudentPhone = view.findViewById(R.id.edtStudentPhone)
        btnEditProfileIcon = view.findViewById(R.id.btnEditProfileIcon)
        btnSaveProfile = view.findViewById(R.id.btnSaveStudentProfile)
        btnLogout = view.findViewById(R.id.btnLogout)
    }

    private fun loadStudentProfile() {
        val currentUser = auth.currentUser
        if (currentUser != null) {
            // Get data from SharedPreferences first (faster)
            val savedName = sharedPreferences.getString("student_name", null)
            val savedEmail = sharedPreferences.getString("student_email", null)
            val savedId = sharedPreferences.getString("student_id", null)
            val savedClass = sharedPreferences.getString("student_class", null)

            if (savedName != null) {
                updateProfileUI(savedName, savedEmail, savedId, savedClass)
            }

            // Also fetch from Firestore for latest data
            firestore.collection("students").document(currentUser.uid)
                .get()
                .addOnSuccessListener { document ->
                    if (document.exists()) {
                        val name = document.getString("name") ?: "Student"
                        val email = currentUser.email ?: "No Email"
                        val studentId = currentUser.uid
                        val studentClass = document.getString("class") ?: "No Class"

                        updateProfileUI(name, email, studentId, studentClass)

                        // Update SharedPreferences
                        with(sharedPreferences.edit()) {
                            putString("student_name", name)
                            putString("student_email", email)
                            putString("student_id", studentId)
                            putString("student_class", studentClass)
                            apply()
                        }
                    }
                }
                .addOnFailureListener {
                    Toast.makeText(requireContext(), "Failed to load profile", Toast.LENGTH_SHORT).show()
                }
        }
    }

    private fun updateProfileUI(name: String?, email: String?, id: String?, studentClass: String?) {
        tvStudentName.text = name ?: "Student Name"
        tvStudentEmail.text = email ?: "student@email.com"
        tvStudentId.text = "ID: ${id ?: "N/A"}"
        tvStudentClass.text = "Class: ${studentClass ?: "Not Assigned"}"
        edtStudentName.setText(name)
        edtStudentEmail.setText(email)
        //edtStudentPhone.setText(phone) // Assuming phone is also saved in SharedPreferences
    }

    private fun setupClickListeners() {
        btnGenerateQR.setOnClickListener {
            if (!isEditing) {
                generateStudentQRCode()
            } else {
                saveProfileChanges()
            }
        }

        btnEditProfileIcon.setOnClickListener {
            enableEditing(true)
        }

        imgStudentProfile.setOnClickListener {
            if (isEditing) pickProfileImage()
        }

        btnLogout.setOnClickListener {
            auth.signOut()
            Toast.makeText(requireContext(), "Logged out successfully", Toast.LENGTH_SHORT).show()
        }

        enableEditing(false)
    }

    private fun enableEditing(enable: Boolean) {
        isEditing = enable
        edtStudentName.isEnabled = enable
        edtStudentName.visibility = if (enable) View.VISIBLE else View.GONE
        edtStudentEmail.isEnabled = enable
        edtStudentPhone.isEnabled = enable

        // Change save button text based on mode
        btnSaveProfile.text = if (enable) "Save Changes" else "Generate QR Code"

        // Show hint to tap profile image when editing
        if (enable) {
            Toast.makeText(requireContext(), "Tap profile image to change photo", Toast.LENGTH_SHORT).show()
        }
    }

    private fun saveProfileChanges() {
        val name = edtStudentName.text.toString()
        val email = edtStudentEmail.text.toString()
        val phone = edtStudentPhone.text.toString()
        // Save to Firestore and SharedPreferences
        val currentUser = auth.currentUser ?: return
        firestore.collection("students").document(currentUser.uid)
            .update(mapOf(
                "name" to name,
                "email" to email,
                "phone" to phone
            )).addOnSuccessListener {
                Toast.makeText(requireContext(), "Profile updated!", Toast.LENGTH_SHORT).show()
                enableEditing(false)
            }.addOnFailureListener {
                Toast.makeText(requireContext(), "Failed to update profile", Toast.LENGTH_SHORT).show()
            }
        with(sharedPreferences.edit()) {
            putString("student_name", name)
            putString("student_email", email)
            putString("student_phone", phone)
            apply()
        }
    }

    private fun pickProfileImage() {
        val intent = android.content.Intent(android.content.Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, 101)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: android.content.Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 101 && resultCode == android.app.Activity.RESULT_OK) {
            val uri = data?.data
            imgStudentProfile.setImageURI(uri)
            // Optionally upload to Firebase Storage here
        }
    }

    private fun generateStudentQRCode() {
        val studentData = buildStudentQRData()
        val qrBitmap = generateQRCode(studentData)

        if (qrBitmap != null) {
            imgQrCode.setImageBitmap(qrBitmap)
            imgQrCode.visibility = View.VISIBLE
            Toast.makeText(requireContext(), "QR Code Generated Successfully", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(requireContext(), "Error generating QR code", Toast.LENGTH_SHORT).show()
        }
    }

    private fun buildStudentQRData(): String {
        val studentId = sharedPreferences.getString("student_id", "N/A") ?: "N/A"
        val studentName = sharedPreferences.getString("student_name", "N/A") ?: "N/A"
        val studentEmail = sharedPreferences.getString("student_email", "N/A") ?: "N/A"
        val studentClass = sharedPreferences.getString("student_class", "N/A") ?: "N/A"
        val timestamp = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date())

        return """
            ACADEMIX STUDENT
            ID: $studentId
            Name: $studentName
            Email: $studentEmail
            Class: $studentClass
            Generated: $timestamp
        """.trimIndent()
    }

    private fun generateQRCode(data: String): Bitmap? {
        return try {
            val writer = QRCodeWriter()
            val bitMatrix = writer.encode(data, BarcodeFormat.QR_CODE, 300, 300)
            val width = bitMatrix.width
            val height = bitMatrix.height
            val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)

            for (x in 0 until width) {
                for (y in 0 until height) {
                    bitmap.setPixel(x, y, if (bitMatrix[x, y]) Color.BLACK else Color.WHITE)
                }
            }
            bitmap
        } catch (e: WriterException) {
            e.printStackTrace()
            null
        }
    }
}
