package com.dumdumbich.train.bubbles.domain.interactor

import com.dumdumbich.train.bubbles.domain.entity.Circle

interface ICanvasView {
    fun drawCircle(circle: Circle)
}