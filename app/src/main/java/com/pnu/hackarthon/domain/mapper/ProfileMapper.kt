package com.pnu.hackarthon.domain.mapper

import com.pnu.hackarthon.data.room.entitiy.ProfileEntity
import com.pnu.hackarthon.domain.interfaces.Mapper
import com.pnu.hackarthon.domain.model.Profile
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProfileMapper @Inject constructor(){
    private val profileToEntity = ProfileToEntity()
    private val entityToProfile = EntityToProfile()

    fun map(entity: ProfileEntity) : Profile = entityToProfile.map(entity)
    fun map(profile: Profile) : ProfileEntity = profileToEntity.map(profile)
}

private class EntityToProfile: Mapper<ProfileEntity, Profile> {
    override fun map(entity: ProfileEntity): Profile {
        return Profile(
            id = entity.id,
            name = entity.name,
            desc = entity.desc
        )
    }
}

private class ProfileToEntity: Mapper<Profile, ProfileEntity> {
    override fun map(profile: Profile): ProfileEntity {
        return ProfileEntity(
            id = profile.id,
            name = profile.name,
            desc = profile.desc
        )
    }
}