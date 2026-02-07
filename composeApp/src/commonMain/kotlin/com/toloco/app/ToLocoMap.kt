package com.toloco.app

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun ToLocoMap(
    modifier: Modifier,
    latitude: Double,
    longitude: Double
)
