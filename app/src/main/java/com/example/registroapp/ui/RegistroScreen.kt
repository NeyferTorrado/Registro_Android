package com.example.registroapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.Alignment

@Composable
fun RegistroScreen(navController: NavController) {
    var nombre by remember { mutableStateOf("") }
    var cedula by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally // Centra horizontalmente
    ) {
        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth(0.8f) // Opcional: Limita ancho al 80%
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = cedula,
            onValueChange = { cedula = it },
            label = { Text("Cédula") },
            modifier = Modifier.fillMaxWidth(0.8f)
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = correo,
            onValueChange = { correo = it },
            label = { Text("Correo") },
            modifier = Modifier.fillMaxWidth(0.8f)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                if (nombre.isNotBlank() && cedula.isNotBlank() && correo.isNotBlank()) {
                    navController.navigate("confirmacion/$nombre/$cedula/$correo")
                }
            },
            modifier = Modifier.fillMaxWidth(0.5f) // Botón al 50% del ancho
        ) {
            Text("Registrarse")
        }
    }
}

