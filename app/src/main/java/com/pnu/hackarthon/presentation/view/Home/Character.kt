package com.pnu.hackarthon.presentation.view.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.pnu.hackarthon.R

@Composable
fun CharacterArea() {
    Box(Modifier.fillMaxWidth()) {
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(id = R.drawable.character_01),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun CharacterAreaPreview() {
    CharacterArea()
}