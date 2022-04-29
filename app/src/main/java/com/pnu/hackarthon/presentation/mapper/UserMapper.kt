package com.pnu.hackarthon.presentation.mapper

import androidx.compose.runtime.mutableStateOf
import com.google.android.gms.common.internal.safeparcel.SafeParcelable
import com.pnu.hackarthon.domain.interfaces.Mapper
import com.pnu.hackarthon.domain.model.User
import com.pnu.hackarthon.presentation.model.UserView
import javax.inject.Inject
import javax.inject.Singleton

//@Singleton
//class UserMapper @Inject constructor() {
//    private val userToView = UserToView()
//
//    fun map(user: User): UserView = userToView.map(user)
//}
//
//private class UserToView : Mapper<User, UserView> {
//    override fun map(input: User): UserView {
//        return UserView(
//            id = mutableStateOf(input.id),
//            name = mutableStateOf(input.name),
//            xp = mutableStateOf(input.userXP),
//            coin = mutableStateOf(input.userCoin),
//            state = mutableStateOf(input.state)
//        )
//    }
//}