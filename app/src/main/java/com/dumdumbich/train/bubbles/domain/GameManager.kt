package com.dumdumbich.train.bubbles.domain

import com.dumdumbich.train.bubbles.domain.entity.MyCircle
import com.dumdumbich.train.bubbles.ui.CanvasView

class GameManager(private val canvasView: CanvasView, private val widthScreen: Int, private val heightScreen: Int) {

    private lateinit var myCircle: MyCircle

    init {
        initMyCircle()
    }

    private fun initMyCircle() {
        myCircle = MyCircle(widthScreen / 2, heightScreen / 2)
    }

    fun onDraw() {
        canvasView.drawCircle(myCircle)
    }

}