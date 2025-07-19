package com.project.tuitionmanagementapp.student

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.tuitionmanagementapp.R

class MaterialActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MaterialAdapter

    private val materialsList = arrayListOf(
        Material("Grade 12 Maths Notes", "PDF", "https://example.com/sample1.pdf"),
        Material("Biology Lecture", "Video", "https://www.youtube.com/watch?v=tZE_fQFK8EY")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_materials_student)  // Rename your layout file accordingly

        recyclerView = findViewById(R.id.recyclerViewMaterials)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = MaterialAdapter(materialsList)
        recyclerView.adapter = adapter
    }
}
