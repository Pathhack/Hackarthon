package com.pnu.hackarthon.domain.repository

import com.pnu.hackarthon.data.room.dao.ProfileDao
import com.pnu.hackarthon.domain.mapper.ProfileMapper
import com.pnu.hackarthon.domain.model.Profile
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject


class ProfileRepository @Inject constructor(
    private val profileDao: ProfileDao,
    private val profileMapper: ProfileMapper
) {
    fun getAllProfiles() : Flow<List<Profile>> {
        return profileDao.getAllProfiles()
            .flowOn(Dispatchers.IO)
            .conflate()
            .map { profileMapper.map(it) }
    }

    suspend fun getProfile(id: Long) : Profile = profileDao.getProfileById(id).run { profileMapper.map(this) }
    suspend fun insert(profile: Profile) = profileDao.insert(profileMapper.map(profile))
    suspend fun update(profile: Profile) = profileDao.update(profileMapper.map(profile))

    suspend fun delete(profile: Profile) = profileDao.delete(profileMapper.map(profile))
    suspend fun deleteAll() = profileDao.deleteAll()
}