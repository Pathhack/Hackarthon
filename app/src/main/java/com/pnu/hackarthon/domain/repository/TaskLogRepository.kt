package com.pnu.hackarthon.domain.repository

import com.pnu.hackarthon.data.room.dao.TaskLogDao
import com.pnu.hackarthon.domain.mapper.TaskLogMapper
import com.pnu.hackarthon.domain.model.TaskLog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TaskLogRepository @Inject constructor(
    private val taskLogDao: TaskLogDao,
    private val taskMapper: TaskLogMapper
) {
    fun getAllTasks() : Flow<List<TaskLog>> {
        return taskLogDao.getAllTasks()
            .flowOn(Dispatchers.IO)
            .conflate()
            .map { taskMapper.map(it) }
    }

    suspend fun getTask(id: Long) : TaskLog = taskLogDao.getTaskById(id).run { taskMapper.map(this) }
    suspend fun insert(task: TaskLog) = taskLogDao.insert(taskMapper.map(task))
    suspend fun update(task: TaskLog) = taskLogDao.update(taskMapper.map(task))

    suspend fun delete(task: TaskLog) = taskLogDao.delete(taskMapper.map(task))
    suspend fun deleteAll() = taskLogDao.deleteAll()
}