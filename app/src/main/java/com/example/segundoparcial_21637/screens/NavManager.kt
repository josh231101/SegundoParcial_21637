package com.example.segundoparcial_21637.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun NavManager() {
    var navHostController : NavHostController = rememberNavController()
    NavHost(navController = navHostController, startDestination = "Personajes") {
        composable(route = "Personajes") {
            PersonajesView(navHostController)
        }

        composable(route = "Personajes/{imagen}/{profesion}",
            arguments = listOf(
                navArgument("imagen") { type = NavType.IntType},
            )
        ) {
            parametros ->
                val imagen = parametros.arguments?.getInt("imagen") ?:0
                val profesion = parametros.arguments?.getString("profesion") ?: ""
                PersonajeFormView(navHostController, imagen, profesion)
        }
    }
}