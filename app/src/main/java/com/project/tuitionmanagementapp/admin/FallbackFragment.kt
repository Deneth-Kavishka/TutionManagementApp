package com.project.tuitionmanagementapp.admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class FallbackFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, container, false)
        val textView = view.findViewById<TextView>(android.R.id.text1)
        textView.text = "Something went wrong. Please try again."
        textView.textSize = 16f
        textView.setPadding(32, 32, 32, 32)
        return view
    }
}
