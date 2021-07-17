package com.dumdumbich.train.bubbles.domain.entity

import kotlin.math.pow
import kotlin.math.sqrt


open class Circle(_x: Int, _y: Int, _r: Int = 0, _c: Int = 0) {

    companion object {
        const val MAX_RADIUS = 100
        const val MIN_RADIUS = 10
        const val SAFE_AREA_RATIO = 3
    }

    var x: Int = _x
    var y: Int = _y
    var r: Int = _r
    var colour: Int = _c

    fun isSmallerThanHim(circle: Circle) = this.r < circle.r

    fun getSafeArea() = Circle(x, y, r * SAFE_AREA_RATIO)

    fun isIntersectedWithHim(circle: Circle): Boolean {
        return r + circle.r >= sqrt(
            (x - circle.x).toDouble().pow(2) + (y - circle.y).toDouble().pow(2)
        )
    }

}