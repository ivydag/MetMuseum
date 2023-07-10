package com.ivy.dev.metmuseum.navigation

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Place
import androidx.compose.material.icons.rounded.Star

object BottomNavData {

    val bottomNavItem = listOf<BottomNavItem>(
        BottomNavItem(name = "Home", route = 0, icon = Icons.Rounded.Home),
        BottomNavItem(name = "Gallery", route = 1, icon = Icons.Rounded.Star),
        BottomNavItem(name = "Exhibitions", route = 2, icon = Icons.Rounded.Place),
        BottomNavItem(name = "Profile", route = 3, icon = Icons.Rounded.Person)
    )
}