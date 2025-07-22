package com.project.tuitionmanagementapp.teacher

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.project.tuitionmanagementapp.R
import java.text.SimpleDateFormat
import java.util.*

class MaterialsActivity : AppCompatActivity() {

    private lateinit var btnChoosePdf: ImageView
    private lateinit var btnUpload: Button
    private lateinit var btnPreview: Button
    private lateinit var etSubject: EditText
    private lateinit var etTopic: EditText
    private lateinit var spinnerGrade: Spinner
    private lateinit var tvFileName: TextView

    private var pdfUri: Uri? = null

    companion object {
        private const val PICK_PDF_REQUEST = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_materials_teacher)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Upload Material"


        // Init views
        btnChoosePdf = findViewById(R.id.btnChoosePdf)
        btnUpload = findViewById(R.id.btnUpload)
        btnPreview = findViewById(R.id.btnPreview)
        etSubject = findViewById(R.id.etSubject)
        etTopic = findViewById(R.id.etTopic)
        spinnerGrade = findViewById(R.id.spinnerGrade)
        tvFileName = findViewById(R.id.tvFileName)

        // Set grade options
        val grades = listOf("Select Grade", "Grade 6", "Grade 7", "Grade 8", "Grade 9", "Grade 10")
        val gradeAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, grades)
        spinnerGrade.adapter = gradeAdapter

        // Choose file
        btnChoosePdf.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "application/pdf"
            startActivityForResult(intent, PICK_PDF_REQUEST)
        }

        // Upload
        btnUpload.setOnClickListener {
            uploadMaterial()
        }

        // Preview (back)
        btnPreview.setOnClickListener {
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_PDF_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            pdfUri = data.data
            val fileName = pdfUri?.lastPathSegment?.split("/")?.last() ?: "PDF Selected"
            tvFileName.text = fileName
        }
    }

    private fun uploadMaterial() {
        val subject = etSubject.text.toString().trim()
        val topic = etTopic.text.toString().trim()
        val grade = spinnerGrade.selectedItem.toString()

        if (subject.isEmpty() || topic.isEmpty() || pdfUri == null || grade == "Select Grade") {
            Toast.makeText(this, "Please fill all fields and select grade", Toast.LENGTH_SHORT).show()
            return
        }

        val timestamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        val fileName = "${subject}_${timestamp}.pdf"

        val storageRef = FirebaseStorage.getInstance().reference.child("materials/$fileName")
        Toast.makeText(this, "Uploading...", Toast.LENGTH_SHORT).show()

        pdfUri?.let { uri ->
            storageRef.putFile(uri)
                .addOnSuccessListener {
                    storageRef.downloadUrl.addOnSuccessListener { downloadUrl ->
                        saveToDatabase(subject, topic, grade, downloadUrl.toString())
                    }
                }
                .addOnFailureListener {
                    Toast.makeText(this, "Upload failed: ${it.message}", Toast.LENGTH_SHORT).show()
                }
        }
    }

    private fun saveToDatabase(subject: String, topic: String, grade: String, fileUrl: String) {
        val databaseRef = FirebaseDatabase.getInstance().getReference("materials")
        val uploadId = databaseRef.push().key

        val material = mapOf(
            "subject" to subject,
            "topic" to topic,
            "grade" to grade,
            "fileUrl" to fileUrl
        )

        uploadId?.let {
            databaseRef.child(it).setValue(material)
                .addOnSuccessListener {
                    Toast.makeText(this, "Material uploaded successfully", Toast.LENGTH_SHORT).show()
                    clearForm()
                }
                .addOnFailureListener {
                    Toast.makeText(this, "Database error: ${it.message}", Toast.LENGTH_SHORT).show()
                }
        }
    }

    private fun clearForm() {
        etSubject.setText("")
        etTopic.setText("")
        spinnerGrade.setSelection(0)
        tvFileName.text = "No file selected"
        pdfUri = null
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

}
