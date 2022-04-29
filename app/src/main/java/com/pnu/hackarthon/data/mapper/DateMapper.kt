package com.pnu.hackarthon.data.mapper

import com.pnu.hackarthon.domain.interfaces.Mapper
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZoneOffset
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DateMapper @Inject constructor() {
    private val dateToLong = DateToLong()
    private val longToDate = LongToDate()

    fun map(input: LocalDateTime?): Long = dateToLong.map(input)
    fun map(input: Long): LocalDateTime? = longToDate.map(input)
}

private class DateToLong: Mapper<LocalDateTime?, Long> {
    override fun map(input: LocalDateTime?): Long {
        if (input == null) return -1L
        return input?.toEpochSecond(ZoneOffset.of("+09:00"))
    }
}

private class LongToDate: Mapper<Long, LocalDateTime?> {
    override fun map(input: Long): LocalDateTime? {
        if (input == -1L) return null
        return LocalDateTime.ofEpochSecond(input, 0, ZoneOffset.of("+09:00"))
    }
}
