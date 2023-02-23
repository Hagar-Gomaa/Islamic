package com.example.islamic.Ui

import Hadeth.HadethFragment
import Tasbeh.TasbehFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.islamic.R
import com.example.islamic.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import quran.QuranFragment

class MainActivity : AppCompatActivity() {
    lateinit var bottomnavigation :BottomNavigationView
   private lateinit var binding :ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomnavigation.setOnItemSelectedListener{

            if (it.itemId == R.id.navigation_Quran) pushFragment(QuranFragment())
            else if (it.itemId == R.id.navigation_hadeth)pushFragment(HadethFragment())
            else if (it.itemId == R.id.navigation_sebha)pushFragment(TasbehFragment())

            return@setOnItemSelectedListener true}

        } fun pushFragment (fragment:Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.continearr,fragment).commit()
    }



}