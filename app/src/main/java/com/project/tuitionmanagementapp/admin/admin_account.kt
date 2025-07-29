package com.project.tuitionmanagementapp.admin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.project.tuitionmanagementapp.R
import com.project.tuitionmanagementapp.admin.AddStudentActivity
import com.project.tuitionmanagementapp.admin.AddTeacherActivity
import com.project.tuitionmanagementapp.models.Student
import com.project.tuitionmanagementapp.models.Teacher

class admin_account : Fragment() {

    private lateinit var usersAdapter: UsersAdapter
    private lateinit var searchView: SearchView
    private lateinit var filterDropdown: AutoCompleteTextView
    private lateinit var recyclerView: RecyclerView

    // Sample data with more detailed information
    private val studentsList = mutableListOf(
        Student(
            id = "1",
            firstName = "Kamal",
            lastName = "Perera",
            studentEmail = "kamal.perera@email.com",
            currentGrade = "Grade 10",
            studentPhone = "0771234567",
            gender = "Male",
            address = "123 Main Street",
            city = "Colombo",
            guardianName = "Mr. Perera",
            guardianPhone = "0771234568",
            totalFees = 15000.0,
            paidAmount = 12000.0,
            pendingAmount = 3000.0
        ),
        Student(
            id = "2",
            firstName = "Nimali",
            lastName = "Silva",
            studentEmail = "nimali.silva@email.com",
            currentGrade = "Grade 9",
            studentPhone = "0779876543",
            gender = "Female",
            address = "456 School Lane",
            city = "Kandy",
            guardianName = "Mrs. Silva",
            guardianPhone = "0779876544",
            totalFees = 14000.0,
            paidAmount = 14000.0,
            pendingAmount = 0.0
        ),
        Student(
            id = "3",
            firstName = "Sunil",
            lastName = "Fernando",
            studentEmail = "sunil.fernando@email.com",
            currentGrade = "Grade 11",
            studentPhone = "0712345678",
            gender = "Male",
            address = "789 College Road",
            city = "Galle",
            guardianName = "Mr. Fernando",
            guardianPhone = "0712345679",
            totalFees = 18000.0,
            paidAmount = 10000.0,
            pendingAmount = 8000.0
        ),
        Student(
            id = "4",
            firstName = "Anusha",
            lastName = "Rathnayake",
            studentEmail = "anusha.rathnayake@email.com",
            currentGrade = "Grade 8",
            studentPhone = "0765432109",
            gender = "Female",
            address = "321 Park Avenue",
            city = "Matara",
            guardianName = "Mrs. Rathnayake",
            guardianPhone = "0765432110",
            totalFees = 13000.0,
            paidAmount = 13000.0,
            pendingAmount = 0.0
        )
    )

    private val teachersList = mutableListOf(
        Teacher(
            id = "1",
            firstName = "Samantha",
            lastName = "Rathnayake",
            email = "samantha.rathnayake@email.com",
            subjects = listOf("Mathematics"),
            phone = "0717777777",
            gender = "Female",
            address = "123 Teacher Lane",
            city = "Colombo",
            experience = "5 years"
        ),
        Teacher(
            id = "2",
            firstName = "Pradeep",
            lastName = "Silva",
            email = "pradeep.silva@email.com",
            subjects = listOf("Science"),
            phone = "0718888888",
            gender = "Male",
            address = "456 Education Street",
            city = "Kandy",
            experience = "8 years"
        ),
        Teacher(
            id = "3",
            firstName = "Nimesha",
            lastName = "Fernando",
            email = "nimesha.fernando@email.com",
            subjects = listOf("English"),
            phone = "0719999999",
            gender = "Female",
            address = "789 Academy Road",
            city = "Galle",
            experience = "3 years"
        ),
        Teacher(
            id = "4",
            firstName = "Kasun",
            lastName = "Perera",
            email = "kasun.perera@email.com",
            subjects = listOf("ICT"),
            phone = "0711111111",
            gender = "Male",
            address = "321 Tech Avenue",
            city = "Colombo",
            experience = "6 years"
        )
    )

    private var allUsers = mutableListOf<Any>()
    private var filteredUsers = mutableListOf<Any>()
    private var currentFilter = "All"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return try {
            inflater.inflate(R.layout.fragment_manage_users, container, false)
        } catch (e: Exception) {
            Log.e("AdminAccount", "Error inflating layout", e)
            createFallbackView()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        try {
            initializeData()
            setupViews(view)
            setupRecyclerView(view)
            setupSearch(view)
            setupFilter(view)
            setupButtons(view)
            updateCounts(view)
        } catch (e: Exception) {
            Log.e("AdminAccount", "Error setting up views", e)
            Toast.makeText(context, "Account management is temporarily unavailable", Toast.LENGTH_SHORT).show()
        }
    }

