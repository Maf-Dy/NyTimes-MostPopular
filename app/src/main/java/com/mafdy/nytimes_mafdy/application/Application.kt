package com.mafdy.nytimes_mafdy.application

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

class Application : Application() {

    override fun onCreate() {
        super.onCreate()

        Fresco.initialize(this)
    }
}