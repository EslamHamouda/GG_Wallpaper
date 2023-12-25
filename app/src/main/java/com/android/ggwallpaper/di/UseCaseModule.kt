package com.android.ggwallpaper.di

import com.android.ggwallpaper.domain.repo.WallpaperRepository
import com.android.ggwallpaper.domain.usecase.GetWallpapersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideGetWallpapersUseCase(repository: WallpaperRepository): GetWallpapersUseCase = GetWallpapersUseCase(repository)
}