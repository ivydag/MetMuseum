package com.ivy.dev.metmuseum.ui.screens.gallery

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ivy.dev.metmuseum.R
import com.ivy.dev.metmuseum.ui.components.TittleBarComponent
import com.ivy.dev.metmuseum.ui.screens.home.HomeAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GalleryContent(navController: NavController) {
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
            TittleBarComponent(stringResource(id = R.string.gallery_title))
            GalleryElements()
            Divider()
        }
    }
}

//TODO RECEIVES THE LIST
@Composable
fun GalleryElements(){

}

//TODO made a component that receives a text and can be used for other views
@Composable
fun GallerryBar() {
    Column(
        modifier = Modifier.padding(horizontal = 15.dp, vertical = 20.dp)
    ) {
        Text(
            text = "PRUEBA GALLERY".uppercase(),
            style = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            ),
        )
    }
}