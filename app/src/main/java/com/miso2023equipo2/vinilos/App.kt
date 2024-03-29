package com.miso2023equipo2.vinilos

import android.app.Application
import androidx.annotation.StringRes
import com.miso2023equipo2.vinilos.data.AppContainer
import com.miso2023equipo2.vinilos.data.DefaultAppContainer

class App: Application() {
    /** instance used by the rest of classes to obtain dependencies */
    lateinit var container: AppContainer
    companion object {
        lateinit var instance: App private set
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
        container = DefaultAppContainer()
    }

}

object Strings {
    fun get(@StringRes stringRes: Int, vararg formatArgs: Any = emptyArray()): String {
        return App.instance.getString(stringRes, *formatArgs)
    }
}
