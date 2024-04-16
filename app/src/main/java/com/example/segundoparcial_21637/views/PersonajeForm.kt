package com.example.segundoparcial_21637.views

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.segundoparcial_21637.R
import com.example.segundoparcial_21637.viewmodels.PokemonViewModel

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun PersonajeForm(navHostController: NavHostController, imagen: Int, profesion: String) {
    var nombre: String by remember {
        mutableStateOf("")
    }
    var selectedPokemon: String by remember {
        mutableStateOf("")
    }
    var hasFinished: Boolean by remember {
        mutableStateOf(false)
    }
    val context = LocalContext.current
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(14.dp), horizontalAlignment = Alignment.CenterHorizontally) {
       Column() {
           Card(
               colors = CardDefaults.cardColors(containerColor = Color(0xFFDCE3E9)),
           ) {
               Row (
                   modifier = Modifier
                       .fillMaxWidth()
                       .padding(4.dp),
                   verticalAlignment = Alignment.CenterVertically
               ) {
                   Image(
                       painter = painterResource(id = imagen), contentDescription = "Personaje",
                       contentScale = ContentScale.Crop,
                       modifier = Modifier.size(80.dp)
                   )
                   Spacer(modifier = Modifier.width(24.dp))
                   Column() {
                       TextField(value = nombre, onValueChange = { nombre = it },
                           label = { Text(text = "¿Cuál es tu nombre?")}, modifier = Modifier.background(Color(0xFFDCE3E9))
                       )
                   }
               }
           }
       }
        Spacer(modifier = Modifier.size(20.dp))
        Text(text = "Selecciona a tu compañero de viaje")
        LazyRow {
            items(PokemonViewModel().getPokemonList()) {
                    pokemon ->
                PokemonCard(pokemon = pokemon, navHostController = navHostController)
                Spacer(modifier = Modifier.size(16.dp))
            }
        }
        Row() {
            Button(onClick = { navHostController.popBackStack() }) {
                Text(text = "Regresar")
            }
            Spacer(modifier = Modifier.width(20.dp))
            Button(onClick = {
                if (nombre == "") {
                    Toast.makeText(context, "Favor proporcionar su nombre", Toast.LENGTH_SHORT).show()
                    return@Button
                }
                hasFinished = true
            }) {
                Text(text = "Finalizar")
            }
        }
        if(nombre != "" && selectedPokemon != "" && hasFinished) {
            Text(text = "${profesion} ${nombre} elijió a ${selectedPokemon}")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun prueba2() {
    PersonajeForm(navHostController = rememberNavController(), R.drawable.male04, "Profgesor")
}