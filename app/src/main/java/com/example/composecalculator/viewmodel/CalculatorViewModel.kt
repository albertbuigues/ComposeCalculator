package com.example.composecalculator.viewmodel

import androidx.lifecycle.ViewModel

class CalculatorViewModel: ViewModel() {

    private var firstNumber = ""
    private var secondNumber = ""
    private var currentOperator = ""

    fun add(firstNumber: Double, secondNumber: Double): Double {
        this.firstNumber = firstNumber.toString()
        this.secondNumber = secondNumber.toString()
        this.currentOperator = "+"
        return firstNumber + secondNumber
    }

    fun subtract(firstNumber: Double, secondNumber: Double): Double {
        this.firstNumber = firstNumber.toString()
        this.secondNumber = secondNumber.toString()
        this.currentOperator = "-"
        return firstNumber - secondNumber
    }

    fun multiply(firstNumber: Double, secondNumber: Double): Double {
        this.firstNumber = firstNumber.toString()
        this.secondNumber = secondNumber.toString()
        this.currentOperator = "*"
        return firstNumber * secondNumber
    }

    fun divide(firstNumber: Double, secondNumber: Double): Double {
        this.firstNumber = firstNumber.toString()
        this.secondNumber = secondNumber.toString()
        this.currentOperator = "/"
        return firstNumber/secondNumber
    }
}