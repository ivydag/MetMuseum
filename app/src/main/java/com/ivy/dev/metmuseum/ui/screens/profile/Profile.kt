package com.ivy.dev.metmuseum.ui.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ivy.dev.metmuseum.R
import com.ivy.dev.metmuseum.data.models.MetUser

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileContent(navController: NavController, metUser: MetUser) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "User Profile", style = MaterialTheme.typography.bodyMedium)
                }
            )
        }
    ) {
        Column(modifier = Modifier.padding(it)) {
            UserInformation(metUser = metUser)
            SettingInformation(
                icon = R.drawable.icon_museum_24,
                label = "My museums",
                onTap = {})
            SettingInformation(
                icon = R.drawable.icon_edit_24,
                label = "Edit Profile",
                onTap = {})
            SettingInformation(
                icon = R.drawable.icon_map_24,
                label = "View Address Information",
                onTap = {})
            Divider(
                modifier = Modifier.padding(vertical = 10.dp)
            )
            SettingInformation(
                icon = R.drawable.icon_language_24,
                label = "Change Language",
                onTap = {})
        }
    }
}

@Composable
fun UserInformation(metUser: MetUser) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.user_profile),
            contentDescription = metUser.email,
            modifier = Modifier.size(80.dp)
        )
        Column(
            modifier = Modifier.padding(horizontal = 10.dp)
        ) {
            Text(
                text = metUser.email,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
            )
            Text(
                text = metUser.firstName + " " + metUser.lastName,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(top = 5.dp)
            )
        }
    }
}

@Composable
fun SettingInformation(icon: Int, label: String, onTap: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 10.dp)
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = { onTap() }
                )
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = label,
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.tertiary)
        )
        Text(
            text = label,
            modifier = Modifier.padding(start = 10.dp)
        )
        Box(
            modifier = Modifier.weight(1F),
        )
        Image(
            painter = painterResource(id = R.drawable.icon_keyboard_arrow_right),
            contentDescription = label,
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.secondary),
            modifier = Modifier.size(18.dp)
        )
    }
}