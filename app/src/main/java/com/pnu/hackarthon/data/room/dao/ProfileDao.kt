package com.pnu.hackarthon.data.room.dao

import androidx.room.*
import com.pnu.hackarthon.data.room.entitiy.ProfileEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProfileDao {
    @Query("SELECT * FROM ProfileTable")
    fun getAllProfiles() : Flow<List<ProfileEntity>>

    @Query("SELECT * FROM ProfileTable WHERE id = :id")
    suspend fun getProfileById(id: Long) : ProfileEntity

    @Query("SELECT * FROM ProfileTable WHERE name = :name")
    suspend fun getProfileByName(name: String) : ProfileEntity

    @Insert
    suspend fun insert(entity: ProfileEntity)

    @Update
    suspend fun update(entity: ProfileEntity)

    @Delete
    suspend fun delete(entity: ProfileEntity)

    @Query("DELETE FROM ProfileTable")
    suspend fun deleteAll()
}