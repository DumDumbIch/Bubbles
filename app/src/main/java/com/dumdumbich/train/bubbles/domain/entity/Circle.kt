package com.dumdumbich.train.bubbles.domain.entity


open class Circle(_x: Int, _y: Int, _r: Int = 0, _c: Int = 0) {

    companion object {
        const val MAX_RADIUS = 100
        const val MIN_RADIUS = 10
    }

    var x: Int = _x
    var y: Int = _y
    var r: Int = _r
    var colour: Int = _c

}