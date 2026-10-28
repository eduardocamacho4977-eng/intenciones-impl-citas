package com.example.intncionesimplicitas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Adaptador para mostrar la lista de lugares con evento de clic (Ejercicio 3)
class AdapterLugares(
    private val listaLugares: List<Lugar>,
    private val onItemClick: (Lugar) -> Unit
) : RecyclerView.Adapter<AdapterLugares.ViewHolderLugares>() {

    class ViewHolderLugares(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgLugar: ImageView = itemView.findViewById(R.id.imgLugarItem)
        val tvNombre: TextView = itemView.findViewById(R.id.tvNombreLugarItem)
        val tvDescripcion: TextView = itemView.findViewById(R.id.tvDescripcionLugarItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderLugares {
        val vista = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_lugar, parent, false)
        return ViewHolderLugares(vista)
    }

    override fun onBindViewHolder(holder: ViewHolderLugares, position: Int) {
        val lugar = listaLugares[position]
        holder.tvNombre.text = lugar.nombre
        holder.tvDescripcion.text = lugar.descripcion
        holder.imgLugar.setImageResource(lugar.imagen)

        // Evento de clic en la fila completa para abrir la actividad de detalle
        holder.itemView.setOnClickListener {
            onItemClick(lugar)
        }
    }

    override fun getItemCount(): Int {
        return listaLugares.size
    }
}
