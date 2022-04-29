package com.pnu.hackarthon.presentation.view.TaskList

import android.content.Intent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.pnu.hackarthon.presentation.view.Chart

@Composable
fun StatisticButton() {
    val context = LocalContext.current
    Spacer(Modifier.height(10.dp))
    Button(
        onClick = {
            val intent = Intent(context, Chart::class.java)
            context.startActivity(intent)
        },
        colors = ButtonDefaults.buttonColors(Color.Black)
    ) {
        Text(text = "전체 분석표 보러가기", color= Color.White)
    }
}