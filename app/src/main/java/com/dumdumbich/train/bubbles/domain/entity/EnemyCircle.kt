package com.dumdumbich.train.bubbles.domain.entity

import android.graphics.Color
import java.util.*


class EnemyCircle(_x: Int, _y: Int, _r: Int = 50) : Circle(_x, _y, _r) {

    init {
        val randomR = Random()
        r = (randomR.nextInt(MAX_RADIUS) + MIN_RADIUS)
        colour = Color.RED
    }

}