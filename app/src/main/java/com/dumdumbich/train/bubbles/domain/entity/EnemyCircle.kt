package com.dumdumbich.train.bubbles.domain.entity

import java.util.*


class EnemyCircle(_x: Int, _y: Int, _r: Int = 50) : Circle(_x, _y, _r) {

    companion object {
        const val MAX_RADIUS = 100
        const val MIN_RADIUS = 10
    }

    init {
        val randomR = Random()
        r = (randomR.nextInt(MAX_RADIUS) + MIN_RADIUS)
    }

}