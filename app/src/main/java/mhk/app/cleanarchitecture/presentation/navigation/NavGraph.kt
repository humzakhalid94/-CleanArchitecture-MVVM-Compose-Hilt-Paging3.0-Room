package mhk.app.cleanarchitecture.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import mhk.app.cleanarchitecture.presentation.screen.details.MovieDetailsScreen
import mhk.app.cleanarchitecture.presentation.screen.home.HomeScreen
import mhk.app.cleanarchitecture.util.Constant

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.MovieDetails.route,
            arguments = listOf(navArgument(Constant.MOVIE_DETAILS_ARGUMENT_KEY) {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            backStackEntry.arguments?.getString(Constant.MOVIE_DETAILS_ARGUMENT_KEY)
                ?.let { MovieDetailsScreen(it,navController) }
        }
    }
}