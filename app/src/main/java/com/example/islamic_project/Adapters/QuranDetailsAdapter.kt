package com.example.islamic_project.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islamic_project.R

class QuranDetailsAdapter(var Items: List<String?>?) : androidx.recyclerview.widget.RecyclerView.Adapter<QuranDetailsAdapter.QuranDetailsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuranDetailsViewHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_quran_details,parent,false)
        return QuranDetailsViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuranDetailsViewHolder, position: Int) {
        val item = Items?.get(position)
        holder.quranLineText.text = item
    }

    override fun getItemCount(): Int {
        return Items?.size ?: 0
    }

    fun updateDate(suralines : List<String>){
        Items = suralines
        notifyDataSetChanged()
    }

    class QuranDetailsViewHolder (itemView:View)
        : ViewHolder(itemView){
            val quranLineText:TextView = itemView.findViewById(R.id.quran_line)
    }
}