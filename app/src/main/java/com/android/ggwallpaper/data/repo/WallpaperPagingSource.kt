package com.android.ggwallpaper.data.repo

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.android.ggwallpaper.data.mapper.WallpaperDomainMapper
import com.android.ggwallpaper.data.service.WallpaperService
import com.android.ggwallpaper.domain.model.WallpaperDomainModel


class WallpaperPagingSource (
    private val service: WallpaperService
) :
    PagingSource<Int, WallpaperDomainModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, WallpaperDomainModel> {

        return try {
            val position = params.key ?: 0
            val response = service.getWallpapers(
                page = position
            ).map { dto -> WallpaperDomainMapper.toDomain(dto) }
            LoadResult.Page(
                data = response,
                prevKey = if (position == 0) null else position - 1,
                nextKey = if (response.isEmpty()) null else position + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    }

    override fun getRefreshKey(state: PagingState<Int, WallpaperDomainModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}