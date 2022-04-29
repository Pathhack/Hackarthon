package com.pnu.hackarthon.presentation.view.Home

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.time.LocalDate

@Composable
fun HeadBar() {
    Spacer(Modifier.height(30.dp))
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(text = "${LocalDate.now()}")
    }
}