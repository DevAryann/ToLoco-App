package com.toloco.app

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch

@Composable
fun App() {
    MaterialTheme {
        // Scope to run async network calls
        val scope = rememberCoroutineScope()
        var statusText by remember { mutableStateOf("Ready to fetch...") }

        Column(Modifier.fillMaxSize()) {
            Text(text = statusText)

            Button(onClick = {
                scope.launch {
                    try {
                        statusText = "Fetching..."
                        // Using the coordinates of your Backend Test
                        val reminders = ToLocoClient.getNearbyReminders(19.0760, 72.8777, 100.0)
                        statusText = "Success! Found: ${reminders.size} items"
                    } catch (e: Exception) {
                        statusText = "Error: ${e.message}"
                    }
                }
            }) {
                Text("Test Connection")
            }
        }
    }
}