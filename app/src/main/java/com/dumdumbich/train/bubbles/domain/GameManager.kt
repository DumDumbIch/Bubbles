package com.dumdumbich.train.bubbles.domain

import com.dumdumbich.train.bubbles.domain.entity.EnemyCircle
import com.dumdumbich.train.bubbles.domain.entity.MyCircle
import com.dumdumbich.train.bubbles.ui.CanvasView
import com.dumdumbich.train.bubbles.util.debug.IDebug
import com.dumdumbich.train.bubbles.util.debug.IDebug.Companion.DEBUG_GameManager
import java.util.*
import kotlin.collections.ArrayList

class GameManager(
    private val canvasView: CanvasView,
    private val widthScreen: Int,
    private val heightScreen: Int
) : IDebug {

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
            var enemy: EnemyCircle
            do {
                enemy = EnemyCircle(randomX.nextInt(widthScreen), randomY.nextInt(heightScreen))
            } while (enemy.isIntersectedWithHim(me.getSafeArea()))
            enemy.isFoodForHim(me)
            enemies.add(enemy)
            logMessage(
                DEBUG_GameManager,
                "GameManager.initEnemyCircles(): enemy.radius = ${enemy.r},  enemy.x = ${enemy.x},  enemy.y = ${enemy.y}"
            )
        }
        logMessage(
            DEBUG_GameManager,
            "GameManager.initEnemyCircles(): enemies.size = ${enemies.size}"
        )
    }

    private fun updateEnemies() {
        for (enemy in enemies) {
            enemy.isFoodForHim(me)
            updateMoveDirection(enemy)
            enemy.randomMove()
        }
    }

    private fun gameOver() {
        me.setDefaultRadius()
        enemies.clear()
        initEnemyCircles()
        canvasView.redraw()
    }

    private fun updateMoveDirection(enemy: EnemyCircle) {
        if (enemy.x >= widthScreen || enemy.x <= 0) enemy.directX = -enemy.directX
        if (enemy.y >= widthScreen || enemy.y <= 0) enemy.directY = -enemy.directY
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
        updateEnemies()
        checkCollision()
    }

    private fun checkCollision() {
        for (enemy in enemies) {
            if (me.isIntersectedWithHim(enemy)) {
                if (enemy.isSmallerThanHim(me)) {
                    me.eat(enemy)
                    enemies.remove(enemy)
                    logMessage(
                        DEBUG_GameManager,
                        "GameManager.checkCollision(): enemies.size = ${enemies.size}"
                    )
                    if (enemies.isEmpty()) gameOver()
                    logMessage(
                        DEBUG_GameManager,
                        "GameManager.checkCollision(): enemies on the game board:"
                    )
                    for (survivorEnemy in enemies) {
                        logMessage(
                            DEBUG_GameManager,
                            "GameManager.checkCollision(): enemy.radius = ${survivorEnemy.r},  enemy.x = ${survivorEnemy.x},  enemy.y = ${survivorEnemy.y}"
                        )
                    }
                } else gameOver()
                break
            }
        }
    }

}