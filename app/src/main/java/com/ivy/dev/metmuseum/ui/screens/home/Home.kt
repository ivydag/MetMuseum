package com.ivy.dev.metmuseum.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ivy.dev.metmuseum.data.models.MetUser
import com.ivy.dev.metmuseum.navigation.BottomNavData
import com.ivy.dev.metmuseum.navigation.BottomNavItem
import com.ivy.dev.metmuseum.ui.screens.profile.ProfileContent
import com.ivy.dev.metmuseum.ui.theme.Amber80
import com.ivy.dev.metmuseum.ui.viewmodel.home.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(homeViewModel: HomeViewModel, navController: NavController) {
    val homeUIState = homeViewModel.uiState.collectAsState().value
    val metUser = MetUser(firstName = "Ivonne", lastName = "Morales", email = "ivmorales@gmail.com", password = "159u6lkn")
    Scaffold(bottomBar = {
        BottomBar(
            bottomNavItems = homeViewModel.bottomNavItems,
            onItemClick = {homeViewModel.changeIndex(it)},
            activeIndex = homeUIState.selectedIndex
        )
    }
    ) {
        Box(modifier = Modifier.padding(paddingValues = it))
        when (homeUIState.selectedIndex){
            0 -> HomeContent(navController = navController)
            3 -> ProfileContent(navController= navController, metUser)
            else -> HomeContent(navController = navController)

        }
    }
       
         
}

@Composable
fun BottomBar(
    bottomNavItems: List<BottomNavItem>,
    onItemClick: (Int) -> Unit,
    activeIndex: Int
){
    BottomAppBar(containerColor = Amber80) {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            bottomNavItems.map { item ->
                val isActive: Boolean = activeIndex == item.route
                Button(
                    onClick = { onItemClick(item.route) },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = if (isActive) MaterialTheme.colorScheme.onPrimary else Color.Gray
                    ),
                    //contentPadding = PaddingValues(0.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector =  item.icon,
                            contentDescription = item.name
                        )
                        if (isActive)
                            Text(text = item.name, fontSize = 10.sp)
                    }
                }
            }
        }
    }


}


@Composable
fun HomeBottomBarPreview() {
    BottomBar(
        BottomNavData.bottomNavItem,
        onItemClick = {

        },
        activeIndex = 1
    )
}