package com.android.ggwallpaper.data.model

import com.google.gson.annotations.SerializedName

data class TopicSubmissions(
    val nature: Nature,
    @SerializedName("textures-patterns")
    val texturesPatterns: TexturesPatterns,
    val wallpapers: Wallpapers
)