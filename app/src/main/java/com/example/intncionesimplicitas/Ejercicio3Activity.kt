package com.example.intncionesimplicitas

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Ejercicio3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio3)

        // 1. Crear la lista de objetos Lugar
        val listaLugares = listOf(
            Lugar("Parque Nacional Simón Bolívar", "Un extenso parque urbano en el corazón de Bogotá con amplias zonas verdes y un hermoso lago.", R.drawable.ic_parque),
            Lugar("Museo del Oro", "Famoso museo que alberga la colección de orfebrería prehispánica más grande del mundo.", R.drawable.ic_museo),
            Lugar("Playa Blanca", "Hermosa playa de aguas cristalinas y arena blanca en la isla de Barú, Cartagena.", R.drawable.ic_playa)
        )

        val rvLugares: RecyclerView = findViewById(R.id.rvLugares)
        rvLugares.layoutManager = LinearLayoutManager(this)

        // 2. Configurar el adaptador con la acción de clic para abrir DetalleLugarActivity mediante Intent explícito
        val adaptador = AdapterLugares(listaLugares) { lugarSeleccionado ->
            val intent = Intent(this, DetalleLugarActivity::class.java)
            intent.putExtra("lugar", lugarSeleccionado)
            startActivity(intent)
        }

        rvLugares.adapter = adaptador
    }
}
