package com.pnu.hackarthon.presentation.view.Home

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pnu.hackarthon.R
import com.pnu.hackarthon.domain.model.User

@Composable
fun CharacterImage() {
    val imageId = User.state.value.imageId


    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.size(250.dp),
            painter = painterResource(id = imageId),
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