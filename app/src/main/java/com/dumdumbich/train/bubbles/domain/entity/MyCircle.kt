package com.dumdumbich.train.bubbles.domain.entity

class MyCircle(_x: Int, _y: Int, _r: Int = 50) {

    var x: Int = _x
        private set
    var y: Int = _y
        private set
    var r: Int = _r
        private set

    fun moveMyCircleWhenTouchAt(nextX: Int, nextY: Int, rateX: Double, rateY: Double) {
        val dX: Int = ((nextX - x) * rateX).toInt()
        val dY: Int = ((nextY - y) * rateY).toInt()
        x += dX
        y += dY
    }

}