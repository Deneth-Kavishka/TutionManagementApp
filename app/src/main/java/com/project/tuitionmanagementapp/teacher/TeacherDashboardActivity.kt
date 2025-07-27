package com.project.tuitionmanagementapp.teacher

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.project.tuitionmanagementapp.R
import com.project.tuitionmanagementapp.auth.LoginActivity
import java.text.SimpleDateFormat
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

        // Find CardViews for each action
        // Using findViewById with null-safe calls and finding parent CardView instead of LinearLayout
        val attendanceCard = findViewById<CardView>(R.id.attendanceCard)
        val materialsCard = findViewById<CardView>(R.id.materialsCard)
        val assignmentsCard = findViewById<CardView>(R.id.assignmentsCard)
        val resultsCard = findViewById<CardView>(R.id.resultsCard)

        // Set click listeners with null checks
        attendanceCard?.setOnClickListener { navigateToAttendance() }
        materialsCard?.setOnClickListener { navigateToMaterials() }
        assignmentsCard?.setOnClickListener { navigateToAssignments() }
        resultsCard?.setOnClickListener { navigateToResults() }

        // Try to find the bottom navigation if it exists
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

                        // Store in SharedPreferences
                        with(sharedPreferences.edit()) {
                            putString("teacher_id", currentTeacherId)
                            putString("teacher_name", currentTeacherName)
                            putString("teacher_email", currentTeacherEmail)
                            apply()
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

        // Note: welcomeText is used instead of tvGreeting
        val welcomeText = findViewById<TextView>(R.id.welcomeText)

        // Update greeting based on time of day
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
                R.id.nav_home -> true
                R.id.nav_assignment -> {
                    navigateToAssignments()
                    true
                }
                R.id.nav_materials -> {
                    navigateToMaterials()
                    true
                }
                R.id.nav_profile -> {
                    navigateToProfile()
                    true
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
                    startActivity(Intent(this, EditProfileActivity::class.java))
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
                else -> false
            }
        }
        popup.show()
    }

    private fun navigateToAttendance() {
        // Show options for attendance - QR Scanner or Manual Entry
        val options = arrayOf("QR Code Scanner", "View Attendance Records")
        android.app.AlertDialog.Builder(this)
            .setTitle("Attendance Options")
            .setItems(options) { _, which ->
                when (which) {
                    0 -> startActivity(Intent(this, QRAttendanceActivity::class.java))
                    1 -> startActivity(Intent(this, AttendanceFragment::class.java))
                }
            }
            .show()
    }

    private fun navigateToAssignments() = startActivity(Intent(this, AssignmentActivity::class.java))
    private fun navigateToMaterials() = startActivity(Intent(this, TeacherMaterialsActivity::class.java))
    private fun navigateToResults() = startActivity(Intent(this, UploadResultActivity::class.java))

    // These activities don't exist yet, so let's show a Toast instead
    private fun navigateToAnalytics() {
        Toast.makeText(this, "Analytics feature coming soon", Toast.LENGTH_SHORT).show()
    }

    private fun navigateToCalendar() {
        Toast.makeText(this, "Calendar feature coming soon", Toast.LENGTH_SHORT).show()
    }

    private fun navigateToProfile() = startActivity(Intent(this, EditProfileActivity::class.java))

    private fun logoutTeacher() {
        android.app.AlertDialog.Builder(this)
            .setTitle("Logout")
            .setMessage("Are you sure you want to logout?")
            .setPositiveButton("Yes") { _, _ ->
                sharedPreferences.edit().clear().apply()
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
    }
}
