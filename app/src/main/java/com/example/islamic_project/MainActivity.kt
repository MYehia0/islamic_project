package com.example.islamic_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.islamic_project.Fragments.AhadethFragment
import com.example.islamic_project.Fragments.QuranFragment
import com.example.islamic_project.Fragments.RadioFragment
import com.example.islamic_project.Fragments.SebhaFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var bottomNavigationItemView: BottomNavigationView
    lateinit var btn_dark: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationItemView = findViewById(R.id.bottom_navigation_view)
        bottomNavigationItemView.setOnItemSelectedListener {
            if(it.itemId == R.id.quran){
                pushFragment(QuranFragment())
            } else if(it.itemId == R.id.ahadeth){
                pushFragment(AhadethFragment())
            } else if(it.itemId == R.id.radio){
                pushFragment(RadioFragment())
            } else if(it.itemId == R.id.sebha){
                pushFragment(SebhaFragment())
            }
            return@setOnItemSelectedListener true
        }
        bottomNavigationItemView.selectedItemId = R.id.quran
        btn_dark = findViewById(R.id.btn_dark)
        btn_dark.setOnClickListener {
            if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
        }
    }
    fun pushFragment(fragment:Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container_fragment,fragment)
            .commit()
    }
}