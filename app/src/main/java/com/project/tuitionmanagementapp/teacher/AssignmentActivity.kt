package com.project.tuitionmanagementapp.teacher

import android.app.*
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.project.tuitionmanagementapp.R
import java.util.*

class AssignmentActivity : AppCompatActivity() {

    private lateinit var etTitle: EditText
    private lateinit var spinnerGrade: Spinner
    private lateinit var etSubmissionDate: EditText
    private lateinit var etSubmissionTime: EditText
    private lateinit var btnChooseFile: Button
    private lateinit var tvFileName: TextView
    private lateinit var btnUpload: Button

    private var selectedFileUri: Uri? = null
    private val PICK_PDF_REQUEST = 1001
    private var selectedDate = ""
    private var selectedTime = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assignment)

        // Toolbar setup
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Upload Assignment"

        // View bindings
        etTitle = findViewById(R.id.etAssignmentTitle)
        spinnerGrade = findViewById(R.id.spinnerGrade)
        etSubmissionDate = findViewById(R.id.etSubmissionDate)
        etSubmissionTime = findViewById(R.id.etSubmissionTime)
        btnChooseFile = findViewById(R.id.btnChooseFile)
        tvFileName = findViewById(R.id.tvFileName)
        btnUpload = findViewById(R.id.btnUploadAssignment)

        // Spinner data
        val grades = listOf("Select Grade", "Grade 6", "Grade 7", "Grade 8", "Grade 9", "Grade 10")
        spinnerGrade.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, grades)

        // Date picker
        etSubmissionDate.setOnClickListener {
            val calendar = Calendar.getInstance()
            DatePickerDialog(this, { _, y, m, d ->
                selectedDate = String.format("%02d-%02d-%04d", d, m + 1, y)
                etSubmissionDate.setText(selectedDate)
            }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show()
        }

        // Time picker
        etSubmissionTime.setOnClickListener {
            val calendar = Calendar.getInstance()
            TimePickerDialog(this, { _, h, min ->
                selectedTime = String.format("%02d:%02d", h, min)
                etSubmissionTime.setText(selectedTime)
            }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true).show()
        }

        // Choose PDF
        btnChooseFile.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "application/pdf"
            startActivityForResult(Intent.createChooser(intent, "Select PDF"), PICK_PDF_REQUEST)
        }

        // Upload
        btnUpload.setOnClickListener {
            uploadAssignment()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_PDF_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            selectedFileUri = data.data
            tvFileName.text = selectedFileUri?.lastPathSegment ?: "File selected"
        }
    }

    private fun uploadAssignment() {
        val title = etTitle.text.toString().trim()
        val grade = spinnerGrade.selectedItem.toString()

        if (title.isEmpty() || selectedDate.isEmpty() || selectedTime.isEmpty() || grade == "Select Grade" || selectedFileUri == null) {
            Toast.makeText(this, "Please complete all fields and select a file", Toast.LENGTH_SHORT).show()
            return
        }

        // Show loading
        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Uploading assignment...")
        progressDialog.setCancelable(false)
        progressDialog.show()

        // Create unique filename
        val timestamp = System.currentTimeMillis()
        val filename = "assignment_${timestamp}.pdf"

        // Firebase storage reference
        val storageRef = FirebaseStorage.getInstance().reference
            .child("assignments")
            .child(filename)

        // Upload file
        storageRef.putFile(selectedFileUri!!)
            .addOnSuccessListener {
                // Get download URL
                storageRef.downloadUrl.addOnSuccessListener { uri ->
                    // Create assignment object
                    val assignmentMap = HashMap<String, Any>()
                    assignmentMap["title"] = title
                    assignmentMap["grade"] = grade
                    assignmentMap["submissionDate"] = selectedDate
                    assignmentMap["submissionTime"] = selectedTime
                    assignmentMap["fileUrl"] = uri.toString()
                    assignmentMap["timestamp"] = timestamp

                    // Save to database
                    FirebaseDatabase.getInstance().reference
                        .child("assignments")
                        .push()
                        .setValue(assignmentMap)
                        .addOnCompleteListener { task ->
                            progressDialog.dismiss()
                            if (task.isSuccessful) {
                                Toast.makeText(this, "Assignment uploaded successfully", Toast.LENGTH_SHORT).show()
                                finish()
                            } else {
                                Toast.makeText(this, "Failed to upload assignment: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                            }
                        }
                }
            }
            .addOnFailureListener { e ->
                progressDialog.dismiss()
                Toast.makeText(this, "Upload failed: ${e.message}", Toast.LENGTH_SHORT).show()
            }
            .addOnProgressListener { taskSnapshot ->
                val progress = (100.0 * taskSnapshot.bytesTransferred / taskSnapshot.totalByteCount)
                progressDialog.setMessage("Uploading: ${progress.toInt()}%")
            }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
