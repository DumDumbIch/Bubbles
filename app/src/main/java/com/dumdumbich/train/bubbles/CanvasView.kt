package com.dumdumbich.train.bubbles

import android.content.Context
import android.graphics.Canvas
import android.graphics.Point
import android.util.AttributeSet
import android.view.Display
import android.view.View
import android.view.WindowManager

class CanvasView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private var widthScreen = 0
    private var heightScreen = 0

    private var gameManager: GameManager

    init {
        initScreenSize(context)
        gameManager = GameManager(this, widthScreen, heightScreen)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        gameManager.onDraw(canvas)
    }

    private fun initScreenSize(context: Context) {
        val windowManager: WindowManager =
            context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display: Display = windowManager.defaultDisplay
        val point = Point()
        display.getSize(point)
        widthScreen = point.x
        heightScreen = point.y
    }

}