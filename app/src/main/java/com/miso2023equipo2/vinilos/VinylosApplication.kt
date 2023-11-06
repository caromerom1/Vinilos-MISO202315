package com.miso2023equipo2.vinilos

import android.app.Application
import com.miso2023equipo2.vinilos.data.AppContainer
import com.miso2023equipo2.vinilos.data.DefaultAppContainer

class VinylosApplication: Application() {
    /** instance used by the rest of classes to obtain dependencies */
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}