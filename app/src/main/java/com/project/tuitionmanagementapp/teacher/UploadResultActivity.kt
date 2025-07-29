package com.project.tuitionmanagementapp.teacher

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.project.tuitionmanagementapp.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.app.Dialog
import android.view.Window
import android.widget.ArrayAdapter
import com.google.android.material.textfield.TextInputEditText

class UploadResultActivity : AppCompatActivity() {

    private lateinit var firestore: FirebaseFirestore
    private lateinit var auth: FirebaseAuth
    private lateinit var recyclerView: RecyclerView
    private lateinit var fabUpload: FloatingActionButton
    private lateinit var progressBar: ProgressBar
    private lateinit var bottomNavigation: BottomNavigationView
    private lateinit var adapter: ResultAdapter
    private var resultsList = ArrayList<ResultModel>()

    // Data for selections
    private var teacherSubjects = mutableListOf<String>()
    private var teacherClasses = mutableListOf<String>()
    private var classStudents = mutableListOf<StudentInfo>()

    data class StudentInfo(
        val id: String,
        val name: String,
        val rollNumber: String
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_result)

        initializeViews()
        setupBottomNavigation()
        setupRecyclerView()
        loadResults()
        loadTeacherData()

        fabUpload.setOnClickListener {
            showResultUploadDialog()
        }

