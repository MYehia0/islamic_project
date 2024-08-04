package com.example.islamic_project.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islamic_project.DataClasses.AhadethItems
import com.example.islamic_project.R
import com.example.islamic_project.Activities.onAhadethClickListener

class AhadethAdapter(var Items: List<AhadethItems>) : androidx.recyclerview.widget.RecyclerView.Adapter<AhadethAdapter.AhadethViewHolder>() {

    var onAhadethClickListener: onAhadethClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AhadethViewHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_ahadeth_list,parent,false)
        return AhadethViewHolder(view)
    }

    override fun onBindViewHolder(holder: AhadethViewHolder, position: Int) {
        holder.name.text = Items.get(position).title
        holder.itemView.setOnClickListener{
            onAhadethClickListener?.onAhadethClick(position,Items.get(position).title)
        }
    }

    override fun getItemCount(): Int {
        return Items.size-1
    }

    class AhadethViewHolder (itemView:View)
        : ViewHolder(itemView){
            val name:TextView = itemView.findViewById(R.id.ahadeth_list)
    }

}