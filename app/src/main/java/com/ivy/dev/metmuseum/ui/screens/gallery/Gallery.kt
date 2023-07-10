package com.ivy.dev.metmuseum.ui.screens.gallery

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.ivy.dev.metmuseum.R
import com.ivy.dev.metmuseum.data.models.GalleryResponse
import com.ivy.dev.metmuseum.ui.components.TittleBarComponent
import com.ivy.dev.metmuseum.ui.screens.home.HomeAppBar
import com.ivy.dev.metmuseum.ui.viewmodel.gallery.GalleryViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GalleryContent(navController: NavController, viewModel: GalleryViewModel) {
    Scaffold(
        topBar = {
            HomeAppBar(
                onNavigateToSearchPage = {
                }
            )
        }
    ) { it ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(it),
        ) {

            val galleryData: GalleryResponse? = viewModel.galleryData.value
            val coroutineScope = rememberCoroutineScope()

            LaunchedEffect(Unit) {
                coroutineScope.launch {
                    viewModel.fetchGallery()
                }
            }

            if (galleryData != null) {
                GalleryElements(viewModel = viewModel)
            } else {
                Text("Loading...")
            }
            TittleBarComponent(stringResource(id = R.string.gallery_title))

            Divider()
        }
    }
}

//TODO RECEIVES THE LIST
@Composable
fun GalleryElements(viewModel: GalleryViewModel){
  Text(text = "HOLA")
}
