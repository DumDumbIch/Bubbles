package com.dumdumbich.train.bubbles

import android.graphics.Canvas
import android.graphics.Paint

class GameManager {

    private lateinit var myCircle: MyCircle
    private lateinit var paint: Paint

    init {
        initMyCircle()
        initPaint()
    }

    fun onDraw(canvas: Canvas?) {
        canvas?.drawCircle(myCircle.x.toFloat(), myCircle.y.toFloat(), myCircle.r.toFloat(), paint)
    }

    private fun initPaint() {
        paint = Paint()
        paint.isAntiAlias = true
        paint.style = Paint.Style.FILL
    }

    private fun initMyCircle() {
        myCircle = MyCircle(200, 500)
    }

}