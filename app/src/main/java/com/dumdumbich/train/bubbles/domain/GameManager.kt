package com.dumdumbich.train.bubbles.domain

import com.dumdumbich.train.bubbles.domain.entity.EnemyCircle
import com.dumdumbich.train.bubbles.domain.entity.MyCircle
import com.dumdumbich.train.bubbles.ui.CanvasView
import java.util.*
import kotlin.collections.ArrayList


class GameManager(
    private val canvasView: CanvasView,
    private val widthScreen: Int,
    private val heightScreen: Int
) {

    companion object {
        const val SPEED_RATIO = 60.0
        const val ENEMY_NUMBER = 10
    }

    private lateinit var me: MyCircle
    private lateinit var enemies: ArrayList<EnemyCircle>
    private var moveRateX: Double = 0.0
    private var moveRateY: Double = 0.0

    init {
        initMoveRate()
        initMyCircle()
        initEnemyCircles()
    }

    private fun initEnemyCircles() {
        enemies = ArrayList()
        val randomX = Random()
        val randomY = Random()
        for (i in 1..ENEMY_NUMBER) {
            val circle =
                EnemyCircle(randomX.nextInt(widthScreen), randomY.nextInt(heightScreen))
            enemies.add(circle)
        }
    }

    private fun initMyCircle() {
        me = MyCircle(widthScreen / 2, heightScreen / 2)
    }

    private fun initMoveRate() {
        moveRateX = SPEED_RATIO / widthScreen
        moveRateY = SPEED_RATIO / heightScreen
    }

    fun onDraw() {
        canvasView.drawCircle(me)
        for (enemy in enemies) {
            canvasView.drawCircle(enemy)
        }
    }

    fun onTouchEvent(x: Int, y: Int) {
        me.moveMyCircleWhenTouchAt(x, y, moveRateX, moveRateY)
    }

}