package com.toloco.app

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object ToLocoClient {
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true // Forgives us if backend sends extra fields
                prettyPrint = true
            })
        }
    }

    // Android Emulator uses 10.0.2.2 to talk to host machine
    // If testing on a REAL device, use your laptop's Wi-Fi IP (e.g., 192.168.1.5)
    private const val BASE_URL = "http://10.0.2.2:8080/api/reminders"

    suspend fun getNearbyReminders(lat: Double, lon: Double, radius: Double): List<Reminder> {
        // Example URL: http://10.0.2.2:8080/api/reminders/nearby?lat=...
        val url = "$BASE_URL/nearby?lat=$lat&lon=$lon&radius=$radius"

        // This actually calls the server
        return client.get(url).body()
    }
}