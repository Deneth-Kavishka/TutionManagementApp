package com.project.tuitionmanagementapp.admin

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.project.tuitionmanagementapp.R
import com.project.tuitionmanagementapp.models.Student
import com.project.tuitionmanagementapp.models.Teacher

class ManageUserFragment : Fragment() {
    
    private val db = FirebaseFirestore.getInstance()
    private lateinit var btnAddStudent: Button
    private lateinit var btnAddTeacher: Button
    private lateinit var btnManageClassCategories: Button
    private lateinit var btnViewAllStudents: Button
    private lateinit var btnViewAllTeachers: Button
    private lateinit var rvRecentStudents: RecyclerView
    private lateinit var rvRecentTeachers: RecyclerView
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_manage_user, container, false)
        
        initializeViews(view)
        setupClickListeners()
        loadRecentData()
        
        return view
    }
    
    private fun initializeViews(view: View) {
        btnAddStudent = view.findViewById(R.id.btnAddStudent)
        btnAddTeacher = view.findViewById(R.id.btnAddTeacher)
        btnManageClassCategories = view.findViewById(R.id.btnManageClassCategories)
        btnViewAllStudents = view.findViewById(R.id.btnViewAllStudents)
        btnViewAllTeachers = view.findViewById(R.id.btnViewAllTeachers)
        rvRecentStudents = view.findViewById(R.id.rvRecentStudents)
        rvRecentTeachers = view.findViewById(R.id.rvRecentTeachers)
    }
    
    private fun setupClickListeners() {
        btnAddStudent.setOnClickListener {
            val intent = Intent(requireContext(), AddStudentActivity::class.java)
            startActivity(intent)
        }
        
        btnAddTeacher.setOnClickListener {
            val intent = Intent(requireContext(), AddTeacherActivity::class.java)
            startActivity(intent)
        }
        
        btnManageClassCategories.setOnClickListener {
            val intent = Intent(requireContext(), ManageClassCategoriesActivity::class.java)
            startActivity(intent)
        }
        
        btnViewAllStudents.setOnClickListener {
            // Navigate to all students view
            showAllStudents()
        }
        
        btnViewAllTeachers.setOnClickListener {
            // Navigate to all teachers view
            showAllTeachers()
        }
    }
    
    private fun loadRecentData() {
        loadRecentStudents()
        loadRecentTeachers()
    }
    
    private fun loadRecentStudents() {
        db.collection("students")
            .whereEqualTo("isActive", true)
            .orderBy("registrationDate", com.google.firebase.firestore.Query.Direction.DESCENDING)
            .limit(5)
            .get()
            .addOnSuccessListener { documents ->
                val students = documents.map { doc ->
                    doc.toObject(Student::class.java).copy(id = doc.id)
                }
                setupRecentStudentsRecyclerView(students)
            }
            .addOnFailureListener { exception ->
                Toast.makeText(requireContext(), "Error loading recent students: ${exception.message}", 
                    Toast.LENGTH_SHORT).show()
            }
    }
    
    private fun loadRecentTeachers() {
        db.collection("teachers")
            .whereEqualTo("isActive", true)
            .orderBy("createdDate", com.google.firebase.firestore.Query.Direction.DESCENDING)
            .limit(5)
            .get()
            .addOnSuccessListener { documents ->
                val teachers = documents.map { doc ->
                    doc.toObject(Teacher::class.java).copy(id = doc.id)
                }
                setupRecentTeachersRecyclerView(teachers)
            }
            .addOnFailureListener { exception ->
                Toast.makeText(requireContext(), "Error loading recent teachers: ${exception.message}", 
                    Toast.LENGTH_SHORT).show()
            }
    }
    
    private fun setupRecentStudentsRecyclerView(students: List<Student>) {
        val adapter = RecentStudentsAdapter(
            students,
            onItemClick = { student -> viewStudentDetails(student) },
            onPaymentClick = { student -> processPayment(student) }
        )
        rvRecentStudents.layoutManager = LinearLayoutManager(requireContext())
        rvRecentStudents.adapter = adapter
    }
    
    private fun setupRecentTeachersRecyclerView(teachers: List<Teacher>) {
        val adapter = RecentTeachersAdapter(teachers) { teacher ->
            // Handle teacher item click
            viewTeacherDetails(teacher)
        }
        rvRecentTeachers.layoutManager = LinearLayoutManager(requireContext())
        rvRecentTeachers.adapter = adapter
    }
    
    private fun viewStudentDetails(student: Student) {
        // Navigate to student details activity
        val intent = Intent(requireContext(), StudentDetailsActivity::class.java)
        intent.putExtra("student_id", student.id)
        startActivity(intent)
    }
    
    private fun viewTeacherDetails(teacher: Teacher) {
        // Navigate to teacher details activity
        Toast.makeText(requireContext(), "Teacher Details: ${teacher.fullName}", Toast.LENGTH_SHORT).show()
        // TODO: Create TeacherDetailsActivity and navigate to it
    }

    private fun processPayment(student: Student) {
        val intent = Intent(requireContext(), StudentPaymentActivity::class.java)
        intent.putExtra("student_id", student.id)
        startActivity(intent)
    }
    
    private fun showAllStudents() {
        // Navigate to all students activity
        Toast.makeText(requireContext(), "View All Students feature to be implemented", Toast.LENGTH_SHORT).show()
    }
    
    private fun showAllTeachers() {
        // Navigate to all teachers activity
        Toast.makeText(requireContext(), "View All Teachers feature to be implemented", Toast.LENGTH_SHORT).show()
    }
    
    override fun onResume() {
        super.onResume()
        // Refresh data when returning to this fragment
        loadRecentData()
    }
}
