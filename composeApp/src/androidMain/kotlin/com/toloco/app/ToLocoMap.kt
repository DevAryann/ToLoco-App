package com.toloco.app

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView

@Composable
actual fun ToLocoMap(
    modifier: Modifier,
    latitude: Double,
    longitude: Double
) {
    AndroidView(
        factory = { context ->
            Configuration.getInstance().load(context, context.getSharedPreferences("osm", 0))
            MapView(context).apply {
                setTileSource(TileSourceFactory.MAPNIK)
                setMultiTouchControls(true)
                controller.setZoom(15.0)
                controller.setCenter(GeoPoint(latitude, longitude))
            }
        },
        modifier = modifier
    )
}
