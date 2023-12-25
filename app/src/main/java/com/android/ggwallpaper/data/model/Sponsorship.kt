package com.android.ggwallpaper.data.model

import com.google.gson.annotations.SerializedName

data class Sponsorship(
    @SerializedName("impression_urls")
    val impressionUrls: List<String>,
    val sponsor: Sponsor,
    val tagline: String,
    @SerializedName("tagline_url")
    val taglineUrl: String
)