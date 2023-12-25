package com.android.ggwallpaper.di

import com.android.ggwallpaper.data.service.WallpaperService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    @Singleton
    fun wallpaperService(retrofit: Retrofit): WallpaperService =
        retrofit.create(WallpaperService::class.java)
}