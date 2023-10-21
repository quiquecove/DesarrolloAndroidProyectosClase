package com.example.lohice.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import com.example.lohice.R
import com.example.lohice.presentation.theme.LoHiceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WearApp()
        }
    }
}

@Composable
fun WearApp() {
    LoHiceTheme {
        var isYes by remember { mutableStateOf(true) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp) // Cambia 40.dp al tamaño deseado
                    .padding(8.dp), // Añade un margen de 8.dp alrededor del texto
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.primary,
                text = if (isYes) "Sí" else "No",
            )


            Button(
                onClick = {
                    isYes = true
                },
                modifier = Modifier
                    .fillMaxWidth(0.4f) // Cambia 0.4f al valor deseado (40% del ancho)
                    .height(40.dp) // Cambia 40.dp al tamaño deseado
            ) {
                Text("Sí")
            }

            Spacer(modifier = Modifier.height(16.dp)) // Agrega un espacio vertical entre los botones

            Button(
                onClick = {
                    isYes = false
                },
                modifier = Modifier
                    .fillMaxWidth(0.4f) // Cambia 0.4f al valor deseado (40% del ancho)
                    .height(40.dp) // Cambia 40.dp al tamaño deseado
            ) {
                Text("No")
            }
        }
    }
}

@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
@Composable
fun DefaultPreview() {
    WearApp()
}
