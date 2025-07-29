package com.project.tuitionmanagementapp.teacher

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.project.tuitionmanagementapp.R
import java.util.*

class TeacherMaterialsActivity : AppCompatActivity() {

    private lateinit var firestore: FirebaseFirestore
    private lateinit var storage: FirebaseStorage
    private lateinit var recyclerView: RecyclerView
    private lateinit var fabUpload: com.google.android.material.floatingactionbutton.FloatingActionButton
    private lateinit var progressBar: ProgressBar
    private lateinit var bottomNavigation: BottomNavigationView
    private lateinit var adapter: MaterialsAdapter
    private var materialsList = ArrayList<MaterialModel>()

    private lateinit var filePickerLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher_materials)

        initializeViews()
        setupBottomNavigation()
        setupRecyclerView()
        loadMaterials()
        setupFilePickerLauncher()
    }

    private fun initializeViews() {
        firestore = FirebaseFirestore.getInstance()
        storage = FirebaseStorage.getInstance()
        fabUpload = findViewById(R.id.fabUploadMaterial)
        progressBar = findViewById(R.id.progressBar)
        recyclerView = findViewById(R.id.rvMaterials)
        bottomNavigation = findViewById(R.id.bottomNavigation)

        findViewById<ImageView>(R.id.backButton).setOnClickListener { finish() }
        fabUpload.setOnClickListener { showUploadDialog() }
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

    private fun setupRecyclerView() {
        adapter = MaterialsAdapter(materialsList) { material ->
            // Handle material click
            Toast.makeText(this, "Opening ${material.title}", Toast.LENGTH_SHORT).show()
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun setupFilePickerLauncher() {
        filePickerLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                result.data?.data?.let { uri ->
                    uploadFile(uri)
                }
            }
        }
    }

    private fun loadMaterials() {
        progressBar.visibility = View.VISIBLE
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
                progressBar.visibility = View.GONE
            }
            .addOnFailureListener {
                Toast.makeText(this, "Failed to load materials", Toast.LENGTH_SHORT).show()
                progressBar.visibility = View.GONE
            }
    }

    private fun showUploadDialog() {
        val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
            type = "*/*"
            addCategory(Intent.CATEGORY_OPENABLE)
        }
        filePickerLauncher.launch(Intent.createChooser(intent, "Select File"))
    }

    private fun uploadFile(uri: Uri) {
        progressBar.visibility = View.VISIBLE
        val fileName = "material_${System.currentTimeMillis()}"
        val storageRef = storage.reference.child("materials/$fileName")

        storageRef.putFile(uri)
            .addOnSuccessListener { taskSnapshot ->
                storageRef.downloadUrl.addOnSuccessListener { downloadUrl ->
                    saveMaterialToFirestore(fileName, downloadUrl.toString())
                }
            }
            .addOnFailureListener {
                showUploadError()
            }
            .addOnProgressListener { taskSnapshot ->
                val progress = (100.0 * taskSnapshot.bytesTransferred / taskSnapshot.totalByteCount)
                // Update progress if needed
            }
    }

    private fun saveMaterialToFirestore(title: String, url: String) {
        val material = MaterialModel(
            title = title,
            url = url,
            uploadDate = System.currentTimeMillis(),
            type = getFileType(url),
            fileUrl = url
        )

        firestore.collection("materials")
            .add(material)
            .addOnSuccessListener {
                Toast.makeText(this, "Material uploaded successfully", Toast.LENGTH_SHORT).show()
                progressBar.visibility = View.GONE
                loadMaterials() // Refresh the list
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this, "Failed to upload material: ${exception.message}", Toast.LENGTH_SHORT).show()
                progressBar.visibility = View.GONE
            }
    }

    private fun getFileType(url: String): String {
        return when {
            url.endsWith(".pdf", true) -> "PDF"
            url.endsWith(".doc", true) || url.endsWith(".docx", true) -> "Document"
            url.endsWith(".mp4", true) || url.endsWith(".avi", true) -> "Video"
            url.endsWith(".jpg", true) || url.endsWith(".png", true) -> "Image"
            else -> "Document"
        }
    }

    private fun showUploadError() {
        progressBar.visibility = View.GONE
        Toast.makeText(this, "Failed to upload material. Please try again.", Toast.LENGTH_SHORT).show()
    }
}
