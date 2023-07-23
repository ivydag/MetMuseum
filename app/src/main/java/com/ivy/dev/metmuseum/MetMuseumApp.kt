package com.ivy.dev.metmuseum

import android.app.Application
import android.util.Log
import com.google.firebase.FirebaseApp
import com.ivy.dev.metmuseum.data.RemoteConfigManager

class MetMuseumApp: Application() {
    @Override
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
        val remoteConfigManager = RemoteConfigManager()
        remoteConfigManager.fetchAndActivate{

            val welcomeMessage = remoteConfigManager.getWelcomeMessage()
            Log.d("MetMuseumApp", "Config params updated: $welcomeMessage")
        }
    }
}