package com.project.tuitionmanagementapp.student

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.database.FirebaseDatabase
import com.project.tuitionmanagementapp.R

class MaterialActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MaterialAdapter
    private lateinit var materialList: ArrayList<Material>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_materials_student)

        recyclerView = findViewById(R.id.recyclerViewMaterials)
        recyclerView.layoutManager = LinearLayoutManager(this)

        materialList = arrayListOf()
        adapter = MaterialAdapter(materialList)
        recyclerView.adapter = adapter

        val studentId = "S001" // TODO: Make this dynamic on login
        loadMaterialsFromFirebase(studentId)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.selectedItemId = R.id.nav_home // fallback

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, StudentDashboardActivity::class.java))
                    overridePendingTransition(0, 0)
                    true
                }
                R.id.nav_attendance -> {
                    startActivity(Intent(this, AttendanceActivity::class.java))
                    overridePendingTransition(0, 0)
                    true
                }
                R.id.nav_assignments -> {
                    startActivity(Intent(this, AssignmentActivity::class.java))
                    overridePendingTransition(0, 0)
                    true
                }
                R.id.nav_profile -> {
                    startActivity(Intent(this, ProfileActivity::class.java))
                    overridePendingTransition(0, 0)
                    true
                }
                else -> false
            }
        }
    }

    private fun loadMaterialsFromFirebase(studentId: String) {
        val dbRef = FirebaseDatabase.getInstance().getReference("materials").child(studentId)

        dbRef.get().addOnSuccessListener { snapshot ->
            materialList.clear()
            for (item in snapshot.children) {
                val material = item.getValue(Material::class.java)
                material?.let { materialList.add(it) }
            }
            adapter.notifyDataSetChanged()
        }.addOnFailureListener {
            Toast.makeText(this, "Failed to load materials", Toast.LENGTH_SHORT).show()
        }
    }
}
