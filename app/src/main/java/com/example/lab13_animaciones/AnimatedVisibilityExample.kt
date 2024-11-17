package com.example.lab13_animaciones


import androidx.compose.animation.*
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

@Composable
fun AnimatedVisibilityExample() {
    // Estado que maneja la visibilidad del cuadro
    var isVisible by remember { mutableStateOf(false) }

    // Contenedor principal de la interfaz
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        // Botón que alterna la visibilidad del cuadro
        Button(onClick = { isVisible = !isVisible }) {
            Text(text = if (isVisible) "Ocultar Cuadro" else "Mostrar Cuadro")
        }

        // Cuadro animado que cambia su visibilidad con AnimatedVisibility
        Spacer(modifier = Modifier.height(20.dp)) // Espaciado entre el botón y el cuadro
        AnimatedVisibility(
            visible = isVisible,  // Dependiendo del estado, el cuadro será visible o no
            enter = fadeIn(tween(1000)),  // Animación de entrada (fadeIn)
            exit = fadeOut(tween(1000))   // Animación de salida (fadeOut)
        ) {
            Box(
                modifier = Modifier
                    .size(200.dp)
                    .background(Color.Blue)  // El color del cuadro
            )
        }
    }
}