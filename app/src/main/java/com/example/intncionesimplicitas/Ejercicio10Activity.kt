package com.example.intncionesimplicitas

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class Ejercicio10Activity : AppCompatActivity() {

    private lateinit var tvResultado: TextView

    // Contrato para recibir la Uri del contacto seleccionado por el usuario
    private val seleccionarContactoLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val contactUri: Uri? = result.data?.data
            if (contactUri != null) {
                obtenerNombreContacto(contactUri)
            } else {
                Toast.makeText(this, "No se seleccionó ningún contacto", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio10)

        val btnSeleccionar: Button = findViewById(R.id.btnSeleccionarContactoAgenda)
        tvResultado = findViewById(R.id.tvContactoResultado)

        btnSeleccionar.setOnClickListener {
            // Intención implícita para abrir el selector de contactos del sistema
            val intent = Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)
            seleccionarContactoLauncher.launch(intent)
        }
    }

    // Método para consultar el nombre del contacto seleccionado usando ContentResolver
    private fun obtenerNombreContacto(contactUri: Uri) {
        val cursor = contentResolver.query(contactUri, null, null, null, null)
        cursor?.use {
            if (it.moveToFirst()) {
                val nameIndex = it.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)
                if (nameIndex >= 0) {
                    val nombre = it.getString(nameIndex)
                    tvResultado.text = "Contacto seleccionado:\n$nombre"
                }
            }
        }
    }
}
