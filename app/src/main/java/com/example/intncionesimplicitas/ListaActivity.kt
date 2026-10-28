package com.example.intncionesimplicitas

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        // Lista de productos disponibles para devolver
        val listaProductos = listOf(
            Producto("Televisor Smart TV 55\"", 0, 1500000.0),
            Producto("Consola de Videojuegos", 0, 2200000.0),
            Producto("Teclado Mecánico RGB", 0, 250000.0),
            Producto("Monitor Gamer 27\"", 0, 950000.0)
        )

        val rvProductos: RecyclerView = findViewById(R.id.rvListaProductosSeleccion)
        rvProductos.layoutManager = LinearLayoutManager(this)

        // Al hacer clic en un producto, devolvemos el resultado a la actividad principal
        val adaptador = AdapterProductosPrecio(listaProductos) { productoSeleccionado ->
            val intentResultado = Intent()
            intentResultado.putExtra("producto_seleccionado", productoSeleccionado)
            setResult(RESULT_OK, intentResultado)
            finish() // Cierra ListaActivity y regresa
        }

        rvProductos.adapter = adaptador
    }
}
