package com.project.tuitionmanagementapp.student

data class Material(
    val title: String = "",
    val type: String = "",  // e.g., "PDF", "Video"
    val url: String = ""    // link to file (can be Firebase URL)
)
