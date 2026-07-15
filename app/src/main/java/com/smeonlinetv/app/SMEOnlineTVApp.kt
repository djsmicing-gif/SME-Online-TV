package com.smeonlinetv.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SMEOnlineTVApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@SMEOnlineTVApp)
            modules(appModule)
        }
    }
}
