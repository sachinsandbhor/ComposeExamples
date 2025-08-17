package com.shreejacreation.composesample

import com.shreejacreation.composesample.tipcalculator.calculateTip
import org.junit.Assert
import org.junit.Test
import java.text.NumberFormat

class TipCalculatorTest {

    @Test
    fun `test calculate tip 20 percentage no round tip`() {
        val amount = 10.00
        val tipPercent = 20.00
        val result = calculateTip(amount, tipPercent, false)
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        Assert.assertEquals(result, expectedTip)
    }
}
