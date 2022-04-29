package com.pnu.hackarthon.domain.repository

import com.pnu.hackarthon.data.room.dao.TaskLogDao
import com.pnu.hackarthon.domain.mapper.TaskMapper
import com.pnu.hackarthon.domain.model.Task
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TaskLogRepository @Inject constructor(
    private val taskLogDao: TaskLogDao,
    private val taskMapper: TaskMapper
) {
    fun getAllTasks() : Flow<List<Task>> {
        return taskLogDao.getAllTasks()
            .flowOn(Dispatchers.IO)
            .conflate()
            .map { taskMapper.map(it) }
    }

    suspend fun getTask(id: Long) : Task = taskMapper.getProfileById(id).run { taskmapper.map(this) }
    suspend fun insert(task: Task) = taskMapper.insert(taskmapper.map(task))
    suspend fun update(task: Task) = taskMapper.update(taskmapper.map(task))

    suspend fun delete(task: Task) = taskMapper.delete(taskmapper.map(task))
    suspend fun deleteAll() = taskMapper.deleteAll()
}