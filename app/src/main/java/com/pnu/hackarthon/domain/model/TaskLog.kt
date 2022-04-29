package com.pnu.hackarthon.domain.model

import java.util.*

data class TaskLog(
    val id: Long,
    val title: String,
    val date: Date? = null,
)