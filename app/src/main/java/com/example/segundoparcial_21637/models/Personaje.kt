package com.example.segundoparcial_21637.models

import androidx.annotation.DrawableRes

data class Personaje(
    @DrawableRes val imagen: Int,
    val profesion: String,
    val sexo: String,
    val edad: Int
)