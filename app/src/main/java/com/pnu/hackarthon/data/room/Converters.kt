package com.pnu.hackarthon.data.room

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.pnu.hackarthon.data.mapper.DateMapper
import java.util.*
import javax.inject.Inject

@ProvidedTypeConverter
class Converters @Inject constructor(
    private val dateMapper: DateMapper
){
    @TypeConverter
    fun fromDate(date: Date): Long = dateMapper.map(date)
    @TypeConverter
    fun toDate(long: Long): Date? = dateMapper.map(long)
}