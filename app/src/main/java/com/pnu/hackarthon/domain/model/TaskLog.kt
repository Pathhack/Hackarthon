package com.pnu.hackarthon.domain.model

import java.time.LocalDateTime

data class TaskLog(
    val id: Long,
    val title: String,
    val date: LocalDateTime? = null,
)