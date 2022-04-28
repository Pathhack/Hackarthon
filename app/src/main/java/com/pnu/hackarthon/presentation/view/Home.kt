package com.pnu.hackarthon.presentation.view

import android.net.wifi.hotspot2.pps.HomeSp
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.pnu.hackarthon.presentation.navigation.Screen
import com.pnu.hackarthon.ui.theme.HackarthonTheme

@Composable
fun HomeScreen(
    navController: NavController
) {
    HomeBackground {
        HomeContent {
            Text(text = "홈 화면")
            Button(
                onClick = {
                    navController.navigate(route= Screen.Splash.route)
                }
            ) {
                Text(text = "네이버 지도 띄우기")
            }
        }
    }
}

@Composable
private fun HomeBackground(
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
private fun HomeContent(
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
fun HomeScreenPreview() {
    HackarthonTheme {
        val navController = rememberNavController()
        HomeScreen(navController = navController)
    }
}