package com.example.dachasimulator

import android.app.ActionBar.LayoutParams
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.dachasimulator.databinding.ActivityEndGameBinding
import com.example.dachasimulator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var loop: Game

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val trackNumber = intent.getIntExtra("trackNumber", 1)
        val potsNumberToButton = mapOf(
            Pots.First to binding.pot1,
            Pots.Second to binding.pot2,
            Pots.Third to binding.pot3,
            Pots.Fouth to binding.pot4,
            Pots.Fifth to binding.pot5,
            Pots.Sixth to binding.pot6,
            Pots.Seventh to binding.pot7,
        )
        val potsButtonToNumber = mapOf(
            binding.buttonPot1 to Pots.First,
            binding.buttonPot2 to Pots.Second,
            binding.buttonPot3 to Pots.Third,
            binding.buttonPot4 to Pots.Fouth,
            binding.buttonPot5 to Pots.Fifth,
            binding.buttonPot6 to Pots.Sixth,
            binding.buttonPot7 to Pots.Seventh
        )

        loop = Game({binding.time.setText("Время: " + (it/1000).toString())},
            {binding.score.setText("Очки: " + (it).toString())},
            {startActivity(it)},
            potsNumberToButton,
            this,
            trackNumber)


        potsButtonToNumber.forEach{
            Button, Pots -> Button.setOnClickListener{loop.takeAction(Pots.ordinal)}
        }

        loop.startGame()

        val targetPot = binding.pot4
        targetPot.setImageResource(R.drawable.redis3)
    }

    override fun onPause() {
        super.onPause()
        loop.endGame()
    }
}