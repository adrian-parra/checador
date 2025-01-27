package com.example.checadorproyect.presentation.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    color: Color = MaterialTheme.colorScheme.primary, // Color principal por defecto
    textColor: Color =  MaterialTheme.colorScheme.onPrimary, // Color secundario por defecto
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = color, contentColor = textColor),
        modifier = modifier.padding(8.dp) // Espaciado opcional
    ) {
        Text(text = text)
    }
}
