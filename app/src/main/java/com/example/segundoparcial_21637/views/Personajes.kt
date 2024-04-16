package com.example.segundoparcial_21637.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.segundoparcial_21637.R
import com.example.segundoparcial_21637.viewmodels.PersonajeViewModel

@Composable
fun Personajes(navHostController: NavHostController) {
    val personajesVM = PersonajeViewModel()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(text = "¿Eres chico o chica?")
            Image(
                painter = painterResource(id = R.drawable.oak), contentDescription = "Personaje",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape),

            )
        }
        LazyColumn() {
            items(personajesVM.getPersonajesList()) {
                personaje ->
                    PersonajeCard(personaje = personaje, navHostController = navHostController)
                    Spacer(modifier = Modifier.size(16.dp))
            }
        }
        Column(modifier = Modifier.padding(100.dp)) {
            Text(text = "Has llegado al fin de esta larga lista de entrenadores")
        }

    }

}

@Preview(showBackground = true)
@Composable
fun prueba() {
    Personajes(navHostController = rememberNavController())
}