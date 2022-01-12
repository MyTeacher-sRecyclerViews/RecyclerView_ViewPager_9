package com.example.recyclerview_viewpager_9.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_viewpager_9.R
import com.example.recyclerview_viewpager_9.model.User

class CustomAdapter(context: Context, private val list: List<User>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val user = list[position]

        if (holder is CustomViewHolder) {
            holder.firstName.text = user.firstName
            holder.secondName.text = user.lastName
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val firstName: TextView = view.findViewById(R.id.text_first)
        val secondName: TextView = view.findViewById(R.id.text_second)
    }
}