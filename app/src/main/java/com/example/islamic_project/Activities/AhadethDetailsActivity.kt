package com.example.islamic_project.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islamic_project.Adapters.AhadethDetailsAdapter
import com.example.islamic_project.DataClasses.Constants
import com.example.islamic_project.DataClasses.allAhadeth
import com.example.islamic_project.R

class AhadethDetailsActivity : AppCompatActivity() {
    lateinit var AhadethDetailsRecyclerView: RecyclerView
    lateinit var AhadethDetailsAdapter: AhadethDetailsAdapter
    lateinit var hadethTitle : TextView
    lateinit var iconBack : ImageView
    var hadethPosition :Int?=null
    var hadethName :String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ahadeth_details)
        hadethTitle = findViewById(R.id.ahadeth_title)
        iconBack = findViewById(R.id.back_toolbar)
        AhadethDetailsRecyclerView = findViewById(R.id.ahadeth_details_recyclerview)
        hadethName = intent.getStringExtra(Constants.EXSTRA_Ahadeth_NAME_KEY)
        hadethPosition = intent.getIntExtra(Constants.EXSTRA_Ahadeth_POSITION,-1)
        AhadethDetailsAdapter = AhadethDetailsAdapter(allAhadeth.get(hadethPosition!!))
        AhadethDetailsRecyclerView.adapter = AhadethDetailsAdapter
        hadethTitle.text = hadethName
        iconBack.setOnClickListener { finish() }

    }
}