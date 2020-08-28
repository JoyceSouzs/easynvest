package com.example.easynvesttest.application

import android.app.Application
import com.example.easynvesttest.providers.di.androidModule
import com.example.easynvesttest.providers.di.repositoryModule
import com.example.easynvesttest.providers.di.retrofitModule
import com.example.easynvesttest.providers.di.viewModelModule
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
            modules(
                listOf(
                    androidModule,
                    retrofitModule,
                    repositoryModule,
                    viewModelModule
                )
            )
        }
    }

}