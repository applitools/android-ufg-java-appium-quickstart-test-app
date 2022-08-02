package com.applitools.android.ufg.java.appium.test.app

import android.app.Application
import com.applitools.vhs.EyesUfg

class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()
        EyesUfg.setup(this, EyesUfg.Mode.APPIUM)
    }
}