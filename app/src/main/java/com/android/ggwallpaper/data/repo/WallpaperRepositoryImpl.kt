package com.android.ggwallpaper.data.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.android.ggwallpaper.data.service.WallpaperService
import com.android.ggwallpaper.domain.model.WallpaperDomainModel
import com.android.ggwallpaper.domain.repo.WallpaperRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class WallpaperRepositoryImpl @Inject constructor(private val service: WallpaperService) :
    WallpaperRepository {

    override suspend fun getWallpapers(): Flow<PagingData<WallpaperDomainModel>> =
        Pager(
            config = PagingConfig(
                pageSize = 30,
                enablePlaceholders = false,
                initialLoadSize = 2
            ),
            pagingSourceFactory = {
                WallpaperPagingSource(service)
            }, initialKey = 0
        ).flow

}