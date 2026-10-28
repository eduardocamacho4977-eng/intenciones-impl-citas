package com.example.intncionesimplicitas

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class DetalleContactoActivity : AppCompatActivity() {

    private var contactoActual: Contacto? = null
    private var posicionContacto: Int = -1

    private lateinit var tvNombre: TextView
    private lateinit var tvTelefono: TextView

    private val editarLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val contactoEditado = result.data?.getSerializableExtra("contacto") as? Contacto
            if (contactoEditado != null) {
                contactoActual = contactoEditado
                tvNombre.text = contactoEditado.nombre
                tvTelefono.text = contactoEditado.telefono

                // Notificar cambio a Ejercicio6Activity
                val intentResultado = Intent()
                intentResultado.putExtra("accion", "EDITAR")
                intentResultado.putExtra("contacto", contactoEditado)
                intentResultado.putExtra("posicion", posicionContacto)
                setResult(RESULT_OK, intentResultado)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_contacto)

        tvNombre = findViewById(R.id.tvNombreDetalleContacto)
        tvTelefono = findViewById(R.id.tvTelefonoDetalleContacto)

        contactoActual = intent.getSerializableExtra("contacto") as? Contacto
        posicionContacto = intent.getIntExtra("posicion", -1)

        contactoActual?.let {
            tvNombre.text = it.nombre
            tvTelefono.text = it.telefono
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detalle_contacto, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_editar_contacto -> {
                val intent = Intent(this, EditarContactoActivity::class.java)
                intent.putExtra("contacto", contactoActual)
                intent.putExtra("posicion", posicionContacto)
                editarLauncher.launch(intent)
                true
            }
            R.id.menu_eliminar_contacto -> {
                val intentResultado = Intent()
                intentResultado.putExtra("accion", "ELIMINAR")
                intentResultado.putExtra("posicion", posicionContacto)
                setResult(RESULT_OK, intentResultado)
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
