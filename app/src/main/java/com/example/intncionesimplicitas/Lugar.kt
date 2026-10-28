package com.example.intncionesimplicitas

import java.io.Serializable

// Clase de datos que representa un Lugar turístico con nombre, descripción e imagen
data class Lugar(
    val nombre: String,
    val descripcion: String,
    val imagen: Int
) : Serializable
