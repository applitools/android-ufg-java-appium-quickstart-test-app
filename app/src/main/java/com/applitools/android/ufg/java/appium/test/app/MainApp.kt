package com.applitools.android.ufg.java.appium.test.app

import android.app.Application
import com.applitools.eyes.Logger
import com.applitools.vhs.EyesUfg

class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()
        val logger = Logger()
        EyesUfg.setup(this, logger, "API_KEY_HERE", EyesUfg.Mode.PULL_VHS_MODE);
    }
}