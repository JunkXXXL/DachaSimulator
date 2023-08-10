package com.example.dachasimulator

import android.app.Activity
import android.content.Intent
import android.media.MediaPlayer
import android.os.CountDownTimer
import android.widget.ImageButton
import com.example.dachasimulator.databinding.ActivityEndGameBinding

class Game(
    val timeFunction: (milliseconds: Long) -> Unit,
    val scoreFunction: (score: Int) -> Unit,
    val startactivity: (intent: Intent) -> Unit,
    val pots: Map<Pots, ImageButton>,
    val context : android.content.Context,
    val trackNumber: Int)
{
    var score: Int = 0
    var t: Int = -1

    val presetClass = potPreset(trackNumber)
    var preset = presetClass.getPots()
    val setter = PictureSetter(pots)
    lateinit var mediaPlayer: MediaPlayer

    fun startGame()
    {
        score = 0
        val interval: Long = (60.0F / presetClass.getBPM()*1000).toLong()
        val timer = object: CountDownTimer((presetClass.getDuration()*1000), interval) {
            override fun onTick(milliseconds: Long) {
                timeFunction(milliseconds)
                scoreFunction(score)
                t++
                drawAll()
            }

            override fun onFinish() {
                endGame()
            }
        }
        mediaPlayer = MediaPlayer.create(context, presetClass.trackId)
        mediaPlayer.start()
        timer.start()
    }

    fun drawAll()
    {
        setter.draw(Pots.First, preset.get(0).get(t))
        setter.draw(Pots.Second, preset.get(1).get(t))
        setter.draw(Pots.Third, preset.get(2).get(t))
        setter.draw(Pots.Fouth, preset.get(3).get(t))
        setter.draw(Pots.Fifth, preset.get(4).get(t))
        setter.draw(Pots.Sixth, preset.get(5).get(t))
        setter.draw(Pots.Seventh, preset.get(6).get(t))
    }

    fun takeAction(numberOfPot: Int)
    {
        if (preset.get(numberOfPot).get(t) == 3 || preset.get(numberOfPot).get(t) == 6) {
            score++
            scoreFunction(score)
            preset[numberOfPot][t] = 0
            drawAll()
        }
        else if (preset.get(numberOfPot).get(t) != 0) {
            if (preset.get(numberOfPot).get(t) == 9 ||
                preset.get(numberOfPot).get(t) == 8 ||
                preset.get(numberOfPot).get(t) == 7) {
                endGame()
            }
            preset[numberOfPot][t] = 0
            if (t + 1 < presetClass.beatQuantity)
            {
                preset[numberOfPot][t + 1] = 0
                if (t + 2 < presetClass.beatQuantity)
                    preset[numberOfPot][t + 2] = 0
            }
            drawAll()
        }

    }

    fun endGame()
    {
        mediaPlayer.stop()
        val intent = Intent(context, activity_end_game::class.java)
        intent.putExtra("score", score)
        intent.putExtra("songName", presetClass.songName)
        startactivity(intent)
    }

}