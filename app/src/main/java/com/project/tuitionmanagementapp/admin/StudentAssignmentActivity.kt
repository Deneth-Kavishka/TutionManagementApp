package com.project.tuitionmanagementapp.admin

import android.os.Bundle
import android.widget.Button
import android.widget.SearchView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.project.tuitionmanagementapp.R

class StudentAssignmentActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference
    private lateinit var classId: String
    private lateinit var className: String
    private lateinit var classCategory: String
    private lateinit var studentsAdapter: StudentAssignmentAdapter
    private val studentsList = mutableListOf<StudentModel>()
    private val filteredStudentsList = mutableListOf<StudentModel>()
    private val assignedStudentIds = mutableSetOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_assignment)

        // Get class ID and category from intent
        classId = intent.getStringExtra("CLASS_ID") ?: ""
        classCategory = intent.getStringExtra("CLASS_CATEGORY") ?: ""

        if (classId.isEmpty()) {
            Toast.makeText(this, "Invalid class ID", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        // Initialize Firebase
        database = FirebaseDatabase.getInstance().reference

        // Set up views
        setupViews()

        // Load class details
        loadClassDetails()

        // Load students based on class category
        loadStudentsByCategory()
    }

    private fun setupViews() {
        // Set up title
        findViewById<TextView>(R.id.tvClassTitle).text = "Loading class details..."

        // Set up search
        val searchView = findViewById<SearchView>(R.id.searchStudents)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean = false

            override fun onQueryTextChange(newText: String?): Boolean {
                studentsAdapter.filter(newText ?: "")
                return true
            }
        })

        // Set up students RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.rvStudents)
        recyclerView.layoutManager = LinearLayoutManager(this)
        studentsAdapter = StudentAssignmentAdapter(
            studentsList,
            assignedStudentIds,
            onStudentCheckedChanged = { studentId, isChecked ->
                // Update assigned students in real-time
                if (isChecked) {
                    assignedStudentIds.add(studentId)
                } else {
                    assignedStudentIds.remove(studentId)
                }

                // Update the counter display
                updateAssignedCounter()
            }
        )
        recyclerView.adapter = studentsAdapter

        // Set up buttons
        findViewById<Button>(R.id.btnSaveAssignments).setOnClickListener {
            saveStudentAssignments()
        }

        findViewById<Button>(R.id.btnCancel).setOnClickListener {
            finish()
        }
    }

    private fun loadClassDetails() {
        database.child("classes").child(classId).addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val classModel = snapshot.getValue(ClassModel::class.java)
                if (classModel != null) {
                    className = classModel.name
                    findViewById<TextView>(R.id.tvClassTitle).text = "Assign Students to: ${classModel.name}"
                    findViewById<TextView>(R.id.tvClassDetails).text =
                        "${classModel.description}\nCategory: ${classModel.classCategory}\nTeacher: ${classModel.teacherName}\n" +
                        "Schedule: ${classModel.weekDay} ${classModel.classDate} ${classModel.startTime} - ${classModel.endTime}"
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@StudentAssignmentActivity, "Error loading class: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        })

        // Load already assigned students for this class
        database.child("students")
            .orderByChild("assignedClasses/$classId")
            .equalTo(true)
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    assignedStudentIds.clear()
                    for (studentSnapshot in snapshot.children) {
                        val studentId = studentSnapshot.key
                        if (studentId != null) {
                            assignedStudentIds.add(studentId)
                        }
                    }
                    // Update adapter
                    studentsAdapter.notifyDataSetChanged()
                    // Update counter
                    updateAssignedCounter()
                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(this@StudentAssignmentActivity, "Error loading assigned students", Toast.LENGTH_SHORT).show()
                }
            })
    }

    private fun loadStudentsByCategory() {
        // Load students who are registered under the same class category
        database.child("students")
            .orderByChild("classCategory")
            .equalTo(classCategory)
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    studentsList.clear()

                    if (snapshot.exists()) {
                        // Students found for this category
                        for (studentSnapshot in snapshot.children) {
                            val student = studentSnapshot.getValue(StudentModel::class.java)
                            student?.let {
                                it.id = studentSnapshot.key ?: ""
                                studentsList.add(it)
                            }
                        }
                    } else {
                        // No students found for this specific category, load all students
                        loadAllStudents()
                        return
                    }

                    studentsAdapter.notifyDataSetChanged()
                    updateAssignedCounter()

                    // Show category info
                    Toast.makeText(
                        this@StudentAssignmentActivity,
                        "Showing ${studentsList.size} students from '$classCategory' category",
                        Toast.LENGTH_LONG
                    ).show()
                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(this@StudentAssignmentActivity, "Error loading students: ${error.message}", Toast.LENGTH_SHORT).show()
                    // Fallback to loading all students
                    loadAllStudents()
                }
            })
    }

    private fun loadAllStudents() {
        // Fallback: Load all students if no category-specific students found
        database.child("students").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                studentsList.clear()
                for (studentSnapshot in snapshot.children) {
                    val student = studentSnapshot.getValue(StudentModel::class.java)
                    student?.let {
                        it.id = studentSnapshot.key ?: ""
                        studentsList.add(it)
                    }
                }
                studentsAdapter.notifyDataSetChanged()
                updateAssignedCounter()

                Toast.makeText(
                    this@StudentAssignmentActivity,
                    "No students found for '$classCategory'. Showing all ${studentsList.size} students.",
                    Toast.LENGTH_LONG
                ).show()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@StudentAssignmentActivity, "Error loading students: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun updateAssignedCounter() {
        findViewById<TextView>(R.id.tvAssignedCount).text = "Selected students: ${assignedStudentIds.size} / ${studentsList.size}"
    }

    private fun saveStudentAssignments() {
        if (assignedStudentIds.isEmpty()) {
            Toast.makeText(this, "Please select at least one student", Toast.LENGTH_SHORT).show()
            return
        }

        // Create a map of updates
        val updates = HashMap<String, Any?>()

        // For each student in the database, we need to set or remove the class assignment
        for (student in studentsList) {
            val isAssigned = assignedStudentIds.contains(student.id)
            if (isAssigned) {
                // Assign student to class
                updates["/students/${student.id}/assignedClasses/$classId"] = true
                // Also update the class's student list
                updates["/classes/$classId/assignedStudents/${student.id}"] = true
            } else {
                // Remove assignment if previously assigned
                updates["/students/${student.id}/assignedClasses/$classId"] = null
                updates["/classes/$classId/assignedStudents/${student.id}"] = null
            }
        }

        // Apply all updates in a single transaction
        database.updateChildren(updates)
            .addOnSuccessListener {
                Toast.makeText(this, "${assignedStudentIds.size} students assigned successfully to $className", Toast.LENGTH_SHORT).show()
                finish()
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error assigning students: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }
}

