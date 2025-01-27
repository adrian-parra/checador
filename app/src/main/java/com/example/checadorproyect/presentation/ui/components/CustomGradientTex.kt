package com.example.checadorproyect.presentation.ui.components
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@Composable
fun CustomGradientText(
    text: String,
    modifier: Modifier = Modifier,
    gradientColors: List<Color> = listOf(Color.Red, Color.Blue)
) {
    val brush = Brush.linearGradient(gradientColors)
    Text(
        text = text,
        modifier = modifier,
        style = TextStyle(
            brush = brush,
            fontSize = 20.sp
        )
    )
}
