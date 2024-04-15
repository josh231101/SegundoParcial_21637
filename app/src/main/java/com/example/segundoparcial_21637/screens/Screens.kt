package com.example.segundoparcial_21637.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun PersonajesView(navHostController: NavHostController) {
    Text(text = "Esta es una prueba")
}

@Composable
fun PersonajeFormView(navHostController: NavHostController, imagen: Int) {
    Text(text = "Esta es otra prueba")
}