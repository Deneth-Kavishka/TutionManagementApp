package com.project.tuitionmanagementapp.teacher

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.project.tuitionmanagementapp.R

class AssignmentFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_assignments_teacher, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up the upload button to launch the AssignmentActivity
        view.findViewById<Button>(R.id.btnUploadAssignment)?.setOnClickListener {
            val intent = android.content.Intent(requireContext(), AssignmentActivity::class.java)
            startActivity(intent)
        }
    }
}
