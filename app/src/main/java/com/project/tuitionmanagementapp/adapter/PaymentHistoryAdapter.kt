package com.project.tuitionmanagementapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.tuitionmanagementapp.R
import com.project.tuitionmanagementapp.models.Payment
import java.text.SimpleDateFormat
import java.util.*

class PaymentHistoryAdapter(private val payments: List<Payment>) :
    RecyclerView.Adapter<PaymentHistoryAdapter.PaymentViewHolder>() {

    private val dateFormat = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())

    inner class PaymentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvAmount: TextView = itemView.findViewById(R.id.tvAmount)
        val tvDate: TextView = itemView.findViewById(R.id.tvDate)
        val tvMethod: TextView = itemView.findViewById(R.id.tvMethod)
        val tvStatus: TextView = itemView.findViewById(R.id.tvStatus)
        val tvDescription: TextView = itemView.findViewById(R.id.tvDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_payment_history, parent, false)
        return PaymentViewHolder(view)
    }

    override fun onBindViewHolder(holder: PaymentViewHolder, position: Int) {
        val payment = payments[position]

        holder.tvAmount.text = "Rs. ${payment.amount}"
        holder.tvDate.text = dateFormat.format(payment.paymentDate)
        holder.tvMethod.text = payment.paymentMethod
        holder.tvDescription.text = payment.description

        holder.tvStatus.text = payment.status
        when (payment.status) {
            "COMPLETED" -> holder.tvStatus.setTextColor(holder.itemView.context.getColor(R.color.colorSuccess))
            "PENDING" -> holder.tvStatus.setTextColor(holder.itemView.context.getColor(R.color.colorAccent))
            else -> holder.tvStatus.setTextColor(holder.itemView.context.getColor(R.color.colorAccent))
        }
    }

    override fun getItemCount(): Int = payments.size
}