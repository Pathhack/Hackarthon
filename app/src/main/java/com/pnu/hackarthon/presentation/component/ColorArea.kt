package com.pnu.hackarthon.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.pnu.hackarthon._constant.UIConstant

@Composable
fun ColorBar(
    height: Dp,
    percent: Float,
    color: Color
) {
    Box {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(height)
                .background(UIConstant.COLOR_PROGRESS_BG)
        )
        Row {
            Spacer(
                modifier = Modifier
                    .height(height)
                    .weight(percent)
                    .background(color)
            )
            Spacer(
                modifier = Modifier
                    .height(height)
                    .weight(1-percent)
            )
        }
    }
}