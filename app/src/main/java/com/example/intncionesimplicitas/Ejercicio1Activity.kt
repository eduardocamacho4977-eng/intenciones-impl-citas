package com.example.intncionesimplicitas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Ejercicio1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio1)

        // 1. Crear la lista de nombres de personas
        val listaNombres = listOf(
            "Ana María Gómez",
            "Carlos Eduardo Pérez",
            "María Fernanda Rodríguez",
            "Juan David Martínez",
            "Laura Daniela López",
            "Pedro José Sánchez",
            "Sofía Ramírez"
        )

        // 2. Obtener la referencia al RecyclerView mediante findViewById
        val rvNombres: RecyclerView = findViewById(R.id.rvNombres)

        // 3. Configurar el LinearLayoutManager para mostrar la lista verticalmente
        rvNombres.layoutManager = LinearLayoutManager(this)

        // 4. Crear el adaptador con la lista y asignarlo al RecyclerView
        val adaptador = AdapterNombres(listaNombres)
        rvNombres.adapter = adaptador
    }
}
