package com.example.juntosnotificaciones

import androidx.compose.runtime.Composable

sealed class NavRoutes (val route: String) {
    object Login : NavRoutes("login")
    object Welcome : NavRoutes("welcome")
}
