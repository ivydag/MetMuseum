package com.ivy.dev.metmuseum.navigation

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val name: String,
    val route: Int,
    val icon: ImageVector,
)
