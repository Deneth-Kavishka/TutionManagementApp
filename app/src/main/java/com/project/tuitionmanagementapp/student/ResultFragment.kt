package com.project.tuitionmanagementapp.student


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.tuitionmanagementapp.R

class ResultActivity : AppCompatActivity() {

    private lateinit var resultRecyclerView: RecyclerView
    private lateinit var resultList: ArrayList<Result>
    private lateinit var adapter: ResultAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_result_student)

        resultRecyclerView = findViewById(R.id.recyclerViewResults)
        resultRecyclerView.layoutManager = LinearLayoutManager(this)

        resultList = arrayListOf(
            Result("Mathematics", 90, "A", "Excellent"),
            Result("Science", 82, "B+", "Good"),
            Result("English", 95, "A+", "Great job!")
        )

        adapter = ResultAdapter(resultList)
        resultRecyclerView.adapter = adapter
    }
}
