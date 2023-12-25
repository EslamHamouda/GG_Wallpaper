package com.android.ggwallpaper.presentation.home.ui

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.rememberAsyncImagePainter
import com.android.ggwallpaper.domain.model.WallpaperDomainModel
import com.android.ggwallpaper.domain.model.WallpaperUrlsDomainModel
import com.android.ggwallpaper.presentation.home.viewmodel.HomeViewModel
import com.android.ggwallpaper.presentation.ui.theme.GGWallpaperTheme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

@Composable
fun HomeScreen(viewModel: HomeViewModel, onClick: (url:String) -> Unit) {
    SideEffect {
        viewModel.getWallpapers()
    }
    WallpapersList(result = viewModel.getWallpapersResponse, onClick = { onClick(it) })
}

@Composable
fun WallpapersList(result: StateFlow<PagingData<WallpaperDomainModel>>, onClick: (url:String) -> Unit) {
    val list = result.collectAsLazyPagingItems()
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalItemSpacing = 10.dp
    ) {
        items(list.itemCount) { item ->
            WallpaperItem(
                url = list[item]!!.url,
                onClick = {onClick(it)}
            )
        }
    }
    list.apply {
        when {
            loadState.refresh is LoadState.Loading || loadState.append is LoadState.Loading -> {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
            loadState.refresh is LoadState.Error || loadState.append is LoadState.Error -> {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Error")
                }
            }
            loadState.refresh is LoadState.NotLoading -> {
            }
        }
    }
}

@Composable
fun WallpaperItem(url: WallpaperUrlsDomainModel, onClick:(url:String)->Unit, modifier: Modifier = Modifier) {
    Image(
        painter = rememberAsyncImagePainter(url.small),
        contentDescription = "Wallpaper",
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .size(250.dp)
            .clickable(onClick = { onClick(url.full) }),
        contentScale = ContentScale.Crop
    )
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    GGWallpaperTheme {
        //HomeScreen()
    }
}