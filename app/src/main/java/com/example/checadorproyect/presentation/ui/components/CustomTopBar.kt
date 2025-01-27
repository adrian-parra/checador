package com.example.checadorproyect.presentation.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar(
    title: String,
    onNavigationClick: (() -> Unit)? = null // Botón de navegación opcional
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge, // Usa la tipografía del tema
                color = MaterialTheme.colorScheme.onPrimary, // Color del texto
            )
        },
        navigationIcon = {
            // Mostrar el ícono de navegación solo si `onNavigationClick` no es nulo
            if (onNavigationClick != null) {
                IconButton(onClick = onNavigationClick) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack, // Icono predeterminado de "atrás"
                        contentDescription = "Atrás",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary, // Color de fondo
            titleContentColor = MaterialTheme.colorScheme.onPrimary // Color del texto
        ),
    )
}
