package com.project.tuitionmanagementapp.teacher

import android.app.Dialog
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.edit
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.project.tuitionmanagementapp.R
import com.project.tuitionmanagementapp.auth.LoginActivity
import java.util.*

class TeacherDashboardActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var firestore: FirebaseFirestore
    private lateinit var sharedPreferences: SharedPreferences

    private lateinit var imgProfile: ImageView
    private lateinit var imgOptions: ImageView
    private lateinit var tvTeacherName: TextView
    private lateinit var bottomNavigationView: BottomNavigationView

    private var currentTeacherId: String? = null
    private var currentTeacherName: String? = null
    private var currentTeacherEmail: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher_dashboard)

        // Initialize Firebase
        auth = FirebaseAuth.getInstance()
        firestore = FirebaseFirestore.getInstance()
        sharedPreferences = getSharedPreferences("TeacherPrefs", MODE_PRIVATE)

        initViews()
        loadTeacherData()
        setupNavigation()
        setupClickListeners()
    }

    private fun initViews() {
        imgProfile = findViewById(R.id.imgProfile)
        imgOptions = findViewById(R.id.imgOptions)
        tvTeacherName = findViewById(R.id.tvTeacherName)

        // Find CardViews for each action - Connect ALL your created features
        val attendanceCard = findViewById<CardView>(R.id.attendanceCard)
        val materialsCard = findViewById<CardView>(R.id.materialsCard)
        val assignmentsCard = findViewById<CardView>(R.id.assignmentsCard)
        val resultsCard = findViewById<CardView>(R.id.resultsCard)

        // Set click listeners to connect ALL your created activities
        attendanceCard?.setOnClickListener { navigateToAttendance() }
        materialsCard?.setOnClickListener { navigateToMaterials() }
        assignmentsCard?.setOnClickListener { navigateToAssignments() }
        resultsCard?.setOnClickListener { navigateToResults() }

        // Initialize bottom navigation
        bottomNavigationView = findViewById(R.id.bottomNavigation)
    }

    private fun loadTeacherData() {
        val currentUser = auth.currentUser
        if (currentUser != null) {
            currentTeacherId = currentUser.uid
            currentTeacherEmail = currentUser.email

            firestore.collection("teachers").document(currentUser.uid)
                .get()
                .addOnSuccessListener { document ->
                    if (document.exists()) {
                        currentTeacherName = document.getString("name") ?: "Teacher"
                        updateUI()

                        // Store in SharedPreferences using KTX extension
                        sharedPreferences.edit {
                            putString("teacher_id", currentTeacherId)
                            putString("teacher_name", currentTeacherName)
                            putString("teacher_email", currentTeacherEmail)
                        }
                    }
                }
                .addOnFailureListener {
                    Toast.makeText(this, "Failed to load teacher data", Toast.LENGTH_SHORT).show()
                }
        }
    }

    private fun updateUI() {
        // Update teacher name
        tvTeacherName.text = currentTeacherName ?: "Teacher"

        // Update greeting based on time of day
        val welcomeText = findViewById<TextView>(R.id.welcomeText)
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val greeting = when {
            hour < 12 -> "Good Morning,"
            hour < 17 -> "Good Afternoon,"
            else -> "Good Evening,"
        }
        welcomeText?.text = greeting
    }

    private fun setupNavigation() {
        bottomNavigationView.selectedItemId = R.id.nav_home
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    // Stay on home
                    true
                }
                R.id.nav_assignment -> {
                    navigateToAssignments()
                    false
                }
                R.id.nav_materials -> {
                    navigateToMaterials()
                    false
                }
                R.id.nav_result -> {
                    navigateToResults()
                    false
                }
                R.id.nav_qr -> {
                    navigateToQRScanner()
                    false
                }
                else -> false
            }
        }
    }

    private fun setupClickListeners() {
        imgProfile.setOnClickListener { showProfileMenu(it) }
        imgOptions.setOnClickListener { showOptionsMenu(it) }
    }

    private fun showProfileMenu(view: View) {
        val popup = PopupMenu(this, view)
        popup.menuInflater.inflate(R.menu.teacher_profile_menu, popup.menu)
        popup.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.menu_edit_profile -> {
                    navigateToProfile()
                    true
                }
                R.id.menu_settings -> {
                    Toast.makeText(this, "Settings coming soon", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.menu_logout -> {
                    logoutTeacher()
                    true
                }
                else -> false
            }
        }
        popup.show()
    }

    private fun showOptionsMenu(view: View) {
        val popup = PopupMenu(this, view)
        popup.menuInflater.inflate(R.menu.teacher_options_menu, popup.menu)
        popup.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.menu_notifications -> {
                    Toast.makeText(this, "Notifications", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.menu_help -> {
                    Toast.makeText(this, "Help & Support", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.menu_about -> {
                    Toast.makeText(this, "About Academix", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.menu_analytics -> {
                    navigateToAnalytics()
                    true
                }
                R.id.menu_calendar -> {
                    navigateToCalendar()
                    true
                }
                else -> false
            }
        }
        popup.show()
    }

    private fun navigateToAttendance() {
        showAttendanceOptionsDialog()
    }

    private fun showAttendanceOptionsDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_attendance_options)
        dialog.setCancelable(true)

        // Find views in dialog
        val btnCloseDialog = dialog.findViewById<ImageView>(R.id.btnCloseDialog)
        val cardQRScanner = dialog.findViewById<CardView>(R.id.cardQRScanner)
        val cardViewRecords = dialog.findViewById<CardView>(R.id.cardViewRecords)

        // Set click listeners
        btnCloseDialog.setOnClickListener {
            dialog.dismiss()
        }

        cardQRScanner.setOnClickListener {
            dialog.dismiss()
            try {
                startActivity(Intent(this, QRAttendanceActivity::class.java))
            } catch (e: Exception) {
                Toast.makeText(this, "QR Scanner not available: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }

        cardViewRecords.setOnClickListener {
            dialog.dismiss()
            try {
                startActivity(Intent(this, AttendanceRecordsActivity::class.java))
            } catch (e: Exception) {
                Toast.makeText(this, "Attendance Records not available: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }

        dialog.show()
    }

    private fun navigateToAssignments() {
        try {
            startActivity(Intent(this, AssignmentActivity::class.java))
        } catch (_: Exception) {
            Toast.makeText(this, "Assignment feature is not available", Toast.LENGTH_SHORT).show()
        }
    }

    private fun navigateToMaterials() {
        try {
            startActivity(Intent(this, TeacherMaterialsManagementActivity::class.java))
        } catch (_: Exception) {
            Toast.makeText(this, "Materials feature is not available", Toast.LENGTH_SHORT).show()
        }
    }

    private fun navigateToResults() {
        try {
            startActivity(Intent(this, UploadResultActivity::class.java))
        } catch (_: Exception) {
            Toast.makeText(this, "Results feature is not available", Toast.LENGTH_SHORT).show()
        }
    }

    private fun navigateToQRScanner() {
        try {
            startActivity(Intent(this, QRAttendanceActivity::class.java))
        } catch (_: Exception) {
            Toast.makeText(this, "QR Scanner feature is not available", Toast.LENGTH_SHORT).show()
        }
    }

    private fun navigateToProfile() {
        try {
            startActivity(Intent(this, EditProfileActivity::class.java))
        } catch (_: Exception) {
            Toast.makeText(this, "Profile feature is not available", Toast.LENGTH_SHORT).show()
        }
    }

    private fun navigateToAnalytics() {
        try {
            startActivity(Intent(this, AnalyticsActivity::class.java))
        } catch (_: Exception) {
            Toast.makeText(this, "Analytics feature is not available", Toast.LENGTH_SHORT).show()
        }
    }

    private fun navigateToCalendar() {
        try {
            startActivity(Intent(this, CalendarActivity::class.java))
        } catch (_: Exception) {
            Toast.makeText(this, "Calendar feature is not available", Toast.LENGTH_SHORT).show()
        }
    }

    private fun logoutTeacher() {
        android.app.AlertDialog.Builder(this)
            .setTitle("Logout")
            .setMessage("Are you sure you want to logout?")
            .setPositiveButton("Yes") { _, _ ->
                sharedPreferences.edit { clear() }
                auth.signOut()
                startActivity(Intent(this, LoginActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                })
                finish()
            }
            .setNegativeButton("No", null)
            .show()
    }

    override fun onResume() {
        super.onResume()
        loadTeacherData()
        // Reset bottom navigation to home when returning to dashboard
        bottomNavigationView.selectedItemId = R.id.nav_home
    }
}
