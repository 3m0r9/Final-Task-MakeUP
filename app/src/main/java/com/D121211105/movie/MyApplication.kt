package com.D121211105.movie

import android.app.Application
import com.D121211105.movie.data.AppContainer
import com.D121211105.movie.data.DefaultAppContainer

class MyApplication: Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }

}