package com.example.islamic_project.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islamic_project.Adapters.QuranDetailsAdapter
import com.example.islamic_project.DataClasses.Constants
import com.example.islamic_project.R

class QuranDetailsActivity : AppCompatActivity() {
    lateinit var quranDetailsRecyclerView: RecyclerView
    lateinit var quranDetailsAdapter: QuranDetailsAdapter
    lateinit var suraNameTitle : TextView
    lateinit var iconBack : ImageView
    var quranPosition :Int?=null
    var quranName :String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quran_details)
        suraNameTitle = findViewById(R.id.sura_title)
        iconBack = findViewById(R.id.back_toolbar)
        quranDetailsRecyclerView = findViewById(R.id.quran_details_recyclerview)
        quranDetailsAdapter = QuranDetailsAdapter(null)
        quranName = intent.getStringExtra(Constants.EXSTRA_QURAN_NAME_KEY)
        quranPosition = intent.getIntExtra(Constants.EXSTRA_QURAN_POSITION,-1)
        quranDetailsRecyclerView.adapter = quranDetailsAdapter
        suraNameTitle.text = "سورة " + quranName
        readFileText()
        iconBack.setOnClickListener { finish() }
    }
    fun readFileText(){
        val fileName = "${quranPosition?.plus(1)}.txt"
        val fileContent =  assets.open(fileName).bufferedReader().use{it.readText()}
        val quranLine = fileContent.split('\n')
        quranDetailsAdapter.updateDate(quranLine)
    }
}