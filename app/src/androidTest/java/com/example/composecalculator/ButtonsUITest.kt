package com.example.composecalculator

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.composecalculator.ui.screens.CalculatorScreen
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ButtonsUITest {

    @get: Rule
    val rule = createComposeRule()

    @Before
    fun init(){
        rule.setContent { CalculatorScreen() }
    }

    @Test
    fun tapButtonWithClearThenTextEmpty() {
        rule.onNodeWithText("1").assertHasClickAction().performClick()
        rule.mainClock.autoAdvance = true
        rule.mainClock.advanceTimeBy(50)
        rule.onAllNodesWithText("1").assertCountEquals(2)
        rule.onNodeWithText("AC").assertHasClickAction().performClick()
        rule.mainClock.advanceTimeBy(50)
        rule.onNodeWithText("").assertExists()
    }
}