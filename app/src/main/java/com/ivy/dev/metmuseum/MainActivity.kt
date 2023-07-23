package com.ivy.dev.metmuseum

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.ivy.dev.metmuseum.data.RemoteConfigManager
import com.ivy.dev.metmuseum.data.repository.GalleryRepository
import com.ivy.dev.metmuseum.navigation.MetNavigationComposable
import com.ivy.dev.metmuseum.network.ApiClient
import com.ivy.dev.metmuseum.ui.theme.MetMuseumTheme
import com.ivy.dev.metmuseum.ui.viewmodel.gallery.GalleryViewModel

class MainActivity : ComponentActivity() {
    private lateinit var galleryRepository: GalleryRepository
    private val galleryViewModel: GalleryViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val remoteConfigManager = RemoteConfigManager()

        val isShowedMessage = remoteConfigManager.getWelcomeMessage()
        if (isShowedMessage) Toast.makeText(applicationContext, isShowedMessage.toString(), Toast.LENGTH_SHORT).show() else Log.d(TAG, "Welcome message is disabled.")
        Log.d("MainActivity", "Config params acity: $isShowedMessage")

        galleryRepository = ApiClient.getGalleryRepository()
        setContent {
            MetMuseumTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    MetNavigationComposable(navController, galleryRepository)
                }
            }
        }
    }
    companion object{
        const val TAG = "MainActivity"
    }
}