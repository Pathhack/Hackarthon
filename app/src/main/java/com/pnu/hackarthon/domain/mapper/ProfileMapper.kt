package com.pnu.hackarthon.domain.mapper

import com.pnu.hackarthon.data.room.entitiy.ProfileEntity
import com.pnu.hackarthon.domain.interfaces.ListMapper
import com.pnu.hackarthon.domain.interfaces.Mapper
import com.pnu.hackarthon.domain.model.Profile
import org.jsoup.nodes.Entities
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProfileMapper @Inject constructor(){
    private val profileToEntity = ProfileToEntity()
    private val entityToProfile = EntityToProfile()
    private val profilesToEntities = ProfilesToEntities()
    private val entitiesToProfiles = EntitiesToProfiles()

    fun map(entity: ProfileEntity) : Profile = entityToProfile.map(entity)
    fun map(profile: Profile) : ProfileEntity = profileToEntity.map(profile)
    @JvmName("EntitiesToProfiles")
    fun map(entities: List<ProfileEntity>) : List<Profile> = entitiesToProfiles.map(entities)
    @JvmName("ProfilesToEntities")
    fun map(profiles: List<Profile>) : List<ProfileEntity> = profilesToEntities.map(profiles)
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

private class ProfilesToEntities: ListMapper<Profile, ProfileEntity>(ProfileToEntity())
private class EntitiesToProfiles: ListMapper<ProfileEntity, Profile>(EntityToProfile())