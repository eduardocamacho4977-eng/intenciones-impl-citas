package com.example.intncionesimplicitas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Ejercicio2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio2)

        // 1. Crear la lista de productos con su nombre e imagen guardada en drawable
        val listaProductos = listOf(
            Producto("Computador Portátil", R.drawable.ic_laptop),
            Producto("Teléfono Inteligente", R.drawable.ic_phone),
            Producto("Audífonos Bluetooth", R.drawable.ic_headphones),
            Producto("Reloj Inteligente", R.drawable.ic_watch)
        )

        // 2. Referenciar el RecyclerView del layout
        val rvProductos: RecyclerView = findViewById(R.id.rvProductos)

        // 3. Asignar el LinearLayoutManager para mostrar los productos verticalmente
        rvProductos.layoutManager = LinearLayoutManager(this)

        // 4. Crear el adaptador y asignarlo al RecyclerView
        val adaptador = AdapterProductos(listaProductos)
        rvProductos.adapter = adaptador
    }
}
