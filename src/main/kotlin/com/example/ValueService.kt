package com.example

interface ValueService {
    suspend fun <T> modifyValue(value: T): T
}
