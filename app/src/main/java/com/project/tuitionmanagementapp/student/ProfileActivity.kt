package com.project.tuitionmanagementapp.student

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.google.zxing.common.BitMatrix
import com.google.zxing.qrcode.QRCodeWriter
import com.project.tuitionmanagementapp.auth.LoginActivity
import com.project.tuitionmanagementapp.R
import java.text.SimpleDateFormat
import java.util.*

class ProfileActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var firestore: FirebaseFirestore
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var imgOptions: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_profile)

        // Initialize Firebase
        auth = FirebaseAuth.getInstance()
        firestore = FirebaseFirestore.getInstance()
        sharedPreferences = getSharedPreferences("StudentPrefs", MODE_PRIVATE)

        // Setup back button
        val backButton = findViewById<ImageView>(R.id.backButton)
        backButton?.setOnClickListener {
            finish()
        }

        // Setup options menu
        imgOptions = findViewById(R.id.imgOptions)
        imgOptions.setOnClickListener { view ->
            showProfileOptionsMenu(view)
        }

        // Load Profile Fragment
        loadFragment(ProfileFragment())

        // Setup bottom navigation
        setupBottomNavigation()
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

    private fun showProfileOptionsMenu(view: View) {
        val popup = PopupMenu(this, view)
        popup.menuInflater.inflate(R.menu.profile_dropdown_menu, popup.menu)

        popup.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.menu_view_profile -> {
                    // Already in profile, just refresh
                    loadFragment(ProfileFragment())
                    true
                }
                R.id.menu_qr_code -> {
                    showStudentQRCode()
                    true
                }
                R.id.menu_settings -> {
                    Toast.makeText(this, "Settings coming soon", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.menu_logout -> {
                    logoutStudent()
                    true
                }
                else -> false
            }
        }
        popup.show()
    }

    private fun showStudentQRCode() {
        val studentData = buildStudentQRData()
        val qrBitmap = generateQRCode(studentData)

        if (qrBitmap != null) {
            val dialog = android.app.AlertDialog.Builder(this)
                .setTitle("Student QR Code")
                .setMessage("Scan this QR code to view student details")
                .setPositiveButton("Close") { dialog, _ -> dialog.dismiss() }
                .create()

            val imageView = ImageView(this)
            imageView.setImageBitmap(qrBitmap)
            imageView.setPadding(50, 50, 50, 50)

            dialog.setView(imageView)
            dialog.show()
        } else {
            Toast.makeText(this, "Error generating QR code", Toast.LENGTH_SHORT).show()
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
            val bitMatrix: BitMatrix = writer.encode(data, BarcodeFormat.QR_CODE, 512, 512)
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

    private fun logoutStudent() {
        android.app.AlertDialog.Builder(this)
            .setTitle("Logout")
            .setMessage("Are you sure you want to logout?")
            .setPositiveButton("Yes") { _, _ ->
                sharedPreferences.edit().clear().apply()
                auth.signOut()

                val intent = Intent(this, LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish()
            }
            .setNegativeButton("No", null)
            .show()
    }

    private fun setupBottomNavigation() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView?.selectedItemId = R.id.nav_profile

        bottomNavigationView?.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, StudentDashboardActivity::class.java))
                    finish()
                    true
                }
                R.id.nav_attendance -> {
                    startActivity(Intent(this, AttendanceActivity::class.java))
                    overridePendingTransition(0, 0)
                    true
                }
                R.id.nav_assignments -> {
                    startActivity(Intent(this, AssignmentActivity::class.java))
                    overridePendingTransition(0, 0)
                    true
                }
                R.id.nav_profile -> true
                else -> false
            }
        }
    }
}
