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
import com.project.tuitionmanagementapp.models.Teacher
import java.text.SimpleDateFormat
import java.util.*

class AddTeacherActivity : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()
    private val storage = FirebaseStorage.getInstance()
    private var selectedImageUri: Uri? = null
    private var selectedSubjects = mutableListOf<String>()
    private var selectedClassCategories = mutableListOf<String>()
    private var selectedWorkingDays = mutableListOf<String>()
    private lateinit var classCategoriesList: List<ClassCategory>

    // Basic Info Views
    private lateinit var etFirstName: EditText
    private lateinit var etLastName: EditText
    private lateinit var etDateOfBirth: EditText
    private lateinit var spGender: Spinner
    private lateinit var etNicNumber: EditText

    // Contact Info Views
    private lateinit var etEmail: EditText
    private lateinit var etPhone: EditText
    private lateinit var etEmergencyContact: EditText
    private lateinit var etEmergencyContactName: EditText
    private lateinit var etAddress: EditText
    private lateinit var etCity: EditText

    // Professional Info Views
    private lateinit var lvSubjects: ListView
    private lateinit var lvClassCategories: ListView
    private lateinit var etQualification: EditText
    private lateinit var etExperience: EditText
    private lateinit var etSpecializations: EditText

    // Employment Info Views
    private lateinit var etJoiningDate: EditText
    private lateinit var spEmploymentType: Spinner
    private lateinit var etSalary: EditText
    private lateinit var lvWorkingDays: ListView

    // Account Creation Views
    private lateinit var etTeacherPassword: EditText
    private lateinit var etTeacherPasswordConfirm: EditText

    // Additional Info Views
    private lateinit var etBio: EditText
    private lateinit var etNotes: EditText
    private lateinit var ivTeacherPhoto: ImageView
    private lateinit var btnSelectPhoto: Button
    private lateinit var btnSaveTeacher: Button

    private val allSubjects = listOf(
        "Mathematics", "Physics", "Chemistry", "Biology", "English", "Sinhala", "Tamil",
        "History", "Geography", "Economics", "Accounting", "Business Studies", "ICT",
        "Art", "Music", "Drama", "Health", "Science"
    )

    private val workingDays = listOf(
        "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_teacher)

        initializeViews()
        setupSpinners()
        setupListViews()
        loadClassCategories()
        setupClickListeners()
    }

    private fun initializeViews() {
        // Basic Info
        etFirstName = findViewById(R.id.etTeacherFirstName)
        etLastName = findViewById(R.id.etTeacherLastName)
        etDateOfBirth = findViewById(R.id.etTeacherDateOfBirth)
        spGender = findViewById(R.id.spTeacherGender)
        etNicNumber = findViewById(R.id.etTeacherNicNumber)

        // Contact Info
        etEmail = findViewById(R.id.etTeacherEmail)
        etPhone = findViewById(R.id.etTeacherPhone)
        etEmergencyContact = findViewById(R.id.etTeacherEmergencyContact)
        etEmergencyContactName = findViewById(R.id.etTeacherEmergencyContactName)
        etAddress = findViewById(R.id.etTeacherAddress)
        etCity = findViewById(R.id.etTeacherCity)

        // Professional Info
        lvSubjects = findViewById(R.id.lvTeacherSubjects)
        lvClassCategories = findViewById(R.id.lvTeacherClassCategories)
        etQualification = findViewById(R.id.etTeacherQualification)
        etExperience = findViewById(R.id.etTeacherExperience)
        etSpecializations = findViewById(R.id.etTeacherSpecializations)

        // Employment Info
        etJoiningDate = findViewById(R.id.etTeacherJoiningDate)
        spEmploymentType = findViewById(R.id.spTeacherEmploymentType)
        etSalary = findViewById(R.id.etTeacherSalary)
        lvWorkingDays = findViewById(R.id.lvTeacherWorkingDays)

        // Account Creation
        etTeacherPassword = findViewById(R.id.etTeacherPassword)
        etTeacherPasswordConfirm = findViewById(R.id.etTeacherPasswordConfirm)

        // Additional Info
        etBio = findViewById(R.id.etTeacherBio)
        etNotes = findViewById(R.id.etTeacherNotes)
        ivTeacherPhoto = findViewById(R.id.ivTeacherPhoto)
        btnSelectPhoto = findViewById(R.id.btnSelectTeacherPhoto)
        btnSaveTeacher = findViewById(R.id.btnSaveTeacher)
    }

    private fun setupSpinners() {
        // Gender Spinner
        val genderOptions = arrayOf("Select Gender", "Male", "Female", "Other")
        val genderAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, genderOptions)
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spGender.adapter = genderAdapter

        // Employment Type Spinner
        val employmentOptions = arrayOf("Select Employment Type", "Full-time", "Part-time", "Contract")
        val employmentAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, employmentOptions)
        employmentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spEmploymentType.adapter = employmentAdapter
    }

    private fun setupListViews() {
        // Subjects ListView
        val subjectsAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, allSubjects)
        lvSubjects.adapter = subjectsAdapter
        lvSubjects.choiceMode = ListView.CHOICE_MODE_MULTIPLE

        lvSubjects.setOnItemClickListener { _, _, position, _ ->
            val subject = allSubjects[position]
            if (selectedSubjects.contains(subject)) {
                selectedSubjects.remove(subject)
            } else {
                selectedSubjects.add(subject)
            }
        }

        // Working Days ListView
        val workingDaysAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, workingDays)
        lvWorkingDays.adapter = workingDaysAdapter
        lvWorkingDays.choiceMode = ListView.CHOICE_MODE_MULTIPLE

        lvWorkingDays.setOnItemClickListener { _, _, position, _ ->
            val day = workingDays[position]
            if (selectedWorkingDays.contains(day)) {
                selectedWorkingDays.remove(day)
            } else {
                selectedWorkingDays.add(day)
            }
        }
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
        etJoiningDate.setOnClickListener { showDatePicker(etJoiningDate) }

        btnSelectPhoto.setOnClickListener { selectPhoto() }
        btnSaveTeacher.setOnClickListener { saveTeacher() }
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
            ivTeacherPhoto.setImageURI(selectedImageUri)
        }
    }

    private fun saveTeacher() {
        if (!validateForm()) return

        // Show progress
        btnSaveTeacher.text = "Creating Account..."
        btnSaveTeacher.isEnabled = false

        // Create teacher account first
        createTeacherAccount()
    }

    private fun createTeacherAccount() {
        val teacherEmail = etEmail.text.toString()
        val teacherPassword = etTeacherPassword.text.toString()

        auth.createUserWithEmailAndPassword(teacherEmail, teacherPassword)
            .addOnSuccessListener { teacherAuthResult ->
                val teacherUserId = teacherAuthResult.user?.uid ?: ""
                // Save teacher data to Firestore
                saveTeacherToFirestore(teacherUserId)
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this, "Error creating teacher account: ${exception.message}",
                    Toast.LENGTH_SHORT).show()
                resetSaveButton()
            }
    }

    private fun saveTeacherToFirestore(teacherUserId: String) {
        val currentDate = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date())
        val teacherId = "TCH${System.currentTimeMillis()}"

        val teacher = Teacher(
            id = UUID.randomUUID().toString(),
            firstName = etFirstName.text.toString(),
            lastName = etLastName.text.toString(),
            dateOfBirth = etDateOfBirth.text.toString(),
            gender = spGender.selectedItem.toString(),
            nicNumber = etNicNumber.text.toString(),
            email = etEmail.text.toString(),
            phone = etPhone.text.toString(),
            emergencyContact = etEmergencyContact.text.toString(),
            emergencyContactName = etEmergencyContactName.text.toString(),
            address = etAddress.text.toString(),
            city = etCity.text.toString(),
            teacherId = teacherId,
            subjects = selectedSubjects,
            classCategories = selectedClassCategories,
            qualification = etQualification.text.toString(),
            experience = etExperience.text.toString(), // Keep as String
            specializations = etSpecializations.text.toString().split(",").map { it.trim() },
            joiningDate = etJoiningDate.text.toString(),
            employmentType = spEmploymentType.selectedItem.toString(),
            salary = etSalary.text.toString(), // Keep as String
            workingDays = selectedWorkingDays,
            bio = etBio.text.toString(),
            notes = etNotes.text.toString(),
            teacherUserId = teacherUserId,
            createdDate = currentDate,
            lastUpdated = currentDate,
            createdBy = "Admin"
        )

        // Save to Firestore
        db.collection("teachers")
            .document(teacher.id)
            .set(teacher)
            .addOnSuccessListener {
                // Update class category teacher assignments
                updateClassCategoryTeacherAssignments(teacher)
                Toast.makeText(this, "Teacher and account created successfully!", Toast.LENGTH_SHORT).show()
                finish()
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this, "Error saving teacher: ${exception.message}",
                    Toast.LENGTH_SHORT).show()
                resetSaveButton()
            }
    }

    private fun updateClassCategoryTeacherAssignments(teacher: Teacher) {
        selectedClassCategories.forEach { categoryId ->
            db.collection("classCategories").document(categoryId)
                .update(
                    mapOf(
                        "teacherId" to teacher.id,
                        "teacherName" to teacher.fullName
                    )
                )
        }
    }

    private fun validateForm(): Boolean {
        val requiredFields = listOf(
            etFirstName to "First Name",
            etLastName to "Last Name",
            etEmail to "Email",
            etPhone to "Phone",
            etQualification to "Qualification",
            etJoiningDate to "Joining Date",
            etTeacherPassword to "Password"
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

        if (spEmploymentType.selectedItemPosition == 0) {
            Toast.makeText(this, "Please select employment type", Toast.LENGTH_SHORT).show()
            return false
        }

        if (selectedSubjects.isEmpty()) {
            Toast.makeText(this, "Please select at least one subject", Toast.LENGTH_SHORT).show()
            return false
        }

        if (selectedWorkingDays.isEmpty()) {
            Toast.makeText(this, "Please select working days", Toast.LENGTH_SHORT).show()
            return false
        }

        // Email validation
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        if (!etEmail.text.toString().matches(emailPattern.toRegex())) {
            etEmail.error = "Please enter a valid email address"
            etEmail.requestFocus()
            return false
        }

        // Password validation
        if (etTeacherPassword.text.toString().length < 6) {
            etTeacherPassword.error = "Password must be at least 6 characters"
            etTeacherPassword.requestFocus()
            return false
        }

        // Password confirmation
        if (etTeacherPassword.text.toString() != etTeacherPasswordConfirm.text.toString()) {
            etTeacherPasswordConfirm.error = "Passwords do not match"
            etTeacherPasswordConfirm.requestFocus()
            return false
        }

        return true
    }

    private fun resetSaveButton() {
        btnSaveTeacher.text = "Save Teacher"
        btnSaveTeacher.isEnabled = true
    }

    companion object {
        private const val REQUEST_IMAGE_PICK = 1000
    }
}
