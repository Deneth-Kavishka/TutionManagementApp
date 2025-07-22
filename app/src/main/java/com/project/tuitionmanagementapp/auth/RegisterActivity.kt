package com.project.tuitionmanagementapp.auth

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
import com.project.tuitionmanagementapp.R
import com.project.tuitionmanagementapp.databinding.ActivityRegisterBinding
import java.util.*

data class User(
    val fullName: String,
    val email: String,
    val password: String,
    val phoneNumber: String,
    val address: String,
    val nic: String,
    val dob: String,
    val role: String,
    val userId: String // New field to store generated ID
)

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var roleSpinner: Spinner
    private lateinit var datePicker: DatePicker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Spinner and DatePicker
        roleSpinner = binding.roleSpinner
        datePicker = findViewById(R.id.dob) // Use findViewById for DatePicker
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

        if (selectedRole == "Select Role") {
            Toast.makeText(this, "Please select a valid role", Toast.LENGTH_SHORT).show()
            return
        }

        val fullName = binding.fullName.text.toString().trim()
        val email = binding.email.text.toString().trim()
        val password = binding.password.text.toString().trim()
        val phoneNumber = binding.phoneNumber.text.toString().trim()
        val address = binding.address.text.toString().trim()
        val nic = binding.nic.text.toString().trim()
        val dob = getSelectedDate()

        // Generate Role-based ID (e.g., STU202507209876)
        val datePart = android.text.format.DateFormat.format("yyyyMMdd", Date())
        val randomDigits = (1000..9999).random()
        val userIdPrefix = when (selectedRole) {
            "Student" -> "STU"
            "Teacher" -> "TEA"
            else -> "USR"
        }
        val generatedUserId = "$userIdPrefix$datePart$randomDigits"

        val user = User(
            fullName = fullName,
            email = email,
            password = password,
            phoneNumber = phoneNumber,
            address = address,
            nic = nic,
            dob = dob,
            role = selectedRole,
            userId = generatedUserId
        )

        val database = FirebaseDatabase.getInstance()
        val userRef = database.getReference("users")

        userRef.child(generatedUserId).setValue(user)
            .addOnSuccessListener {
                AlertDialog.Builder(this)
                    .setTitle("Registration Successful")
                    .setMessage("Your $selectedRole ID is:\n\n$generatedUserId")
                    .setPositiveButton("OK") { _, _ -> finish() }
                    .show()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Registration failed: ${it.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun getSelectedDate(): String {
        val day = datePicker.dayOfMonth
        val month = datePicker.month + 1 // Month is 0-based
        val year = datePicker.year
        return String.format("%02d/%02d/%04d", day, month, year)
    }

    private fun validateInput(): Boolean {
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
            binding.nic.error = "Invalid NIC format (9–12 digits)"
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
