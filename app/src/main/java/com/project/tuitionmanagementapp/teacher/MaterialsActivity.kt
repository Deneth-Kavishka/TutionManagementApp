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
    private lateinit var adapter: MaterialsAdapter
    private var materialsList = ArrayList<MaterialModel>()

    private lateinit var filePickerLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher_materials)

        initializeViews()
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

        findViewById<ImageView>(R.id.backButton).setOnClickListener { finish() }
        fabUpload.setOnClickListener { showUploadDialog() }
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
                materialsList.sortByDescending { material: MaterialModel -> material.uploadDate }
                adapter.notifyDataSetChanged()
                progressBar.visibility = View.GONE
            }
            .addOnFailureListener {
                progressBar.visibility = View.GONE
                Toast.makeText(this, "Failed to load materials", Toast.LENGTH_SHORT).show()
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
            type = if (url.endsWith(".pdf", true)) "PDF" else "Document"
        )

        firestore.collection("materials")
            .add(material)
            .addOnSuccessListener {
                Toast.makeText(this, "Material uploaded successfully", Toast.LENGTH_SHORT).show()
                progressBar.visibility = View.GONE
                loadMaterials() // Refresh the list
            }
            .addOnFailureListener {
                showUploadError()
            }
    }

    private fun showUploadError() {
        progressBar.visibility = View.GONE
        Toast.makeText(this, "Failed to upload material", Toast.LENGTH_SHORT).show()
    }
}
