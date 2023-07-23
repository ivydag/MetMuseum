package com.ivy.dev.metmuseum.data

import android.util.Log
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings

class RemoteConfigManager {

    companion object {
        private const val TAG = "RemoteConfigManager"

        private const val SHOW_TEXT = "show_body_text"
    }

    private val firebaseRemoteConfig: FirebaseRemoteConfig by lazy {
        FirebaseRemoteConfig.getInstance()
    }

    init {
        // Set Remote Config default values here (can be used for fallback)
        val defaults: Map<String, Any> = mapOf(
            SHOW_TEXT to false
            // Add more parameters and their default values as needed
        )

        firebaseRemoteConfig.setDefaultsAsync(defaults)

        // Set Remote Config settings (can be adjusted for production)
        val configSettings = FirebaseRemoteConfigSettings.Builder()
            .setMinimumFetchIntervalInSeconds(0) // Set the minimum fetch interval in seconds (e.g., 1 hour)
            .build()

        firebaseRemoteConfig.setConfigSettingsAsync(configSettings)
    }

    fun fetchAndActivate(onComplete: () -> Unit) {
        firebaseRemoteConfig.fetchAndActivate()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val updated = task.result
                    Log.d(TAG, "Config params updated: $updated")
                    firebaseRemoteConfig.activate()
                } else {
                    Log.e(TAG, "Fetch failed")
                }
                onComplete()
            }
    }

    fun getWelcomeMessage(): Boolean {
        return firebaseRemoteConfig.getValue(SHOW_TEXT).asBoolean()
    }

}