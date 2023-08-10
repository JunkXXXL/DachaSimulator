package com.example.dachasimulator

import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.core.view.marginBottom
import androidx.core.view.marginLeft
import androidx.core.view.marginRight
import androidx.core.view.marginTop

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

class PictureSetter(val pots: Map<Pots, ImageButton>)
{
    val images = mapOf(
        0 to R.drawable.dot,
        1 to R.drawable.redis1,
        2 to R.drawable.redis2,
        3 to R.drawable.redis3,
        4 to R.drawable.repa1,
        5 to R.drawable.repa2,
        6 to R.drawable.repa3,
        7 to R.drawable.borsh1,
        8 to R.drawable.borsh2,
        9 to R.drawable.borsh3
    )
    fun draw(pot: Pots, imageNumber: Int)
    {
        val target = pots.get(pot)
        target!!.setImageResource(images.get(imageNumber)!!)

    }
}