package com.example.islamic_project.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.islamic_project.*
import com.example.islamic_project.Activities.QuranDetailsActivity
import com.example.islamic_project.Adapters.QuranAdapter
import com.example.islamic_project.onQuranClickListener
import com.example.islamic_project.DataClasses.ArSuras
import com.example.islamic_project.DataClasses.Constants
import com.example.islamic_project.DataClasses.ayatNumber

class QuranFragment:Fragment() {
    lateinit var quranRecyclerView:RecyclerView
    lateinit var quranAdapter: QuranAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quran,container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        quranRecyclerView = view.findViewById(R.id.quran_recyclerview)
        quranAdapter = QuranAdapter(ArSuras, ayatNumber)
        quranRecyclerView.adapter = quranAdapter
        quranAdapter.onQuranClickListener = object : onQuranClickListener {
            override fun onQuranClick(position: Int,suraName:String?) {
                val intent = Intent(requireActivity(), QuranDetailsActivity::class.java)
                intent.putExtra(Constants.EXSTRA_QURAN_POSITION,position )
                intent.putExtra(Constants.EXSTRA_QURAN_NAME_KEY,suraName )
                startActivity(intent)
            }
        }
    }
}