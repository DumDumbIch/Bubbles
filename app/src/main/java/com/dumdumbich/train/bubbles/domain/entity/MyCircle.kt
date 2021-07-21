package com.dumdumbich.train.bubbles.domain.entity

import android.graphics.Color
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sqrt


class MyCircle(_x: Int, _y: Int, _r: Int = INIT_RADIUS) : Circle(_x, _y, _r) {

    companion object {
        const val INIT_RADIUS = 50
    }

    init {
        colour = Color.BLUE
    }

    fun moveMyCircleWhenTouchAt(nextX: Int, nextY: Int, rateX: Double, rateY: Double) {
        val dX: Int = ((nextX - x) * rateX).toInt()
        val dY: Int = ((nextY - y) * rateY).toInt()
        x += dX
        y += dY
    }

    fun setDefaultRadius() {
        r = INIT_RADIUS
    }

    fun eat(circle: Circle) {
        r = sqrt(r.toDouble().pow(2) + circle.r.toDouble().pow(2)).roundToInt()
    }

}