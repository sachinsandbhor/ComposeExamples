package com.shreejacreation.composesample

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.shreejacreation.composesample.tipcalculator.TipTimeLayout
import com.shreejacreation.composesample.ui.theme.ComposeSampleTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

class TipUiTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testCalculateTip20Percentage() {
        composeTestRule.setContent {
            ComposeSampleTheme {
                TipTimeLayout()
            }
        }
        composeTestRule.onNodeWithText("Cost of Service")
            .performTextInput("10")
        composeTestRule.onNodeWithText("Tip Percentage")
            .performTextInput("20")
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        composeTestRule.onNodeWithText("Tip Amount: $expectedTip")
            .assertExists("No node with this text found")
    }
}
