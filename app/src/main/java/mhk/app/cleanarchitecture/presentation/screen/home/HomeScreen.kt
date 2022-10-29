package mhk.app.cleanarchitecture.presentation.screen.home

import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import mhk.app.cleanarchitecture.presentation.components.MovieListItem
import mhk.app.cleanarchitecture.presentation.components.ProgressBar
import mhk.app.cleanarchitecture.presentation.screen.home.HomeViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import mhk.app.domain.util.Result
import mhk.app.cleanarchitecture.R
import mhk.app.cleanarchitecture.ui.theme.*

@Composable
fun HomeScreen(navController: NavHostController, viewModel: HomeViewModel = hiltViewModel()) {

    val systemUiController = rememberSystemUiController()
    val systemBarColor = MaterialTheme.colors.statusBarColor
    val allMovies = viewModel.getAllPopularMovies.collectAsLazyPagingItems()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = systemBarColor
        )
    }


    Scaffold(
        backgroundColor = MaterialTheme.colors.AppThemeColor,
        contentColor = MaterialTheme.colors.AppContentColor,
        topBar = {
            HomeTopBar()
        },
        content = {
            MovieListContent(allMovies = allMovies, navController = navController)
        }
    )
}

