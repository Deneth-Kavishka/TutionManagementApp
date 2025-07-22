// 1. FIRST: Create a simple test fragment to verify fragment loading works
// TestFragment.kt
package com.project.tuitionmanagementapp.admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.LinearLayout
import android.graphics.Color
import android.util.Log

class TestFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("TestFragment", "onCreateView called")

        // Create a simple view programmatically to test
        val linearLayout = LinearLayout(requireContext()).apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            setBackgroundColor(Color.LTGRAY)
            setPadding(32, 32, 32, 32)
        }

        val textView = TextView(requireContext()).apply {
            text = "TEST FRAGMENT IS WORKING!"
            textSize = 24f
            setTextColor(Color.BLACK)
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        }

        val textView2 = TextView(requireContext()).apply {
            text = "If you can see this, fragments are loading correctly."
            textSize = 16f
            setTextColor(Color.LTGRAY)
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        }

        linearLayout.addView(textView)
        linearLayout.addView(textView2)

        return linearLayout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("TestFragment", "onViewCreated called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("TestFragment", "onResume called")
    }
}