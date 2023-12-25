package com.android.ggwallpaper.presentation.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.android.ggwallpaper.domain.model.WallpaperDomainModel
import com.android.ggwallpaper.domain.usecase.GetWallpapersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getWallpapersUseCase: GetWallpapersUseCase) :
    ViewModel() {

    private var _getWallpapersResponse: MutableStateFlow<PagingData<WallpaperDomainModel>> =
        MutableStateFlow(PagingData.empty())
    val getWallpapersResponse
        get() = _getWallpapersResponse.asStateFlow()

    fun getWallpapers() {
        viewModelScope.launch {
            getWallpapersUseCase().cachedIn(viewModelScope).flowOn(Dispatchers.IO).collect {
                _getWallpapersResponse.value = it
            }
        }
    }

}