package com.pnu.hackarthon.domain.model

import com.pnu.hackarthon._enums.BabyState

/** 로그인한 유저를 표현하는 클래스 */
class User(
    val id: String,
    val email: String,
    val name: String,
    var userXP: Float,
    var userCoin: Float,
    var state: BabyState,
) {
    fun isGuest() : Boolean = (this == GUEST)

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
        this.userXP += reward
        checkXP()
    }

    private fun checkXP() {
        if(userXP >= state.getRequiredXP())
            getEvolve()
    }

    private fun getEvolve() {
        when(state) {
            BabyState.BABY_0 -> state = BabyState.BABY_1
            BabyState.BABY_1 -> state = BabyState.BABY_2
            BabyState.BABY_2 -> state = BabyState.BABY_3
            BabyState.BABY_3 -> state = BabyState.BABY_4
        }
    }

    fun gainCoin(reward : Float) {
        this.userCoin += reward
    }

    companion object {
        val GUEST = User("Guest", "", "", 0F, 0F, BabyState.BABY_0)
    }
}