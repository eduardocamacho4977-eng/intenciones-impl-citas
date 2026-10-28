package com.example.intncionesimplicitas

import java.io.Serializable

// Clase de datos que representa una nota con id, título y contenido
data class Nota(
    val id: String,
    var titulo: String,
    var contenido: String
) : Serializable
