package com.project.tuitionmanagementapp.student

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.FirebaseDatabase
import com.project.tuitionmanagementapp.R

class MaterialsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MaterialAdapter
    private lateinit var materialList: ArrayList<Material>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_materials_student, container, false)
        setupRecyclerView(view)
        loadMaterialsFromFirebase()
        return view
    }

    private fun setupRecyclerView(view: View) {
        recyclerView = view.findViewById(R.id.recyclerViewMaterials)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        materialList = arrayListOf()
        adapter = MaterialAdapter(materialList)
        recyclerView.adapter = adapter
    }

    private fun loadMaterialsFromFirebase() {
        val database = FirebaseDatabase.getInstance()
        val materialsRef = database.getReference("materials")

        materialsRef.get().addOnSuccessListener { snapshot ->
            materialList.clear()

            for (materialSnapshot in snapshot.children) {
                val material = materialSnapshot.getValue(Material::class.java)
                material?.let {
                    materialList.add(it)
                }
            }

            // If no materials found, add sample data
            if (materialList.isEmpty()) {
                addSampleMaterials()
            }

            materialList.sortBy { it.title }
            adapter.notifyDataSetChanged()
        }.addOnFailureListener {
            Toast.makeText(requireContext(), "Failed to load materials", Toast.LENGTH_SHORT).show()
            // Add sample data even on failure
            addSampleMaterials()
            adapter.notifyDataSetChanged()
        }
    }

    private fun addSampleMaterials() {
        // Mathematics Materials
        materialList.add(Material(
            "Algebra Fundamentals",
            "PDF",
            "https://academix.com/materials/algebra_basics.pdf"
        ))
        materialList.add(Material(
            "Calculus Introduction",
            "Video",
            "https://academix.com/videos/calc_intro.mp4"
        ))
        materialList.add(Material(
            "Geometry Practice Problems",
            "PDF",
            "https://academix.com/materials/geometry_practice.pdf"
        ))

        // Science Materials
        materialList.add(Material(
            "Chemistry Lab Safety Guide",
            "PDF",
            "https://academix.com/materials/lab_safety.pdf"
        ))
        materialList.add(Material(
            "Physics Experiments Demo",
            "Video",
            "https://academix.com/videos/physics_lab.mp4"
        ))
        materialList.add(Material(
            "Biology Cell Structure Notes",
            "PDF",
            "https://academix.com/materials/cell_structure.pdf"
        ))

        // English Materials
        materialList.add(Material(
            "Essay Writing Guide",
            "PDF",
            "https://academix.com/materials/essay_guide.pdf"
        ))
        materialList.add(Material(
            "Literature Analysis Methods",
            "Video",
            "https://academix.com/videos/lit_analysis.mp4"
        ))
        materialList.add(Material(
            "Grammar and Punctuation Rules",
            "PDF",
            "https://academix.com/materials/grammar_rules.pdf"
        ))
    }
}
