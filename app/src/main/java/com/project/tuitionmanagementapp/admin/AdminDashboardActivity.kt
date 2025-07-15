package com.project.tuitionmanagementapp.admin

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.project.tuitionmanagementapp.R
import com.google.android.material.navigation.NavigationView
import com.project.tuitionmanagementapp.admin.student.StudentListFragment
import com.project.tuitionmanagementapp.admin.teachers.TeacherListFragment
import com.project.tuitionmanagementapp.admin.courses.CourseListFragment
import com.project.tuitionmanagementapp.admin.attendance.AttendanceReportFragment
import com.project.tuitionmanagementapp.admin.payments.PaymentListFragment
import com.project.tuitionmanagementapp.admin.notifications.NotificationListFragment

class AdminDashboardActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var drawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_dashboard)

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.navigation_view)

        drawerToggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )

        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        // Load dashboard fragment by default
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.content_frame, DashboardFragment())
                .commit()
            navigationView.setCheckedItem(R.id.nav_dashboard)
        }

        navigationView.setNavigationItemSelectedListener { menuItem ->
            drawerLayout.closeDrawers()
            when (menuItem.itemId) {
                R.id.nav_dashboard -> {
                    replaceFragment(DashboardFragment())
                    true
                }
                R.id.nav_students -> {
                    replaceFragment(StudentListFragment())
                    true
                }
                R.id.nav_teachers -> {
                    replaceFragment(TeacherListFragment())
                    true
                }
                R.id.nav_courses -> {
                    replaceFragment(CourseListFragment())
                    true
                }
                R.id.nav_attendance -> {
                    replaceFragment(AttendanceReportFragment())
                    true
                }
                R.id.nav_payments -> {
                    replaceFragment(PaymentListFragment())
                    true
                }
                R.id.nav_notifications -> {
                    replaceFragment(NotificationListFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: androidx.fragment.app.Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.content_frame, fragment)
            .commit()
    }
}
