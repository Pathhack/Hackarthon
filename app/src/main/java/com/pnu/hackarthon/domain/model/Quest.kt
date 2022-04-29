package com.pnu.hackarthon.domain.model

data class Quest(
    val id: Long,
    val title: String,
    val desc: String,
    val reward: Float
)