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
            }
            CalculatorButton(icon = Icons.Outlined.Backspace, bgColor = Color.Transparent, foregroundColor = Orange) {
                val noSpacedResultText = viewModel.resultText.value.replace(" ", "")
                if (noSpacedResultText.length == 2) {
                    viewModel.resultText.value = "0"
                    viewModel.text.value = ""
                }
                else if (viewModel.text.value != "0" && viewModel.resultText.value != "= 0" && viewModel.text.value.isNotEmpty() && viewModel.resultText.value.isNotEmpty()) {
                    viewModel.text.value = viewModel.text.value.removeRange(viewModel.text.value.length-1, viewModel.text.value.length)
                    viewModel.resultText.value = viewModel.resultText.value.removeRange(viewModel.resultText.value.length-1, viewModel.resultText.value.length)
                }
            }
            CalculatorButton(text = "%", bgColor = Color.Transparent, foregroundColor = Orange) { }
            CalculatorButton(text = "/", bgColor = Color.Transparent, foregroundColor = Orange) { }
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
            CalculatorButton(text = "X", bgColor = Color.Transparent, foregroundColor = Orange) {

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
            CalculatorButton(text = "—", bgColor = Color.Transparent, foregroundColor = Orange) { }
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
            CalculatorButton(text = "+", bgColor = Color.Transparent, foregroundColor = Orange) { }
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
        if (viewModel.text.value.any { !it.isDigit() }) {
            textAreaStrBuilder.replace(Regex("^\\D$"), strToAppend)
        }
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
    }
}

@Composable
@Preview
fun PreviewScreen() {
    CalculatorScreen()
}