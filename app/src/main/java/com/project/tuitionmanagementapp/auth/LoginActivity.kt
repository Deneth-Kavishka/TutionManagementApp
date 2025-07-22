package com.project.tuitionmanagementapp.auth


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*
import com.project.tuitionmanagementapp.databinding.FragmentLoginBinding

data class use (
    val fullName: String = "",
    val email: String = "",
    val password: String = "",
    val phoneNumber: String = "",
    val address: String = "",
    val nic: String = "",
    val dob: String = "",
    val role: String = "",
    val userId: String = ""
)

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = FirebaseDatabase.getInstance().getReference("users")


        binding.loginButton.setOnClickListener {
            val email = binding.email.text.toString().trim()
            val password = binding.password.text.toString().trim()


            if (email.isEmpty()) {
                binding.email.error = "Email is required"
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                binding.password.error = "Password is required"
                return@setOnClickListener
            }

            loginUser(email, password)
        }

        binding.goToRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        binding.forgotPassword.setOnClickListener {
            Toast.makeText(this, "Forgot Password feature coming soon!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun loginUser(email: String, password: String) {
        database.orderByChild("email").equalTo(email)
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (!snapshot.exists()) {
                        Toast.makeText(this@LoginActivity, "Account not found", Toast.LENGTH_SHORT).show()
                        return
                    }

                    for (userSnapshot in snapshot.children) {
                        val user = userSnapshot.getValue(User::class.java)
                        if (user != null && user.password == password) {
                            Toast.makeText(
                                this@LoginActivity,
                                "Welcome ${user.fullName} (${user.role})",
                                Toast.LENGTH_LONG
                            ).show()

                            // TODO: Navigate to dashboard based on user.role
                            return
                        }
                    }

                    Toast.makeText(this@LoginActivity, "Incorrect password", Toast.LENGTH_SHORT).show()
                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(this@LoginActivity, "Database error: ${error.message}", Toast.LENGTH_SHORT).show()
                }
            })
    }

class LoginActivity {


}
