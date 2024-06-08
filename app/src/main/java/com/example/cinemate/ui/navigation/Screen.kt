package com.example.cinemate.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Profile : Screen("profile")
    object Detail : Screen("home/{movieId}") {
        fun createRoute(movieId: Long) = "home/$movieId"
    }
}
