package com.dumdumbich.train.bubbles.util.debug

import android.content.Context
import android.util.Log
import android.widget.Toast


interface IDebug {

    companion object {
        const val DEBUG_TAG = "DUMDUMBICH_BUBBLES"
        const val DEBUG_EnemyCircle: Boolean = true
    }

    fun logMessage(flag: Boolean, message: String) {
        if (flag) Log.d(DEBUG_TAG, message)
    }

    fun uiMessage(context: Context, flag: Boolean, message: String) {
        if (flag) Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

}