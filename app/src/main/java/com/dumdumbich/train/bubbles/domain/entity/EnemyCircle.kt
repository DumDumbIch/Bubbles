package com.dumdumbich.train.bubbles.domain.entity

import android.graphics.Color
import java.util.*


class EnemyCircle(_x: Int, _y: Int, _r: Int = 50) : Circle(_x, _y, _r) {

    companion object {
        const val ENEMY_COLOR = Color.RED
        const val FOOD_COLOR = Color.GREEN
    }

    init {
        val randomR = Random()
        r = (randomR.nextInt(MAX_RADIUS) + MIN_RADIUS)
        colour = ENEMY_COLOR
    }

    fun isFoodForHim(circle: Circle): Boolean {
        var isFood = false
        if (isSmallerThanHim(circle)) {
            this.colour = FOOD_COLOR
            isFood = true
        } else {
            this.colour = ENEMY_COLOR
        }
        return isFood
    }

}