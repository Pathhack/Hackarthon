package com.pnu.hackarthon.presentation.view.TaskList

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pnu.hackarthon.domain.model.TaskLog
import java.time.LocalDateTime

@Composable
fun TaskListItem(taskLog: TaskLog) {
    Row(
        modifier = Modifier
            .height(50.dp)
            .background(Color.LightGray)
            .padding(horizontal = 8.dp)
            .clip(RoundedCornerShape(18f)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = taskLog.date!!.toString())

        Spacer(modifier = Modifier.width(10.dp))

        Text(text = taskLog.title)
    }
}

@Preview
@Composable
fun TaskListItemPreview() {
    val taskLog = TaskLog(0, "분유주기", LocalDateTime.now())
    TaskListItem(taskLog)
}