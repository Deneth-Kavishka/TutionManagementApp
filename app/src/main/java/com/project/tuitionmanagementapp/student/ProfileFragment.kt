package com.example.studentapplication

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import java.io.InputStream

class ProfileActivity : AppCompatActivity() {

    private lateinit var ivProfile: ImageView
    private lateinit var btnEditPhoto: Button
    private lateinit var etUsername: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPhone: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnSave: Button

    private var selectedImageUri: Uri? = null

    // Modern image picker using Activity Result API
    private val pickImageLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK && result.data != null) {
            selectedImageUri = result.data!!.data
            try {
                selectedImageUri?.let { uri ->
                    val inputStream: InputStream? = contentResolver.openInputStream(uri)
                    val bitmap = BitmapFactory.decodeStream(inputStream)
                    ivProfile.setImageBitmap(bitmap)
                }
            } catch (e: Exception) {
                Toast.makeText(this, "Error loading image", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_profile_student)  // or activity_profile.xml

        // Bind views
        ivProfile = findViewById(R.id.ivProfile)
        btnEditPhoto = findViewById(R.id.btnEditPhoto)
        etUsername = findViewById(R.id.etUsername)
        etEmail = findViewById(R.id.etEmail)
        etPhone = findViewById(R.id.etPhone)
        etPassword = findViewById(R.id.etPassword)
        btnSave = findViewById(R.id.btnSaveProfile)

        // Set dummy data (replace with Firebase later)
        etUsername.setText("student123")
        etEmail.setText("student@email.com")
        etPhone.setText("0712345678")
        etPassword.setText("password123")

        // Pick image
        btnEditPhoto.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            pickImageLauncher.launch(intent)
        }

        // Save button
        btnSave.setOnClickListener {
            val name = etUsername.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val phone = etPhone.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else {
                // You can save this data to Firebase or SharedPreferences
                Toast.makeText(this, "Profile updated successfully!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
