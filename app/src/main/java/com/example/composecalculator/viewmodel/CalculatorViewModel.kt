package com.example.composecalculator.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CalculatorViewModel: ViewModel() {

    var firstNumber: Double? = null
    var secondNumber: Double? = null
    var currentOperator: String? = null
    var text = mutableStateOf("")
    var resultText = mutableStateOf("0")
    var prevResultsText = mutableStateOf("")
    var resultList = mutableListOf<Double>()
    var isResultFocused = mutableStateOf(true)

    fun add(firstNumber: Double, secondNumber: Double): Double {
        return firstNumber + secondNumber
    }

    fun subtract(firstNumber: Double, secondNumber: Double): Double {
        return firstNumber - secondNumber
    }

    fun multiply(firstNumber: Double, secondNumber: Double): Double {
        return firstNumber * secondNumber
    }

    fun divide(firstNumber: Double, secondNumber: Double): Double {
        return firstNumber/secondNumber
    }

    fun percentage(firstNumber: Double): Double {
        return firstNumber/100
    }
}