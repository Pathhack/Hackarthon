package com.pnu.hackarthon.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pnu.hackarthon._constant.UIConstant
import com.pnu.hackarthon.domain.model.Task

@Composable
fun QuestItem(quest: Task) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(UIConstant.HEIGHT_QUEST_ITEM),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(
            Modifier
                .height(UIConstant.HEIGHT_QUEST_ITEM)
                .width(20.dp)
                .background(Color.Black)
        )
        Spacer(Modifier.width(10.dp))
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = quest.title
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = quest.desc
            )
        }
        Text(text = quest.reward.toString())
        Checkbox(checked = true, onCheckedChange = {})
    }
}

@Preview(showSystemUi = true)
@Composable
fun QuestItemPreview() {
    val quest = Task(10, "분유주기", "분유를 주세요", 50f)
    QuestItem(quest = quest)
}