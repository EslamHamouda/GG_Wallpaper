package com.android.ggwallpaper.data.service

import com.android.ggwallpaper.data.model.WallpaperResponseItem
import retrofit2.http.GET
import retrofit2.http.Query

interface WallpaperService {
    @GET("photos")
    suspend fun getWallpapers(
        @Query("client_id") clientId: String = "WL225V6Emzt5Au9Sqge6s6cHEYwFuVVnuJc4ck9Lw1U",
        @Query("page") page: Int,
    ): List<WallpaperResponseItem>
}