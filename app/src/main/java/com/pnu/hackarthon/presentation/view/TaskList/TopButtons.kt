package com.pnu.hackarthon.presentation.view.TaskList

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.pnu.hackarthon.ui.theme.Purple200

@Composable
fun TopButtons() {
    Card(
        modifier = Modifier.height(60.dp),
        backgroundColor = Purple200
    ) {
        Row {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clickable {  },
                contentAlignment = Alignment.Center
            ) {
                Text(text = "분유")
            }
            Spacer(Modifier.width(1.dp).fillMaxHeight().background(Color.White))
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clickable {  },
                contentAlignment = Alignment.Center
            ) {
                Text(text = "기저귀")
            }
            Spacer(Modifier.width(1.dp).fillMaxHeight().background(Color.White))
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clickable {  },
                contentAlignment = Alignment.Center
            ) {
                Text(text = "수면")
            }
        }
    }
}