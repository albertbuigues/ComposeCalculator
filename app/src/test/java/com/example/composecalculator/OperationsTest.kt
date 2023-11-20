package com.example.composecalculator

import com.example.composecalculator.viewmodel.CalculatorViewModel
import org.junit.Assert
import org.junit.Before
import org.junit.Test


class OperationsTest {

    private lateinit var viewModel: CalculatorViewModel
    private val n1 = 2.0
    private val n2 = 1.0

    @Before
    fun prepare() {
        viewModel = CalculatorViewModel()
    }

    @Test
    fun `if Add Two Numbers Assert Result Is Correct`() {
        val res = viewModel.add(n1, n2)
        Assert.assertEquals(res, 3.0, 0.0)
        Assert.assertNotEquals(res, 2.0)
    }

    @Test
    fun `if Subtract Two Numbers Assert Result Is Correct`() {
        val res = viewModel.subtract(n1, n2)
        Assert.assertEquals(res, 1.0,0.00)
        Assert.assertNotEquals(res, 2.0)
    }

    @Test
    fun `if Multiply Two Numbers Assert Result Is Correct`() {
        val res = viewModel.multiply(n1, n2)
        Assert.assertEquals(res, 2.0, 0.0)
        Assert.assertNotEquals(res, 5.0)
    }

    @Test
    fun `if Divide Two Numbers Assert And Not DivisionByZero Result Is Correct`() {
        val res = viewModel.divide(n1, n2)
        Assert.assertEquals(res, 2.0, 0.0)
        Assert.assertNotEquals(res, 10.0)
    }
}