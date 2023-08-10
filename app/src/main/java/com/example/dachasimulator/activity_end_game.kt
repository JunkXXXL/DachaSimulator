package com.example.dachasimulator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dachasimulator.databinding.ActivityEndGameBinding
import com.example.dachasimulator.databinding.ActivityMenuBinding

class activity_end_game : AppCompatActivity() {
    private lateinit var binding: ActivityEndGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEndGameBinding.inflate(layoutInflater)
        val root = binding.root
        setContentView(root)

        val score = intent.getIntExtra("score", 0)
        val songName = intent.getStringExtra("songName")

        binding.scoreField.setText(score.toString())
        binding.songField.setText(songName)
        binding.buttonToMenu.setOnClickListener{
            val intent = Intent(this, activity_menu::class.java)
            startActivity(intent)
        }
    }
}