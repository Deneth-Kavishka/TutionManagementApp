package com.project.tuitionmanagementapp.teacher

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.firestore.FirebaseFirestore
import com.project.tuitionmanagementapp.R

class UploadResultActivity : AppCompatActivity() {

    private lateinit var firestore: FirebaseFirestore
    private lateinit var recyclerView: RecyclerView
    private lateinit var fabUpload: FloatingActionButton
    private lateinit var progressBar: ProgressBar
    private lateinit var adapter: ResultAdapter
    private var resultsList = ArrayList<ResultModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_result)

        initializeViews()
        setupRecyclerView()
        loadResults()

        fabUpload.setOnClickListener {
            showUploadDialog()
        }

        // Back button
        findViewById<ImageView>(R.id.backButton).setOnClickListener {
            finish()
        }
    }

    private fun initializeViews() {
        firestore = FirebaseFirestore.getInstance()
        recyclerView = findViewById(R.id.rvResults)
        fabUpload = findViewById(R.id.fabUploadResult)
        progressBar = findViewById(R.id.progressBar)
    }

    private fun setupRecyclerView() {
        adapter = ResultAdapter(resultsList) { result ->
            showEditDialog(result)
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun loadResults() {
        progressBar.visibility = View.VISIBLE
        firestore.collection("results")
            .get()
            .addOnSuccessListener { documents ->
                resultsList.clear()
                for (document in documents) {
                    val result = document.toObject(ResultModel::class.java)
                    resultsList.add(result)
                }
                resultsList.sortByDescending { it.examDate }
                adapter.notifyDataSetChanged()
                progressBar.visibility = View.GONE
            }
            .addOnFailureListener {
                Toast.makeText(this, "Failed to load results", Toast.LENGTH_SHORT).show()
                progressBar.visibility = View.GONE
            }
    }

    private fun showUploadDialog(existingResult: ResultModel? = null) {
        val dialog = android.app.AlertDialog.Builder(this)
            .setView(R.layout.dialog_upload_result)
            .create()

        dialog.show()

        // Initialize dialog views
        val spinnerStudent = dialog.findViewById<AutoCompleteTextView>(R.id.spinnerStudent)
        val spinnerSubject = dialog.findViewById<AutoCompleteTextView>(R.id.spinnerSubject)
        val edtMarks = dialog.findViewById<TextInputEditText>(R.id.edtMarks)
        val tvGrade = dialog.findViewById<TextView>(R.id.tvCalculatedGrade)
        val edtComment = dialog.findViewById<TextInputEditText>(R.id.edtComment)
        val btnSubmit = dialog.findViewById<Button>(R.id.btnSubmit)
        val btnCancel = dialog.findViewById<Button>(R.id.btnCancel)

        // Load students for spinner
        loadStudentsForSpinner(spinnerStudent)

        // Load subjects for spinner
        loadSubjectsForSpinner(spinnerSubject)

        // Calculate grade on marks change
        edtMarks?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                val marks = s.toString().toIntOrNull() ?: 0
                val result = ResultModel(marks = marks)
                tvGrade?.text = "Grade: ${result.calculateGrade()}"
            }
        })

        // Set existing data if editing
        existingResult?.let {
            spinnerStudent?.setText(it.studentName)
            spinnerSubject?.setText(it.subject)
            edtMarks?.setText(it.marks.toString())
            edtComment?.setText(it.comment)
        }

        // Handle submit
        btnSubmit?.setOnClickListener {
            val studentName = spinnerStudent?.text.toString()
            val subject = spinnerSubject?.text.toString()
            val marks = edtMarks?.text.toString().toIntOrNull() ?: 0
            val comment = edtComment?.text.toString()

            if (validateInputs(studentName, subject, marks)) {
                val result = ResultModel(
                    id = existingResult?.id,
                    studentName = studentName,
                    subject = subject,
                    marks = marks,
                    grade = ResultModel(marks = marks).calculateGrade(),
                    comment = comment
                )
                saveResult(result, dialog)
            }
        }

        btnCancel?.setOnClickListener {
            dialog.dismiss()
        }
    }

    private fun loadStudentsForSpinner(spinner: AutoCompleteTextView?) {
        firestore.collection("students")
            .get()
            .addOnSuccessListener { documents ->
                val students = documents.mapNotNull { it.getString("name") }
                val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, students)
                spinner?.setAdapter(adapter)
            }
    }

    private fun loadSubjectsForSpinner(spinner: AutoCompleteTextView?) {
        val subjects = listOf("Mathematics", "Science", "English", "Physics", "Chemistry", "Biology")
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, subjects)
        spinner?.setAdapter(adapter)
    }

    private fun validateInputs(studentName: String, subject: String, marks: Int): Boolean {
        if (studentName.isBlank()) {
            Toast.makeText(this, "Please select a student", Toast.LENGTH_SHORT).show()
            return false
        }
        if (subject.isBlank()) {
            Toast.makeText(this, "Please select a subject", Toast.LENGTH_SHORT).show()
            return false
        }
        if (marks <= 0 || marks > 100) {
            Toast.makeText(this, "Please enter valid marks (1-100)", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    private fun saveResult(result: ResultModel, dialog: android.app.AlertDialog) {
        progressBar.visibility = View.VISIBLE

        val resultMap = hashMapOf(
            "studentName" to result.studentName,
            "subject" to result.subject,
            "marks" to result.marks,
            "grade" to result.grade,
            "comment" to result.comment,
            "examDate" to System.currentTimeMillis()
        )

        val collection = firestore.collection("results")
        val task = if (result.id != null) {
            collection.document(result.id).set(resultMap)
        } else {
            collection.add(resultMap)
        }

        task.addOnSuccessListener {
            Toast.makeText(this, "Result saved successfully", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
            loadResults()
        }.addOnFailureListener {
            Toast.makeText(this, "Failed to save result", Toast.LENGTH_SHORT).show()
        }.addOnCompleteListener {
            progressBar.visibility = View.GONE
        }
    }

    private fun showEditDialog(result: ResultModel) {
        showUploadDialog(result)
    }
}
