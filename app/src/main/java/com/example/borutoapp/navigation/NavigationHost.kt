package com.example.borutoapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.borutoapp.utils.Constants.ARGUMENT_HERO_KEY

@Composable
fun NavigationHost(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route) {

        }

        composable(Screen.Welcome.route) {}
        composable(Screen.Home.route) {}
        composable(Screen.Details.route, arguments = listOf(navArgument(ARGUMENT_HERO_KEY) {
            type = NavType.IntType
        })) {

        }

        composable(Screen.Search.route) {}
    }
}