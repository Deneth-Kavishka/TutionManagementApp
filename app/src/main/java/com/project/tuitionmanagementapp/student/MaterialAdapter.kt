package com.project.tuitionmanagementapp.student

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.tuitionmanagementapp.R

class MaterialAdapter(private val list: List<Material>) :
    RecyclerView.Adapter<MaterialAdapter.MaterialViewHolder>() {

    class MaterialViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleText: TextView = itemView.findViewById(R.id.tvMaterialTitle)
        val typeText: TextView = itemView.findViewById(R.id.tvMaterialType)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MaterialViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_material, parent, false)
        return MaterialViewHolder(view)
    }

    override fun onBindViewHolder(holder: MaterialViewHolder, position: Int) {
        val item = list[position]
        holder.titleText.text = item.title
        holder.typeText.text = item.type

        holder.itemView.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(item.url))
            // Check if there is an app to handle this intent
            if (intent.resolveActivity(holder.itemView.context.packageManager) != null) {
                holder.itemView.context.startActivity(intent)
            } else {
                // Optionally, show a Toast or Snackbar to inform the user
            }
        }
    }

    override fun getItemCount() = list.size
}
