package com.pnu.hackarthon.domain.interfaces

interface Mapper<I, O> {
    fun map(input: I) : O
}