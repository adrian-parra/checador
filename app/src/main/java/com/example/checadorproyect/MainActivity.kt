package com.example.checadorproyect

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.checadorproyect.ui.theme.ChecadorProyectTheme

import com.example.checadorproyect.data.api.EmployeeApi
import com.example.checadorproyect.data.repository.EmployeeRepository
import com.example.checadorproyect.domain.usecase.GetEmployeeUseCase
import com.example.checadorproyect.presentation.ui.EmployeeQueryScreen
import com.example.checadorproyect.presentation.ui.components.CustomTopBar
import com.example.checadorproyect.presentation.viewmodel.EmployeeViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Configurar Retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl("https://6795be4fbedc5d43a6c35ded.mockapi.io/api/") // Cambiar por tu URL
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api = retrofit.create(EmployeeApi::class.java)

        // Crear ViewModel
        val repository = EmployeeRepository(api)
        val useCase = GetEmployeeUseCase(repository)
        val viewModel = EmployeeViewModel(useCase)


        // Cargar UI
        setContent {
            ChecadorProyectTheme {
                Scaffold(
                    topBar = {
                        // Aquí puedes definir la barra superior, si es necesaria
                        CustomTopBar(
                            title = "Consulta de Empleados"
                        )

                    }
                ) { paddingValues ->
                    EmployeeQueryScreen(viewModel = viewModel,
                        modifier = Modifier.padding(paddingValues))

                }
            }
        }

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ChecadorProyectTheme {
        Greeting("Android")
    }
}