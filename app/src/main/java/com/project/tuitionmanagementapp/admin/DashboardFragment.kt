package com.project.tuitionmanagementapp.admin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.project.tuitionmanagementapp.R

class DashboardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dashboard_admin, container, false)

        // Initialize dummy summary values (these can be replaced with Firebase data)
        val tvTotalStudents: TextView = view.findViewById(R.id.tvTotalStudents)
        val tvTotalTeachers: TextView = view.findViewById(R.id.tvTotalTeachers)
        val tvTotalPayments: TextView = view.findViewById(R.id.tvTotalPayments)

        tvTotalStudents.text = "Total Students: 120"
        tvTotalTeachers.text = "Total Teachers: 10"
        tvTotalPayments.text = "Payments Collected: Rs. 145,000"

        return view
    }
}
