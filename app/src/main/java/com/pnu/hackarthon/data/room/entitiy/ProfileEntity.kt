package com.pnu.hackarthon.data.room.entitiy

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ProfileTable")
data class ProfileEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    val id: Long = 0L,
    @ColumnInfo(name="name")
    val name: String = "",
    @ColumnInfo(name="desc")
    val desc: String = "",
)