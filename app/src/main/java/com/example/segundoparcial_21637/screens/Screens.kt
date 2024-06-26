package com.example.segundoparcial_21637.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.segundoparcial_21637.views.PersonajeForm
import com.example.segundoparcial_21637.views.Personajes

@Composable
fun PersonajesView(navHostController: NavHostController) {
    Personajes(navHostController = navHostController)
}

@Composable
fun PersonajeFormView(navHostController: NavHostController, imagen: Int, profesion: String) {
    PersonajeForm(navHostController = navHostController, imagen = imagen, profesion)
}