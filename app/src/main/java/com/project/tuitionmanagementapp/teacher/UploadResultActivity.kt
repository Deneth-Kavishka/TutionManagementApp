package com.project.tuitionmanagementapp.teacher

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.project.tuitionmanagementapp.R

class UploadResultActivity : AppCompatActivity() {

    private lateinit var etStudentId: EditText
    private lateinit var spinnerGrade: Spinner
    private lateinit var etSubject: EditText
    private lateinit var etResultMark: EditText
    private lateinit var btnAddResult: Button
    private lateinit var recyclerView: RecyclerView

    private val resultList = mutableListOf<ResultModel>()
    private val keyList = mutableListOf<String>()
    private lateinit var adapter: ResultAdapter

    private val dbRef = FirebaseDatabase.getInstance().getReference("student_results")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_result)



        etStudentId = findViewById(R.id.etStudentId)
        spinnerGrade = findViewById(R.id.spinnerGrade)
        etSubject = findViewById(R.id.etSubject)
        etResultMark = findViewById(R.id.etResultMark)
        btnAddResult = findViewById(R.id.btnAddResult)
        recyclerView = findViewById(R.id.recyclerViewResults)

        val grades = listOf("Select Grade", "Grade 7", "Grade 8", "Grade 9", "Grade 10")
        spinnerGrade.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, grades)

        adapter = ResultAdapter(
            resultList,
            onEdit = { result, key -> showEditDialog(result, key) },
            onDelete = { key -> deleteResult(key) }
        )
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        btnAddResult.setOnClickListener {
            val studentId = etStudentId.text.toString().trim()
            val grade = spinnerGrade.selectedItem.toString()
            val subject = etSubject.text.toString().trim()
            val markText = etResultMark.text.toString().trim()

            if (studentId.isEmpty() || grade == "Select Grade" || subject.isEmpty() || markText.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val mark = markText.toIntOrNull()
            if (mark == null || mark < 0 || mark > 100) {
                Toast.makeText(this, "Enter a valid mark (0–100)", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val resultGrade = when {
                mark >= 90 -> "A+"
                mark >= 85 -> "A"
                mark >= 75 -> "A-"
                mark >= 65 -> "B+"
                mark >= 60 -> "B"
                mark >= 55 -> "B-"
                mark >= 50 -> "C+"
                mark >= 45 -> "C"
                mark >= 40 -> "C-"
                else -> "Fail"
            }

            val data = ResultModel(studentId, grade, subject, "$mark - $resultGrade")

            val key = dbRef.push().key ?: return@setOnClickListener
            dbRef.child(key).setValue(data)
                .addOnSuccessListener {
                    resultList.add(data)
                    keyList.add(key)
                    adapter.setKeys(keyList)
                    adapter.notifyItemInserted(resultList.size - 1)
                    clearInputs()
                    Toast.makeText(this, "Result Uploaded", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener {
                    Toast.makeText(this, "Upload Failed: ${it.message}", Toast.LENGTH_SHORT).show()
                }
        }

        loadResults()
    }

    private fun loadResults() {
        dbRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                resultList.clear()
                keyList.clear()
                for (child in snapshot.children) {
                    val result = child.getValue(ResultModel::class.java)
                    if (result != null) {
                        resultList.add(result)
                        keyList.add(child.key!!)
                    }
                }
                adapter.setKeys(keyList)
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@UploadResultActivity, "Failed to load results", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun clearInputs() {
        etStudentId.setText("")
        etSubject.setText("")
        etResultMark.setText("")
        spinnerGrade.setSelection(0)
    }

    private fun showEditDialog(result: ResultModel, key: String) {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_edit_result, null)
        val editMark = dialogView.findViewById<EditText>(R.id.etEditMark)
        editMark.setText(result.result.split(" - ")[0])

        AlertDialog.Builder(this)
            .setTitle("Edit Result")
            .setView(dialogView)
            .setPositiveButton("Update") { _, _ ->
                val newMark = editMark.text.toString().trim().toIntOrNull()
                if (newMark == null || newMark !in 0..100) {
                    Toast.makeText(this, "Invalid mark", Toast.LENGTH_SHORT).show()
                    return@setPositiveButton
                }

                val newGrade = when {
                    newMark >= 90 -> "A+"
                    newMark >= 85 -> "A"
                    newMark >= 75 -> "A-"
                    newMark >= 65 -> "B+"
                    newMark >= 60 -> "B"
                    newMark >= 55 -> "B-"
                    newMark >= 50 -> "C+"
                    newMark >= 45 -> "C"
                    newMark >= 40 -> "C-"
                    else -> "Fail"
                }

                val updatedResult = result.copy(result = "$newMark - $newGrade")
                dbRef.child(key).setValue(updatedResult)
                    .addOnSuccessListener {
                        val index = keyList.indexOf(key)
                        if (index != -1) {
                            resultList[index] = updatedResult
                            adapter.notifyItemChanged(index)
                        }
                        Toast.makeText(this, "Result Updated", Toast.LENGTH_SHORT).show()
                    }
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    private fun deleteResult(key: String) {
        dbRef.child(key).removeValue()
            .addOnSuccessListener {
                val index = keyList.indexOf(key)
                if (index != -1) {
                    resultList.removeAt(index)
                    keyList.removeAt(index)
                    adapter.setKeys(keyList)
                    adapter.notifyItemRemoved(index)
                    Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener {
                Toast.makeText(this, "Delete failed", Toast.LENGTH_SHORT).show()
            }
    }

    }

