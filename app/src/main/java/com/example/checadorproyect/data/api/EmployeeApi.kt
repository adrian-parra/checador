package com.example.checadorproyect.data.api

import retrofit2.http.GET
import retrofit2.http.Path

data class EmployeeDto(
    val id: Int,
    val name: String,
    val hireDate: String // Ejemplo: "2015-01-10"
)

interface EmployeeApi {
    @GET("employee/{id}")
    suspend fun getEmployee(@Path("id") id: Int): EmployeeDto
}
