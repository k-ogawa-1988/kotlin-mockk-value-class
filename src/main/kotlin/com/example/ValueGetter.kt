package com.example

interface ValueGetter {
    suspend fun getLong(): LongValueClass
    suspend fun getString(): StringValueClass
}
