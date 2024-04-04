package com.example

import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class ValueUseCaseTest {
    private val valueGetter = mockk<ValueGetter>()
    private val valueService = mockk<ValueService>()

    private val valueUseCase = ValueUseCase(valueGetter, valueService)

    @Test
    fun testLong() = runTest {
        coEvery { valueGetter.getLong() } returns LongValueClass(10)
        coEvery { valueService.modifyValue<LongValueClass>(any()) } returns LongValueClass(100)

        assertEquals(
            LongValueClass(100),
            valueUseCase.doubleLong()
        )
    }

    @Test
    fun testString() = runTest {
        coEvery { valueGetter.getString() } returns StringValueClass("lorem ipsum")
        coEvery { valueService.modifyValue<StringValueClass>(any()) } returns StringValueClass("mocked!")

        assertEquals(
            StringValueClass("mocked!"),
            valueUseCase.getReversedString()
        )
    }
}
