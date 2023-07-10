package com.ivy.dev.metmuseum.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun TittleBarComponent(title:String) {
    Column(
        modifier = Modifier.padding(horizontal = 15.dp, vertical = 20.dp)
    ) {
        Text(
            text = title.uppercase(),
            style = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            ),
        )
    }
}