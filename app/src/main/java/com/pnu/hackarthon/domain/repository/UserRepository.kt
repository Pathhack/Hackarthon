package com.pnu.hackarthon.domain.repository

import com.pnu.hackarthon.data.storage.UserPref
import com.pnu.hackarthon.domain.model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val userPref: UserPref
) {
    private val scope = CoroutineScope(Dispatchers.IO)

    fun getLoggedInUser() : User {
        return runBlocking {
            userPref.getLoggedInUser().first()
        }
    }
    fun setLoggedInUser(user: User) {
        scope.launch {
            userPref.setLoggedInUser(user)
        }
    }
}