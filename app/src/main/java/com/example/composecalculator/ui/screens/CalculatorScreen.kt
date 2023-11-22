package com.example.composecalculator.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Backspace
import androidx.compose.material.icons.outlined.OpenWith
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.core.text.isDigitsOnly
import com.example.composecalculator.ui.components.CalculatorButton
import com.example.composecalculator.ui.components.TextArea
import com.example.composecalculator.ui.theme.Orange
import com.example.composecalculator.viewmodel.CalculatorViewModel

@Composable
fun CalculatorScreen(viewModel: CalculatorViewModel = viewModel()) {
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    Column {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(screenHeight / 2)
        ) {
            TextArea(viewModel.text.value, viewModel.resultText.value)
        }
        Divider(
            thickness = 1.dp,
            color = Color.LightGray
        )
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(screenHeight / 2)
        ) {
            ButtonsArea(viewModel = viewModel)
        }
    }
}

@Composable
fun ButtonsArea(viewModel: CalculatorViewModel = viewModel()) {
    val textAreaStrBuilder = StringBuilder(viewModel.text.value)
    val resultAreaStrBuilder = StringBuilder(viewModel.resultText.value)
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(), verticalArrangement = Arrangement.SpaceAround) {
        Row(
            Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CalculatorButton(text = "AC", bgColor = Color.Transparent, foregroundColor = Orange) {
                viewModel.text.value = ""
                viewModel.resultText.value = "0"
                viewModel.currentOperator = null
                viewModel.firstNumber = null
                viewModel.secondNumber = null
            }
            CalculatorButton(icon = Icons.Outlined.Backspace, bgColor = Color.Transparent, foregroundColor = Orange) {
                val noSpacedResultText = viewModel.resultText.value.replace(" ", "")
                if (noSpacedResultText.length == 2) {
                    viewModel.resultText.value = "0"
                    viewModel.text.value = ""
                    viewModel.currentOperator = null
                    viewModel.firstNumber = null
                    viewModel.secondNumber = null
                }
                else if (viewModel.text.value != "0" && viewModel.resultText.value != "= 0" && viewModel.text.value.isNotEmpty() && viewModel.resultText.value.isNotEmpty()) {
                    viewModel.text.value = viewModel.text.value.removeRange(viewModel.text.value.length-1, viewModel.text.value.length)
                    viewModel.resultText.value = viewModel.resultText.value.removeRange(viewModel.resultText.value.length-1, viewModel.resultText.value.length)
                }
            }
            CalculatorButton(text = "%", bgColor = Color.Transparent, foregroundColor = Orange) { }
            CalculatorButton(text = "/", bgColor = Color.Transparent, foregroundColor = Orange) {
                setOrChangeOperator(textAreaStrBuilder, viewModel, "/")
                viewModel.currentOperator = "/"
                setFirstNumber(textAreaStrBuilder, viewModel)
            }
        }
        Row(
            Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CalculatorButton(text = "7", bgColor = Color.Transparent, foregroundColor = Color.Black) {
                appendStr(viewModel, textAreaStrBuilder, resultAreaStrBuilder, "7")
            }
            CalculatorButton(text = "8", bgColor = Color.Transparent, foregroundColor = Color.Black) {
                appendStr(viewModel, textAreaStrBuilder, resultAreaStrBuilder, "8")
            }
            CalculatorButton(text = "9", bgColor = Color.Transparent, foregroundColor = Color.Black) {
                appendStr(viewModel, textAreaStrBuilder, resultAreaStrBuilder, "9")
            }
            CalculatorButton(text = "x", bgColor = Color.Transparent, foregroundColor = Orange) {
                setOrChangeOperator(textAreaStrBuilder, viewModel, "x")
                viewModel.currentOperator = "x"
                setFirstNumber(textAreaStrBuilder, viewModel)
            }
        }
        Row(
            Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CalculatorButton(text = "4", bgColor = Color.Transparent, foregroundColor = Color.Black) {
                appendStr(viewModel, textAreaStrBuilder, resultAreaStrBuilder, "4")
            }
            CalculatorButton(text = "5", bgColor = Color.Transparent, foregroundColor = Color.Black) {
                appendStr(viewModel, textAreaStrBuilder, resultAreaStrBuilder, "5")
            }
            CalculatorButton(text = "6", bgColor = Color.Transparent, foregroundColor = Color.Black) {
                appendStr(viewModel, textAreaStrBuilder, resultAreaStrBuilder, "6")
            }
            CalculatorButton(text = "-", bgColor = Color.Transparent, foregroundColor = Orange) {
                setOrChangeOperator(textAreaStrBuilder, viewModel, "-")
                viewModel.currentOperator = "-"
                setFirstNumber(textAreaStrBuilder, viewModel)
            }
        }
        Row(
            Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CalculatorButton(text = "1", bgColor = Color.Transparent, foregroundColor = Color.Black) {
                appendStr(viewModel, textAreaStrBuilder, resultAreaStrBuilder, "1")
            }
            CalculatorButton(text = "2", bgColor = Color.Transparent, foregroundColor = Color.Black) {
                appendStr(viewModel, textAreaStrBuilder, resultAreaStrBuilder, "2")
            }
            CalculatorButton(text = "3", bgColor = Color.Transparent, foregroundColor = Color.Black) {
                appendStr(viewModel, textAreaStrBuilder, resultAreaStrBuilder, "3")
            }
            CalculatorButton(text = "+", bgColor = Color.Transparent, foregroundColor = Orange) {
                setOrChangeOperator(textAreaStrBuilder, viewModel, "+")
                viewModel.currentOperator = "+"
                setFirstNumber(textAreaStrBuilder, viewModel)
            }
        }
        Row(
            Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CalculatorButton(icon = Icons.Outlined.OpenWith, bgColor = Color.Transparent, foregroundColor = Orange) { }
            CalculatorButton(text = "0", bgColor = Color.Transparent, foregroundColor = Color.Black) {
                appendStr(viewModel, textAreaStrBuilder, resultAreaStrBuilder, "0")
            }
            CalculatorButton(text = ",", bgColor = Color.Transparent, foregroundColor = Color.Black) { }
            CalculatorButton(text = "=", bgColor = Orange, foregroundColor = Color.White) { }
        }
    }
}

