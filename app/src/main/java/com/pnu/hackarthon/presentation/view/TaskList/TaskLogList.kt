package com.pnu.hackarthon.presentation.view.TaskList

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pnu.hackarthon.presentation.viewmodel.TaskLogViewModel

@Composable
fun TaskLogList(
    viewModel: TaskLogViewModel,
    scrollState: LazyListState
) {
    val logs = viewModel.taskLogs.value

    Spacer(Modifier.height(20.dp))
    LazyColumn(
        state = scrollState
    ) {
        items(logs) { log ->
            TaskListItem(taskLog = log)
            Spacer(modifier=Modifier.height(10.dp))
        }
    }
}