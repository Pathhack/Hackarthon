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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.pnu.hackarthon.domain.model.User
import com.pnu.hackarthon.domain.repository.TaskLogRepository
import com.pnu.hackarthon.presentation.component.AppBottomNavigation
import com.pnu.hackarthon.presentation.view.Home.*
import com.pnu.hackarthon.presentation.viewmodel.HomeViewModel
import com.pnu.hackarthon.ui.theme.HackarthonTheme

@Composable
fun HomeScreen(
    navController: NavController,
    homeViewModel: HomeViewModel,
) {
    Scaffold(
        bottomBar = {
            AppBottomNavigation(navController)
        },
    ) { innerPadding ->
        HomeBackground {
            HomeContent(innerPadding) {
                HeadBar()
                CharacterImage()
                CharacterInfo()
                TaskButtons(homeViewModel)
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
    innerPadding: PaddingValues,
    content: @Composable ColumnScope.() -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(horizontal = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        content = content,
    )
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HackarthonTheme {
    }
}