private fun appendStr(viewModel: CalculatorViewModel, textAreaStrBuilder: StringBuilder, resultAreaStrBuilder: StringBuilder, strToAppend: String) {
    if (resultAreaStrBuilder.toString() == "0") {
        if (strToAppend != "0") {
            resultAreaStrBuilder.clear()
        } else { return }
    }
    if (!strToAppend.isDigitsOnly()) {
        // TODO: When a coma is pressed
    } else {
        if (viewModel.text.value.length == 1 && viewModel.text.value[0] == '0') {
            if (strToAppend == "0") { return } else {
                textAreaStrBuilder.clear()
                textAreaStrBuilder.append(strToAppend)
                resultAreaStrBuilder.clear()
                resultAreaStrBuilder.append("=$strToAppend")
            }
        } else if (textAreaStrBuilder.isEmpty() && resultAreaStrBuilder.isEmpty()) {
            textAreaStrBuilder.append(strToAppend)
            resultAreaStrBuilder.append("=$strToAppend")
        } else {
            textAreaStrBuilder.append(strToAppend)
            resultAreaStrBuilder.append(strToAppend)
        }
        viewModel.text.value = textAreaStrBuilder.toString()
        viewModel.resultText.value = resultAreaStrBuilder.toString()
        setSecondNumber(textAreaStrBuilder, viewModel)
        val operationRes = performOperation(viewModel = viewModel)
        operationRes?.let {
            resultAreaStrBuilder.clear()
            resultAreaStrBuilder.append("=$it")
            viewModel.resultText.value = resultAreaStrBuilder.toString()
        }
    }
}

private fun setOrChangeOperator(strBuilder: StringBuilder, viewModel: CalculatorViewModel, newOperator: String) {
    var newString = ""
    if (currentOperatorHasBeenSet(viewModel = viewModel)) {
        newString = strBuilder.replaceFirst(regex = Regex("[+\\-*\\/]"), replacement = newOperator)
        strBuilder.clear().append(newString)
    } else {
        strBuilder.append(newOperator)
    }
    if (!strBuilder[0].isDigit()) {
        newString = "0${strBuilder}"
        strBuilder.clear().append(newString)
    }
    viewModel.text.value = strBuilder.toString()
}

private fun currentOperatorHasBeenSet(viewModel: CalculatorViewModel): Boolean {
    return viewModel.currentOperator != null
}

private fun setFirstNumber(strBuilder: StringBuilder, viewModel: CalculatorViewModel) {
    val operatorPosition = viewModel.currentOperator?.let { strBuilder.indexOf(it) }
    viewModel.firstNumber = strBuilder.substring(0, operatorPosition ?: return).toDouble()
}

private fun setSecondNumber(strBuilder: StringBuilder, viewModel: CalculatorViewModel) {
    val operatorPosition = viewModel.currentOperator?.let { strBuilder.indexOf(it) }
    if (operatorPosition != strBuilder.toString().length-1) {
        viewModel.secondNumber = strBuilder.substring((operatorPosition?.plus(1)) ?: return).toDouble()
    }
}

private fun performOperation(viewModel: CalculatorViewModel): Double? {
    var res: Double? = null
    if (viewModel.currentOperator != null && viewModel.firstNumber != null && viewModel.secondNumber != null) {
        when(viewModel.currentOperator) {
            "+" -> { res = viewModel.add(viewModel.firstNumber!!, viewModel.secondNumber!!) }
            "-" -> { res = viewModel.subtract(viewModel.firstNumber!!, viewModel.secondNumber!!) }
            "x" -> { res = viewModel.multiply(viewModel.firstNumber!!, viewModel.secondNumber!!) }
            "/" -> { res = viewModel.divide(viewModel.firstNumber!!, viewModel.secondNumber!!) }

        }
    }
    return res
}

@Composable
@Preview
fun PreviewScreen() {
    CalculatorScreen()
}