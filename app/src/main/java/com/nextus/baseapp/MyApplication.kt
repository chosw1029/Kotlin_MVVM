package com.nextus.baseapp

import android.app.Application
import com.nextus.baseapp.di.appModules
import com.nextus.baseapp.utils.AppLogger
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            AppLogger.init()
            Timber.plant(Timber.DebugTree())
        }

        // start Koin!
        startKoin {
            // Android context
            androidContext(this@MyApplication)
            // modules
            modules(appModules)
        }
    }
}