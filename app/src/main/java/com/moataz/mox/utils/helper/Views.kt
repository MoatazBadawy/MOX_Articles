package com.moataz.mox.utils.helper

import android.os.Build
import android.view.View
import android.view.Window
import androidx.annotation.RequiresApi

object Views {
    @RequiresApi(Build.VERSION_CODES.M)
    fun intiViews(window: Window) {
        // make the icons on Statues black
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }
}