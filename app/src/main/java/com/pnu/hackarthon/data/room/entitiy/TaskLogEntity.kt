package com.pnu.hackarthon.data.room.entitiy

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "TaskLogTable")
data class TaskLogEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    val id: Long = 0L,
    @ColumnInfo(name="name")
    val name: String = "",
    @ColumnInfo(name="date")
    val date: Date?
)