// Adapter for the student assignment list
class StudentAssignmentAdapter(
    private val studentsList: List<StudentModel>,
    private val assignedStudentIds: Set<String>,
    private val onStudentCheckedChanged: (String, Boolean) -> Unit
) : RecyclerView.Adapter<StudentAssignmentAdapter.StudentViewHolder>() {

    private var filteredStudentsList = studentsList.toList()

    fun filter(query: String) {
        filteredStudentsList = if (query.isEmpty()) {
            studentsList.toList()
        } else {
            studentsList.filter { student ->
                student.name.contains(query, ignoreCase = true) ||
                student.email.contains(query, ignoreCase = true) ||
                student.classCategory.contains(query, ignoreCase = true)
            }
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: android.view.ViewGroup, viewType: Int): StudentViewHolder {
        val view = android.view.LayoutInflater.from(parent.context)
            .inflate(R.layout.item_student_assignment, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = filteredStudentsList[position]
        holder.bind(student, assignedStudentIds.contains(student.id), onStudentCheckedChanged)
    }

    override fun getItemCount(): Int = filteredStudentsList.size

    class StudentViewHolder(itemView: android.view.View) : RecyclerView.ViewHolder(itemView) {
        private val tvStudentName: TextView = itemView.findViewById(R.id.tvStudentName)
        private val tvStudentDetails: TextView = itemView.findViewById(R.id.tvStudentDetails)
        private val checkBox: android.widget.CheckBox = itemView.findViewById(R.id.checkboxStudent)

        fun bind(student: StudentModel, isAssigned: Boolean, onCheckedChanged: (String, Boolean) -> Unit) {
            tvStudentName.text = student.name
            tvStudentDetails.text = "Email: ${student.email}\nCategory: ${student.classCategory}\nPhone: ${student.phone}"

            // Set checkbox state without triggering listener
            checkBox.setOnCheckedChangeListener(null)
            checkBox.isChecked = isAssigned

            // Set new listener
            checkBox.setOnCheckedChangeListener { _, isChecked ->
                onCheckedChanged(student.id, isChecked)
            }

            // Make whole item clickable
            itemView.setOnClickListener {
                checkBox.isChecked = !checkBox.isChecked
            }
        }
    }
}

// Updated Student model with class category
data class StudentModel(
    var id: String = "",
    val name: String = "",
    val email: String = "",
    val phone: String = "",
    val classCategory: String = "", // e.g., "2025 A/L Combined Maths"
    val assignedClasses: Map<String, Boolean> = mapOf()
)
