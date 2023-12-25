package com.android.ggwallpaper.presentation.details.ui

import android.telecom.Call.Details
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.android.ggwallpaper.presentation.home.ui.HomeScreen
import com.android.ggwallpaper.presentation.ui.theme.GGWallpaperTheme

@Composable
fun DetailsScreen(url: String){
   WallpaperItem(url = url)
}

@Composable
fun WallpaperItem(url: String, modifier: Modifier = Modifier) {
    Image(
        painter = rememberAsyncImagePainter(url),
        contentDescription = "Wallpaper",
        modifier = modifier.fillMaxSize(),
        contentScale = ContentScale.Crop,
    )
}

@Preview(showBackground = true)
@Composable
fun ScreenScreenPreview() {
    GGWallpaperTheme {
        //DetailsScreen()
    }
}