package com.example.checadorproyect.presentation.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.checadorproyect.presentation.viewmodel.EmployeeViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun EmployeeScreen(viewModel: EmployeeViewModel, employeeId: Int) {
    // Llamar a fetchEmployee cuando el employeeId cambie
    LaunchedEffect(employeeId) {
        viewModel.fetchEmployee(employeeId)
    }

    // Obtener el estado del empleado
    val employee by viewModel.employee.collectAsState()

    // Componer la UI
    Column(modifier = Modifier.padding(16.dp)) {
        when (val emp = employee) {
            null -> {
                // Mostrar un mensaje de carga si el empleado aún no se ha cargado
                Text(text = "Cargando empleado...")
            }
            else -> {
                // Mostrar los detalles del empleado cuando la información esté disponible
                Text(text = "Nombre: ${emp.name}", style = MaterialTheme.typography.h6)
                Text(text = "ID: ${emp.id}", style = MaterialTheme.typography.body1)
                Text(text = "Fecha de contratación: ${emp.hireDate}", style = MaterialTheme.typography.body1)
            }
        }
    }
}
