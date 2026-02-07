package com.toloco.app

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch

@Composable
fun App() {
    MaterialTheme {
        // State to hold our list of reminders
        var reminders by remember { mutableStateOf<List<Reminder>>(emptyList()) }
        val scope = rememberCoroutineScope()

        // LaunchedEffect runs once when the app starts
        LaunchedEffect(Unit) {
            try {
                // Fetch from Backend (Use your specific Lat/Lon)
                reminders = ToLocoClient.getNearbyReminders(19.0760, 72.8777, 5000.0)
            } catch (e: Exception) {
                println("Error fetching reminders: ${e.message}")
            }
        }

        Column(Modifier.fillMaxSize()) {
            ToLocoMap(
                modifier = Modifier.fillMaxSize(),
                latitude = 19.0760,
                longitude = 72.8777,
                reminders = reminders // Pass the data to the map!
            )
        }
    }
}