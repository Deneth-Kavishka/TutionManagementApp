package com.project.tuitionmanagementapp.teacher

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.project.tuitionmanagementapp.R
import java.util.*

class TeacherMaterialsManagementActivity : AppCompatActivity() {

    private lateinit var firestore: FirebaseFirestore
    private lateinit var storage: FirebaseStorage
    private lateinit var tabLayout: TabLayout
    private lateinit var recyclerView: RecyclerView
    private lateinit var fabUpload: FloatingActionButton
    private lateinit var bottomNavigation: BottomNavigationView
    private lateinit var adapter: MaterialsAdapter
    private var materialsList = ArrayList<MaterialModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher_materials_management)

        initializeViews()
        setupBottomNavigation()
        setupTabs()
        loadViewMaterials()
    }

    private fun initializeViews() {
        firestore = FirebaseFirestore.getInstance()
        storage = FirebaseStorage.getInstance()
        tabLayout = findViewById(R.id.tabLayout)
        recyclerView = findViewById(R.id.rvMaterials)
        fabUpload = findViewById(R.id.fabUpload)
        bottomNavigation = findViewById(R.id.bottomNavigation)

        findViewById<ImageView>(R.id.backButton).setOnClickListener { finish() }

        // Setup RecyclerView
        adapter = MaterialsAdapter(materialsList) { material ->
            // Handle material click - you can implement view/download functionality here
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // FAB click to show upload fragment
        fabUpload.setOnClickListener {
            showUploadFragment()
        }
    }

    private fun setupBottomNavigation() {
        bottomNavigation.selectedItemId = R.id.nav_materials
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
                R.id.nav_materials -> true // Stay on current page
                R.id.nav_result -> {
                    startActivity(Intent(this, UploadResultActivity::class.java))
                    finish()
                    true
                }
                R.id.nav_qr -> {
                    startActivity(Intent(this, QRAttendanceActivity::class.java))
                    finish()
                    true
                }
                else -> false
            }
        }
    }

    private fun setupTabs() {
        tabLayout.addTab(tabLayout.newTab().setText("View Materials"))
        tabLayout.addTab(tabLayout.newTab().setText("Upload Material"))

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.position) {
                    0 -> showViewMaterials()
                    1 -> showUploadFragment()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }

    private fun showViewMaterials() {
        recyclerView.visibility = View.VISIBLE
        fabUpload.visibility = View.VISIBLE

        // Hide upload fragment if it's currently shown
        val uploadFragment = supportFragmentManager.findFragmentByTag("upload_fragment")
        if (uploadFragment != null) {
            supportFragmentManager.beginTransaction()
                .hide(uploadFragment)
                .commit()
        }

        loadViewMaterials()
    }

    private fun showUploadFragment() {
        recyclerView.visibility = View.GONE
        fabUpload.visibility = View.GONE

        // Show the MaterialsFragment
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val materialsFragment = MaterialsFragment()
        fragmentTransaction.replace(R.id.fragmentContainer, materialsFragment, "upload_fragment")
        fragmentTransaction.commit()

        // Select the upload tab
        tabLayout.getTabAt(1)?.select()
    }

    private fun showUploadMaterialDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_upload_material)
        dialog.setCancelable(true)

        // Find views in dialog
        val btnCloseDialog = dialog.findViewById<ImageView>(R.id.btnCloseDialog)
        val etMaterialTitle = dialog.findViewById<TextInputEditText>(R.id.etMaterialTitle)
        val etMaterialDescription = dialog.findViewById<TextInputEditText>(R.id.etMaterialDescription)
        val spinnerSubject = dialog.findViewById<Spinner>(R.id.spinnerSubject)
        val spinnerClass = dialog.findViewById<Spinner>(R.id.spinnerClass)
        val cardSelectFile = dialog.findViewById<CardView>(R.id.cardSelectFile)
        val tvSelectedFile = dialog.findViewById<TextView>(R.id.tvSelectedFile)
        val uploadProgressBar = dialog.findViewById<ProgressBar>(R.id.uploadProgressBar)
        val btnCancel = dialog.findViewById<Button>(R.id.btnCancel)
        val btnUpload = dialog.findViewById<Button>(R.id.btnUpload)

        var selectedFileUri: Uri? = null

        // Setup file picker launcher
        val filePickerLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                result.data?.data?.let { uri ->
                    selectedFileUri = uri
                    val fileName = getFileName(uri)
                    tvSelectedFile.text = fileName
                }
            }
        }

        // Setup spinners
        setupDialogSpinners(spinnerSubject, spinnerClass)

        // Setup click listeners
        btnCloseDialog.setOnClickListener { dialog.dismiss() }
        btnCancel.setOnClickListener { dialog.dismiss() }

        cardSelectFile.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
                type = "*/*"
                addCategory(Intent.CATEGORY_OPENABLE)
            }
            filePickerLauncher.launch(Intent.createChooser(intent, "Select File"))
        }

        btnUpload.setOnClickListener {
            val title = etMaterialTitle.text.toString().trim()
            val description = etMaterialDescription.text.toString().trim()
            val subject = spinnerSubject.selectedItem.toString()
            val selectedClass = spinnerClass.selectedItem.toString()

            if (validateDialogInput(title, subject, selectedClass, selectedFileUri)) {
                uploadMaterialFromDialog(
                    title, description, subject, selectedClass,
                    selectedFileUri!!, uploadProgressBar, dialog
                )
            }
        }

        dialog.show()
    }

    private fun setupDialogSpinners(spinnerSubject: Spinner, spinnerClass: Spinner) {
        // Setup subjects
        val subjects = listOf("Select Subject", "Mathematics", "Science", "English", "History", "Geography")
        val subjectAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, subjects)
        spinnerSubject.adapter = subjectAdapter

        // Load classes from Firebase
        firestore.collection("classes")
            .get()
            .addOnSuccessListener { documents ->
                val classes = mutableListOf("Select Class")
                for (document in documents) {
                    val className = document.getString("className") ?: ""
                    val grade = document.getString("grade") ?: ""
                    if (className.isNotEmpty()) {
                        classes.add("$className - $grade")
                    }
                }
                val classAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, classes)
                spinnerClass.adapter = classAdapter
            }
    }

    private fun validateDialogInput(title: String, subject: String, selectedClass: String, fileUri: Uri?): Boolean {
        when {
            title.isEmpty() -> {
                Toast.makeText(this, "Please enter material title", Toast.LENGTH_SHORT).show()
                return false
            }
            subject == "Select Subject" -> {
                Toast.makeText(this, "Please select a subject", Toast.LENGTH_SHORT).show()
                return false
            }
            selectedClass == "Select Class" -> {
                Toast.makeText(this, "Please select a class", Toast.LENGTH_SHORT).show()
                return false
            }
            fileUri == null -> {
                Toast.makeText(this, "Please select a file", Toast.LENGTH_SHORT).show()
                return false
            }
        }
        return true
    }

    private fun uploadMaterialFromDialog(
        title: String, description: String, subject: String,
        selectedClass: String, fileUri: Uri, progressBar: ProgressBar, dialog: Dialog
    ) {
        progressBar.visibility = View.VISIBLE
        val fileName = "material_${System.currentTimeMillis()}"
        val storageRef = storage.reference.child("materials/$fileName")

        storageRef.putFile(fileUri)
            .addOnSuccessListener {
                storageRef.downloadUrl.addOnSuccessListener { downloadUrl ->
                    saveMaterialFromDialog(title, description, subject, selectedClass, downloadUrl.toString(), dialog)
                }
            }
            .addOnFailureListener { exception ->
                progressBar.visibility = View.GONE
                Toast.makeText(this, "Upload failed: ${exception.message}", Toast.LENGTH_SHORT).show()
            }
            .addOnProgressListener { taskSnapshot ->
                val progress = (100.0 * taskSnapshot.bytesTransferred / taskSnapshot.totalByteCount).toInt()
                // You can update progress if needed
            }
    }

    private fun saveMaterialFromDialog(
        title: String, description: String, subject: String,
        selectedClass: String, url: String, dialog: Dialog
    ) {
        val material = hashMapOf(
            "title" to title,
            "description" to description,
            "subject" to subject,
            "targetClass" to selectedClass,
            "url" to url,
            "uploadDate" to System.currentTimeMillis(),
            "type" to getFileType(url),
            "fileUrl" to url,
            "uploadedBy" to "teacher"
        )

        firestore.collection("materials")
            .add(material)
            .addOnSuccessListener {
                Toast.makeText(this, "Material uploaded successfully!", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
                loadViewMaterials() // Refresh the list
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this, "Failed to save material: ${exception.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun getFileName(uri: Uri): String {
        return uri.lastPathSegment?.split("/")?.last() ?: "Selected File"
    }

    private fun getFileType(url: String): String {
        return when {
            url.endsWith(".pdf", true) -> "PDF"
            url.endsWith(".doc", true) || url.endsWith(".docx", true) -> "Document"
            url.endsWith(".mp4", true) || url.endsWith(".avi", true) -> "Video"
            url.endsWith(".jpg", true) || url.endsWith(".png", true) -> "Image"
            url.endsWith(".ppt", true) || url.endsWith(".pptx", true) -> "Presentation"
            else -> "Document"
        }
    }

    private fun loadViewMaterials() {
        firestore.collection("materials")
            .get()
            .addOnSuccessListener { documents ->
                materialsList.clear()
                for (document in documents) {
                    val material = document.toObject(MaterialModel::class.java)
                    materialsList.add(material)
                }
                materialsList.sortByDescending { it.uploadDate }
                adapter.notifyDataSetChanged()
            }
            .addOnFailureListener {
                // Handle error
            }
    }
}
