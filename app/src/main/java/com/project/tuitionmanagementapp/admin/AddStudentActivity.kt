package com.project.tuitionmanagementapp.admin

import android.app.DatePickerDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.project.tuitionmanagementapp.R
import com.project.tuitionmanagementapp.models.ClassCategory
import com.project.tuitionmanagementapp.models.Student
import java.text.SimpleDateFormat
import java.util.*

class AddStudentActivity : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()
    private val storage = FirebaseStorage.getInstance()
    private var selectedImageUri: Uri? = null
    private var selectedClassCategories = mutableListOf<String>()
    private lateinit var classCategoriesList: List<ClassCategory>

    // Student Basic Info Views
    private lateinit var etFirstName: EditText
    private lateinit var etLastName: EditText
    private lateinit var etDateOfBirth: EditText
    private lateinit var spGender: Spinner
    private lateinit var etNicNumber: EditText

    // Student Contact Views
    private lateinit var etStudentPhone: EditText
    private lateinit var etStudentEmail: EditText
    private lateinit var etAddress: EditText
    private lateinit var etCity: EditText

    // Academic Info Views
    private lateinit var etCurrentGrade: EditText
    private lateinit var etAdmissionDate: EditText
    private lateinit var lvClassCategories: ListView

    // Guardian Info Views
    private lateinit var etGuardianName: EditText
    private lateinit var etGuardianPhone: EditText
    private lateinit var etGuardianEmail: EditText
    private lateinit var etGuardianAddress: EditText

    // Account Creation Views
    private lateinit var etStudentPassword: EditText
    private lateinit var etStudentPasswordConfirm: EditText
    private lateinit var etGuardianPassword: EditText
    private lateinit var etGuardianPasswordConfirm: EditText

    // Additional Info Views
    private lateinit var etMedicalConditions: EditText
    private lateinit var etNotes: EditText
    private lateinit var ivStudentPhoto: ImageView
    private lateinit var btnSelectPhoto: Button
    private lateinit var btnSaveStudent: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)

        initializeViews()
        setupSpinners()
        loadClassCategories()
        setupClickListeners()
    }

    private fun initializeViews() {
        // Student Basic Info
        etFirstName = findViewById(R.id.etFirstName)
        etLastName = findViewById(R.id.etLastName)
        etDateOfBirth = findViewById(R.id.etDateOfBirth)
        spGender = findViewById(R.id.spGender)
        etNicNumber = findViewById(R.id.etNicNumber)

        // Student Contact
        etStudentPhone = findViewById(R.id.etStudentPhone)
        etStudentEmail = findViewById(R.id.etStudentEmail)
        etAddress = findViewById(R.id.etAddress)
        etCity = findViewById(R.id.etCity)

        // Academic Info
        etCurrentGrade = findViewById(R.id.etCurrentGrade)
        etAdmissionDate = findViewById(R.id.etAdmissionDate)
        lvClassCategories = findViewById(R.id.lvClassCategories)

        // Guardian Info
        etGuardianName = findViewById(R.id.etGuardianName)
        etGuardianPhone = findViewById(R.id.etGuardianPhone)
        etGuardianEmail = findViewById(R.id.etGuardianEmail)
        etGuardianAddress = findViewById(R.id.etGuardianAddress)

        // Account Creation
        etStudentPassword = findViewById(R.id.etStudentPassword)
        etStudentPasswordConfirm = findViewById(R.id.etStudentPasswordConfirm)
        etGuardianPassword = findViewById(R.id.etGuardianPassword)
        etGuardianPasswordConfirm = findViewById(R.id.etGuardianPasswordConfirm)

        // Additional Info
        etMedicalConditions = findViewById(R.id.etMedicalConditions)
        etNotes = findViewById(R.id.etNotes)
        ivStudentPhoto = findViewById(R.id.ivStudentPhoto)
        btnSelectPhoto = findViewById(R.id.btnSelectPhoto)
        btnSaveStudent = findViewById(R.id.btnSaveStudent)
    }

    private fun setupSpinners() {
        // Gender Spinner
        val genderOptions = arrayOf("Select Gender", "Male", "Female", "Other")
        val genderAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, genderOptions)
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spGender.adapter = genderAdapter
    }

    private fun loadClassCategories() {
        db.collection("classCategories")
            .whereEqualTo("isActive", true)
            .get()
            .addOnSuccessListener { documents ->
                classCategoriesList = documents.map { doc ->
                    doc.toObject(ClassCategory::class.java).copy(id = doc.id)
                }
                setupClassCategoriesListView()
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this, "Error loading class categories: ${exception.message}",
                    Toast.LENGTH_SHORT).show()
            }
    }

    private fun setupClassCategoriesListView() {
        val categoryNames = classCategoriesList.map { "${it.categoryName} (${it.subject})" }
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, categoryNames)
        lvClassCategories.adapter = adapter
        lvClassCategories.choiceMode = ListView.CHOICE_MODE_MULTIPLE

        lvClassCategories.setOnItemClickListener { _, _, position, _ ->
            val categoryId = classCategoriesList[position].id
            if (selectedClassCategories.contains(categoryId)) {
                selectedClassCategories.remove(categoryId)
            } else {
                selectedClassCategories.add(categoryId)
            }
        }
    }

    private fun setupClickListeners() {
        etDateOfBirth.setOnClickListener { showDatePicker(etDateOfBirth) }
        etAdmissionDate.setOnClickListener { showDatePicker(etAdmissionDate) }

        btnSelectPhoto.setOnClickListener { selectPhoto() }
        btnSaveStudent.setOnClickListener { saveStudent() }
    }

    private fun showDatePicker(editText: EditText) {
        val calendar = Calendar.getInstance()
        val datePickerDialog = DatePickerDialog(
            this,
            { _, year, month, dayOfMonth ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(year, month, dayOfMonth)
                val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                editText.setText(dateFormat.format(selectedDate.time))
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
    }

    private fun selectPhoto() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, REQUEST_IMAGE_PICK)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_PICK && resultCode == RESULT_OK && data != null) {
            selectedImageUri = data.data
            ivStudentPhoto.setImageURI(selectedImageUri)
        }
    }

    private fun saveStudent() {
        if (!validateForm()) return

        // Show progress
        btnSaveStudent.text = "Creating Account..."
        btnSaveStudent.isEnabled = false

        // Create student account first
        createStudentAccount()
    }

    private fun createStudentAccount() {
        val studentEmail = etStudentEmail.text.toString()
        val studentPassword = etStudentPassword.text.toString()

        auth.createUserWithEmailAndPassword(studentEmail, studentPassword)
            .addOnSuccessListener { studentAuthResult ->
                val studentUserId = studentAuthResult.user?.uid ?: ""
                // Create guardian account
                createGuardianAccount(studentUserId)
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this, "Error creating student account: ${exception.message}",
                    Toast.LENGTH_SHORT).show()
                resetSaveButton()
            }
    }

    private fun createGuardianAccount(studentUserId: String) {
        val guardianEmail = etGuardianEmail.text.toString()
        val guardianPassword = etGuardianPassword.text.toString()

        auth.createUserWithEmailAndPassword(guardianEmail, guardianPassword)
            .addOnSuccessListener { guardianAuthResult ->
                val guardianUserId = guardianAuthResult.user?.uid ?: ""
                // Save student data to Firestore
                saveStudentToFirestore(studentUserId, guardianUserId)
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this, "Error creating guardian account: ${exception.message}",
                    Toast.LENGTH_SHORT).show()
                resetSaveButton()
            }
    }

    private fun saveStudentToFirestore(studentUserId: String, guardianUserId: String) {
        val currentDate = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date())
        val studentId = "STU${System.currentTimeMillis()}"

        val student = Student(
            id = UUID.randomUUID().toString(),
            firstName = etFirstName.text.toString(),
            lastName = etLastName.text.toString(),
            dateOfBirth = etDateOfBirth.text.toString(),
            gender = spGender.selectedItem.toString(),
            nicNumber = etNicNumber.text.toString(),
            studentPhone = etStudentPhone.text.toString(),
            studentEmail = etStudentEmail.text.toString(),
            address = etAddress.text.toString(),
            city = etCity.text.toString(),
            studentId = studentId,
            classCategories = selectedClassCategories,
            currentGrade = etCurrentGrade.text.toString(),
            admissionDate = etAdmissionDate.text.toString(),
            guardianName = etGuardianName.text.toString(),
            guardianPhone = etGuardianPhone.text.toString(),
            guardianEmail = etGuardianEmail.text.toString(),
            guardianAddress = etGuardianAddress.text.toString(),
            medicalConditions = etMedicalConditions.text.toString(),
            notes = etNotes.text.toString(),
            studentUserId = studentUserId,
            guardianUserId = guardianUserId,
            registrationDate = currentDate,
            lastUpdated = currentDate,
            registeredBy = "Admin"
        )

        // Save to Firestore
        db.collection("students")
            .document(student.id)
            .set(student)
            .addOnSuccessListener {
                // Update class category student counts
                updateClassCategoryStudentCounts()
                Toast.makeText(this, "Student and accounts created successfully!", Toast.LENGTH_SHORT).show()
                finish()
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this, "Error saving student: ${exception.message}",
                    Toast.LENGTH_SHORT).show()
                resetSaveButton()
            }
    }

    private fun updateClassCategoryStudentCounts() {
        selectedClassCategories.forEach { categoryId ->
            db.collection("classCategories").document(categoryId)
                .update("currentStudents", com.google.firebase.firestore.FieldValue.increment(1))
        }
    }

    private fun validateForm(): Boolean {
        val requiredFields = listOf(
            etFirstName to "First Name",
            etLastName to "Last Name",
            etDateOfBirth to "Date of Birth",
            etStudentEmail to "Student Email",
            etStudentPassword to "Student Password",
            etStudentPasswordConfirm to "Student Password Confirmation",
            etGuardianName to "Guardian Name",
            etGuardianPhone to "Guardian Phone",
            etGuardianEmail to "Guardian Email",
            etGuardianPassword to "Guardian Password",
            etGuardianPasswordConfirm to "Guardian Password Confirmation"
        )

        for ((editText, fieldName) in requiredFields) {
            if (editText.text.toString().trim().isEmpty()) {
                editText.error = "$fieldName is required"
                editText.requestFocus()
                return false
            }
        }

        if (spGender.selectedItemPosition == 0) {
            Toast.makeText(this, "Please select gender", Toast.LENGTH_SHORT).show()
            return false
        }

        if (selectedClassCategories.isEmpty()) {
            Toast.makeText(this, "Please select at least one class category", Toast.LENGTH_SHORT).show()
            return false
        }

        // Email validation
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        if (!etStudentEmail.text.toString().matches(emailPattern.toRegex()) ||
            !etGuardianEmail.text.toString().matches(emailPattern.toRegex())) {
            Toast.makeText(this, "Please enter valid email addresses", Toast.LENGTH_SHORT).show()
            return false
        }

        // Password validation
        if (etStudentPassword.text.toString().length < 6 ||
            etGuardianPassword.text.toString().length < 6) {
            Toast.makeText(this, "Passwords must be at least 6 characters", Toast.LENGTH_SHORT).show()
            return false
        }

        // Password confirmation validation
        if (etStudentPassword.text.toString() != etStudentPasswordConfirm.text.toString()) {
            etStudentPasswordConfirm.error = "Student passwords do not match"
            etStudentPasswordConfirm.requestFocus()
            Toast.makeText(this, "Student passwords do not match", Toast.LENGTH_SHORT).show()
            return false
        }

        if (etGuardianPassword.text.toString() != etGuardianPasswordConfirm.text.toString()) {
            etGuardianPasswordConfirm.error = "Guardian passwords do not match"
            etGuardianPasswordConfirm.requestFocus()
            Toast.makeText(this, "Guardian passwords do not match", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    private fun resetSaveButton() {
        btnSaveStudent.text = "Save Student"
        btnSaveStudent.isEnabled = true
    }

    companion object {
        private const val REQUEST_IMAGE_PICK = 100
    }
}
