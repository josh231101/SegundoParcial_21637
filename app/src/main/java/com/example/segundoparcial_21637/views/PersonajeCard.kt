package com.example.segundoparcial_21637.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.segundoparcial_21637.R
import com.example.segundoparcial_21637.models.Personaje

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonajeCard(personaje: Personaje, navHostController: NavHostController) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0xFFDCE3E9)),
        onClick = {
            navHostController.navigate("Personajes/${personaje.imagen}")
        }
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = personaje.imagen), contentDescription = "Personaje",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(100.dp)
            )
            Spacer(modifier = Modifier.width(24.dp))
            Column() {
                Text(text = personaje.profesion)
                Spacer(modifier = Modifier.height(18.dp))
                Text(text = personaje.sexo)
                Spacer(modifier = Modifier.height(18.dp))
                Text(text = "${personaje.edad} años")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun test() {
    PersonajeCard(Personaje(R.drawable.male04, 12, "chico", "Profesor"), rememberNavController())
}