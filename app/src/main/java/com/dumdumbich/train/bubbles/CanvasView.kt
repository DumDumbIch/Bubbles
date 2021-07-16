package com.dumdumbich.train.bubbles

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View

class CanvasView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private var gameManager = GameManager()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        gameManager.onDraw(canvas)
    }

}