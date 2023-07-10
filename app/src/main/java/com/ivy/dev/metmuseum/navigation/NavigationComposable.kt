package com.ivy.dev.metmuseum.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ivy.dev.metmuseum.ui.screens.home.Home
import com.ivy.dev.metmuseum.ui.viewmodel.home.HomeViewModel


@Composable
fun MetNavigationComposable(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Routes.HOME.name
    ) {
        composable(Routes.HOME.name) {
           Home(homeViewModel = HomeViewModel(), navController)
        }
        composable(Routes.PROFILE.name) {

        }

    }

}