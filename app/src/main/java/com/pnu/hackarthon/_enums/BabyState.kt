package com.pnu.hackarthon._enums

import android.graphics.Bitmap
import com.pnu.hackarthon.R

enum class BabyState(val level: Int, private val requiredXP : Float, val imageId: Int) {
    BABY_0(1,100F, R.drawable.baby1),
    BABY_1(2,400F, R.drawable.baby2),
    BABY_2(3,900F, R.drawable.baby3),
    BABY_3(4,1600F, R.drawable.baby4),
    BABY_4(5,2500F, R.drawable.baby5);

    fun getRequiredXP() = requiredXP
}