package com.android.ggwallpaper.data.mapper

import com.android.ggwallpaper.data.model.WallpaperResponseItem
import com.android.ggwallpaper.domain.model.WallpaperDomainModel
import com.android.ggwallpaper.domain.model.WallpaperUrlsDomainModel

object WallpaperDomainMapper{
    fun toDomain(from: WallpaperResponseItem) = WallpaperDomainModel(
        id = from.id,
        url = WallpaperUrlsDomainModel(
            from.urls.raw,
            from.urls.full,
            from.urls.small
        )
    )
}