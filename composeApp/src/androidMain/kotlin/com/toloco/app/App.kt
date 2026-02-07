package com.toloco.app

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun App() {
    MaterialTheme {
        Column(Modifier.fillMaxSize()) {
            // Header
            Text(
                text = "ToLoco Map",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(16.dp)
            )

            // The Map (Taking up all remaining space)
            ToLocoMap(
                modifier = Modifier.fillMaxSize(),
                latitude = 19.0760, // Mumbai
                longitude = 72.8777
            )
        }
    }
}