package com.example

import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class ValueGetterTest {
    private val someClass = mockk<ValueGetter>()

    @Test
    fun testLong() = runTest {
        coEvery { someClass.getLong() } returns LongValueClass(2)
        assertEquals(LongValueClass(2), someClass.getLong())
    }

    @Test
    fun testString() = runTest {
        coEvery { someClass.getString() } returns StringValueClass("test")
        assertEquals(StringValueClass("test"), someClass.getString())
    }
}
