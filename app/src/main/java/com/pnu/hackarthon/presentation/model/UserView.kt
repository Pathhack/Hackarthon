package com.pnu.hackarthon.presentation.model

import androidx.compose.runtime.MutableState
import com.pnu.hackarthon._enums.BabyState

data class UserView(
    val id: MutableState<String>,
    val name: MutableState<String>,
    val xp: MutableState<Float>,
    val coin: MutableState<Float>,
    val state: MutableState<BabyState>
)
