package com.pnu.hackarthon.presentation.view

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.pnu.hackarthon._constant.UIConstant
import com.pnu.hackarthon.presentation.navigation.Screen
import com.pnu.hackarthon.ui.theme.HackarthonTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController
) {
    val duration = UIConstant.ANIMATION_DURATION_SPLASH
    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(duration)
    )
    
    LaunchedEffect(true) {
        startAnimation = true

        delay(duration + 500L)
        navController.popBackStack()
        navController.navigate(Screen.Home.route)
    }

    SplashBackground(alpha = alphaAnim.value) {
        SplashContent {
            LogoArea()
        }
    }
}

@Composable
private fun LogoArea() {
    Spacer(Modifier.height(50.dp))
    Text(
        modifier = Modifier,
        text = "HACKARTHON",
        color = Color.Black,
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
private fun SplashBackground(
    alpha: Float,
    content: @Composable BoxScope.() -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .alpha(alpha),
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