package com.example.registroapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.navigation.compose.*
import androidx.navigation.compose.rememberNavController
import com.example.registroapp.ui.HomeScreen
import com.example.registroapp.ui.RegistroScreen
import com.example.registroapp.ui.ConfirmacionScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RegistroApp()
        }
    }
}

@Composable
fun RegistroApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("registro") { RegistroScreen(navController) }
        composable("confirmacion/{nombre}/{cedula}/{correo}") { backStackEntry ->
            val nombre = backStackEntry.arguments?.getString("nombre") ?: ""
            val cedula = backStackEntry.arguments?.getString("cedula") ?: ""
            val correo = backStackEntry.arguments?.getString("correo") ?: ""
            ConfirmacionScreen(nombre, cedula, correo)
        }
    }
}
