package com.example.dachasimulator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dachasimulator.databinding.ActivityInfoBinding
import com.example.dachasimulator.databinding.ActivityMainBinding

class activity_info : AppCompatActivity() {
    private lateinit var binding: ActivityInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonBack.setOnClickListener{
            val intent = Intent(this, activity_menu::class.java)
            startActivity(intent)
        }
    }
}