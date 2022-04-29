package com.pnu.hackarthon.presentation.view.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pnu.hackarthon.R

@Composable
fun CharacterImage() {
    Box(Modifier.fillMaxWidth()) {
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(id = R.drawable.character_01),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
    }
    Spacer(Modifier.height(30.dp))
}

@Preview(showSystemUi = true)
@Composable
private fun CharacterAreaPreview() {
    CharacterImage()
}