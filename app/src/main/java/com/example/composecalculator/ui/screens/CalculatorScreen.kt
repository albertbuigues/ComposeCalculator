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
import com.example.composecalculator.ui.components.CalculatorButton
import com.example.composecalculator.ui.components.TextArea
import com.example.composecalculator.ui.theme.Orange

@Composable
fun CalculatorScreen() {
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    Column {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(screenHeight / 2)
        ) {
            TextArea()
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
            ButtonsArea()
        }
    }
}

@Composable
fun ButtonsArea() {
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
            CalculatorButton(text = "AC", bgColor = Color.Transparent, foregroundColor = Orange) { }
            CalculatorButton(icon = Icons.Outlined.Backspace, bgColor = Color.Transparent, foregroundColor = Orange) { }
            CalculatorButton(text = "%", bgColor = Color.Transparent, foregroundColor = Orange) { }
            CalculatorButton(text = "/", bgColor = Color.Transparent, foregroundColor = Orange) { }
        }
        Row(
            Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CalculatorButton(text = "7", bgColor = Color.Transparent, foregroundColor = Color.Black) { }
            CalculatorButton(text = "8", bgColor = Color.Transparent, foregroundColor = Color.Black) { }
            CalculatorButton(text = "9", bgColor = Color.Transparent, foregroundColor = Color.Black) { }
            CalculatorButton(text = "X", bgColor = Color.Transparent, foregroundColor = Orange) { }
        }
        Row(
            Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CalculatorButton(text = "4", bgColor = Color.Transparent, foregroundColor = Color.Black) { }
            CalculatorButton(text = "5", bgColor = Color.Transparent, foregroundColor = Color.Black) { }
            CalculatorButton(text = "6", bgColor = Color.Transparent, foregroundColor = Color.Black) { }
            CalculatorButton(text = "—", bgColor = Color.Transparent, foregroundColor = Orange) { }
        }
        Row(
            Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CalculatorButton(text = "1", bgColor = Color.Transparent, foregroundColor = Color.Black) { }
            CalculatorButton(text = "2", bgColor = Color.Transparent, foregroundColor = Color.Black) { }
            CalculatorButton(text = "3", bgColor = Color.Transparent, foregroundColor = Color.Black) { }
            CalculatorButton(text = "+", bgColor = Color.Transparent, foregroundColor = Orange) { }
        }
        Row(
            Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CalculatorButton(icon = Icons.Outlined.OpenWith, bgColor = Color.Transparent, foregroundColor = Orange) { }
            CalculatorButton(text = "0", bgColor = Color.Transparent, foregroundColor = Color.Black) { }
            CalculatorButton(text = ",", bgColor = Color.Transparent, foregroundColor = Color.Black) { }
            CalculatorButton(text = "=", bgColor = Orange, foregroundColor = Color.White) { }
        }
    }
}

@Composable
@Preview
fun PreviewScreen() {
    CalculatorScreen()
}