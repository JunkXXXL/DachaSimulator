package com.example.dachasimulator

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.dachasimulator.databinding.ActivityMainBinding
import com.example.dachasimulator.databinding.ActivityMenuBinding
import java.lang.Integer.max
import java.lang.Integer.min

class activity_menu : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        val root = binding.root
        setContentView(root)

        var trackNumber = 0
        val tracks = 5
        val tracksArray = arrayOf("vegas light - Panic! At the Disco (kinbgstonl33t)",
            "slezyora - GO FAST GO QUICK",
            "tyom4style - Галилео такому не научит",
            "my!lane - This Feeling",
            "Placid Angles - First Blue Sky",
            "yeah sure - Goreshit - Fine Night")


        binding.trackName.text = tracksArray[0]

        binding.buttonLeft.setOnClickListener{
            trackNumber = max(0, trackNumber-1)
            binding.trackName.text = tracksArray[trackNumber]
        }

        binding.buttonRight.setOnClickListener{
            trackNumber = min(tracks, trackNumber+1)
            binding.trackName.text = tracksArray[trackNumber]
        }

        binding.buttonStart.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("trackNumber", trackNumber)
            startActivity(intent)
        }

        binding.buttonInfo.setOnClickListener{
            val intent = Intent(this, activity_info::class.java)
            startActivity(intent)
        }
    }
}