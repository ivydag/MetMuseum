package com.ivy.dev.metmuseum.ui.viewmodel.home

import androidx.lifecycle.ViewModel
import com.ivy.dev.metmuseum.navigation.BottomNavData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()
    val bottomNavItems = BottomNavData.bottomNavItem


    fun changeIndex(newIndex: Int) {
        _uiState.update {
            it.copy(selectedIndex = newIndex)
        }
    }
}