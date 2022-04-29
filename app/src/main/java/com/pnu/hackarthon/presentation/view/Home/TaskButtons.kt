package com.pnu.hackarthon.presentation.view.Home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.pnu.hackarthon._constant.UIConstant
import com.pnu.hackarthon._enums.TaskType
import com.pnu.hackarthon.domain.model.User
import com.pnu.hackarthon.presentation.viewmodel.HomeViewModel
import com.pnu.hackarthon.ui.theme.Purple200

@Composable
fun ColumnScope.TaskButtons(
    viewModel: HomeViewModel
) {
    val itemWidth = UIConstant.WIDTH_ITEM_MEDIUM
    Spacer(Modifier.height(30.dp))
    Box(
        modifier = Modifier.weight(1f),
        contentAlignment = Alignment.Center
    ) {
        Row(Modifier.height(80.dp)) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp)
                    .background(Purple200)
                    .clickable { viewModel.addTaskLog(TaskType.MILK) },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "분유",
                    textAlign = TextAlign.Center,
                    color = Color.Black
                )
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp)
                    .background(Purple200)
                    .clickable { viewModel.addTaskLog(TaskType.DIAPER) },
                contentAlignment = Alignment.Center

            ) {
                Text(
                    text = "기저귀",
                    textAlign = TextAlign.Center,
                    color = Color.Black
                )
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp)
                    .background(Purple200)
                    .clickable { viewModel.addTaskLog(TaskType.SLEEP) },
                contentAlignment = Alignment.Center

            ) {
                Text(
                    text = "수면",
                    textAlign = TextAlign.Center,
                    color = Color.Black
                )
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp)
                    .background(Purple200)
                    .clickable { viewModel.addTaskLog(TaskType.FOOD) },
                contentAlignment = Alignment.Center

            ) {
                Text(
                    text = "이유식",
                    textAlign = TextAlign.Center,
                    color = Color.Black
                )
            }
        }
    }
}