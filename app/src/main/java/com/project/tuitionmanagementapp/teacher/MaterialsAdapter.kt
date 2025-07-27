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
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MaterialViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_material, parent, false)
        return MaterialViewHolder(view)
    }

    override fun onBindViewHolder(holder: MaterialViewHolder, position: Int) {
        val material = materials[position]

        holder.title.text = material.title
        holder.type.text = material.type
        holder.date.text = formatDate(material.uploadDate)

        // Set icon based on material type
        holder.icon.setImageResource(
            when (material.type.lowercase()) {
                "pdf" -> R.drawable.ic_pdf
                "video" -> R.drawable.ic_video
                else -> R.drawable.ic_document
            }
        )

        // Set card click listener
        holder.cardView.setOnClickListener { onItemClick(material) }

        // Apply theme colors
        holder.icon.setColorFilter(holder.itemView.context.getColor(R.color.purple_700))
    }

    override fun getItemCount() = materials.size

    private fun formatDate(timestamp: Long): String {
        val sdf = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())
        return sdf.format(Date(timestamp))
    }
}
