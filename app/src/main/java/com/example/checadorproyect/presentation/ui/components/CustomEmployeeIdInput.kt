package com.example.checadorproyect.presentation.ui.components
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomEmployeeIdInput(
    employeeId: String,
    onEmployeeIdChange: (String) -> Unit,
    onSubmit: (Int) -> Unit,
    onKeyboardAction: () -> Unit,  // Callback para manejar la acción del teclado
    modifier: Modifier = Modifier,
    text: String = "Ingrese ID del empleado",
) {
    // Aquí se mueve la lógica de controlador del teclado dentro de la función composable
    val keyboardController = LocalSoftwareKeyboardController.current

    OutlinedTextField(
        value = employeeId,
        onValueChange = onEmployeeIdChange,
        label = { Text(text) },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done  // Acción al presionar Enter
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                if (employeeId.isNotEmpty()) {
                    onSubmit(employeeId.toInt()) // Consultar el empleado
                }
                // Llamar al callback y ocultar el teclado después de la acción
                keyboardController?.hide()  // Esto solo puede ocurrir dentro de una función composable
                onKeyboardAction()  // Llamar al callback de la acción del teclado
            },
            onNext = {
                keyboardController?.hide()  // Ocultar el teclado si se presiona "Next"
                onKeyboardAction()  // Llamar al callback para manejar el "Next"
            }
        ),
        singleLine = true,
        modifier = modifier.fillMaxWidth(),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colorScheme.primary, // Color de borde cuando el campo tiene el foco
            unfocusedBorderColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f), // Color de borde cuando el campo no tiene foco
            focusedLabelColor = MaterialTheme.colorScheme.primary, // Color de la etiqueta cuando el campo tiene el foco
            unfocusedLabelColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f) // Color de la etiqueta cuando no tiene foco
        )
    )
}
