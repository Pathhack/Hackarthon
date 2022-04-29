package com.pnu.hackarthon.presentation.view.Home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.pnu.hackarthon._constant.UIConstant
import com.pnu.hackarthon.domain.model.User
import com.pnu.hackarthon.presentation.component.ColorBar
import java.lang.Float.max
import java.lang.Float.min

@Composable
fun CharacterInfo() {
    val xp = User.userXP.value
    val requiredXp = User.state.value.getRequiredXP()

    ProgressBar(value = xp, limit = requiredXp, color = Color.Red)
}

@Composable
fun ProgressBar(
    color: Color,
    value: Float,
    limit: Float,
    width: Dp? = null) {
    val modifier =
        if (width != null) Modifier.width(width)
        else Modifier.fillMaxWidth()
    val coercedPercent = min(1f, value / limit)

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Done,
            contentDescription = ""
        )
        Spacer(Modifier.width(10.dp))
        Column {
            ColorBar(height = 10.dp, percent = coercedPercent, color = color)
            Row {
                Text(
                    modifier = Modifier.weight(1f),
                    text = "${value.toInt()} / ${limit.toInt()}"
                )
                Text("Experience")
            }
        }
    }
}

@Preview
@Composable
fun CharacterInfoPreview() {
    CharacterInfo()
}