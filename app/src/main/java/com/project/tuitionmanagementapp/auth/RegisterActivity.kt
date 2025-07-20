package com.project.tuitionmanagementapp.auth

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
import com.project.tuitionmanagementapp.R
import com.project.tuitionmanagementapp.databinding.ActivityRegisterBinding

data class User(
    val fullName: String,
    val email: String,
    val password: String,
    val phoneNumber: String,
    val address: String,
    val nic: String,
    val role: String
)

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var roleSpinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Spinner
        roleSpinner = binding.roleSpinner
        setupRoleSpinner()

        binding.registerButton.setOnClickListener {
            if (validateInput()) {
                registerUser()
            }
        }

        binding.termsCheckbox.setOnCheckedChangeListener { _, isChecked ->
            binding.registerButton.isEnabled = isChecked
        }
        binding.registerButton.isEnabled = false
    }

    private fun setupRoleSpinner() {
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.roles_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        roleSpinner.adapter = adapter
    }

    private fun registerUser() {
        val selectedRole = roleSpinner.selectedItem.toString()

        // Validate that a role is selected (not the first hint item)
        if (selectedRole == "Select Role") {
            Toast.makeText(this, "Please select a valid role", Toast.LENGTH_SHORT).show()
            return
        }

        val user = User(
            fullName = binding.fullName.text.toString().trim(),
            email = binding.email.text.toString().trim(),
            password = binding.password.text.toString().trim(),
            phoneNumber = binding.phoneNumber.text.toString().trim(),
            address = binding.address.text.toString().trim(),
            nic = binding.nic.text.toString().trim(),
            role = selectedRole
        )

        val database = FirebaseDatabase.getInstance()
        val userRef = database.getReference("users")
        val userId = userRef.push().key ?: user.nic

        userRef.child(userId).setValue(user)
            .addOnSuccessListener {
                Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()
                finish()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Registration failed: ${it.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun validateInput(): Boolean {
        // Clear previous errors
        binding.fullName.error = null
        binding.email.error = null
        binding.password.error = null
        binding.confirmPassword.error = null
        binding.phoneNumber.error = null
        binding.address.error = null
        binding.nic.error = null

        val name = binding.fullName.text.toString().trim()
        val email = binding.email.text.toString().trim()
        val password = binding.password.text.toString().trim()
        val confirmPassword = binding.confirmPassword.text.toString().trim()
        val phoneNumber = binding.phoneNumber.text.toString().trim()
        val address = binding.address.text.toString().trim()
        val nic = binding.nic.text.toString().trim()
        val role = roleSpinner.selectedItem.toString()

        var valid = true

        if (name.isEmpty()) {
            binding.fullName.error = "Name is required"
            valid = false
        }
        if (email.isEmpty()) {
            binding.email.error = "Email is required"
            valid = false
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.email.error = "Invalid email format"
            valid = false
        }
        if (password.isEmpty()) {
            binding.password.error = "Password is required"
            valid = false
        } else if (password.length < 6) {
            binding.password.error = "Password must be at least 6 characters"
            valid = false
        }
        if (confirmPassword.isEmpty()) {
            binding.confirmPassword.error = "Confirm Password is required"
            valid = false
        } else if (confirmPassword != password) {
            binding.confirmPassword.error = "Passwords do not match"
            valid = false
        }
        if (phoneNumber.isEmpty()) {
            binding.phoneNumber.error = "Phone number is required"
            valid = false
        } else if (!android.util.Patterns.PHONE.matcher(phoneNumber).matches()) {
            binding.phoneNumber.error = "Invalid phone number format"
            valid = false
        }
        if (address.isEmpty()) {
            binding.address.error = "Address is required"
            valid = false
        }
        if (nic.isEmpty()) {
            binding.nic.error = "NIC is required"
            valid = false
        } else if (!nic.matches("^[0-9]{9,12}$".toRegex())) {
            binding.nic.error = "Invalid NIC format (9-12 digits)"
            valid = false
        }
        if (role == "Select Role") {
            Toast.makeText(this, "Please select a role", Toast.LENGTH_SHORT).show()
            valid = false
        }
        if (!binding.termsCheckbox.isChecked) {
            Toast.makeText(this, "Please accept the Terms and Conditions", Toast.LENGTH_SHORT).show()
            valid = false
        }

        return valid
    }
}