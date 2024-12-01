package com.example.pertemuan10

import Mail
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pertemuan10.R

class MailAdapter(private val mailList: List<Mail>, private val clickListener: (Mail) -> Unit) :
    RecyclerView.Adapter<MailAdapter.MailViewHolder>() {

    class MailViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val senderName: TextView = view.findViewById(R.id.senderName)
        val subject: TextView = view.findViewById(R.id.subject)
        val date: TextView = view.findViewById(R.id.date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mail, parent, false)
        return MailViewHolder(view)
    }

    override fun onBindViewHolder(holder: MailViewHolder, position: Int) {
        val mail = mailList[position]
        holder.senderName.text = mail.sender
        holder.subject.text = mail.subject
        holder.date.text = mail.date
        holder.itemView.setOnClickListener { clickListener(mail) }
    }

    override fun getItemCount() = mailList.size
}
