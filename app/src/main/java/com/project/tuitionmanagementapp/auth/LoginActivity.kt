package com.project.tuitionmanagementapp.auth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.project.tuitionmanagementapp.databinding.FragmentLoginBinding
import com.project.tuitionmanagementapp.models.User
import com.project.tuitionmanagementapp.admin.AdminDashboardActivity
import com.project.tuitionmanagementapp.student.StudentDashboardActivity
import com.project.tuitionmanagementapp.teacher.TeacherDashboardActivity
import com.project.tuitionmanagementapp.parent.ParentHomeActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var database: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase Realtime DB only
        database = FirebaseDatabase.getInstance()

        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.loginButton.setOnClickListener {
            val email = binding.email.text.toString().trim()
            val password = binding.password.text.toString().trim()

            if (validateInput(email, password)) {
                loginUser(email, password)
            }
        }

        binding.goToRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        binding.forgotPassword.setOnClickListener {
            Toast.makeText(this, "Password reset feature coming soon", Toast.LENGTH_SHORT).show()
        }
    }

    private fun validateInput(email: String, password: String): Boolean {
        if (email.isEmpty()) {
            binding.email.error = "Email is required"
            return false
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.email.error = "Invalid email format"
            return false
        }
        if (password.isEmpty()) {
            binding.password.error = "Password is required"
            return false
        }
        if (password.length < 6) {
            binding.password.error = "Password must be ≥6 characters"
            return false
        }
        return true
    }

    private fun loginUser(email: String, password: String) {
        binding.loginButton.isEnabled = false
        binding.loginButton.text = "Logging in..."

        Log.d("LoginActivity", "Attempting login for email: $email")

        try {
            database.reference.child("users") // if your data is under "supports/users"
                .orderByChild("email")
                .equalTo(email.lowercase().trim()) // normalize email case and trim
                .addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        Log.d("LoginActivity", "Received data snapshot: ${snapshot.value}")

                        if (snapshot.exists()) {
                            for (userSnapshot in snapshot.children) {
                                Log.d("LoginActivity", "Found user: ${userSnapshot.key}")
                                val user = userSnapshot.getValue(User::class.java)
                                if (user != null) {
                                    Log.d("LoginActivity", "User data: $user")
                                    if (user.password == password) {
                                        Log.d("LoginActivity", "Login successful for ${user.email}")
                                        redirectToDashboard(user)
                                        return
                                    } else {
                                        Log.d("LoginActivity", "Password mismatch for ${user.email}")
                                    }
                                }
                            }
                        }
                        Log.d("LoginActivity", "No matching user found or password incorrect")
                        Toast.makeText(
                            this@LoginActivity,
                            "Invalid email or password",
                            Toast.LENGTH_SHORT
                        ).show()
                        resetLoginButton()
                    }

                    override fun onCancelled(error: DatabaseError) {
                        Log.e("LoginActivity", "Database error: ${error.message}", error.toException())
                        Toast.makeText(
                            this@LoginActivity,
                            "Database error: ${error.message}",
                            Toast.LENGTH_SHORT
                        ).show()
                        resetLoginButton()
                    }
                })
        } catch (e: Exception) {
            Log.e("LoginActivity", "Network error during login", e)
            Toast.makeText(
                this@LoginActivity,
                "Network error: ${e.message}",
                Toast.LENGTH_SHORT
            ).show()
            resetLoginButton()
        }
    }

    private fun redirectToDashboard(user: User) {
        val intent = when (user.role.lowercase()) {
            "admin" -> Intent(this, AdminDashboardActivity::class.java)
            "teacher" -> Intent(this, TeacherDashboardActivity::class.java)
            "student" -> Intent(this, StudentDashboardActivity::class.java)
            "parent" -> Intent(this, ParentHomeActivity::class.java)
            else -> {
                Toast.makeText(this, "Unknown role: ${user.role}", Toast.LENGTH_SHORT).show()
                resetLoginButton()
                return
            }
        }

        // Pass only essential data as strings
        intent.putExtra("USER_ID", user.userId)
        intent.putExtra("USER_EMAIL", user.email)
        intent.putExtra("USER_ROLE", user.role)
        intent.putExtra("USER_NAME", user.fullName)

        startActivity(intent)
        finish()
    }

    private fun resetLoginButton() {
        binding.loginButton.isEnabled = true
        binding.loginButton.text = "Login"
    }
}