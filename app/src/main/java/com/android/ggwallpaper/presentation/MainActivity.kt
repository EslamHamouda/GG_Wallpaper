package com.android.ggwallpaper.presentation

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.android.ggwallpaper.presentation.details.ui.DetailsScreen
import com.android.ggwallpaper.presentation.home.ui.HomeScreen
import com.android.ggwallpaper.presentation.home.viewmodel.HomeViewModel
import com.android.ggwallpaper.presentation.ui.theme.GGWallpaperTheme
import dagger.hilt.android.AndroidEntryPoint
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GGWallpaperTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavHost()
                }
            }
        }
    }
}

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val viewModel: HomeViewModel = viewModel()
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = "Home"
    ) {
        composable("Home") {
            HomeScreen(viewModel) {
                navController.navigate("Details/${Uri.encode(it)}")
            }
        }
        composable("Details/{url}") {
            DetailsScreen(it.arguments?.getString("url") ?: "https://static.thenounproject.com/png/504708-200.png")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GGWallpaperTheme {
    }
}