package com.pnu.hackarthon.domain.interfaces

abstract class ListMapper<I, O>(
    private val mapper: Mapper<I, O>
) {
    fun map(input: List<I>): List<O> {
        return input.map { mapper.map(it) }
    }
}