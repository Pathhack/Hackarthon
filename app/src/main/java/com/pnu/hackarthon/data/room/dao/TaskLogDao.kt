package com.pnu.hackarthon.data.room.dao

import androidx.room.*
import com.pnu.hackarthon.data.room.entitiy.TaskLogEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskLogDao {
    @Query("SELECT * FROM TaskLogTable")
    fun getAllTasks() : Flow<List<TaskLogEntity>>

    @Query("SELECT * FROM TaskLogTable WHERE id = :id")
    suspend fun getTaskById(id: Long) : TaskLogEntity

    @Query("SELECT * FROM TaskLogTable WHERE name = :name")
    suspend fun getTaskByName(name: String) : TaskLogEntity

    @Insert
    suspend fun insert(logEntity: TaskLogEntity)

    @Update
    suspend fun update(logEntity: TaskLogEntity)

    @Delete
    suspend fun delete(logEntity: TaskLogEntity)

    @Query("DELETE FROM TaskLogTable")
    suspend fun deleteAll()
}