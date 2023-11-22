package com.example.swipeapp

import android.app.Application
import com.example.swipeapp.di.networkModule
import com.example.swipeapp.di.useCasesModule
import com.example.swipeapp.di.viewModelsModule
import org.koin.core.context.GlobalContext.startKoin

class SwipeApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(networkModule)
            modules(useCasesModule)
            modules(viewModelsModule)
        }
    }
}
