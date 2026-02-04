package com.toloco.app

import kotlinx.serialization.Serializable

@Serializable
data class Reminder(


    val id: Long? = null,
    val itemName: String,
    val shopName: String,
    val latitude: Double,
    val longitude: Double,
    val isNotified: Boolean = false
)