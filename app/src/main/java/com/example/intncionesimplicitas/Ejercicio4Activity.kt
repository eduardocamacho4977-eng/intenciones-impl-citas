package com.example.intncionesimplicitas

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Ejercicio4Activity : AppCompatActivity() {

    private val listaElementos = mutableListOf(
        "Aprender Kotlin",
        "Diseñar layouts en XML",
        "Usar RecyclerView"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio4)

        val etNuevoElemento: EditText = findViewById(R.id.etNuevoElemento)
        val btnAgregar: Button = findViewById(R.id.btnAgregarElemento)
        val rvElementos: RecyclerView = findViewById(R.id.rvElementosDinamicos)

        rvElementos.layoutManager = LinearLayoutManager(this)

        // Configurar adaptador mostrando Toast con el texto al hacer clic
        val adaptador = AdapterElementos(listaElementos) { elementoSeleccionado ->
            Toast.makeText(this, "Seleccionaste: $elementoSeleccionado", Toast.LENGTH_SHORT).show()
        }
        rvElementos.adapter = adaptador

        // Botón para agregar nuevos elementos a la lista
        btnAgregar.setOnClickListener {
            val textoIngresado = etNuevoElemento.text.toString().trim()

            if (textoIngresado.isNotEmpty()) {
                adaptador.agregarElemento(textoIngresado)
                etNuevoElemento.text.clear()
                Toast.makeText(this, "Elemento agregado correctamente", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Por favor escribe un texto", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
