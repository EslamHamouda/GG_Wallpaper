package com.android.ggwallpaper.di

import com.android.ggwallpaper.data.repo.WallpaperRepositoryImpl
import com.android.ggwallpaper.data.service.WallpaperService
import com.android.ggwallpaper.domain.repo.WallpaperRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {
    @Provides
    @Singleton
    fun provideVendorRepository(service: WallpaperService): WallpaperRepository = WallpaperRepositoryImpl(service)
}