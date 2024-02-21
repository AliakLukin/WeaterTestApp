package com.example.weatertestapp.app

import android.app.Application
import com.example.weatertestapp.di.appModule
import com.example.weatertestapp.di.dataModule
import com.example.weatertestapp.di.databaseModule
import com.example.weatertestapp.di.domainModule
import com.example.weatertestapp.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class WeatherApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@WeatherApp)
            modules(appModule, dataModule, domainModule, networkModule, databaseModule)
        }
    }
}