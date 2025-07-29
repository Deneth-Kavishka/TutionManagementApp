package com.project.tuitionmanagementapp.teacher

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.project.tuitionmanagementapp.R
import java.text.SimpleDateFormat
import java.util.*

class MaterialsFragment : Fragment() {

    private lateinit var firestore: FirebaseFirestore
    private lateinit var storage: FirebaseStorage
    private lateinit var btnChooseFile: LinearLayout
    private lateinit var btnUpload: Button
    private lateinit var btnCancel: Button
    private lateinit var etSubject: TextInputEditText
    private lateinit var etTopic: TextInputEditText
    private lateinit var spinnerGrade: Spinner
    private lateinit var spinnerClass: Spinner
    private lateinit var tvFileName: TextView

    private var selectedFileUri: Uri? = null
    private lateinit var filePickerLauncher: ActivityResultLauncher<Intent>
    private var classesList = ArrayList<String>()
    private var classesIdList = ArrayList<String>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_materials_teacher, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeFirebase()
        initializeViews(view)
        setupSpinner()
        setupClickListeners()
        setupFilePickerLauncher()
    }

    private fun initializeFirebase() {
        firestore = FirebaseFirestore.getInstance()
        storage = FirebaseStorage.getInstance()
    }

    private fun initializeViews(view: View) {
        btnChooseFile = view.findViewById(R.id.btnChooseFile)
        btnUpload = view.findViewById(R.id.btnUpload)
        btnCancel = view.findViewById(R.id.btnCancel)
        etSubject = view.findViewById(R.id.etSubject)
        etTopic = view.findViewById(R.id.etTopic)
        spinnerGrade = view.findViewById(R.id.spinnerGrade)
        spinnerClass = view.findViewById(R.id.spinnerClass)
        tvFileName = view.findViewById(R.id.tvFileName)
    }

    private fun setupSpinner() {
        val grades = listOf("Select Grade", "Grade 6", "Grade 7", "Grade 8", "Grade 9", "Grade 10", "Grade 11", "A/L")
        val gradeAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, grades)
        spinnerGrade.adapter = gradeAdapter

        // Load classes for the spinner
        loadClasses()
    }

    private fun loadClasses() {
        classesList.clear()
        classesIdList.clear()
        classesList.add("Select Target Class")
        classesIdList.add("")

        // Check if user is authenticated
        val currentUser = com.google.firebase.auth.FirebaseAuth.getInstance().currentUser
        if (currentUser == null) {
            Toast.makeText(requireContext(), "Please log in to access classes", Toast.LENGTH_LONG).show()
            val classAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, classesList)
            spinnerClass.adapter = classAdapter
            return
        }

        firestore.collection("classes")
            .get()
            .addOnSuccessListener { documents ->
                if (documents.isEmpty) {
                    Toast.makeText(requireContext(), "No classes found. You can still upload materials.", Toast.LENGTH_SHORT).show()
                } else {
                    for (document in documents) {
                        val className = document.getString("className") ?: ""
                        val grade = document.getString("grade") ?: ""
                        val subject = document.getString("subject") ?: ""

                        val displayName = if (className.isNotEmpty()) {
                            if (grade.isNotEmpty() && subject.isNotEmpty()) {
                                "$className - $grade ($subject)"
                            } else if (grade.isNotEmpty()) {
                                "$className - $grade"
                            } else {
                                className
                            }
                        } else {
                            "Class ${document.id}"
                        }

                        classesList.add(displayName)
                        classesIdList.add(document.id)
                    }
                }

                val classAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, classesList)
                spinnerClass.adapter = classAdapter
            }
            .addOnFailureListener { exception ->
                // Handle permission denied and other errors
                val errorMessage = when {
                    exception.message?.contains("PERMISSION_DENIED") == true ->
                        "Database access denied. Please check your login status and try again."
                    exception.message?.contains("offline") == true ->
                        "You're offline. Please check your internet connection."
                    else -> "Unable to load classes: ${exception.message}"
                }

                Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_LONG).show()

                // Add a manual option for users to enter class name
                classesList.add("General (No specific class)")
                classesIdList.add("general")

                val classAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, classesList)
                spinnerClass.adapter = classAdapter

                android.util.Log.e("MaterialsFragment", "Error loading classes", exception)
            }
    }

    private fun setupClickListeners() {
        btnChooseFile.setOnClickListener {
            openFilePicker()
        }

        btnUpload.setOnClickListener {
            uploadMaterial()
        }

        btnCancel.setOnClickListener {
            clearForm()
        }
    }

    private fun setupFilePickerLauncher() {
        filePickerLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                result.data?.data?.let { uri ->
                    selectedFileUri = uri
                    val fileName = getFileName(uri)
                    tvFileName.text = fileName
                }
            }
        }
    }

    private fun openFilePicker() {
        val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
            type = "*/*"
            addCategory(Intent.CATEGORY_OPENABLE)
        }
        filePickerLauncher.launch(Intent.createChooser(intent, "Select File"))
    }

    private fun uploadMaterial() {
        val subject = etSubject.text.toString().trim()
        val topic = etTopic.text.toString().trim()
        val grade = spinnerGrade.selectedItem.toString()
        val selectedClassIndex = spinnerClass.selectedItemPosition
        val targetClass = if (selectedClassIndex > 0) classesList[selectedClassIndex] else ""
        val targetClassId = if (selectedClassIndex > 0) classesIdList[selectedClassIndex] else ""

        if (!validateInput(subject, topic, grade, targetClass)) {
            return
        }

        selectedFileUri?.let { uri ->
            val fileName = "material_${System.currentTimeMillis()}"
            val storageRef = storage.reference.child("materials/$fileName")

            Toast.makeText(requireContext(), "Uploading material...", Toast.LENGTH_SHORT).show()

            storageRef.putFile(uri)
                .addOnSuccessListener {
                    storageRef.downloadUrl.addOnSuccessListener { downloadUrl ->
                        saveMaterialToFirestore(subject, topic, grade, targetClass, targetClassId, downloadUrl.toString(), getFileName(uri))
                    }
                }
                .addOnFailureListener { exception ->
                    Toast.makeText(requireContext(), "Upload failed: ${exception.message}", Toast.LENGTH_SHORT).show()
                }
        }
    }

    private fun saveMaterialToFirestore(subject: String, topic: String, grade: String, targetClass: String, targetClassId: String, url: String, originalFileName: String) {
        val material = hashMapOf(
            "title" to originalFileName,
            "url" to url,
            "uploadDate" to System.currentTimeMillis(),
            "type" to getFileType(originalFileName),
            "subject" to subject,
            "topic" to topic,
            "grade" to grade,
            "targetClass" to targetClass,
            "targetClassId" to targetClassId,
            "fileUrl" to url,
            "uploadedBy" to "teacher" // You can add teacher ID here if needed
        )

        firestore.collection("materials")
            .add(material)
            .addOnSuccessListener {
                Toast.makeText(requireContext(), "Material uploaded successfully for $targetClass!", Toast.LENGTH_SHORT).show()
                clearForm()
            }
            .addOnFailureListener { exception ->
                Toast.makeText(requireContext(), "Failed to save material: ${exception.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun validateInput(subject: String, topic: String, grade: String, targetClass: String): Boolean {
        when {
            subject.isEmpty() -> {
                etSubject.error = "Subject is required"
                return false
            }
            topic.isEmpty() -> {
                etTopic.error = "Topic is required"
                return false
            }
            grade == "Select Grade" -> {
                Toast.makeText(requireContext(), "Please select a grade", Toast.LENGTH_SHORT).show()
                return false
            }
            targetClass.isEmpty() -> {
                Toast.makeText(requireContext(), "Please select a target class", Toast.LENGTH_SHORT).show()
                return false
            }
            selectedFileUri == null -> {
                Toast.makeText(requireContext(), "Please select a file", Toast.LENGTH_SHORT).show()
                return false
            }
        }
        return true
    }

    private fun getFileName(uri: Uri): String {
        return uri.lastPathSegment?.split("/")?.last() ?: "Selected File"
    }

    private fun getFileType(fileName: String): String {
        return when {
            fileName.endsWith(".pdf", true) -> "PDF"
            fileName.endsWith(".doc", true) || fileName.endsWith(".docx", true) -> "Document"
            fileName.endsWith(".mp4", true) || fileName.endsWith(".avi", true) -> "Video"
            fileName.endsWith(".jpg", true) || fileName.endsWith(".png", true) -> "Image"
            fileName.endsWith(".ppt", true) || fileName.endsWith(".pptx", true) -> "Presentation"
            else -> "Document"
        }
    }

    private fun clearForm() {
        etSubject.text?.clear()
        etTopic.text?.clear()
        spinnerGrade.setSelection(0)
        spinnerClass.setSelection(0)
        tvFileName.text = "No file selected"
        selectedFileUri = null
    }
}
