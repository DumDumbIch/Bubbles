package com.dumdumbich.train.bubbles.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Point
import android.util.AttributeSet
import android.view.Display
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import com.dumdumbich.train.bubbles.domain.GameManager
import com.dumdumbich.train.bubbles.domain.entity.Circle
import com.dumdumbich.train.bubbles.domain.interactor.ICanvasView
import com.dumdumbich.train.bubbles.util.debug.IDebug
import com.dumdumbich.train.bubbles.util.debug.IDebug.Companion.DEBUG_CanvasView


class CanvasView(context: Context, attrs: AttributeSet) : View(context, attrs), ICanvasView,
    IDebug {

    private var widthScreen = 0
    private var heightScreen = 0
    private lateinit var paint: Paint
    private var gameManager: GameManager
    private var canvas: Canvas? = null
    private var toast: Toast? = null

    init {
        initPaint()
        initScreenSize(context)
        gameManager = GameManager(this, widthScreen, heightScreen)
    }

    private fun initPaint() {
        paint = Paint()
        paint.isAntiAlias = true
        paint.style = Paint.Style.FILL
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        this.canvas = canvas
        gameManager.onDraw()
    }

    private fun initScreenSize(context: Context) {
        val windowManager: WindowManager =
            context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display: Display = windowManager.defaultDisplay
        val point = Point()
        display.getSize(point)
        widthScreen = point.x
        heightScreen = point.y
        logMessage(
            DEBUG_CanvasView,
            "CanvasView.initScreenSize(): widthScreen = $widthScreen, heightScreen = $heightScreen"
        )
    }

    override fun drawCircle(circle: Circle) {
        paint.color = circle.colour
        canvas?.drawCircle(circle.x.toFloat(), circle.y.toFloat(), circle.r.toFloat(), paint)
    }

    override fun redraw() {
        invalidate()
    }

    override fun showGameOverMessage(message: String) {
        toast?.cancel()
        toast = Toast.makeText(context, message, Toast.LENGTH_SHORT)
        toast?.show()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event != null) {
            val x: Int = event.x.toInt()
            val y: Int = event.y.toInt()
            when (event.action) {
                MotionEvent.ACTION_MOVE -> {
                    gameManager.onTouchEvent(x, y)
                }
            }
        }
        redraw()
        return true
    }

    override fun performClick(): Boolean {
        return super.performClick()
    }

}