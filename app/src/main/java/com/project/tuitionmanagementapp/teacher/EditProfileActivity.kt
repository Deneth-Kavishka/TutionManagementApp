package com.project.tuitionmanagementapp.teacher

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.firebase.database.FirebaseDatabase
import com.project.tuitionmanagementapp.R

class EditProfileActivity : AppCompatActivity() {

    private lateinit var imgProfile: ImageView
    private lateinit var tvDisplayName: TextView
    private lateinit var edtName: EditText
    private lateinit var edtUsername: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnSave: Button

    private val PICK_IMAGE_REQUEST = 1
    private var selectedImageUri: Uri? = null

    private var teacherId: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_teacher_profile)

        // ✅ Toolbar Setup
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Edit Profile"

        imgProfile = findViewById(R.id.imgProfileEdit)
        tvDisplayName = findViewById(R.id.tvDisplayName)
        edtName = findViewById(R.id.edtName)
        edtUsername = findViewById(R.id.edtUsername)
        edtPassword = findViewById(R.id.edtPassword)
        btnSave = findViewById(R.id.btnSaveProfile)

        // Pre-fill teacher name from intent
        val teacherName = intent.getStringExtra("teacher_name") ?: "Teacher"
        tvDisplayName.text = teacherName
        edtName.setText(teacherName)

        teacherId = intent.getStringExtra("teacher_id") ?: teacherName.lowercase()

        // Toggle name edit
        tvDisplayName.setOnClickListener {
            tvDisplayName.visibility = View.GONE
            edtName.visibility = View.VISIBLE
            edtName.requestFocus()
        }

        // Pick image
        imgProfile.setOnClickListener {
            openGallery()
        }

        // Save profile
        btnSave.setOnClickListener {
            val name = edtName.text.toString().trim()
            val username = edtUsername.text.toString().trim()
            val password = edtPassword.text.toString().trim()

            if (name.isBlank() || username.isBlank() || password.isBlank()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else {
                saveProfileToFirebase(name, username, password)
            }
        }
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK) {
            selectedImageUri = data?.data
            imgProfile.setImageURI(selectedImageUri)
        }
    }

    private fun saveProfileToFirebase(name: String, username: String, password: String) {
        val database = FirebaseDatabase.getInstance().reference
        val teacherRef = database.child("teachers").child(teacherId)

        val profileData = mapOf(
            "name" to name,
            "username" to username,
            "password" to password
        )

        teacherRef.setValue(profileData)
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

    // 🔙 Back arrow in toolbar
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
