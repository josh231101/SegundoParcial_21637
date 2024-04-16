package com.example.segundoparcial_21637.viewmodels

import androidx.lifecycle.ViewModel
import com.example.segundoparcial_21637.R
import com.example.segundoparcial_21637.models.Pokemon

class PokemonViewModel: ViewModel() {
    init {

    }

    fun getPokemonList(): ArrayList<Pokemon> {
        val pokemon = Pokemon(R.drawable.pokemon01, "Sprigatito")
        val pokemonList: ArrayList<Pokemon> = ArrayList<Pokemon>()
        pokemonList.add(pokemon)
        pokemonList.add(Pokemon(R.drawable.pokemon02, "Fuecoco"))
        pokemonList.add(Pokemon(R.drawable.pokemon03, "Quaxly"))

        return pokemonList
    }
}