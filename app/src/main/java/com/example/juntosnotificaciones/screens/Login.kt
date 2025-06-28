package com.example.juntosnotificaciones.screens

import android.R.style
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.juntosnotificaciones.NavRoutes

@Composable
fun Login(navController: NavHostController) {
    var correo by remember { mutableStateOf("") }
    var contraseña by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }


    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Text(text = "JUNTOS",
            modifier = Modifier.align(Alignment.CenterHorizontally),

            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                color = Color.Red
            ))
        Spacer(modifier = Modifier.height(50.dp))
        Text(text = "Correo",
            modifier = Modifier.align(Alignment.Start).padding(start = 16.dp),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
            ))
        OutlinedTextField(
            value = correo,
            onValueChange = {correo = it},
            modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp),
            label = { Text(text = "Ingresa tu correo") }
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = "Contraseña",
            modifier = Modifier.align(Alignment.Start).padding(start = 16.dp),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp))
        OutlinedTextField(
            value = contraseña,
            onValueChange = {contraseña = it},
            modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp),
            label = { Text(text = "Ingresa tu contraseña") },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val icon =
                    if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
                val description =
                    if (passwordVisible) "Ocultar contraseña" else "Mostrar contraseña"

                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(imageVector = icon, contentDescription = description)
                }
            }
        )
        Spacer(modifier = Modifier.height(40.dp))
        Button(onClick = { navController.navigate(NavRoutes.Welcome.route) },) {
            Text(text = "Iniciar Sesión")
        }
    }
}