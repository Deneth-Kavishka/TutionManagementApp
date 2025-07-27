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

class ResultFragment : Fragment() {

    private lateinit var resultRecyclerView: RecyclerView
    private lateinit var resultList: ArrayList<StudentResult>
    private lateinit var adapter: ResultAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_result_student, container, false)

        resultRecyclerView = view.findViewById(R.id.recyclerViewResults)
        resultRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        resultList = arrayListOf()
        adapter = ResultAdapter(resultList)
        resultRecyclerView.adapter = adapter

        val studentId = "S001" // TODO: Make dynamic based on login
        loadResultsFromFirebase(studentId)

        return view
    }

    private fun loadResultsFromFirebase(studentId: String) {
        val database = FirebaseDatabase.getInstance()
        val resultsRef = database.getReference("results").child(studentId)

        resultsRef.get().addOnSuccessListener { snapshot ->
            resultList.clear()
            for (resultSnapshot in snapshot.children) {
                val result = resultSnapshot.getValue(StudentResult::class.java)
                result?.let {
                    resultList.add(it)
                }
            }
            // If no results found, add sample data
            if (resultList.isEmpty()) {
                resultList.add(StudentResult("Mathematics", 85, "A", "Excellent work!"))
                resultList.add(StudentResult("Science", 78, "B+", "Good effort!"))
                resultList.add(StudentResult("English", 92, "A+", "Outstanding!"))
            }
            adapter.notifyDataSetChanged()
        }.addOnFailureListener {
            Toast.makeText(requireContext(), "Failed to load results", Toast.LENGTH_SHORT).show()
        }
    }
}
