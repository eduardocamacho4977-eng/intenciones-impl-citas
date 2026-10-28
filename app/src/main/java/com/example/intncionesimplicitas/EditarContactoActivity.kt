package com.example.intncionesimplicitas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EditarContactoActivity : AppCompatActivity() {

    private var contactoExistente: Contacto? = null
    private var posicionContacto: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_contacto)

        val etNombre: EditText = findViewById(R.id.etNombreContacto)
        val etTelefono: EditText = findViewById(R.id.etTelefonoContacto)
        val btnGuardar: Button = findViewById(R.id.btnGuardarContacto)

        // Verificar si se recibió un contacto para editar
        contactoExistente = intent.getSerializableExtra("contacto") as? Contacto
        posicionContacto = intent.getIntExtra("posicion", -1)

        if (contactoExistente != null) {
            etNombre.setText(contactoExistente?.nombre)
            etTelefono.setText(contactoExistente?.telefono)
        }

        btnGuardar.setOnClickListener {
            val nombre = etNombre.text.toString().trim()
            val telefono = etTelefono.text.toString().trim()

            if (nombre.isNotEmpty() && telefono.isNotEmpty()) {
                val intentResultado = Intent()
                val contactoGuardado = Contacto(
                    id = contactoExistente?.id ?: System.currentTimeMillis().toString(),
                    nombre = nombre,
                    telefono = telefono
                )
                intentResultado.putExtra("contacto", contactoGuardado)
                intentResultado.putExtra("posicion", posicionContacto)
                setResult(RESULT_OK, intentResultado)
                finish()
            } else {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
