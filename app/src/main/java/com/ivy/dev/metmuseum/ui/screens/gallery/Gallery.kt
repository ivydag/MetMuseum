package com.ivy.dev.metmuseum.ui.screens.gallery

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ivy.dev.metmuseum.R
import com.ivy.dev.metmuseum.data.models.GalleryResponse
import com.ivy.dev.metmuseum.data.models.Record
import com.ivy.dev.metmuseum.ui.components.LottieLoading
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
            Divider()

            if (galleryData != null) {
                SetGalleryList(galleryData = galleryData, onItemClicked = {} )
            } else {
                LottieLoading()
            }
            TittleBarComponent(stringResource(id = R.string.gallery_title))
        }
    }
}
@Composable
fun SetGalleryList(galleryData: GalleryResponse, onItemClicked: (Int) -> Unit){
    val listRecords = galleryData.records
    LazyColumn(
        modifier = Modifier.padding(vertical = 10.dp)
    ) {
        items(
            listRecords.size,
            itemContent = {
                GalleryElements(
                    galleryElements = listRecords[it],
                    onItemClick = {
                        onItemClicked(listRecords[it].id)
                    }
                )
            }
        )
    }
}

@Composable
fun GalleryElements(galleryElements: Record, onItemClick:()-> Unit){
    Column(
        modifier = Modifier
            .padding(horizontal = 15.dp, vertical = 10.dp)
            .clickable {
                //TODO ADD LATER FOR ANOTHEr SCREEN IF POSSIBLE
                //onItemClick()
            },
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(2F)
            ) {
                Text(
                    text = galleryElements.name,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold,
                    ),
                    modifier = Modifier.padding(bottom = 5.dp)
                )
                Text(
                    text = "Floor: " + galleryElements.floor.toString(),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(bottom = 5.dp),
                    maxLines = 2,
                    overflow = TextOverflow.Visible
                )
                Text(
                    text = "Theme:  ${galleryElements.theme ?: "No Records"}",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Medium,
                    ),
                    modifier = Modifier.padding(bottom = 5.dp)
                )
                Text(
                    text = "Last updated :" +galleryElements.lastupdate,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Medium,
                    ),
                    modifier = Modifier.padding(bottom = 5.dp)
                )
            }
        }

        Divider(
            modifier = Modifier.padding(top = 15.dp)
        )
    }
}
