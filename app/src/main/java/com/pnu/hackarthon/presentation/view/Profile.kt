package com.pnu.hackarthon.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.pnu.hackarthon.ui.theme.HackarthonTheme

@Composable
fun ProfileScreen(
    navController: NavController
) {
    Scaffold() { innerPadding ->
        ProfileBackground {
            ProfileContent(innerPadding = innerPadding) {

            }
        }
    }
}

@Composable
private fun ProfileBackground(
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
private fun ProfileContent(
    innerPadding: PaddingValues,
    content: @Composable ColumnScope.() -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        content = content,
    )
}

@Preview(showSystemUi = true)
@Composable
private fun ProfileScreenPreview() {
    HackarthonTheme {
        val navController = rememberNavController()
        ProfileScreen(navController = navController)
    }
}