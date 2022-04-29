package com.pnu.hackarthon.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pnu.hackarthon._constant.UIConstant

@Composable
fun DataCard(
    modifier: Modifier = Modifier,
    icon: Int,
    mainText: String,
    subText: String,
    data: String,
    background: Color = UIConstant.COLOR_SOFT_BG,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = modifier
            .padding(horizontal = 4.dp)
            .width(154.dp)
            .clickable { onClick() },
        elevation = 1.dp,
        backgroundColor = background
    ) {
        Column(Modifier.padding(horizontal = 12.dp, vertical = 12.dp)) {
            Row {
                Image(
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(36.dp)
                        .padding(5.dp),
                    painter = painterResource(id = icon),
                    contentDescription = ""
                )
                Column(Modifier.padding(start = 10.dp)) {
                    Text(
                        text = mainText,
                        color = Color.DarkGray,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp
                    )
                    Text(
                        text = subText,
                        color = Color.Gray,
                        fontWeight = FontWeight.Medium,
                        fontSize = 10.sp
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.width(130.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = data,
                    color = Color.Gray,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}