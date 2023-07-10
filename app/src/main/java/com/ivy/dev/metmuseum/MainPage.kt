package com.ivy.dev.metmuseum

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ivy.dev.metmuseum.ui.viewmodel.main.MainPageUiState
import com.ivy.dev.metmuseum.ui.viewmodel.main.MainPageViewModel

@Composable
fun MainPage(
    mainPageViewModel : MainPageViewModel = viewModel(
        factory = MainPageViewModel.Factory
    )
) {

}