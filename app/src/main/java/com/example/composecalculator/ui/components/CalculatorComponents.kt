package com.example.composecalculator.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateSizeAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorButton(
    text: String? = null,
    icon: ImageVector? = null,
    bgColor: Color,
    foregroundColor: Color,
    isAnimated: Boolean = false,
    onClick: () -> Unit) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    Button(
        onClick = {
            if (isAnimated) {
                expanded = !expanded
            }
            onClick()
        },
        modifier = Modifier.wrapContentSize(),
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
            if (isAnimated) {
                Icon(imageVector = icon, contentDescription = "", modifier = Modifier.animateContentSize().size(if (expanded) 36.dp else 32.dp) ,tint = foregroundColor)
            } else {
                Icon(imageVector = icon, contentDescription = "", tint = foregroundColor)
            }
        }
    }
}

@Composable
fun TextArea(prevResultsText: String, text: String, resultText: String, isResultFocused: Boolean) {
    val resSize by animateSizeAsState(targetValue = if (isResultFocused) { Size(24.sp.value, 24.sp.value) } else { Size(18.sp.value, 18.sp.value) }, label = "")
    val txtSize by animateSizeAsState(targetValue = if (isResultFocused) { Size(18.sp.value, 18.sp.value) } else { Size(24.sp.value, 24.sp.value) }, label = "")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            Text(
                text = prevResultsText,
                modifier = Modifier
                    .align(Alignment.BottomEnd),
                color = Color.LightGray,
                fontSize = 16.sp
            )
        }
        Text(
            text = text,
            modifier = Modifier
                .height(32.dp)
                .fillMaxWidth(),
            color = if (isResultFocused) { Color.LightGray } else { Color.Black },
            fontSize = TextUnit(txtSize.height, TextUnitType.Sp),
            textAlign = TextAlign.End
        )
        Text(
            text = resultText,
            modifier = Modifier
                .height(32.dp)
                .fillMaxWidth(),
            color = if (isResultFocused) { Color.Black } else { Color.LightGray },
            fontSize = TextUnit(resSize.height, TextUnitType.Sp),
            textAlign = TextAlign.End
        )
    }
}

@Composable
@Preview
fun PreviewButton() {
    CalculatorButton(text = "AC", bgColor = Color.Transparent, foregroundColor = Color.Green) { }
}