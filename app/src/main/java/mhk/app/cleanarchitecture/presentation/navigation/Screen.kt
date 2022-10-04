package mhk.app.cleanarchitecture.presentation.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home_screen")
}
