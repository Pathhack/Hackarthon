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
import com.pnu.hackarthon.presentation.component.DataCard
import com.pnu.hackarthon.presentation.viewmodel.HomeViewModel
import com.pnu.hackarthon.ui.theme.Purple200

@Composable
fun ColumnScope.TaskButtons(
    viewModel: HomeViewModel
) {
    val itemWidth = UIConstant.WIDTH_ITEM_MEDIUM
    Spacer(Modifier.height(30.dp))
    Column(
        modifier = Modifier.weight(1f),
    ) {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            DataCard(
                modifier = Modifier.weight(1f),
                icon = R.drawable.playing,
                mainText = "놀기",
                subText = "아이와 놀아주기",
                data = "${TaskType.FOOD.reward} XP",
                onClick = {
                    viewModel.addTaskLog(TaskType.MILK)
                }
            )

            Spacer(Modifier.width(20.dp))

            DataCard(
                modifier = Modifier.weight(1f),
                icon = R.drawable.diaper,
                mainText = "기저귀",
                subText = "기저귀 갈아주기",
                data = "${TaskType.DIAPER.reward} XP",
                onClick = { viewModel.addTaskLog(TaskType.DIAPER) }
            )
        }

        Spacer(Modifier.height(30.dp))

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            DataCard(
                modifier = Modifier.weight(1f),
                icon = R.drawable.sleeping,
                mainText = "재우기",
                subText = "아이 낮잠 재우기",
                data = "${TaskType.SLEEP.reward} XP",
                onClick = { viewModel.addTaskLog(TaskType.SLEEP) }
            )

            Spacer(Modifier.width(20.dp))

            DataCard(
                modifier = Modifier.weight(1f),
                icon = R.drawable.eusick,
                mainText = "이유식",
                subText = "아이 이유식 먹이기",
                data = "${TaskType.FOOD.reward} XP",
                onClick = { viewModel.addTaskLog(TaskType.FOOD) }
            )
        }
    }
}

@Composable
private fun RowScope.IconButton(
    resId: Int,
    onClick: () -> Unit,
) {
    IconButton(
        modifier = Modifier
            .weight(1f)
            .clip(RoundedCornerShape(50)),
        onClick = onClick
    ) {
        Image(
            modifier = Modifier
                .size(65.dp),
            painter = painterResource(id = resId),
            contentDescription = "",
            contentScale = ContentScale.Inside
        )
    }
}