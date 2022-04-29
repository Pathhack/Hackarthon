package com.pnu.hackarthon.presentation.view.TaskList

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import com.pnu.hackarthon.presentation.viewmodel.TaskLogViewModel

@Composable
fun TaskLogList(
    viewModel: TaskLogViewModel,
    scrollState: LazyListState
) {
    val logs = viewModel.taskLogs
    LazyColumn(content = )
}