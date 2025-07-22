package com.project.tuitionmanagementapp.admin

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.project.tuitionmanagementapp.R
import com.project.tuitionmanagementapp.databinding.ActivityAdminDashboardBinding
import com.project.tuitionmanagementapp.databinding.AdminNavHeaderBinding

class AdminDashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAdminDashboardBinding
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var headerBinding: AdminNavHeaderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Initialize view binding
        binding = ActivityAdminDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize header binding
        headerBinding = binding.mainHeader

        // Set up edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize drawer layout
        binding = ActivityAdminDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        headerBinding = binding.mainHeader

        // Set up custom header functionality
        setupCustomHeader()

        // Set default fragment
        if (savedInstanceState == null) {
            replaceFragment(admin_home())
            binding.navView.setCheckedItem(R.id.admin_home)
            binding.bottomNavigationView.selectedItemId = R.id.admin_home
        }

        setupNavigationDrawer()
        setupBottomNavigation()
    }

    private fun setupCustomHeader() {
        // Set click listener for account icon
        headerBinding.accountIcon.setOnClickListener { view ->
            showProfileDropdown(view)
        }

        // You can customize other header elements here
        // headerBinding.appName.text = "Custom App Name"
        // headerBinding.logoImage.setImageResource(R.drawable.custom_logo)
    }

    private fun setupNavigationDrawer() {
        binding.navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.admin_home -> {
                    replaceFragment(admin_home())
                    binding.bottomNavigationView.selectedItemId = R.id.admin_home
                }
                R.id.admin_account -> {
                    replaceFragment(admin_account())
                    binding.bottomNavigationView.selectedItemId = R.id.admin_account
                }
                R.id.admin_classes -> {
                    replaceFragment(admin_classes())
                    binding.bottomNavigationView.selectedItemId = R.id.admin_classes
                }
                R.id.admin_reports -> {
                    replaceFragment(admin_reports())
                    binding.bottomNavigationView.selectedItemId = R.id.admin_reports
                }
                R.id.admin_addClasses -> {
                    replaceFragment(admin_assign())
                    binding.bottomNavigationView.selectedItemId = R.id.admin_addClasses
                }
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }

    private fun setupBottomNavigation() {
        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.admin_home -> {
                    replaceFragment(admin_home())
                    binding.navView.setCheckedItem(R.id.admin_home)
                    true
                }
                R.id.admin_account -> {
                    replaceFragment(admin_account())
                    binding.navView.setCheckedItem(R.id.admin_account)
                    true
                }
                R.id.admin_classes -> {
                    replaceFragment(admin_classes())
                    binding.navView.setCheckedItem(R.id.admin_classes)
                    true
                }
                R.id.admin_reports -> {
                    replaceFragment(admin_reports())
                    binding.navView.setCheckedItem(R.id.admin_reports)
                    true
                }
                R.id.admin_addClasses -> {
                    replaceFragment(admin_assign())
                    binding.navView.setCheckedItem(R.id.admin_addClasses)
                    true
                }
                else -> false
            }
        }
    }

    private fun showProfileDropdown(anchorView: View) {
        val popup = androidx.appcompat.widget.PopupMenu(this, anchorView)
        popup.menuInflater.inflate(R.menu.account_menu_admin, popup.menu)

        popup.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.edit_profile -> {
                    handleEditProfile()
                    true
                }
                R.id.admin_settings -> {
                    handleSettings()
                    true
                }
                R.id.manage_admin -> {
                    handleManageAdmins()
                    true
                }
                else -> false
            }
        }

        popup.show()
    }

    private fun handleEditProfile() {
        Log.d("AdminDashboard", "Edit profile clicked")
    }

    private fun handleSettings() {
        Log.d("AdminDashboard", "Settings clicked")
    }

    private fun handleManageAdmins() {
        Log.d("AdminDashboard", "Manage admins clicked")
    }

    private fun replaceFragment(fragment: Fragment) {
        try {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayoutID, fragment)
                .commit()
        } catch (e: Exception) {
            Log.e("AdminDashboard", "Error replacing fragment", e)
        }
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}