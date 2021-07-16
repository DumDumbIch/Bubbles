package com.dumdumbich.train.bubbles

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CanvasView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private lateinit var myCircle: MyCircle
    private lateinit var paint: Paint

    init {
        initMyCircle()
        initPaint()
    }

    private fun initPaint() {
        paint = Paint()
        paint.isAntiAlias = true
        paint.style = Paint.Style.FILL
    }

    private fun initMyCircle() {
        myCircle = MyCircle(200, 500)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawCircle(myCircle.x.toFloat(), myCircle.y.toFloat(), myCircle.r.toFloat(), paint)
    }

}