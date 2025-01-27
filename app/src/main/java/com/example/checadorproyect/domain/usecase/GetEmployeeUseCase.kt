package com.example.checadorproyect.domain.usecase

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.checadorproyect.data.repository.EmployeeRepository
import com.example.checadorproyect.domain.model.Employee

class GetEmployeeUseCase(private val repository: EmployeeRepository) {
    @RequiresApi(Build.VERSION_CODES.O)
    suspend operator fun invoke(id: Int): Employee {
        return repository.getEmployee(id)
    }
}
