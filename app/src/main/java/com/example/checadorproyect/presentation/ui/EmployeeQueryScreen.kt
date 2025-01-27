
package com.example.checadorproyect.presentation.ui

import CustomText
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.checadorproyect.presentation.ui.components.CustomButton
import com.example.checadorproyect.presentation.ui.components.CustomEmployeeIdInput
import com.example.checadorproyect.presentation.ui.components.CustomGradientText
import com.example.checadorproyect.presentation.viewmodel.EmployeeViewModel
import com.example.checadorproyect.utils.calcularAntiguedad


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun EmployeeQueryScreen(viewModel: EmployeeViewModel, modifier: Modifier) {
    // Variable para almacenar el ID del empleado ingresado
    var employeeId by remember { mutableStateOf("") }
    // Llamar a fetchEmployee cuando el ID del empleado cambia
    val employee by viewModel.employee.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState() // Obtenemos el estado de carga
    var isFirstQuery by remember { mutableStateOf(true) } // Variable booleana para saber si es la primera consulta

    // Callback para manejar la acción del teclado
    val handleKeyboardAction: () -> Unit = {
        // Aquí puedes cerrar el teclado, mover el foco, o cualquier otra cosa
        // Por ejemplo, para cerrar el teclado:
    }

    // Componer la UI
    Column(modifier = modifier) {
        Spacer(modifier = Modifier.height(16.dp))

        CustomEmployeeIdInput(
            employeeId = employeeId,
            onEmployeeIdChange = { employeeId = it },
            onSubmit = {
                viewModel.fetchEmployee(it) // Consultar el empleado con el ID
                isFirstQuery = false // Cambiar el estado de la primera consulta
            },
            onKeyboardAction = handleKeyboardAction, // Pasamos el callback
        )

        Spacer(modifier = Modifier.height(16.dp))

        CustomButton(
            text = "Consultar Empleado",
            onClick = {
                if (employeeId.isNotEmpty()) {
                    viewModel.fetchEmployee(employeeId.toInt()) // Llamar al ViewModel para obtener los detalles del empleado
                    isFirstQuery = false
                }
            },
            modifier = Modifier.fillMaxWidth()
        )


        Spacer(modifier = Modifier.height(16.dp))

        // Mostrar loader mientras se están cargando los datos
        when {
            isLoading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
            }
            isFirstQuery -> {
                // Mostrar un texto vacío o mensaje inicial si es la primera consulta
                Text("", modifier = Modifier.align(Alignment.CenterHorizontally)) // Puede ser un texto vacío o algo indicativo
            }
            employee == null -> {
                Text("Empleado no encontrado o error en la consulta.", modifier = Modifier.align(Alignment.CenterHorizontally))
            }
            else -> {
                CustomGradientText(
                    text = "Detalles del Empleado",
                )
                CustomText(
                    text = "ID: ${employee!!.id}",
                )
                // Mostrar los detalles del empleado si ya se hizo una consulta y no es null
                Text("Nombre: ${employee!!.name}", style = MaterialTheme.typography.h6)
                Text("Fecha de contratación: ${employee!!.hireDate}", style = MaterialTheme.typography.body1)
                val antiguedad = calcularAntiguedad(employee!!.hireDate)
                Text("Antigüedad: $antiguedad", style = MaterialTheme.typography.body1)
            }
        }
    }
}
