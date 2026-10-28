package com.example.intncionesimplicitas

import java.io.Serializable

// Clase de datos (data class) que representa un producto con su nombre e imagen (ID de recurso drawable)
data class Producto(
    val nombre: String,
    val imagen: Int,
    val precio: Double = 0.0 // Opcional con valor por defecto para reutilizar en otros ejercicios
) : Serializable
