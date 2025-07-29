package com.project.tuitionmanagementapp.admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.tabs.TabLayout
import com.project.tuitionmanagementapp.R

class admin_assign : Fragment() {

    private val assignmentsList = mutableListOf(
        "Grade 10 Mathematics - Mrs. Samantha Rathnayake",
        "Grade 9 Science - Mr. Pradeep Silva",
        "Grade 11 Physics - Ms. Nimesha Fernando",
        "Grade 8 English - Mr. Kasun Perera",
        "A/L Biology - Dr. Sunil Jayawardena"
    )

    private val teachersList = listOf(
        "Mrs. Samantha Rathnayake - Mathematics",
        "Mr. Pradeep Silva - Science",
        "Ms. Nimesha Fernando - Physics",
        "Mr. Kasun Perera - English",
        "Dr. Sunil Jayawardena - Biology"
    )

    private val classesList = listOf(
        "Grade 6 Mathematics",
        "Grade 7 Science",
        "Grade 8 English",
        "Grade 9 Mathematics",
        "Grade 10 Science",
        "Grade 11 Physics",
        "A/L Biology",
        "A/L Chemistry"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_admin_assignment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupSpinner(view)
        setupTabLayout(view)
        setupRecyclerView(view)
        setupButtons(view)
    }

    private fun setupSpinner(view: View) {
        val spinner = view.findViewById<Spinner>(R.id.spinnerClasses)
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, classesList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }

    private fun setupTabLayout(view: View) {
        val tabLayout = view.findViewById<TabLayout>(R.id.tabLayout)
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                // Handle tab selection
                when (tab?.position) {
                    0 -> loadStudentAssignments()
                    1 -> loadTeacherAssignments()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }

    private fun setupRecyclerView(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.rvAssignments)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Create a simple adapter for the assignments
        val adapter = object : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
                val textView = TextView(context).apply {
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    setPadding(16, 16, 16, 16)
                    textSize = 16f
                }
                return object : RecyclerView.ViewHolder(textView) {}
            }

            override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
                (holder.itemView as TextView).text = assignmentsList[position]
                holder.itemView.setOnClickListener {
                    showAssignmentDetailsDialog(assignmentsList[position])
                }
            }

            override fun getItemCount(): Int = assignmentsList.size
        }

        recyclerView.adapter = adapter
    }

    private fun setupButtons(view: View) {
        view.findViewById<Button>(R.id.btnAssign).setOnClickListener {
            showAddAssignmentDialog()
        }

        view.findViewById<Button>(R.id.btnUnassign).setOnClickListener {
            showUnassignedClassesDialog()
        }
    }

    private fun loadStudentAssignments() {
        // Load student assignments - for future implementation
        Toast.makeText(context, "Student assignments loaded", Toast.LENGTH_SHORT).show()
    }

    private fun loadTeacherAssignments() {
        // Load teacher assignments - for future implementation
        Toast.makeText(context, "Teacher assignments loaded", Toast.LENGTH_SHORT).show()
    }

    private fun showAddAssignmentDialog() {
        val dialog = BottomSheetDialog(requireContext())

        // Create assignment dialog programmatically
        val view = LinearLayout(requireContext()).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(50, 50, 50, 50)
        }

        val teacherSpinner = Spinner(requireContext()).apply {
            val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, teachersList)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            this.adapter = adapter
        }

        val classSpinner = Spinner(requireContext()).apply {
            val unassignedClasses = getUnassignedClasses()
            val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, unassignedClasses)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            this.adapter = adapter
        }

        val assignButton = Button(requireContext()).apply {
            text = "Create Assignment"
            setOnClickListener {
                val teacher = teacherSpinner.selectedItem.toString()
                val selectedClass = classSpinner.selectedItem.toString()

                if (teacher.isNotEmpty() && selectedClass.isNotEmpty()) {
                    val teacherName = teacher.split(" - ")[0]
                    val newAssignment = "$selectedClass - $teacherName"
                    assignmentsList.add(newAssignment)
                    view.findViewById<RecyclerView>(R.id.rvAssignments)?.adapter?.notifyDataSetChanged()
                    Toast.makeText(context, "Assignment created successfully", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                } else {
                    Toast.makeText(context, "Please select both teacher and class", Toast.LENGTH_SHORT).show()
                }
            }
        }

        val cancelButton = Button(requireContext()).apply {
            text = "Cancel"
            setOnClickListener { dialog.dismiss() }
        }

        view.addView(TextView(requireContext()).apply { text = "Select Teacher:" })
        view.addView(teacherSpinner)
        view.addView(TextView(requireContext()).apply { text = "Select Class:" })
        view.addView(classSpinner)
        view.addView(assignButton)
        view.addView(cancelButton)

        dialog.setContentView(view)
        dialog.show()
    }

    private fun showUnassignedClassesDialog() {
        val unassignedClasses = getUnassignedClasses()
        val message = if (unassignedClasses.isEmpty()) {
            "All classes are assigned!"
        } else {
            "Unassigned Classes:\n${unassignedClasses.joinToString("\n")}"
        }

        android.app.AlertDialog.Builder(requireContext())
            .setTitle("Unassigned Classes")
            .setMessage(message)
            .setPositiveButton("OK", null)
            .show()
    }

    private fun showAssignmentDetailsDialog(assignment: String) {
        val options = arrayOf("Edit", "Remove")

        android.app.AlertDialog.Builder(requireContext())
            .setTitle(assignment)
            .setItems(options) { _, which ->
                when (which) {
                    0 -> Toast.makeText(context, "Edit functionality will be implemented", Toast.LENGTH_SHORT).show()
                    1 -> {
                        assignmentsList.remove(assignment)
                        view?.findViewById<RecyclerView>(R.id.rvAssignments)?.adapter?.notifyDataSetChanged()
                        Toast.makeText(context, "Assignment removed", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            .show()
    }

    private fun getUnassignedClasses(): List<String> {
        val assignedClasses = assignmentsList.map { it.split(" - ")[0] }
        return classesList.filter { !assignedClasses.contains(it) }
    }
}
