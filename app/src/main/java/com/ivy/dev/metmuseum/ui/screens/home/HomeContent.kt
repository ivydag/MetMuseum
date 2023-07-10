package com.ivy.dev.metmuseum.ui.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ivy.dev.metmuseum.R
import com.ivy.dev.metmuseum.ui.components.GridWithCards

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeContent(
    navController: NavController
) {
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
            HomeBanner(
                onSearch = {

                }
            )
            Divider()
            RecyclerViewContent()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeAppBar(onNavigateToSearchPage: () -> Unit) {
    TopAppBar(
        title = {
            LogoImage(size = 100.dp)
        }
    )
}


@Composable
fun HomeBanner(onSearch: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(280.dp)
            .background(color = MaterialTheme.colorScheme.primary),
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .weight(1F)
                    .padding(horizontal = 15.dp)
            ) {
                Text(
                    text = "Harvard Art Museum",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                )
                Text(
                    text = "Boston",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onPrimary
                )
                Text(
                    text = stringResource(id = R.string.home_body_text),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.padding(top = 15.dp)
                )
            }
            Image(
                painter = painterResource(id = R.drawable.harvard_museum),
                contentDescription = "Little Lemon",
                modifier = Modifier
                    .size(170.dp)
                    .clip(RoundedCornerShape(15))
                    .weight(1F)
                    .padding(horizontal = 15.dp),
                contentScale = ContentScale.Crop

            )
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecyclerViewContent() {
    Scaffold(
        topBar = { /* Top Bar */ },
        content = {
            Surface(color = MaterialTheme.colorScheme.primary) {
                GridWithCards()
            }
        }
    )
}

@Composable
fun LogoImage(size: Dp) {
    Image(
        painter = painterResource(id = R.drawable.harvard_m_logo),
        contentDescription = "Little Lemon Logo",
        contentScale = ContentScale.Fit,
        modifier = Modifier.size(size)
    )
}