package com.pnu.hackarthon.data.room

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.pnu.hackarthon.data.room.dao.ProfileDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun providesProfileDao(database: Database) : ProfileDao
            = database.profileDao()

    @Singleton
    @Provides
    fun providesRoomCallback() : RoomDatabase.Callback
            = object: RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            // DB 생성 시 기본적으로 할일 명시

//            val record = ContentValues()
//            record.put("key", -1L)
//            db.insert("tableName", SQLiteDatabase.CONFLICT_IGNORE, record)
        }
    }


    @Singleton
    @Provides
    fun provideLinkItDatabase(
        @ApplicationContext context: Context,
        callback: RoomDatabase.Callback,
        converter: Converters
    ) : Database
            = Room.databaseBuilder(
        context,
        Database::class.java,
        "hackarthon_db"
    )
        // 스키마를 업데이트하면 기존 데이터를 비운다.
        .fallbackToDestructiveMigration()
        .addCallback(callback)
        .addTypeConverter(converter)
        .build()
}