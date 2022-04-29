package com.pnu.hackarthon.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pnu.hackarthon._constant.UIConstant
import com.pnu.hackarthon.domain.model.Quest

@Composable
fun QuestItem(quest: Quest) {
    Row(modifier = Modifier
        .height(UIConstant.HEIGHT_QUEST_ITEM)
    ) {
        Spacer(
            Modifier
                .fillMaxHeight()
                .width(20.dp)
                .background(Color.Green)
        )
        Column(Modifier.fillMaxHeight()) {
            Text(quest.title)
            Text(quest.desc)
        }
        Text(text = quest.reward.toString())
        Checkbox(checked = true, onCheckedChange = {})
    }
}

@Preview
@Composable
fun QuestItemPreview() {
    val quest = Quest(10, "분유주기", "분유를 주세요", 50f)
    QuestItem(quest = quest)
}