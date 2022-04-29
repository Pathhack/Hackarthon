package com.pnu.hackarthon.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pnu.hackarthon.presentation.view.HomeScreen
import com.pnu.hackarthon.presentation.view.SplashScreen
import com.pnu.hackarthon.presentation.view.TaskListScreen
import com.pnu.hackarthon.presentation.viewmodel.HomeViewModel
import com.pnu.hackarthon.presentation.viewmodel.TaskLogViewModel

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
            val viewModel = hiltViewModel<HomeViewModel>()
            HomeScreen(navController = navController, viewModel)
        }
        composable(route = Screen.TaskLog.route) {
            val viewModel = hiltViewModel<TaskLogViewModel>()
            TaskListScreen(navController = navController, viewModel = viewModel)
        }
    }
}