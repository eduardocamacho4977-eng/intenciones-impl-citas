package com.example.intncionesimplicitas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Ejercicio9Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio9)

        val etTexto: EditText = findViewById(R.id.etTextoCompartir)
        val btnCompartir: Button = findViewById(R.id.btnCompartirTexto)

        btnCompartir.setOnClickListener {
            val mensaje = etTexto.text.toString().trim()

            if (mensaje.isNotEmpty()) {
                // Intención implícita para compartir el texto ingresado
                val intentCompartir = Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, mensaje)
                }

                val selector = Intent.createChooser(intentCompartir, "Compartir mensaje usando:")
                startActivity(selector)
            } else {
                Toast.makeText(this, "Escribe un mensaje antes de compartir", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
