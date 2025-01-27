package com.example.checadorproyect.presentation.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.checadorproyect.domain.model.Employee
import com.example.checadorproyect.domain.usecase.GetEmployeeUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class EmployeeViewModel(private val getEmployeeUseCase: GetEmployeeUseCase) : ViewModel() {
    private val _employee = MutableStateFlow<Employee?>(null)
    val employee: StateFlow<Employee?> = _employee

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    @RequiresApi(Build.VERSION_CODES.O)
    fun fetchEmployee(id: Int) {
        viewModelScope.launch {
            _isLoading.value = true // Iniciar carga
            try {
                val employee = getEmployeeUseCase(id)
                _employee.value = employee
            } catch (e: Exception) {
                // Manejar error si es necesario
                _employee.value = null
            } finally {
                _isLoading.value = false // Finalizar carga
            }
        }
    }
}
