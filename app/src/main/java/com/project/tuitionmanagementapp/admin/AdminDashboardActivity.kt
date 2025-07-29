package com.project.tuitionmanagementapp.admin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
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

        // Initialize drawer layout
        drawerLayout = binding.drawerLayout

        // Initialize header binding
        headerBinding = binding.mainHeader

        // Set up edge-to-edge display with proper padding for bottom navigation
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            // Don't apply top padding to root as header handles it
            view.setPadding(systemBars.left, 0, systemBars.right, 0)

            // Apply bottom padding to bottom navigation
            binding.bottomNavigationView.setPadding(
                binding.bottomNavigationView.paddingLeft,
                binding.bottomNavigationView.paddingTop,
                binding.bottomNavigationView.paddingRight,
                systemBars.bottom + 20
            )
            insets
        }

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

        // Since there's no menu icon in the header layout, we'll use the app name as a fallback
        // for opening the drawer, or users can swipe from the edge
        try {
            headerBinding.appName.setOnClickListener {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START)
                } else {
                    drawerLayout.openDrawer(GravityCompat.START)
                }
            }
        } catch (e: Exception) {
            Log.d("AdminDashboard", "App name click listener setup failed")
        }
    }

    private fun setupNavigationDrawer() {
        binding.navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.admin_home -> {
                    replaceFragment(admin_home())
                    binding.bottomNavigationView.selectedItemId = R.id.admin_home
                }
                R.id.admin_account -> {
                    // Launch the proper AdminAccountActivity instead of using a fragment
                    val intent = Intent(this, AdminAccountActivity::class.java)
                    startActivity(intent)
                    true
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
                    // Launch the proper AdminAccountActivity instead of using a fragment
                    val intent = Intent(this, AdminAccountActivity::class.java)
                    startActivity(intent)
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
                R.id.admin_logout -> {
                    handleLogout()
                    true
                }
                else -> false
            }
        }

        popup.show()
    }

    private fun handleEditProfile() {
        Log.d("AdminDashboard", "Edit profile clicked")
        Toast.makeText(this, "Edit Profile functionality will be implemented", Toast.LENGTH_SHORT).show()
    }

    private fun handleSettings() {
        Log.d("AdminDashboard", "Settings clicked")
        // Instead of trying to load a settings fragment that may not exist,
        // redirect to admin_account which can handle admin settings
        replaceFragment(admin_account())
        Toast.makeText(this, "Admin Settings", Toast.LENGTH_SHORT).show()
    }

    private fun handleManageAdmins() {
        Log.d("AdminDashboard", "Manage admins clicked")
        // Use admin_account fragment which handles user management
        replaceFragment(admin_account())
        Toast.makeText(this, "User Management", Toast.LENGTH_SHORT).show()
    }

    private fun handleLogout() {
        // Show a confirmation dialog before logging out
        android.app.AlertDialog.Builder(this)
            .setTitle("Logout")
            .setMessage("Are you sure you want to logout?")
            .setPositiveButton("Yes") { _, _ ->
                // Clear user session data (you may want to use SharedPreferences or your auth system)
                val sharedPrefs = getSharedPreferences("TuitionAppPrefs", MODE_PRIVATE)
                val editor = sharedPrefs.edit()
                editor.remove("admin_logged_in")
                editor.remove("admin_id")
                editor.remove("admin_name")
                editor.remove("admin_email")
                // Add any other admin data that needs to be cleared
                editor.apply()

                // Show toast message
                Toast.makeText(this, "Logged out successfully", Toast.LENGTH_SHORT).show()

                // Redirect to login screen
                val intent = Intent(this, com.project.tuitionmanagementapp.auth.LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish()
            }
            .setNegativeButton("No", null)
            .show()
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

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (::drawerLayout.isInitialized && drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
