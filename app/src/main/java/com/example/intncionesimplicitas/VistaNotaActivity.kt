package com.example.intncionesimplicitas

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class VistaNotaActivity : AppCompatActivity() {

    private var notaActual: Nota? = null
    private var posicionNota: Int = -1

    private lateinit var tvTitulo: TextView
    private lateinit var tvContenido: TextView

    private val editarNotaLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val notaEditada = result.data?.getSerializableExtra("nota") as? Nota
            if (notaEditada != null) {
                notaActual = notaEditada
                tvTitulo.text = notaEditada.titulo
                tvContenido.text = notaEditada.contenido

                // Retornar la nota editada a Ejercicio7Activity
                val intentResultado = Intent()
                intentResultado.putExtra("nota", notaEditada)
                intentResultado.putExtra("posicion", posicionNota)
                setResult(RESULT_OK, intentResultado)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vista_nota)

        tvTitulo = findViewById(R.id.tvTituloVistaNota)
        tvContenido = findViewById(R.id.tvContenidoVistaNota)

        notaActual = intent.getSerializableExtra("nota") as? Nota
        posicionNota = intent.getIntExtra("posicion", -1)

        notaActual?.let {
            tvTitulo.text = it.titulo
            tvContenido.text = it.contenido
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_vista_nota, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_editar_nota -> {
                val intent = Intent(this, EdicionNotaActivity::class.java)
                intent.putExtra("nota", notaActual)
                intent.putExtra("posicion", posicionNota)
                editarNotaLauncher.launch(intent)
                true
            }
            R.id.menu_compartir_nota -> {
                notaActual?.let { nota ->
                    // Intención implícita para compartir el contenido de la nota con otras aplicaciones
                    val intentCompartir = Intent(Intent.ACTION_SEND).apply {
                        type = "text/plain"
                        putExtra(Intent.EXTRA_TEXT, "Nota: ${nota.titulo}\n\n${nota.contenido}")
                    }
                    val chooser = Intent.createChooser(intentCompartir, "Compartir nota mediante")
                    startActivity(chooser)
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
