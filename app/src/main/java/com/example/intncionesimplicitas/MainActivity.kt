package com.example.intncionesimplicitas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configuración de los botones de cada ejercicio

        // Ejercicio 1
        val btnEjercicio1: Button = findViewById(R.id.btnEjercicio1)
        btnEjercicio1.setOnClickListener {
            val intent = Intent(this, Ejercicio1Activity::class.java)
            startActivity(intent)
        }

        // Ejercicio 2
        val btnEjercicio2: Button = findViewById(R.id.btnEjercicio2)
        btnEjercicio2.setOnClickListener {
            val intent = Intent(this, Ejercicio2Activity::class.java)
            startActivity(intent)
        }

        // Ejercicio 3
        val btnEjercicio3: Button = findViewById(R.id.btnEjercicio3)
        btnEjercicio3.setOnClickListener {
            val intent = Intent(this, Ejercicio3Activity::class.java)
            startActivity(intent)
        }

        // Ejercicio 4
        val btnEjercicio4: Button = findViewById(R.id.btnEjercicio4)
        btnEjercicio4.setOnClickListener {
            val intent = Intent(this, Ejercicio4Activity::class.java)
            startActivity(intent)
        }

        // Ejercicio 5
        val btnEjercicio5: Button = findViewById(R.id.btnEjercicio5)
        btnEjercicio5.setOnClickListener {
            val intent = Intent(this, Ejercicio5Activity::class.java)
            startActivity(intent)
        }

        // Ejercicio 6
        val btnEjercicio6: Button = findViewById(R.id.btnEjercicio6)
        btnEjercicio6.setOnClickListener {
            val intent = Intent(this, Ejercicio6Activity::class.java)
            startActivity(intent)
        }

        // Ejercicio 7
        val btnEjercicio7: Button = findViewById(R.id.btnEjercicio7)
        btnEjercicio7.setOnClickListener {
            val intent = Intent(this, Ejercicio7Activity::class.java)
            startActivity(intent)
        }

        // Ejercicio 8
        val btnEjercicio8: Button = findViewById(R.id.btnEjercicio8)
        btnEjercicio8.setOnClickListener {
            val intent = Intent(this, Ejercicio8Activity::class.java)
            startActivity(intent)
        }

        // Ejercicio 9
        val btnEjercicio9: Button = findViewById(R.id.btnEjercicio9)
        btnEjercicio9.setOnClickListener {
            val intent = Intent(this, Ejercicio9Activity::class.java)
            startActivity(intent)
        }

        // Ejercicio 10
        val btnEjercicio10: Button = findViewById(R.id.btnEjercicio10)
        btnEjercicio10.setOnClickListener {
            val intent = Intent(this, Ejercicio10Activity::class.java)
            startActivity(intent)
        }

        // Para los ejercicios pendientes del 11 al 12
        val botonesPendientes = listOf(
            R.id.btnEjercicio11 to "Ejercicio 11",
            R.id.btnEjercicio4 to "Ejercicio 4",
            R.id.btnEjercicio5 to "Ejercicio 5",
            R.id.btnEjercicio6 to "Ejercicio 6",
            R.id.btnEjercicio7 to "Ejercicio 7",
            R.id.btnEjercicio8 to "Ejercicio 8",
            R.id.btnEjercicio9 to "Ejercicio 9",
            R.id.btnEjercicio10 to "Ejercicio 10",
            R.id.btnEjercicio11 to "Ejercicio 11",
            R.id.btnEjercicio12 to "Ejercicio 12"
        )

        for ((idBoton, nombreEjercicio) in botonesPendientes) {
            val btn: Button = findViewById(idBoton)
            btn.setOnClickListener {
                Toast.makeText(this, "Seleccionado: $nombreEjercicio. En desarrollo paso a paso.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
