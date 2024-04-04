package com.example

class ValueUseCase(private val valueGetter: ValueGetter, private val valueService: ValueService) {
    suspend fun doubleLong(): LongValueClass {
        val value = valueGetter.getLong()
        return valueService.modifyValue(value)
    }

    suspend fun getReversedString(): StringValueClass {
        val value = valueGetter.getString()
        return valueService.modifyValue(value)
    }
}
