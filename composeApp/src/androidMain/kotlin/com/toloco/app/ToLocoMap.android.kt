package com.toloco.app

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker // Import this

@Composable
fun ToLocoMap(
    modifier: Modifier,
    latitude: Double,
    longitude: Double,
    reminders: List<Reminder>
) {
    AndroidView(
        factory = { context ->
            MapView(context).apply {
                setTileSource(TileSourceFactory.MAPNIK)
                setMultiTouchControls(true)
                controller.setZoom(15.0)
                controller.setCenter(GeoPoint(latitude, longitude))
            }
        },
        update = { mapView ->
            // This block runs every time 'reminders' changes

            // 1. Clear old markers so we don't get duplicates
            mapView.overlays.clear()

            // 2. Add a marker for each reminder
            reminders.forEach { reminder ->
                val marker = Marker(mapView)
                marker.position = GeoPoint(reminder.latitude, reminder.longitude)
                marker.title = reminder.itemName // Shows "Buy Milk" when clicked
                marker.snippet = reminder.shopName // Shows "D-Mart"
                mapView.overlays.add(marker)
            }

            // 3. Refresh the map to show changes
            mapView.invalidate()
        },
        modifier = modifier
    )
}