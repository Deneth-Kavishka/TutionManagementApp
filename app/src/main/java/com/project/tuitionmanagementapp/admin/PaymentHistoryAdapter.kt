package com.project.tuitionmanagementapp.admin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.tuitionmanagementapp.R
import com.project.tuitionmanagementapp.models.Payment
import java.text.SimpleDateFormat
import java.util.Locale

class PaymentHistoryAdapter(
    private val payments: List<Payment>,
    private val onItemClick: (Payment) -> Unit
) : RecyclerView.Adapter<PaymentHistoryAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvPaymentDate: TextView = view.findViewById(R.id.tvPaymentDate)
        val tvPaymentAmount: TextView = view.findViewById(R.id.tvPaymentAmount)
        val tvPaymentMethod: TextView = view.findViewById(R.id.tvPaymentMethod)
        val tvPaymentStatus: TextView = view.findViewById(R.id.tvPaymentStatus)
        val tvReference: TextView = view.findViewById(R.id.tvReference)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_payment_history, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val payment = payments[position]
        val dateFormat = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())

        holder.tvPaymentDate.text = dateFormat.format(payment.paymentDate)
        holder.tvPaymentAmount.text = "₹${payment.amount}"
        holder.tvPaymentMethod.text = payment.paymentMethod
        holder.tvPaymentStatus.text = payment.status

        if (payment.referenceNumber.isNotEmpty()) {
            holder.tvReference.visibility = View.VISIBLE
            holder.tvReference.text = "Ref: ${payment.referenceNumber}"
        } else {
            holder.tvReference.visibility = View.GONE
        }

        holder.itemView.setOnClickListener { onItemClick(payment) }
    }

    override fun getItemCount() = payments.size
}
