package com.example.intncionesimplicitas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class Ejercicio5Activity : AppCompatActivity() {

    private lateinit var tvProductoDevuelto: TextView

    // Registrar el contrato para recibir el resultado de ListaActivity
    private val selectorProductoLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val producto = result.data?.getSerializableExtra("producto_seleccionado") as? Producto
            if (producto != null) {
                tvProductoDevuelto.text = "Nombre: ${producto.nombre}\nPrecio: $${producto.precio}"
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio5)

        val btnAbrirLista: Button = findViewById(R.id.btnAbrirListaProductos)
        tvProductoDevuelto = findViewById(R.id.tvProductoDevuelto)

        btnAbrirLista.setOnClickListener {
            val intent = Intent(this, ListaActivity::class.java)
            selectorProductoLauncher.launch(intent)
        }
    }
}
