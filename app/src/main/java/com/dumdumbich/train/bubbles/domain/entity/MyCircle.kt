package com.dumdumbich.train.bubbles.domain.entity


class MyCircle(_x: Int, _y: Int, _r: Int = 50) : Circle(_x, _y, _r) {

    fun moveMyCircleWhenTouchAt(nextX: Int, nextY: Int, rateX: Double, rateY: Double) {
        val dX: Int = ((nextX - x) * rateX).toInt()
        val dY: Int = ((nextY - y) * rateY).toInt()
        x += dX
        y += dY
    }

}