package com.ivy.dev.metmuseum.ui.viewmodel.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.ivy.dev.metmuseum.MetMuseumApp
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.StateFlow

class MainPageViewModel: ViewModel() {

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as MetMuseumApp)
                MainPageViewModel()
            }
        }
    }




}