package com.pnu.hackarthon.domain.model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.pnu.hackarthon._enums.BabyState

/** 로그인한 유저를 표현하는 클래스 */
object User{
    const val id: String = ""
    const val email: String = ""
    const val name: String = "GUSET"
    private var userXP: MutableState<Float> = mutableStateOf(0F)
    private var userCoin: MutableState<Float> = mutableStateOf(0F)
    private var state: MutableState<BabyState> = mutableStateOf(BabyState.BABY_0)

    fun isGuest() : Boolean = (true)

    override fun toString(): String {
        return "User(id: $id, email: $email, name: $name"
    }

    override fun equals(other: Any?): Boolean {
        if (other !is User) return false
        return id == other.id
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + email.hashCode()
        result = 31 * result + name.hashCode()
        return result
    }

    fun gainXP(reward : Float) {
        this.userXP.value = this.userXP.value + reward
        checkXP()
    }

    private fun checkXP() {
        if(userXP.value >= state.value.getRequiredXP())
            getEvolve()
    }

    private fun getEvolve() {
        when(state.value) {
            BabyState.BABY_0 -> state.value = BabyState.BABY_1
            BabyState.BABY_1 -> state.value = BabyState.BABY_2
            BabyState.BABY_2 -> state.value = BabyState.BABY_3
            BabyState.BABY_3 -> state.value = BabyState.BABY_4
        }
    }

    fun gainCoin(reward : Float) {
        this.userCoin.value = this.userCoin.value + reward
    }

}