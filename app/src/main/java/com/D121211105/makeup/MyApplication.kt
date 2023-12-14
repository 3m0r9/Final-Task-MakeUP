package com.D121211105.makeup

import android.app.Application
import com.D121211105.makeup.data.AppContainer
import com.D121211105.makeup.data.DefaultAppContainer

class MyApplication: Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }

}