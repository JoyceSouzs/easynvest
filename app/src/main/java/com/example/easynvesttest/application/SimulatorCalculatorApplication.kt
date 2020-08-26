package com.example.easynvesttest.application

import android.app.Application
import com.example.easynvesttest.providers.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class SimulatorCalculatorApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@SimulatorCalculatorApplication)
            modules(appModules)
        }
    }

}