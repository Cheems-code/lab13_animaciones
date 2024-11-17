package com.example.lab13_animaciones

import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.animation.*
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ColorChangeButton() {
    // Estado para controlar el color
    var isBlue by remember { mutableStateOf(true) }

    // AnimateColorAsState para animar el color de fondo
    val color by animateColorAsState(
        targetValue = if (isBlue) Color.Blue else Color.Green,
        animationSpec = tween(durationMillis = 1000) // Puedes usar tween o spring aquí
    )

    // Contenedor principal con un botón
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        // Cuadro que cambia de color con la animación
        Box(
            modifier = Modifier
                .size(200.dp)
                .background(color) // Color animado
        )
        Spacer(modifier = Modifier.height(20.dp)) // Espaciado

        // Botón para cambiar el estado y el color
        Button(onClick = { isBlue = !isBlue }) {
            Text(text = "Cambiar Color")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ColorChangeButton()
}
