package com.example.intncionesimplicitas

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Ejercicio8Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio8)

        val btnMostrarMapa: Button = findViewById(R.id.btnMostrarUbicacion)

        btnMostrarMapa.setOnClickListener {
            // Coordenadas de prueba (Plaza de Bolívar, Bogotá D.C.)
            val latitud = "4.60971"
            val longitud = "-74.08175"
            val etiqueta = "Plaza de Bolívar, Bogotá"

            // Intención implícita con URI geo:
            val uriMapa = Uri.parse("geo:$latitud,$longitud?q=$latitud,$longitud($etiqueta)")
            val intentMapa = Intent(Intent.ACTION_VIEW, uriMapa)

            try {
                startActivity(intentMapa)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(this, "No se encontró una aplicación de mapas instalada", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
