package com.ivy.dev.metmuseum

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
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
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@Composable
fun GreetingPreview() {
    MetMuseumTheme {
        Greeting("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun MainContainer(){
    val navController = rememberNavController()
}