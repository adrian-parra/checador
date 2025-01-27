package com.example.checadorproyect.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

// Función para convertir la fecha UTC a LocalDate
@RequiresApi(Build.VERSION_CODES.O)
fun parseFechaContratacion(utcDate: String): LocalDate {
    val formatter = DateTimeFormatter.ISO_DATE_TIME // Usa el formato adecuado para UTC
    return LocalDate.parse(utcDate, formatter)
}

@RequiresApi(Build.VERSION_CODES.O)
fun calcularAntiguedad(fechaContratacionUtc: String): String {
    val fechaContratacion = parseFechaContratacion(fechaContratacionUtc)
    val fechaActual = LocalDate.now()

    val años = ChronoUnit.YEARS.between(fechaContratacion, fechaActual)
    val meses = ChronoUnit.MONTHS.between(fechaContratacion, fechaActual) % 12
    val dias = ChronoUnit.DAYS.between(fechaContratacion.plusYears(años).plusMonths(meses), fechaActual)

    return "$años años, $meses meses y $dias días"
}
