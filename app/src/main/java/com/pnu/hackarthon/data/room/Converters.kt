package com.pnu.hackarthon.data.room

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.pnu.hackarthon.data.mapper.DateMapper
import java.time.LocalDateTime
import java.util.*
import javax.inject.Inject

@ProvidedTypeConverter
class Converters @Inject constructor(
    private val dateMapper: DateMapper
){
    @TypeConverter
    fun fromDate(date: LocalDateTime?): Long = dateMapper.map(date)
    @TypeConverter
    fun toDate(long: Long): LocalDateTime? = dateMapper.map(long)
}