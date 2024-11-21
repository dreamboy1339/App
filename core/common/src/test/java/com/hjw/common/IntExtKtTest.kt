@file:Suppress("DANGEROUS_CHARACTERS", "NonAsciiCharacters")

package com.hjw.common

import org.junit.Assert.assertEquals
import org.junit.Test

class IntExtKtTest {

    @Test
    fun `given_상품가격_when_가격이 100 일 때_then_"100"표시`() {
        val price = 100

        val actual = price.decimalFormat()

        assertEquals("100", actual)
    }

    @Test
    fun `given_상품가격_when_가격이 1000 일 때_then_"1,000"표시`() {
        val price = 1000

        val actual = price.decimalFormat()

        assertEquals("1,000", actual)
    }

    @Test
    fun `given_상품가격_when_가격이 10000 일 때_then_"10,000"표시`() {
        val price = 10000

        val actual = price.decimalFormat()

        assertEquals("10,000", actual)
    }

    @Test
    fun `given_상품가격_when_가격이 0 일 때_then_"0"표시`() {
        val price = 0

        val actual = price.decimalFormat()

        assertEquals("0", actual)
    }

    @Test
    fun `given_상품가격_when_가격이 999999999 일 때_then_"999,999,999"표시`() {
        val price = 999999999

        val actual = price.decimalFormat()

        assertEquals("999,999,999", actual)
    }

    @Test
    fun `given_상품가격_when_가격이 -9999 일 때_then_""표시`() {
        val price = -9999

        val actual = price.decimalFormat()

        assertEquals("-9,999", actual)
    }
}
