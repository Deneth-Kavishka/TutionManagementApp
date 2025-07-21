package com.project.tuitionmanagementapp.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.project.tuitionmanagementapp.databinding.FragmentLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var auth: FirebaseAuth
    private val database = Firebase.database.reference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        // Auto-login if user exists
        auth.currentUser?.let { user ->
            checkUserRole(user.uid)
        }

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (validateInput(email, password)) {
                loginUser(email, password)
            }
        }

        binding.tvRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    private fun validateInput(email: String, password: String): Boolean {
        binding.etEmail.error = null
        binding.etPassword.error = null

        var isValid = true

        if (email.isEmpty()) {
            binding.etEmail.error = "Email is required"
            isValid = false
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.etEmail.error = "Invalid email format"
            isValid = false
        }

        if (password.isEmpty()) {
            binding.etPassword.error = "Password is required"
            isValid = false
        } else if (password.length < 6) {
            binding.etPassword.error = "Password must be at least 6 characters"
            isValid = false
        }

        return isValid
    }

    private fun loginUser(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val userId = auth.currentUser?.uid ?: run {
                        showToast("Authentication error")
                        return@addOnCompleteListener
                    }
                    // Find the user in Realtime Database by email
                    findUserInDatabase(email, userId)
                } else {
                    handleLoginError(task.exception)
                }
            }
    }

    private fun findUserInDatabase(email: String, authUid: String) {
        database.child("users").orderByChild("email").equalTo(email)
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (!snapshot.exists()) {
                        auth.signOut()
                        showToast("User data not found in database")
                        return
                    }

                    // Get the first matching user (email should be unique)
                    val userEntry = snapshot.children.firstOrNull() ?: run {
                        auth.signOut()
                        showToast("User data not found")
                        return
                    }

                    // Verify the user's role and proceed
                    val role = userEntry.child("role").getValue(String::class.java) ?: run {
                        auth.signOut()
                        showToast("Role not specified")
                        return
                    }

                    when (role) {
                        "Student" -> {
                            showToast("Student login successful")
                            // Navigate to Student Dashboard
                        }
                        "Teacher" -> {
                            showToast("Teacher login successful")
                            // Navigate to Teacher Dashboard
                        }
                        "Admin" -> {
                            showToast("Admin login successful")
                            // Navigate to Admin Dashboard
                        }
                        else -> {
                            auth.signOut()
                            showToast("Invalid user role")
                        }
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    showToast("Database error: ${error.message}")
                }
            })
    }

    private fun checkUserRole(authUid: String) {
        // Since your database uses different IDs, we need to search by email
        // First get the current user's email
        val user = auth.currentUser
        user?.email?.let { email ->
            findUserInDatabase(email, authUid)
        } ?: run {
            auth.signOut()
            showToast("User email not found")
        }
    }

    private fun handleLoginError(exception: Exception?) {
        val errorMessage = when (exception) {
            is FirebaseAuthInvalidUserException -> "Account not found"
            is FirebaseAuthInvalidCredentialsException -> "Invalid credentials"
            else -> "Login failed: ${exception?.message}"
        }
        showToast(errorMessage)
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}