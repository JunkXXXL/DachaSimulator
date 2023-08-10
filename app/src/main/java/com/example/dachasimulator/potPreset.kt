package com.example.dachasimulator

class potPreset(trackNumber: Int) {

    var songName: String = "None"
    var beatQuantity: Int = 0
    var BPM: Int = 0
    var Long: Int = 0
    var trackId: Int = 0
    var pot1: ArrayList<Int> = ArrayList()
    var pot2: ArrayList<Int> = ArrayList()
    var pot3: ArrayList<Int> = ArrayList()
    var pot4: ArrayList<Int> = ArrayList()
    var pot5: ArrayList<Int> = ArrayList()
    var pot6: ArrayList<Int> = ArrayList()
    var pot7: ArrayList<Int> = ArrayList()
    var pot8: ArrayList<Int> = ArrayList()
    val allpots = arrayOf(pot1,pot2,pot3,pot4,pot5,pot6,pot7,pot8)

    //0 - ничего не растёт
    //1 - редис на первой стадии
    //2 - редис на второй стадии
    //3 - редис на третьей стадии, стадии сбора
    //4 - репа на первой стадии
    //5 - редис на второй стадии
    //6 - редис на третьей стадии, стадии сбора
    //7 - борщевик 1
    //8 - борщевик 2
    //9 - борщевик 3

    init {
        if (trackNumber == 0) {
            songName = "vegas light - Panic! At the Disco (kinbgstonl33t)"
            Long = 60
            BPM = 160
            beatQuantity = (Long / 60 * BPM).toInt()
            trackId = R.raw.atthedisco
        }
        else if (trackNumber == 1)
        {
            songName = "slezyora - GO FAST GO QUICK"
            Long = 60
            BPM = 175
            beatQuantity = (Long.toFloat() / 60 * BPM).toInt()
            trackId = R.raw.icantwait
        }
        else if (trackNumber == 2)
        {
            songName = "tyom4style - Галилео такому не научит"
            Long = 60
            BPM = 160
            beatQuantity = (Long.toFloat() / 60 * BPM).toInt()
            trackId = R.raw.galileo
        }
        else if (trackNumber == 3)
        {
            songName = "my!lane - This Feeling"
            Long = 60
            BPM = 130
            beatQuantity = (Long.toFloat() / 60 * BPM).toInt()
            trackId = R.raw.thisfeeling
        }
        else if (trackNumber == 4)
        {
            songName = "Placid Angles - First Blue Sky"
            Long = 60
            BPM = 145
            beatQuantity = (Long.toFloat() / 60 * BPM).toInt()
            trackId = R.raw.firstblueski
        }
        else if (trackNumber == 5)
        {
            songName = "yeah sure - Goreshit - Fine Night"
            Long = 60
            BPM = 180
            beatQuantity = (Long.toFloat() / 60 * BPM).toInt()
            trackId = R.raw.goreshit
        }

        createEmptyPots()
        var newPlants: Int

        for (beat in 1..(beatQuantity-1))
        {
            newPlants = arrayOf(1,1,2).random()
            for (potPlant in 0..newPlants)
            {
                allpots[(0..7).random()][beat] = arrayOf(1, 1, 4, 4,7).random()
            }
        }
        fullPot()
    }

    fun createEmptyPots() {
        for(pot in 0..7)
        {
            for (beat in 0..(beatQuantity-1))
            {
                allpots[pot].add(0)
            }
        }
    }

    fun fullPot() {

        for (i in 0..(beatQuantity - 1)) {
            for (pot in 0..7) {
                if (allpots[pot][i] == 1 && (i + 1 < beatQuantity))
                    allpots[pot][i + 1] = 2
                if (allpots[pot][i] == 2 && (i + 1 < beatQuantity))
                    allpots[pot][i + 1] = 3

                if (allpots[pot][i] == 4 && (i + 1 < beatQuantity))
                    allpots[pot][i + 1] = 5
                if (allpots[pot][i] == 5 && (i + 1 < beatQuantity))
                    allpots[pot][i + 1] = 6

                if (allpots[pot][i] == 7 && (i + 1 < beatQuantity))
                    allpots[pot][i + 1] = 8
                if (allpots[pot][i] == 8 && (i + 1 < beatQuantity))
                    allpots[pot][i + 1] = 9
            }
        }
    }

    fun getPots(): Array<ArrayList<Int>>
    {
        return allpots
    }

    fun getBPM(): Long
    {
        return BPM.toLong()
    }

    fun getDuration(): Long
    {
        return Long.toLong()
    }
}