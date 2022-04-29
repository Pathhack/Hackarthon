package com.pnu.hackarthon.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.pnu.hackarthon.presentation.component.AppBottomNavigation
import com.pnu.hackarthon.presentation.view.TaskList.StatisticButton
import com.pnu.hackarthon.presentation.view.TaskList.TaskLogList
import com.pnu.hackarthon.presentation.view.TaskList.TopButtons
import com.pnu.hackarthon.presentation.viewmodel.TaskLogViewModel

@Composable
fun TaskListScreen(
    navController: NavController,
    viewModel: TaskLogViewModel
) {
    val scrollState = rememberLazyListState()

    Scaffold(
        bottomBar = {
            AppBottomNavigation(navController = navController)
        }
    ) {
        TaskListBackground {
            TaskListContent(it) {
                TopButtons()
                StatisticButton()
                TaskLogList(scrollState = scrollState, viewModel = viewModel)
            }
        }
    }
}

@Composable
fun TaskListBackground(
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
fun TaskListContent(
    innerPadding: PaddingValues,
    content: @Composable ColumnScope.() -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(horizontal = 30.dp, vertical = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        content = content,
    )
}

//@Preview(showSystemUi = true)
//@Composable
//fun TaksListScreenPreview() {
//    val navController = rememberNavController()
//    TaskListScreen(navController = navController)
//}