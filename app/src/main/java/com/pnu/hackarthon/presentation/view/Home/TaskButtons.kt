package com.pnu.hackarthon.presentation.view.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.pnu.hackarthon.R
import com.pnu.hackarthon._constant.UIConstant
import com.pnu.hackarthon._enums.TaskType
import com.pnu.hackarthon.domain.model.User
import com.pnu.hackarthon.domain.model.User.id
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
        Row(Modifier.height(70.dp)) {
            IconButton(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(50)),
                onClick = { viewModel.addTaskLog(TaskType.MILK) }
            ) {
                Image(
                    modifier = Modifier
                        .size(70.dp),
                    painter = painterResource(id = R.drawable.playing),
                    contentDescription = "",
                    contentScale = ContentScale.Inside
                )
            }
            IconButton(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(50)),
                onClick = { viewModel.addTaskLog(TaskType.DIAPER) }
            ) {
                Image(
                    modifier = Modifier
                        .size(70.dp),
                    painter = painterResource(id = R.drawable.diaper),
                    contentDescription = "",
                    contentScale = ContentScale.Inside
                )
            }
            IconButton(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(50)),
                onClick = { viewModel.addTaskLog(TaskType.SLEEP) }
            ) {
                Image(
                    modifier = Modifier
                        .size(70.dp),
                    painter = painterResource(id = R.drawable.sleeping),
                    contentDescription = "",
                    contentScale = ContentScale.Inside
                )
            }
            IconButton(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(50)),
                onClick = { viewModel.addTaskLog(TaskType.FOOD) }
            ) {
                Image(
                    modifier = Modifier
                        .size(70.dp),
                    painter = painterResource(id = R.drawable.eusick),
                    contentDescription = "",
                    contentScale = ContentScale.Inside
                )
            }
        }
    }
}