package com.example.checadorproyect.data.repository

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.checadorproyect.data.api.EmployeeApi
import com.example.checadorproyect.domain.model.Employee

class EmployeeRepository(private val api: EmployeeApi) {
    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun getEmployee(id: Int): Employee {
        try {
            val dto = api.getEmployee(id)
            // Log para ver la respuesta de la API
            Log.d("EmployeeRepository", "Response: $dto")
            return Employee(
                id = dto.id,
                name = dto.name,
                hireDate = dto.hireDate
            )
        } catch (e: Exception) {
            Log.e("EmployeeRepository", "Error fetching employee", e)
            throw e
        }
    }
}
