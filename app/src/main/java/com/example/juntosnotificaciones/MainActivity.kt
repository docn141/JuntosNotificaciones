package com.example.juntosnotificaciones

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.juntosnotificaciones.ui.theme.JuntosNotificacionesTheme
import com.example.juntosnotificaciones.screens.Login
import com.example.juntosnotificaciones.NavRoutes
import com.example.juntosnotificaciones.screens.Welcome

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JuntosNotificacionesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                MainScreen(modifier = Modifier.padding(it))
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = NavRoutes.Login.route) {
        composable(NavRoutes.Login.route) {
            Login(navController)
        }
        composable(NavRoutes.Welcome.route) {
            Welcome()
        }
    }
}

