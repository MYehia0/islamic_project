package com.example.islamic_project.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islamic_project.R
import com.example.islamic_project.onQuranClickListener

class QuranAdapter(var Items: List<String>,var Ayat: List<String>) : androidx.recyclerview.widget.RecyclerView.Adapter<QuranAdapter.QuranViewHolder>() {

    var onQuranClickListener: onQuranClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuranViewHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_quran_list,parent,false)
        return QuranViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuranViewHolder, position: Int) {
        val item = Items[position]
        val itemAyat = Ayat[position]
        holder.name.text = item
        holder.numOfAyah.text = itemAyat
        holder.itemView.setOnClickListener{
            onQuranClickListener?.onQuranClick(position,Items[position])
        }
    }

    override fun getItemCount(): Int {
        return Items.size
    }

    class QuranViewHolder (itemView:View)
        : ViewHolder(itemView){
            val name:TextView = itemView.findViewById(R.id.sura_name)
            val numOfAyah:TextView = itemView.findViewById(R.id.sura_num)
    }
}