package com.dumdumbich.train.bubbles.domain

import com.dumdumbich.train.bubbles.domain.entity.MyCircle
import com.dumdumbich.train.bubbles.ui.CanvasView


class GameManager(
    private val canvasView: CanvasView,
    private val widthScreen: Int,
    private val heightScreen: Int
) {

    private val rateConst = 60.0
    private lateinit var myCircle: MyCircle
    private var moveRateX: Double = 0.0
    private var moveRateY: Double = 0.0

    init {
        initMyCircle()
        initMoveRate()
    }

    private fun initMyCircle() {
        myCircle = MyCircle(widthScreen / 2, heightScreen / 2)
    }

    private fun initMoveRate() {
        moveRateX = rateConst / widthScreen
        moveRateY = rateConst / heightScreen
    }

    fun onDraw() {
        canvasView.drawCircle(myCircle)
    }

    fun onTouchEvent(x: Int, y: Int) {
        myCircle.moveMyCircleWhenTouchAt(x, y, moveRateX, moveRateY)
    }

}