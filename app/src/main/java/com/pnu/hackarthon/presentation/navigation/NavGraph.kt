package com.pnu.hackarthon.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pnu.hackarthon.presentation.view.HomeScreen
import com.pnu.hackarthon.presentation.view.SplashScreen
import com.pnu.hackarthon.presentation.viewmodel.HomeViewModel

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.Home.route) {
            val viewModel = HomeViewModel()
            HomeScreen(navController = navController, viewModel)
        }
    }
}