    private fun createFallbackView(): View {
        return TextView(requireContext()).apply {
            text = "Account Management\n\nThis feature is being updated.\nPlease try again later."
            textAlignment = View.TEXT_ALIGNMENT_CENTER
            textSize = 16f
            setPadding(32, 32, 32, 32)
        }
    }

    private fun initializeData() {
        allUsers.clear()
        allUsers.addAll(studentsList)
        allUsers.addAll(teachersList)
        filteredUsers.clear()
        filteredUsers.addAll(allUsers)
    }

    private fun setupViews(view: View) {
        searchView = view.findViewById(R.id.idSV)
        filterDropdown = view.findViewById(R.id.autoCompleteID)
        recyclerView = view.findViewById(R.id.usersRecyclerView) ?: createRecyclerView(view)
    }

    private fun createRecyclerView(view: View): RecyclerView {
        // If RecyclerView doesn't exist in layout, create it dynamically
        val recyclerView = RecyclerView(requireContext()).apply {
            id = R.id.usersRecyclerView
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        }

        // Find the container and add RecyclerView
        val container = view.findViewById<LinearLayout>(R.id.usersContainer)
            ?: view.findViewById<ViewGroup>(android.R.id.content)
        container?.addView(recyclerView)

        return recyclerView
    }

    private fun setupRecyclerView(view: View) {
        usersAdapter = UsersAdapter(filteredUsers) { user, action ->
            when (action) {
                "view" -> viewUserDetails(user)
                "edit" -> editUser(user)
                "delete" -> deleteUser(user)
            }
        }

        recyclerView.apply {
            adapter = usersAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun setupSearch(view: View) {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                filterUsers(query ?: "", currentFilter)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterUsers(newText ?: "", currentFilter)
                return true
            }
        })
    }

    private fun setupFilter(view: View) {
        val filterOptions = arrayOf("All", "Students", "Teachers", "Grade 8", "Grade 9", "Grade 10", "Grade 11")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, filterOptions)
        filterDropdown.setAdapter(adapter)
        filterDropdown.setText("All", false)

        filterDropdown.setOnItemClickListener { _, _, position, _ ->
            currentFilter = filterOptions[position]
            filterUsers(searchView.query.toString(), currentFilter)
        }
    }

    private fun filterUsers(query: String, filter: String) {
        filteredUsers.clear()

        val baseList = when (filter) {
            "Students" -> studentsList.toList()
            "Teachers" -> teachersList.toList()
            "Grade 8", "Grade 9", "Grade 10", "Grade 11" ->
                studentsList.filter { it.grade == filter }
            else -> allUsers
        }

        if (query.isEmpty()) {
            filteredUsers.addAll(baseList)
        } else {
            filteredUsers.addAll(baseList.filter { user ->
                when (user) {
                    is Student -> {
                        user.firstName.contains(query, true) ||
                        user.lastName.contains(query, true) ||
                        user.email.contains(query, true) ||
                        user.grade.contains(query, true)
                    }
                    is Teacher -> {
                        user.firstName.contains(query, true) ||
                        user.lastName.contains(query, true) ||
                        user.email.contains(query, true) ||
                        user.subject.contains(query, true)
                    }
                    else -> false
                }
            })
        }

        usersAdapter.notifyDataSetChanged()
        updateCounts(requireView())
    }

    private fun setupButtons(view: View) {
        // Add Student Button
        view.findViewById<com.google.android.material.button.MaterialButton>(R.id.btnAddStudent)?.setOnClickListener {
            try {
                Log.d("AdminAccount", "Add Student button clicked")
                val intent = Intent(requireActivity(), AddStudentActivity::class.java)
                startActivity(intent)
            } catch (e: Exception) {
                Log.e("AdminAccount", "Error starting AddStudentActivity", e)
                Toast.makeText(context, "Add Student feature temporarily unavailable: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }

        // Add Teacher Button
        view.findViewById<com.google.android.material.button.MaterialButton>(R.id.btnAddTeacher)?.setOnClickListener {
            try {
                Log.d("AdminAccount", "Add Teacher button clicked")
                val intent = Intent(requireActivity(), AddTeacherActivity::class.java)
                startActivity(intent)
            } catch (e: Exception) {
                Log.e("AdminAccount", "Error starting AddTeacherActivity", e)
                Toast.makeText(context, "Add Teacher feature temporarily unavailable: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }

        // Notification Button
        view.findViewById<ImageButton>(R.id.notificationButton)?.setOnClickListener {
            try {
                val intent = Intent(requireContext(), Notifications::class.java)
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(context, "Notifications feature will be implemented", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun updateCounts(view: View) {
        val studentCount = filteredUsers.count { it is Student }
        val teacherCount = filteredUsers.count { it is Teacher }

        view.findViewById<TextView>(R.id.title)?.text = studentCount.toString()
        view.findViewById<TextView>(R.id.teacherCountAmu)?.text = teacherCount.toString()
    }

    private fun viewUserDetails(user: Any) {
        when (user) {
            is Student -> showStudentDetails(user)
            is Teacher -> showTeacherDetails(user)
        }
    }

    private fun editUser(user: Any) {
        when (user) {
            is Student -> editStudent(user)
            is Teacher -> editTeacher(user)
        }
    }

    private fun deleteUser(user: Any) {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Delete ${if (user is Student) "Student" else "Teacher"}")
            .setMessage("Are you sure you want to delete this ${if (user is Student) "student" else "teacher"}? This action cannot be undone.")
            .setPositiveButton("Delete") { _, _ ->
                when (user) {
                    is Student -> {
                        studentsList.remove(user)
                        Toast.makeText(context, "Student deleted successfully", Toast.LENGTH_SHORT).show()
                    }
                    is Teacher -> {
                        teachersList.remove(user)
                        Toast.makeText(context, "Teacher deleted successfully", Toast.LENGTH_SHORT).show()
                    }
                }
                initializeData()
                filterUsers(searchView.query.toString(), currentFilter)
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    private fun showStudentDetails(student: Student) {
        try {
            val dialog = BottomSheetDialog(requireContext())
            val view = layoutInflater.inflate(R.layout.student_acc_info_admin, null)

            // Populate student details using the correct IDs from the layout
            try {
                view.findViewById<TextView>(R.id.Fname)?.text = "First Name: ${student.firstName}"
                view.findViewById<TextView>(R.id.Lname)?.text = "Last Name: ${student.lastName}"
                view.findViewById<TextView>(R.id.mail)?.text = "Email: ${student.studentEmail}"
                view.findViewById<TextView>(R.id.school)?.text = "Grade: ${student.currentGrade}"
                view.findViewById<TextView>(R.id.contactNo)?.text = "Contact number: ${student.studentPhone}"
                view.findViewById<TextView>(R.id.gender)?.text = "Gender: ${student.gender}"
                view.findViewById<TextView>(R.id.Address)?.text = "Address: ${student.address}"
                view.findViewById<TextView>(R.id.city)?.text = "City: ${student.city}"
            } catch (e: Exception) {
                Log.d("AdminAccount", "Error setting name fields")
            }

            // Setup close button using the correct ID
            view.findViewById<Button>(R.id.closeAccInfoBtn)?.setOnClickListener {
                dialog.dismiss()
            }

            dialog.setContentView(view)
            dialog.show()
        } catch (e: Exception) {
            Toast.makeText(context, "Student details: $student", Toast.LENGTH_LONG).show()
        }
    }

    private fun showTeacherDetails(teacher: Teacher) {
        try {
            val dialog = BottomSheetDialog(requireContext())
            val view = layoutInflater.inflate(R.layout.teacher_acc_info_admin, null)

            // Populate teacher details using the correct IDs from the layout
            try {
                view.findViewById<TextView>(R.id.Fname)?.text = "First Name: ${teacher.firstName}"
                view.findViewById<TextView>(R.id.Lname)?.text = "Last Name: ${teacher.lastName}"
                view.findViewById<TextView>(R.id.mail)?.text = "Email: ${teacher.email}"
                view.findViewById<TextView>(R.id.speciality)?.text = "Specialty: ${teacher.subject}"
                view.findViewById<TextView>(R.id.contactNo)?.text = "Contact number: ${teacher.phone}"
                view.findViewById<TextView>(R.id.gender)?.text = "Gender: ${teacher.gender}"
                view.findViewById<TextView>(R.id.city)?.text = "City: ${teacher.city}"
            } catch (e: Exception) {
                Log.d("AdminAccount", "Error setting teacher fields")
            }

            // Setup close button using the correct ID
            view.findViewById<Button>(R.id.closeAccInfoBtnTeacher)?.setOnClickListener {
                dialog.dismiss()
            }

            dialog.setContentView(view)
            dialog.show()
        } catch (e: Exception) {
            Toast.makeText(context, "Teacher details: $teacher", Toast.LENGTH_LONG).show()
        }
    }

    private fun editStudent(student: Student) {
        val dialog = BottomSheetDialog(requireContext())
        val view = layoutInflater.inflate(R.layout.dialog_edit_student, null)

        // Pre-populate fields with current student data
        view.findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.etEditFirstName)?.setText(student.firstName)
        view.findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.etEditLastName)?.setText(student.lastName)
        view.findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.etEditEmail)?.setText(student.email)
        view.findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.etEditPhone)?.setText(student.phone)
        view.findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.etEditAddress)?.setText(student.address)

        // Setup Grade dropdown
        val gradeDropdown = view.findViewById<AutoCompleteTextView>(R.id.etEditGrade)
        val grades = arrayOf("Grade 6", "Grade 7", "Grade 8", "Grade 9", "Grade 10", "Grade 11", "A/L")
        val gradeAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, grades)
        gradeDropdown?.setAdapter(gradeAdapter)
        gradeDropdown?.setText(student.grade, false)

        // Setup Gender dropdown
        val genderDropdown = view.findViewById<AutoCompleteTextView>(R.id.etEditGender)
        val genders = arrayOf("Male", "Female", "Other")
        val genderAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, genders)
        genderDropdown?.setAdapter(genderAdapter)
        genderDropdown?.setText(student.gender, false)

        // Save button click listener
        view.findViewById<com.google.android.material.button.MaterialButton>(R.id.btnSaveEdit)?.setOnClickListener {
            val updatedStudent = student.copy(
                firstName = view.findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.etEditFirstName)?.text.toString(),
                lastName = view.findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.etEditLastName)?.text.toString(),
                email = view.findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.etEditEmail)?.text.toString(),
                grade = gradeDropdown?.text.toString(),
                phone = view.findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.etEditPhone)?.text.toString(),
                gender = genderDropdown?.text.toString(),
                address = view.findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.etEditAddress)?.text.toString()
            )

            // Update the student in the list
            val index = studentsList.indexOfFirst { it.id == student.id }
            if (index != -1) {
                studentsList[index] = updatedStudent
                initializeData()
                filterUsers(searchView.query.toString(), currentFilter)
                Toast.makeText(context, "Student updated successfully", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
        }

        // Cancel button click listener
        view.findViewById<com.google.android.material.button.MaterialButton>(R.id.btnCancelEdit)?.setOnClickListener {
            dialog.dismiss()
        }

        dialog.setContentView(view)
        dialog.show()
    }

    private fun editTeacher(teacher: Teacher) {
        val dialog = BottomSheetDialog(requireContext())
        val view = layoutInflater.inflate(R.layout.dialog_edit_teacher, null)

        // Pre-populate fields with current teacher data
        view.findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.etEditFirstName)?.setText(teacher.firstName)
        view.findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.etEditLastName)?.setText(teacher.lastName)
        view.findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.etEditEmail)?.setText(teacher.email)
        view.findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.etEditPhone)?.setText(teacher.phone)
        view.findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.etEditAddress)?.setText(teacher.address)

        // Setup Subject dropdown
        val subjectDropdown = view.findViewById<AutoCompleteTextView>(R.id.etEditSubject)
        val subjects = arrayOf("Mathematics", "Science", "English", "Sinhala", "History", "Geography", "ICT", "Business Studies", "Economics", "Physics", "Chemistry", "Biology")
        val subjectAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, subjects)
        subjectDropdown?.setAdapter(subjectAdapter)
        subjectDropdown?.setText(teacher.subject, false)

        // Setup Gender dropdown
        val genderDropdown = view.findViewById<AutoCompleteTextView>(R.id.etEditGender)
        val genders = arrayOf("Male", "Female", "Other")
        val genderAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, genders)
        genderDropdown?.setAdapter(genderAdapter)
        genderDropdown?.setText(teacher.gender, false)

        // Save button click listener
        view.findViewById<com.google.android.material.button.MaterialButton>(R.id.btnSaveEdit)?.setOnClickListener {
            val updatedTeacher = teacher.copy(
                firstName = view.findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.etEditFirstName)?.text.toString(),
                lastName = view.findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.etEditLastName)?.text.toString(),
                email = view.findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.etEditEmail)?.text.toString(),
                subject = subjectDropdown?.text.toString(),
                phone = view.findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.etEditPhone)?.text.toString(),
                gender = genderDropdown?.text.toString(),
                address = view.findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.etEditAddress)?.text.toString()
            )

            // Update the teacher in the list
            val index = teachersList.indexOfFirst { it.id == teacher.id }
            if (index != -1) {
                teachersList[index] = updatedTeacher
                initializeData()
                filterUsers(searchView.query.toString(), currentFilter)
                Toast.makeText(context, "Teacher updated successfully", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
        }

        // Cancel button click listener
        view.findViewById<com.google.android.material.button.MaterialButton>(R.id.btnCancelEdit)?.setOnClickListener {
            dialog.dismiss()
        }

        dialog.setContentView(view)
        dialog.show()
    }
}