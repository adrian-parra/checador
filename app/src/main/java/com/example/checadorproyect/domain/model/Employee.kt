package com.example.checadorproyect.domain.model

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.Period

data class Employee(
    val id: Int,
    val name: String,
    val hireDate: String
)