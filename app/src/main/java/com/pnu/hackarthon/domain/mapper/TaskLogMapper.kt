package com.pnu.hackarthon.domain.mapper

import com.pnu.hackarthon.data.room.entitiy.TaskLogEntity
import com.pnu.hackarthon.domain.interfaces.ListMapper
import com.pnu.hackarthon.domain.interfaces.Mapper
import com.pnu.hackarthon.domain.model.TaskLog
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TaskLogMapper @Inject constructor(){
    private val taskToEntity = TaskToEntity()
    private val entityToTask = EntitiyToTask()
    private val tasksToEntities = TasksToEntities()
    private val entitiesToTasks = EntitiesToTasks()

    fun map(logEntity: TaskLogEntity) : TaskLog = entityToTask.map(logEntity)
    fun map(task: TaskLog) : TaskLogEntity = taskToEntity.map(task)
    @JvmName("EntitiesToTasks")
    fun map(logEntities: List<TaskLogEntity>) : List<TaskLog> = entitiesToTasks.map(logEntities)
    @JvmName("TasksToEntities")
    fun map(tasks: List<TaskLog>) : List<TaskLogEntity> = tasksToEntities.map(tasks)
}

private class EntitiyToTask: Mapper<TaskLogEntity, TaskLog> {
    override fun map(logEntity: TaskLogEntity): TaskLog {
        return TaskLog(
            id = logEntity.id,
            title = logEntity.name,
            date = logEntity.date
        )
    }
}

private class TaskToEntity: Mapper<TaskLog, TaskLogEntity> {
    override fun map(task: TaskLog): TaskLogEntity {
        return TaskLogEntity(
            id = task.id,
            name = task.title,
            date = task.date
        )
    }
}

private class TasksToEntities: ListMapper<TaskLog, TaskLogEntity>(TaskToEntity())
private class EntitiesToTasks: ListMapper<TaskLogEntity, TaskLog>(EntitiyToTask())