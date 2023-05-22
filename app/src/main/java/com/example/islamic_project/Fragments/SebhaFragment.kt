package com.example.islamic_project.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.islamic_project.Activities.QuranDetailsActivity
import com.example.islamic_project.Adapters.QuranAdapter
import com.example.islamic_project.DataClasses.ArSuras
import com.example.islamic_project.DataClasses.Constants
import com.example.islamic_project.DataClasses.ayatNumber
import com.example.islamic_project.R
import com.example.islamic_project.onQuranClickListener

class SebhaFragment:Fragment() {

    lateinit var tasbeehCountText:TextView
    lateinit var tasbeehCountButton:Button
    var count:Int = 0
    var state:Int = 1
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sebha,container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tasbeehCountButton = view.findViewById(R.id.tasbeeh_button)
        tasbeehCountText = view.findViewById(R.id.num_of_tasbeeh_count_text)
        tasbeehCountButton.text = "سبحان الله"
        tasbeehCountText.text = count.toString()
        tasbeehCountButton.setOnClickListener {
            if(count == 33){
                if(state == 1){
                    tasbeehCountButton.text = "الحمد لله"
                }
                else if(state == 2){
                    tasbeehCountButton.text = "الله أكبر"
                }
                else if(state == 3){
                    tasbeehCountButton.text = "سبحان الله"
                    state = 1
                }
                count = 1
                state++
            }else{
                count++
            }
            tasbeehCountText.text = count.toString()
        }
    }

}