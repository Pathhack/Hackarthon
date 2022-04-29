package com.pnu.hackarthon.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.pnu.hackarthon.data.room.dao.ProfileDao
import com.pnu.hackarthon.data.room.entitiy.ProfileEntity

@Database(
    entities = [ProfileEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class Database : RoomDatabase() {
    abstract fun profileDao(): ProfileDao
}
