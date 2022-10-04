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
import mhk.app.cleanarchitecture.presentation.components.MovieListItem
import mhk.app.cleanarchitecture.presentation.components.ProgressBar
import mhk.app.cleanarchitecture.presentation.screen.home.HomeViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import mhk.app.domain.util.Result
import mhk.app.cleanarchitecture.R
import mhk.app.cleanarchitecture.ui.theme.statusBarColor
import mhk.app.cleanarchitecture.ui.theme.titleColor
import mhk.app.cleanarchitecture.ui.theme.topAppbarBackgroundColor

@Composable
fun HomeScreen(navController: NavHostController, viewModel: HomeViewModel = hiltViewModel()) {

    val systemUiController = rememberSystemUiController()
    val systemBarColor = MaterialTheme.colors.statusBarColor
    val titleColor = MaterialTheme.colors.titleColor
    val topAppbarBackgroundColor = MaterialTheme.colors.topAppbarBackgroundColor

    SideEffect {
        systemUiController.setStatusBarColor(
            color = systemBarColor
        )
    }

    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(text = stringResource(R.string.app_name), color = titleColor)
            },
            backgroundColor = topAppbarBackgroundColor
        )
    }) {
        when (val movieResponse = viewModel.movieState.value) {
            is Result.Loading -> ProgressBar()
            is Result.Success -> LazyColumn(
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
            ) {
                movieResponse.data?.let { movieList ->
                    items(
                        items = movieList.movies,
                        itemContent = {
                            MovieListItem(movie = it, navController = navController)
                        }
                    )
                }
            }
            is Result.Error -> Toast.makeText(
                LocalContext.current,
                stringResource(R.string.toast_error),
                Toast.LENGTH_SHORT
            )
        }
    }
}

