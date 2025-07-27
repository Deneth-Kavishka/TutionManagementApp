package com.project.tuitionmanagementapp.teacher

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.project.tuitionmanagementapp.R
import com.project.tuitionmanagementapp.auth.LoginActivity
import com.project.tuitionmanagementapp.student.AttendanceActivity


class TeacherDashboardActivity : AppCompatActivity() {

    private lateinit var imgProfile: ImageView
    private lateinit var imgOptions: ImageView
    private lateinit var tvTeacherName: TextView
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher_dashboard)

        imgProfile = findViewById(R.id.imgProfile)
        imgOptions = findViewById(R.id.imgOptions)
        tvTeacherName = findViewById(R.id.tvTeacherName)
        bottomNavigationView = findViewById(R.id.bottomNavigation)

        val teacherName = intent.getStringExtra("teacher_name") ?: "Teacher"
        tvTeacherName.text = teacherName

        imgOptions.setOnClickListener {
            showOptionsMenu()
        }

        imgProfile.setOnClickListener {
            Toast.makeText(this, "Profile image clicked!", Toast.LENGTH_SHORT).show()
        }

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    Toast.makeText(this, "Home selected", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_assignment -> {
                    startActivity(Intent(this, AssignmentActivity::class.java))
                    true
                }
                R.id.nav_materials -> {
                    startActivity(Intent(this, MaterialsActivity::class.java))
                    true
                }
                R.id.nav_result -> {
                    startActivity(Intent(this, UploadResultActivity::class.java))
                    true
                }

                R.id.nav_attendance -> {
                    startActivity(Intent(this, AttendanceActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }

    private fun showOptionsMenu() {
        val popup = PopupMenu(this, imgOptions)
        popup.menuInflater.inflate(R.menu.menu_profile_options, popup.menu)

        popup.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.menu_edit_profile -> {
                    val intent = Intent(this, EditProfileActivity::class.java)
                    intent.putExtra("teacher_name", tvTeacherName.text.toString())
                    startActivity(intent)
                    true
                }
                R.id.menu_settings -> {
                    Toast.makeText(this, "Settings clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.menu_logout -> {
                    Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, LoginActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }

        popup.show()
    }
}
