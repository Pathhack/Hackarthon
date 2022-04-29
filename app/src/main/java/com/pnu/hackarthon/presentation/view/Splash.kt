package com.pnu.hackarthon.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.pnu.hackarthon.presentation.navigation.Screen
import com.pnu.hackarthon.ui.theme.HackarthonTheme

@Composable
fun SplashScreen(
    navController: NavController
) {
    SplashBackground {
        SplashContent {
            Text(
                text = "스플래시 화면",
                fontSize = 80.sp
            )
            Button(
                onClick = {
                    navController.navigate(route= Screen.Home.route) {
                        launchSingleTop = true
                    }
                }
            ) {
                Text(text = "홈 화면으로!")
            }
        }
    }
}

@Composable
private fun SplashBackground(
    content: @Composable BoxScope.() -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        content = content
    )
}

@Composable
private fun SplashContent(
    content: @Composable ColumnScope.() -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp, vertical = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        content = content,
    )
}

@Preview(showSystemUi = true)
@Composable
fun SplashScreenPreview() {
    HackarthonTheme {
        val navController = rememberNavController()
        SplashScreen(navController = navController)
    }
}