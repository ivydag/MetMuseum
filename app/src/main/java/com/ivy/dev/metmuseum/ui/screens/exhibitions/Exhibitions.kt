package com.ivy.dev.metmuseum.ui.screens.exhibitions

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.ivy.dev.metmuseum.R
import com.ivy.dev.metmuseum.ui.components.TittleBarComponent
import com.ivy.dev.metmuseum.ui.screens.home.HomeAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExhibitionsContent() {
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
            TittleBarComponent(stringResource(id = R.string.exhibition_title))
            Divider()
        }
    }
}