package com.example.islamic_project.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islamic_project.DataClasses.AhadethItems
import com.example.islamic_project.R

class AhadethDetailsAdapter(var Items: AhadethItems) : androidx.recyclerview.widget.RecyclerView.Adapter<AhadethDetailsAdapter.AhadethDetailsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AhadethDetailsViewHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_ahadeth_details,parent,false)
        return AhadethDetailsViewHolder(view)
    }

    override fun onBindViewHolder(holder: AhadethDetailsViewHolder, position: Int) {
        val item = Items.content
        holder.quranLineText.text = item
    }

    override fun getItemCount(): Int {
        return 1
    }

    class AhadethDetailsViewHolder (itemView:View)
        : ViewHolder(itemView){
            val quranLineText:TextView = itemView.findViewById(R.id.ahadeth_list)
    }
}