package com.example.composecalculator.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorButton(
    text: String? = null,
    icon: ImageVector? = null,
    bgColor: Color,
    foregroundColor: Color,
    onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.size(48.dp),
        contentPadding = PaddingValues(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = bgColor
        ),
        shape = CircleShape
    ) {
        text?.let {
            Text(text = text, color = foregroundColor, fontSize = 18.sp)
        }
        icon?.let {
            Icon(imageVector = icon, contentDescription = "", tint = foregroundColor)
        }
    }
}

@Composable
fun TextArea(text: String, resultText: String) {
    Column(
        modifier = Modifier.fillMaxSize().padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            Text(
                text = text,
                modifier = Modifier
                    .align(Alignment.BottomEnd),
                fontSize = 24.sp
            )
        }
        Text(
            text = resultText,
            modifier = Modifier
                .height(IntrinsicSize.Min)
                .fillMaxWidth(),
            fontSize = 24.sp,
            textAlign = TextAlign.End
        )
    }
}

@Composable
@Preview
fun PreviewButton() {
    CalculatorButton(text = "AC", bgColor = Color.Transparent, foregroundColor = Color.Green) { }
}