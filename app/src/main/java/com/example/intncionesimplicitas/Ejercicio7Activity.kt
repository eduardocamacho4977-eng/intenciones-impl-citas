package com.example.intncionesimplicitas

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Ejercicio7Activity : AppCompatActivity() {

    private val listaNotas = mutableListOf(
        Nota("1", "Tareas del SENA", "Revisar la guía sobre intenciones implícitas y RecyclerView."),
        Nota("2", "Lista de compras", "Comprar leche, fruta y pan para la semana."),
        Nota("3", "Ideas de proyecto", "Crear una app para gestión de inventarios.")
    )

    private lateinit var adaptador: AdapterNotas

    private val crearNotaLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val nuevaNota = result.data?.getSerializableExtra("nota") as? Nota
            if (nuevaNota != null) {
                listaNotas.add(nuevaNota)
                adaptador.notifyItemInserted(listaNotas.size - 1)
                Toast.makeText(this, "Nota creada exitosamente", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private val verNotaLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val notaEditada = result.data?.getSerializableExtra("nota") as? Nota
            val posicion = result.data?.getIntExtra("posicion", -1) ?: -1

            if (notaEditada != null && posicion != -1) {
                listaNotas[posicion] = notaEditada
                adaptador.notifyItemChanged(posicion)
                Toast.makeText(this, "Nota actualizada", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio7)

        val rvNotas: RecyclerView = findViewById(R.id.rvNotas)
        rvNotas.layoutManager = LinearLayoutManager(this)

        adaptador = AdapterNotas(listaNotas) { notaSeleccionada, posicion ->
            val intent = Intent(this, VistaNotaActivity::class.java)
            intent.putExtra("nota", notaSeleccionada)
            intent.putExtra("posicion", posicion)
            verNotaLauncher.launch(intent)
        }

        rvNotas.adapter = adaptador
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_ejercicio7, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_nueva_nota -> {
                val intent = Intent(this, EdicionNotaActivity::class.java)
                crearNotaLauncher.launch(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
