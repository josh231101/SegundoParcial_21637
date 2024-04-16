package com.example.segundoparcial_21637.viewmodels

import androidx.lifecycle.ViewModel
import com.example.segundoparcial_21637.R
import com.example.segundoparcial_21637.models.Personaje

class PersonajeViewModel: ViewModel() {
    init {

    }

    fun getPersonajesList(): ArrayList<Personaje> {
        val personaje = Personaje(R.drawable.female01, 12, "chica", "Estudiante")
        val personajesList: ArrayList<Personaje> = ArrayList<Personaje>()
        personajesList.add(personaje)
        personajesList.add(Personaje(R.drawable.male01, 10, "chico", "Estudiante"))
        personajesList.add(Personaje(R.drawable.female02, 14, "chica", "Youtuber"))
        personajesList.add(Personaje(R.drawable.male02, 24, "chico", "Profesor"))
        personajesList.add(Personaje(R.drawable.female03, 22, "chica", "Enfermera"))
        personajesList.add(Personaje(R.drawable.male03, 65, "chico", "Pescador"))
        personajesList.add(Personaje(R.drawable.female04, 21, "chica", "Mecánica"))
        personajesList.add(Personaje(R.drawable.male04, 32, "chico", "Cocinero"))

        return personajesList
    }
}