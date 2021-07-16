package com.dumdumbich.train.bubbles.domain.interactor

import com.dumdumbich.train.bubbles.domain.entity.MyCircle

interface ICanvasView {
    fun drawCircle(circle: MyCircle)
}