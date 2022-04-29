package com.pnu.hackarthon.data.mapper

import com.pnu.hackarthon.domain.interfaces.Mapper
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DateMapper @Inject constructor() {
    private val dateToLong = DateToLong()
    private val longToDate = LongToDate()

    fun map(input: Date?): Long = dateToLong.map(input)
    fun map(input: Long): Date? = longToDate.map(input)
}

private class DateToLong: Mapper<Date?, Long> {
    override fun map(input: Date?): Long {
        if (input == null) return -1L
        return input.time
    }
}

private class LongToDate: Mapper<Long, Date?> {
    override fun map(input: Long): Date? {
        if (input == -1L) return null
        return Date(input)
    }
}
