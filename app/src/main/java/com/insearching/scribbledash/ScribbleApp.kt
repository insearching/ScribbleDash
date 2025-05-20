package com.insearching.scribbledash

import android.app.Application
import com.insearching.scribbledash.presentation.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class ScribbleApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ScribbleApp)

            modules(appModule)
        }
    }
}