package com.example.islamic_project.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.islamic_project.*
import com.example.islamic_project.Activities.AhadethDetailsActivity
import com.example.islamic_project.Adapters.AhadethAdapter
import com.example.islamic_project.onAhadethClickListener
import com.example.islamic_project.DataClasses.AhadethItems
import com.example.islamic_project.DataClasses.Constants
import com.example.islamic_project.DataClasses.allAhadeth

class AhadethFragment:Fragment() {
    lateinit var ahadethRecyclerView: RecyclerView
    lateinit var ahadethAdapter: AhadethAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ahadeth,container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ahadethRecyclerView = view.findViewById(R.id.ahadeth_recyclerview)
        readHadethFile()
        ahadethAdapter = AhadethAdapter(allAhadeth)
        ahadethRecyclerView.adapter = ahadethAdapter
        ahadethAdapter.onAhadethClickListener = object : onAhadethClickListener {
            override fun onAhadethClick(position: Int,hadethName:String?) {
                val intent = Intent(requireActivity(), AhadethDetailsActivity::class.java)
                intent.putExtra(Constants.EXSTRA_Ahadeth_POSITION,position )
                intent.putExtra(Constants.EXSTRA_Ahadeth_NAME_KEY, hadethName )
                startActivity(intent)
            }
        }

    }


    fun readHadethFile(){
        allAhadeth = mutableListOf()
        val fileContent =  activity?.assets?.open("ahadeth .txt")?.bufferedReader().use{it?.readText()}
        if (fileContent == null) return
        val ahadethContents = fileContent.trim().split('#')
        ahadethContents.forEach{
            val title = it.trim().substringBefore('\n')
            val content = it.trim().substringAfter('\n')
            val hadeth = AhadethItems(title,content)
            allAhadeth.add(hadeth)
        }
    }

}
