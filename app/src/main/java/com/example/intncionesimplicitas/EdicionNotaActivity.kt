package com.example.intncionesimplicitas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EdicionNotaActivity : AppCompatActivity() {

    private var notaExistente: Nota? = null
    private var posicionNota: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edicion_nota)

        val etTitulo: EditText = findViewById(R.id.etTituloNota)
        val etContenido: EditText = findViewById(R.id.etContenidoNota)
        val btnGuardar: Button = findViewById(R.id.btnGuardarNota)

        notaExistente = intent.getSerializableExtra("nota") as? Nota
        posicionNota = intent.getIntExtra("posicion", -1)

        notaExistente?.let {
            etTitulo.setText(it.titulo)
            etContenido.setText(it.contenido)
        }

        btnGuardar.setOnClickListener {
            val titulo = etTitulo.text.toString().trim()
            val contenido = etContenido.text.toString().trim()

            if (titulo.isNotEmpty() && contenido.isNotEmpty()) {
                val intentResultado = Intent()
                val notaGuardada = Nota(
                    id = notaExistente?.id ?: System.currentTimeMillis().toString(),
                    titulo = titulo,
                    contenido = contenido
                )
                intentResultado.putExtra("nota", notaGuardada)
                intentResultado.putExtra("posicion", posicionNota)
                setResult(RESULT_OK, intentResultado)
                finish()
            } else {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
