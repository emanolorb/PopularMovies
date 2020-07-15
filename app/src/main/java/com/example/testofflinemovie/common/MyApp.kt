package com.example.testofflinemovie.common

import android.app.Application

// para regresar el contexto y otras cosas en cualquier lugar que estemos
// se debe iniciar en el manifiesto

class MyApp: Application() {
    companion object{
        lateinit var instance: MyApp
    }

    override fun onCreate() {

        super.onCreate()
        instance = this
    }
}