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

class Ejercicio6Activity : AppCompatActivity() {

    private val listaContactos = mutableListOf(
        Contacto("1", "Juan Carlos Pérez", "3001234567"),
        Contacto("2", "María Camila López", "3159876543"),
        Contacto("3", "Carlos Alberto Gómez", "3104567890")
    )

    private lateinit var adaptador: AdapterContactos

    // Launcher para crear nuevo contacto
    private val crearContactoLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val nuevoContacto = result.data?.getSerializableExtra("contacto") as? Contacto
            if (nuevoContacto != null) {
                listaContactos.add(nuevoContacto)
                adaptador.notifyItemInserted(listaContactos.size - 1)
                Toast.makeText(this, "Contacto creado exitosamente", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Launcher para detalle (editar o eliminar)
    private val detalleContactoLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val accion = result.data?.getStringExtra("accion")
            val posicion = result.data?.getIntExtra("posicion", -1) ?: -1

            if (accion == "EDITAR" && posicion != -1) {
                val contactoEditado = result.data?.getSerializableExtra("contacto") as? Contacto
                if (contactoEditado != null) {
                    listaContactos[posicion] = contactoEditado
                    adaptador.notifyItemChanged(posicion)
                    Toast.makeText(this, "Contacto actualizado", Toast.LENGTH_SHORT).show()
                }
            } else if (accion == "ELIMINAR" && posicion != -1) {
                listaContactos.removeAt(posicion)
                adaptador.notifyItemRemoved(posicion)
                Toast.makeText(this, "Contacto eliminado", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio6)

        val rvContactos: RecyclerView = findViewById(R.id.rvContactos)
        rvContactos.layoutManager = LinearLayoutManager(this)

        adaptador = AdapterContactos(listaContactos) { contactoSeleccionado, posicion ->
            val intent = Intent(this, DetalleContactoActivity::class.java)
            intent.putExtra("contacto", contactoSeleccionado)
            intent.putExtra("posicion", posicion)
            detalleContactoLauncher.launch(intent)
        }

        rvContactos.adapter = adaptador
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_ejercicio6, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_nuevo_contacto -> {
                val intent = Intent(this, EditarContactoActivity::class.java)
                crearContactoLauncher.launch(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