        // Back button
        findViewById<ImageView>(R.id.backButton).setOnClickListener {
            finish()
        }
    }

    private fun initializeViews() {
        firestore = FirebaseFirestore.getInstance()
        auth = FirebaseAuth.getInstance()
        recyclerView = findViewById(R.id.rvResults)
        fabUpload = findViewById(R.id.fabUploadResult)
        progressBar = findViewById(R.id.progressBar)
        bottomNavigation = findViewById(R.id.bottomNavigation)
    }

    private fun loadTeacherData() {
        val teacherId = auth.currentUser?.uid ?: return

        // Load teacher's subjects and classes
        firestore.collection("teachers").document(teacherId)
            .get()
            .addOnSuccessListener { document ->
                if (document.exists()) {
                    val subjects = document.get("subjects") as? List<String> ?: listOf()
                    val classes = document.get("classes") as? List<String> ?: listOf()

                    teacherSubjects.clear()
                    teacherSubjects.addAll(subjects)

                    teacherClasses.clear()
                    teacherClasses.addAll(classes)
                }
            }
            .addOnFailureListener {
                Toast.makeText(this, "Failed to load teacher data", Toast.LENGTH_SHORT).show()
            }
    }

    private fun showResultUploadDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_upload_result)
        dialog.setCancelable(true)

        // Find views in dialog
        val spinnerSubject = dialog.findViewById<Spinner>(R.id.spinnerSubject)
        val spinnerClass = dialog.findViewById<Spinner>(R.id.spinnerClass)
        val spinnerStudent = dialog.findViewById<Spinner>(R.id.spinnerStudent)
        val etMarks = dialog.findViewById<TextInputEditText>(R.id.etMarks)
        val etGrade = dialog.findViewById<TextInputEditText>(R.id.etGrade)
        val etComments = dialog.findViewById<TextInputEditText>(R.id.etComments)
        val btnUpload = dialog.findViewById<Button>(R.id.btnUploadResult)
        val btnCancel = dialog.findViewById<Button>(R.id.btnCancel)

        // Setup subject spinner
        val subjectAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, teacherSubjects)
        subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerSubject.adapter = subjectAdapter

        // Setup class spinner
        val classAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, teacherClasses)
        classAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerClass.adapter = classAdapter

        // Setup class selection listener
        spinnerClass.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedClass = teacherClasses[position]
                loadStudentsForClass(selectedClass, spinnerStudent)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        // Setup upload button
        btnUpload.setOnClickListener {
            val selectedSubject = spinnerSubject.selectedItem?.toString()
            val selectedClass = spinnerClass.selectedItem?.toString()
            val selectedStudentPosition = spinnerStudent.selectedItemPosition
            val marks = etMarks.text.toString()
            val grade = etGrade.text.toString()
            val comments = etComments.text.toString()

            if (validateResultData(selectedSubject, selectedClass, selectedStudentPosition, marks, grade)) {
                val selectedStudent = classStudents[selectedStudentPosition]
                uploadResult(selectedStudent, selectedSubject!!, selectedClass!!, marks, grade, comments, dialog)
            }
        }

        btnCancel.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun loadStudentsForClass(className: String, studentSpinner: Spinner) {
        firestore.collection("students")
            .whereEqualTo("className", className)
            .get()
            .addOnSuccessListener { documents ->
                classStudents.clear()
                val studentNames = mutableListOf<String>()

                for (document in documents) {
                    val student = StudentInfo(
                        id = document.id,
                        name = document.getString("name") ?: "",
                        rollNumber = document.getString("rollNumber") ?: ""
                    )
                    classStudents.add(student)
                    studentNames.add("${student.name} (${student.rollNumber})")
                }

                val studentAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, studentNames)
                studentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                studentSpinner.adapter = studentAdapter
            }
            .addOnFailureListener {
                Toast.makeText(this, "Failed to load students", Toast.LENGTH_SHORT).show()
            }
    }

    private fun validateResultData(subject: String?, className: String?, studentPosition: Int, marks: String, grade: String): Boolean {
        if (subject.isNullOrEmpty()) {
            Toast.makeText(this, "Please select a subject", Toast.LENGTH_SHORT).show()
            return false
        }
        if (className.isNullOrEmpty()) {
            Toast.makeText(this, "Please select a class", Toast.LENGTH_SHORT).show()
            return false
        }
        if (studentPosition < 0 || classStudents.isEmpty()) {
            Toast.makeText(this, "Please select a student", Toast.LENGTH_SHORT).show()
            return false
        }
        if (marks.isEmpty()) {
            Toast.makeText(this, "Please enter marks", Toast.LENGTH_SHORT).show()
            return false
        }
        if (grade.isEmpty()) {
            Toast.makeText(this, "Please enter grade", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    private fun uploadResult(student: StudentInfo, subject: String, className: String, marks: String, grade: String, comments: String, dialog: Dialog) {
        val teacherId = auth.currentUser?.uid ?: return

        val resultData = mapOf(
            "studentId" to student.id,
            "studentName" to student.name,
            "rollNumber" to student.rollNumber,
            "teacherId" to teacherId,
            "subject" to subject,
            "className" to className,
            "marks" to (marks.toIntOrNull() ?: 0),
            "grade" to grade,
            "comments" to comments,
            "uploadDate" to com.google.firebase.Timestamp.now(),
            "academicYear" to "2025"
        )

        progressBar.visibility = View.VISIBLE

        firestore.collection("results")
            .add(resultData)
            .addOnSuccessListener {
                progressBar.visibility = View.GONE
                Toast.makeText(this, "Result uploaded successfully for ${student.name}", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
                loadResults() // Refresh the results list
            }
            .addOnFailureListener { exception ->
                progressBar.visibility = View.GONE
                Toast.makeText(this, "Failed to upload result: ${exception.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun setupBottomNavigation() {
        bottomNavigation.selectedItemId = R.id.nav_result
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, TeacherDashboardActivity::class.java))
                    finish()
                    true
                }
                R.id.nav_assignment -> {
                    startActivity(Intent(this, AssignmentActivity::class.java))
                    finish()
                    true
                }
                R.id.nav_materials -> {
                    startActivity(Intent(this, TeacherMaterialsManagementActivity::class.java))
                    finish()
                    true
                }
                R.id.nav_result -> true // Stay on current page
                R.id.nav_qr -> {
                    startActivity(Intent(this, QRAttendanceActivity::class.java))
                    finish()
                    true
                }
                else -> false
            }
        }
    }

    private fun setupRecyclerView() {
        adapter = ResultAdapter(resultsList) { result ->
            // Handle edit result click - you can implement edit functionality here
            editResult(result)
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun editResult(result: ResultModel) {
        // Show edit dialog or navigate to edit screen
        Toast.makeText(this, "Edit result for ${result.studentName}", Toast.LENGTH_SHORT).show()
        // You can implement edit functionality here later
    }

    private fun loadResults() {
        val teacherId = auth.currentUser?.uid ?: return

        progressBar.visibility = View.VISIBLE

        firestore.collection("results")
            .whereEqualTo("teacherId", teacherId)
            .orderBy("uploadDate", com.google.firebase.firestore.Query.Direction.DESCENDING)
            .get()
            .addOnSuccessListener { documents ->
                resultsList.clear()
                for (document in documents) {
                    val result = ResultModel(
                        id = document.id,
                        studentName = document.getString("studentName") ?: "",
                        subject = document.getString("subject") ?: "",
                        className = document.getString("className") ?: "",
                        marks = document.getLong("marks")?.toInt() ?: 0,
                        grade = document.getString("grade") ?: "",
                        comments = document.getString("comments") ?: "",
                        uploadDate = document.getTimestamp("uploadDate")
                    )
                    resultsList.add(result)
                }
                adapter.notifyDataSetChanged()
                progressBar.visibility = View.GONE
            }
            .addOnFailureListener { exception ->
                progressBar.visibility = View.GONE
                Toast.makeText(this, "Failed to load results: ${exception.message}", Toast.LENGTH_SHORT).show()
            }
    }
}
