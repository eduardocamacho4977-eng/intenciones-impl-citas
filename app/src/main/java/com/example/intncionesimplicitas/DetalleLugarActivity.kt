package com.example.intncionesimplicitas

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetalleLugarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_lugar)

        // 1. Obtener el objeto Lugar enviado a través del Intent explícito
        val lugar = intent.getSerializableExtra("lugar") as? Lugar

        // 2. Referenciar las vistas del layout
        val imgDetalle: ImageView = findViewById(R.id.imgDetalleLugar)
        val tvNombre: TextView = findViewById(R.id.tvNombreDetalleLugar)
        val tvDescripcion: TextView = findViewById(R.id.tvDescripcionDetalleLugar)

        // 3. Asignar los valores a las vistas si el objeto existe
        if (lugar != null) {
            tvNombre.text = lugar.nombre
            tvDescripcion.text = lugar.descripcion
            imgDetalle.setImageResource(lugar.imagen)
        }
    }
}
