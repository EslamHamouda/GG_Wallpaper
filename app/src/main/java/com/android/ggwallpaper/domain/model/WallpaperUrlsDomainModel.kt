package com.android.ggwallpaper.domain.model

import com.google.gson.annotations.SerializedName

data class WallpaperUrlsDomainModel(
    val raw: String,
    val full: String,
    val small: String
)