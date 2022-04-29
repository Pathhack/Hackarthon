package com.pnu.hackarthon.presentation.view.Home

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pnu.hackarthon.presentation.component.CustomChip
import com.pnu.hackarthon.ui.theme.Yellow200
import com.pnu.hackarthon.ui.theme.Yellow500
import com.pnu.hackarthon.ui.theme.Yellow700
import java.time.LocalDate
import java.time.ZoneOffset

@Composable
fun HeadBar() {
    Spacer(Modifier.height(30.dp))
    CustomChip(
        text = " ${LocalDate.now(ZoneOffset.of("+09:00"))} ",
        borderWidth = 1.dp,
        height = 23.dp
    )
    Spacer(Modifier.height(10.dp))
}