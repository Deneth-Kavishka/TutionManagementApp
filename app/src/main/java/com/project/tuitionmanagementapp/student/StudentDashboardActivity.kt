// StudentDashboardActivity.kt
package com.project.tuitionmanagementapp.student

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
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

class StudentDashboardActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var firestore: FirebaseFirestore
    private lateinit var sharedPreferences: SharedPreferences

    private lateinit var welcomeText: TextView
    private lateinit var greetingText: TextView
    private lateinit var imgProfile: ImageView
    private lateinit var imgOptions: ImageView

    private var currentStudentId: String? = null
    private var currentStudentName: String? = null
    private var currentStudentEmail: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_dashboard)

        // Initialize Firebase
        auth = FirebaseAuth.getInstance()
        firestore = FirebaseFirestore.getInstance()
        sharedPreferences = getSharedPreferences("StudentPrefs", MODE_PRIVATE)

        // Initialize views
        initViews()

        // Load student data
        loadStudentData()

        // Setup navigation
        setupBottomNavigation()

        // Setup click listeners
        setupClickListeners()

        // Setup profile dropdown
        setupProfileDropdown()
    }

    private fun initViews() {
        welcomeText = findViewById(R.id.welcomeText)
        greetingText = findViewById(R.id.greetingText)
        imgProfile = findViewById(R.id.imgProfile)
        imgOptions = findViewById(R.id.imgOptions)
    }

    private fun loadStudentData() {
        val currentUser = auth.currentUser
        if (currentUser != null) {
            currentStudentId = currentUser.uid
            currentStudentEmail = currentUser.email

            // Get student data from Firestore
            firestore.collection("students").document(currentUser.uid)
                .get()
                .addOnSuccessListener { document ->
                    if (document.exists()) {
                        currentStudentName = document.getString("name") ?: "Student"
                        val studentClass = document.getString("class") ?: ""

                        // Update UI with student info
                        updateWelcomeText()

                        // Store in SharedPreferences for QR generation
                        with(sharedPreferences.edit()) {
                            putString("student_id", currentStudentId)
                            putString("student_name", currentStudentName)
                            putString("student_email", currentStudentEmail)
                            putString("student_class", studentClass)
                            apply()
                        }
                    } else {
                        greetingText.text = "Student"
                    }
                }
                .addOnFailureListener {
                    greetingText.text = "Student"
                }
        }
    }

    private fun updateWelcomeText() {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)

        val greeting = when {
            hour < 12 -> "Good Morning,"
            hour < 17 -> "Good Afternoon,"
            else -> "Good Evening,"
        }

        welcomeText.text = greeting
        greetingText.text = currentStudentName ?: "Student"
    }

    private fun setupBottomNavigation() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.selectedItemId = R.id.nav_home

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> true
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
                R.id.nav_profile -> {
                    startActivity(Intent(this, ProfileActivity::class.java))
                    overridePendingTransition(0, 0)
                    true
                }
                else -> false
            }
        }
    }

    private fun setupClickListeners() {
        // Attendance card click
        findViewById<LinearLayout>(R.id.attendence1)?.setOnClickListener {
            startActivity(Intent(this, AttendanceActivity::class.java))
        }

        // Assignments card click
        findViewById<LinearLayout>(R.id.assignments1)?.setOnClickListener {
            startActivity(Intent(this, AssignmentActivity::class.java))
        }

        // Results card click
        findViewById<LinearLayout>(R.id.results1)?.setOnClickListener {
            showResultsSection()
        }

        // Materials card click
        findViewById<LinearLayout>(R.id.materials1)?.setOnClickListener {
            startActivity(Intent(this, MaterialsActivity::class.java))
        }
    }

    private fun setupProfileDropdown() {
        imgProfile.setOnClickListener { view ->
            showProfileDropdown(view)
        }

        imgOptions.setOnClickListener { view ->
            showOptionsMenu(view)
        }
    }

    private fun showProfileDropdown(view: View) {
        val popup = PopupMenu(this, view)
        popup.menuInflater.inflate(R.menu.profile_dropdown_menu, popup.menu)

        popup.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.menu_view_profile -> {
                    startActivity(Intent(this, ProfileActivity::class.java))
                    true
                }
                R.id.menu_qr_code -> {
                    showStudentQRCode()
                    true
                }
                R.id.menu_settings -> {
                    // Navigate to settings if available
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

    private fun showOptionsMenu(view: View) {
        val popup = PopupMenu(this, view)
        popup.menuInflater.inflate(R.menu.options_menu, popup.menu)

        popup.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.menu_notifications -> {
                    // Show notifications
                    Toast.makeText(this, "Notifications", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.menu_help -> {
                    // Show help
                    Toast.makeText(this, "Help & Support", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.menu_about -> {
                    // Show about
                    Toast.makeText(this, "About Academix", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
        popup.show()
    }

    private fun showStudentQRCode() {
        // Generate unique QR code for student
        val studentData = buildStudentQRData()
        val qrBitmap = generateQRCode(studentData)

        if (qrBitmap != null) {
            // Create and show QR code dialog
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
        // Build unique student data for QR code
        val studentId = currentStudentId ?: "N/A"
        val studentName = currentStudentName ?: "N/A"
        val studentEmail = currentStudentEmail ?: "N/A"
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

    private fun showResultsSection() {
        // Create intent to show results
        val intent = Intent(this, ResultActivity::class.java)
        startActivity(intent)
    }

    private fun showMaterialsSection() {
        val intent = Intent(this, MaterialsActivity::class.java)
        startActivity(intent)
    }

    private fun logoutStudent() {
        android.app.AlertDialog.Builder(this)
            .setTitle("Logout")
            .setMessage("Are you sure you want to logout?")
            .setPositiveButton("Yes") { _, _ ->
                // Clear SharedPreferences
                sharedPreferences.edit().clear().apply()

                // Sign out from Firebase
                auth.signOut()

                // Navigate to login
                val intent = Intent(this, LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish()
            }
            .setNegativeButton("No", null)
            .show()
    }

    override fun onResume() {
        super.onResume()
        // Refresh student data when returning to dashboard
        loadStudentData()
    }
}
