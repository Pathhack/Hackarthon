package com.pnu.hackarthon._enums

enum class TaskType(val reward: Float, val title: String) {
    MILK(30f, "분유"),
    DIAPER(40f, "기저귀"),
    SLEEP(20f, "수면"),
    FOOD(40f, "이유식"),
    HOSPITAL(100f, "병원")
}