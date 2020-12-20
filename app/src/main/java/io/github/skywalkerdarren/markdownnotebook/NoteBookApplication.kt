package io.github.skywalkerdarren.markdownnotebook

import android.app.Application
import android.content.Context

class NoteBookApplication : Application() {
    companion object {
        lateinit var appContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        appContext = this
    }
}