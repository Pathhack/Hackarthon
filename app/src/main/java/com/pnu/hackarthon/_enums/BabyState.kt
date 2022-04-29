package com.pnu.hackarthon._enums

enum class BabyState(private val requiredXP : Float) {
    BABY_0(100F),
    BABY_1(400F),
    BABY_2(900F),
    BABY_3(1600F),
    BABY_4(2500F);

    fun getRequiredXP() = requiredXP
}