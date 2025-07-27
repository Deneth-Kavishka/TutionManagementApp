package com.example.tutionmanagementapp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tutionmanagementapp.databinding.ActivityRegistrationBinding
import com.google.android.material.button.MaterialButtonToggleGroup
import com.example.tutionmanagementapp.R

class RegistrationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toggleUserType.addOnButtonCheckedListener { _, checkedId, isChecked ->
            if (isChecked) {
                when (checkedId) {
                    R.id.btnStudent -> {
                        binding.tilGrade.visibility = View.VISIBLE
                        binding.tilSubject.visibility = View.GONE
                    }
                    R.id.btnTeacher -> {
                        binding.tilGrade.visibility = View.GONE
                        binding.tilSubject.visibility = View.VISIBLE
                    }
                    R.id.btnAdmin -> {
                        binding.tilGrade.visibility = View.GONE
                        binding.tilSubject.visibility = View.GONE
                    }
                }
            }
        }

        binding.btnUploadPhoto.setOnClickListener {
            Toast.makeText(this@RegistrationActivity, "Photo upload not implemented", Toast.LENGTH_SHORT).show()
        }

        binding.btnRegister.setOnClickListener {
            // Clear previous errors
            binding.tilFullName.error = null
            binding.tilEmail.error = null
            binding.tilPassword.error = null
            binding.tilConfirmPassword.error = null

            if (!binding.cbTerms.isChecked) {
                Toast.makeText(this@RegistrationActivity, "Please agree to terms", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val name = binding.etFullName.text?.toString() ?: ""
            val email = binding.etEmail.text?.toString() ?: ""
            val password = binding.etPassword.text?.toString() ?: ""
            val confirmPassword = binding.etConfirmPassword.text?.toString() ?: ""
            var hasError = false
            if (name.isBlank()) {
                binding.tilFullName.error = "Required"
                hasError = true
            }
            if (email.isBlank()) {
                binding.tilEmail.error = "Required"
                hasError = true
            }
            if (password.isBlank()) {
                binding.tilPassword.error = "Required"
                hasError = true
            }
            if (confirmPassword.isBlank()) {
                binding.tilConfirmPassword.error = "Required"
                hasError = true
            }
            if (hasError) {
                Toast.makeText(this@RegistrationActivity, "Please fill all required fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (password != confirmPassword) {
                binding.tilConfirmPassword.error = "Passwords do not match"
                return@setOnClickListener
            } else {
                binding.tilConfirmPassword.error = null
            }
            binding.progressBar.visibility = View.VISIBLE
            binding.progressBar.postDelayed({
                binding.progressBar.visibility = View.GONE
                Toast.makeText(this@RegistrationActivity, "Registered!", Toast.LENGTH_SHORT).show()
            }, 1500)
        }

        binding.tvLogin.setOnClickListener {
            Toast.makeText(this@RegistrationActivity, "Go to Login", Toast.LENGTH_SHORT).show()
        }
    }
}
