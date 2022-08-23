package com.moataz.mox.utils.helper

import android.view.View
import android.view.Window

object Views {
    fun intiViews(window: Window) {
        // make the icons on Statues bar black
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }
}