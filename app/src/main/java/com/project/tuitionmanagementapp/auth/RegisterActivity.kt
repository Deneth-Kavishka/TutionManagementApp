package com.project.tuitionmanagementapp.auth

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
import com.project.tuitionmanagementapp.R
import com.project.tuitionmanagementapp.databinding.ActivityRegisterBinding
import com.project.tuitionmanagementapp.models.User
import java.util.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var roleSpinner: Spinner
    private var selectedDate: Calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        roleSpinner = binding.roleSpinner
        setupRoleSpinner()
        setupDatePicker()

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
        // Create roles array programmatically since we don't have access to resources
        val roles = arrayOf("Select Role", "Student", "Teacher", "Parent", "Admin")

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            roles
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        roleSpinner.adapter = adapter
    }

    private fun setupDatePicker() {
        binding.dateOfBirth.setOnClickListener {
            val datePickerDialog = DatePickerDialog(
                this,
                { _, year, month, day ->
                    selectedDate.set(Calendar.YEAR, year)
                    selectedDate.set(Calendar.MONTH, month)
                    selectedDate.set(Calendar.DAY_OF_MONTH, day)
                    binding.dateOfBirth.setText(getFormattedDate())
                },
                selectedDate.get(Calendar.YEAR),
                selectedDate.get(Calendar.MONTH),
                selectedDate.get(Calendar.DAY_OF_MONTH)
            )
            datePickerDialog.show()
        }
    }

    private fun getFormattedDate(): String {
        return String.format(
            Locale.getDefault(),
            "%02d/%02d/%04d",
            selectedDate.get(Calendar.DAY_OF_MONTH),
            selectedDate.get(Calendar.MONTH) + 1,
            selectedDate.get(Calendar.YEAR)
        )
    }

    private fun registerUser() {
        val selectedRole = roleSpinner.selectedItem.toString()

        if (selectedRole == "Select Role") {
            Toast.makeText(this, getString(R.string.select_role_prompt), Toast.LENGTH_SHORT).show()
            return
        }

        // Fixed: Moved variable declarations outside the if statement
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
            "Parent" -> "PAR"
            "Admin" -> "ADM"
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

        // Disable button during registration
        binding.registerButton.isEnabled = false
        binding.registerButton.setText(R.string.registering)

        userRef.child(generatedUserId).setValue(user)
            .addOnSuccessListener {
                binding.registerButton.isEnabled = true
                binding.registerButton.setText(R.string.register)

                AlertDialog.Builder(this)
                    .setTitle(R.string.registration_successful)
                    .setMessage(getString(R.string.registration_id_message, selectedRole, generatedUserId))
                    .setPositiveButton(android.R.string.ok) { _, _ -> finish() }
                    .setCancelable(false)
                    .show()
            }
            .addOnFailureListener { exception ->
                binding.registerButton.isEnabled = true
                binding.registerButton.setText(R.string.register)
                Toast.makeText(this, getString(R.string.registration_failed, exception.message), Toast.LENGTH_LONG).show()
            }
    }

    private fun getSelectedDate(): String {
        return getFormattedDate()
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

        // Validate full name
        if (name.isEmpty()) {
            binding.fullName.error = getString(R.string.name_required)
            binding.fullName.requestFocus()
            return false
        } else if (name.length < 2) {
            binding.fullName.error = getString(R.string.name_length_error)
            binding.fullName.requestFocus()
            return false
        }

        // Validate email
        if (email.isEmpty()) {
            binding.email.error = getString(R.string.email_required)
            binding.email.requestFocus()
            valid = false
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.email.error = getString(R.string.invalid_email)
            binding.email.requestFocus()
            valid = false
        }

        // Validate password
        if (password.isEmpty()) {
            binding.password.error = getString(R.string.password_required)
            binding.password.requestFocus()
            valid = false
        } else if (password.length < 6) {
            binding.password.error = getString(R.string.password_length_error)
            binding.password.requestFocus()
            valid = false
        }

        // Validate confirm password
        if (confirmPassword.isEmpty()) {
            binding.confirmPassword.error = getString(R.string.confirm_password_required)
            binding.confirmPassword.requestFocus()
            valid = false
        } else if (confirmPassword != password) {
            binding.confirmPassword.error = getString(R.string.passwords_not_match)
            binding.confirmPassword.requestFocus()
            valid = false
        }

        // Validate phone number
        if (phoneNumber.isEmpty()) {
            binding.phoneNumber.error = getString(R.string.phone_required)
            binding.phoneNumber.requestFocus()
            valid = false
        } else if (phoneNumber.length < 10) {
            binding.phoneNumber.error = getString(R.string.phone_length_error)
            binding.phoneNumber.requestFocus()
            valid = false
        }

        // Validate address
        if (address.isEmpty()) {
            binding.address.error = getString(R.string.address_required)
            binding.address.requestFocus()
            valid = false
        }

        // Validate NIC
        if (nic.isEmpty()) {
            binding.nic.error = getString(R.string.nic_required)
            binding.nic.requestFocus()
            valid = false
        } else if (!nic.matches("^[0-9]{9,12}[vVxX]?$".toRegex())) {
            binding.nic.error = getString(R.string.nic_format_error)
            binding.nic.requestFocus()
            valid = false
        }

        // Validate role selection
        if (role == "Select Role") {
            Toast.makeText(this, getString(R.string.select_role_prompt), Toast.LENGTH_SHORT).show()
            valid = false
        }

        // Validate terms and conditions
        if (!binding.termsCheckbox.isChecked) {
            Toast.makeText(this, getString(R.string.accept_terms), Toast.LENGTH_SHORT).show()
            valid = false
        }

        return valid
    }
}