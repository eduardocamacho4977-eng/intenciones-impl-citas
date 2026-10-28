package com.example.intncionesimplicitas

import java.io.Serializable

// Clase de datos para gestionar contactos con id, nombre y teléfono
data class Contacto(
    val id: String,
    var nombre: String,
    var telefono: String
) : Serializable
