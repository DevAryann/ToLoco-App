package com.toloco.app

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView

@Composable
actual fun ToLocoMap(
    modifier: Modifier,
    latitude: Double,
    longitude: Double
) {
    // AndroidView allows us to use classic Android Views (like MapView) inside Compose
    AndroidView(
        factory = { context ->
            MapView(context).apply {
                // 1. Set the Map Source (Mapnik is the standard OSM look)
                setTileSource(TileSourceFactory.MAPNIK)

                // 2. Enable Multi-touch controls (zooming with fingers)
                setMultiTouchControls(true)

                // 3. Set the starting position
                controller.setZoom(15.0)
                val startPoint = GeoPoint(latitude, longitude)
                controller.setCenter(startPoint)
            }
        },
        modifier = modifier
    )
}