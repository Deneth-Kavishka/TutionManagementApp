package com.project.tuitionmanagementapp.teacher

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.project.tuitionmanagementapp.R
import java.text.SimpleDateFormat
import java.util.*

class MaterialsAdapter(
    private val materials: List<MaterialModel>,
    private val onItemClick: (MaterialModel) -> Unit
) : RecyclerView.Adapter<MaterialsAdapter.MaterialViewHolder>() {

    inner class MaterialViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView: CardView = itemView.findViewById(R.id.cardMaterial)
        val title: TextView = itemView.findViewById(R.id.tvMaterialTitle)
        val type: TextView = itemView.findViewById(R.id.tvMaterialType)
        val date: TextView = itemView.findViewById(R.id.tvUploadDate)
        val icon: ImageView = itemView.findViewById(R.id.imgMaterialIcon)
        val downloadBtn: ImageView = itemView.findViewById(R.id.btnDownload)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MaterialViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_material, parent, false)
        return MaterialViewHolder(view)
    }

    override fun onBindViewHolder(holder: MaterialViewHolder, position: Int) {
        val material = materials[position]

        holder.title.text = material.title.ifEmpty { "Untitled Material" }
        holder.type.text = material.type.ifEmpty { "Document" }
        holder.date.text = formatDate(material.uploadDate)

        // Set icon based on material type using existing drawable resources
        holder.icon.setImageResource(
            when (material.type.lowercase()) {
                "pdf" -> R.drawable.baseline_article_24 // Use existing article icon for PDFs
                "video" -> R.drawable.baseline_upload_file_24 // Use upload file icon for videos
                "image" -> R.drawable.baseline_add_box_24 // Use add box icon for images
                "document" -> R.drawable.baseline_article_24 // Use article icon for documents
                else -> R.drawable.baseline_article_24 // Default to article icon
            }
        )

        // Set click listeners
        holder.cardView.setOnClickListener { onItemClick(material) }
        holder.downloadBtn.setOnClickListener { onItemClick(material) }
    }

    override fun getItemCount(): Int = materials.size

    private fun formatDate(timestamp: Long): String {
        return if (timestamp > 0) {
            val dateFormat = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())
            dateFormat.format(Date(timestamp))
        } else {
            "Unknown date"
        }
    }
}
