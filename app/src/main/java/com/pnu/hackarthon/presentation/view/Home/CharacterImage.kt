package com.pnu.hackarthon.presentation.view.Home

import android.widget.Toast
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInWindow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pnu.hackarthon.R
import com.pnu.hackarthon.domain.model.User

@Composable
fun CharacterImage(
    onPositioned: (Offset) -> Unit = {}
) {
    val imageId = User.state.value.imageId
    val context = LocalContext.current

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .size(250.dp)
                .onGloballyPositioned {
                    onPositioned(it.positionInWindow())
                }
            ,
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
    CharacterImage() {}
}