package com.android.ggwallpaper.domain.repo

import androidx.paging.PagingData
import com.android.ggwallpaper.domain.model.WallpaperDomainModel
import kotlinx.coroutines.flow.Flow

interface WallpaperRepository {
    suspend fun getWallpapers():
            Flow<PagingData<WallpaperDomainModel>>
}