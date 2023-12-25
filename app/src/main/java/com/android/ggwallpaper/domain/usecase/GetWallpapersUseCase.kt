package com.android.ggwallpaper.domain.usecase

import androidx.paging.PagingData
import com.android.ggwallpaper.domain.model.WallpaperDomainModel
import com.android.ggwallpaper.domain.repo.WallpaperRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetWallpapersUseCase @Inject constructor(private val repository: WallpaperRepository) {
    suspend operator fun invoke(): Flow<PagingData<WallpaperDomainModel>> = repository.getWallpapers()
}