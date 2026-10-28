package com.example.intncionesimplicitas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Adaptador para listas dinámicas con evento de clic en cada ítem (Ejercicio 4)
class AdapterElementos(
    private val listaElementos: MutableList<String>,
    private val onItemClick: (String) -> Unit
) : RecyclerView.Adapter<AdapterElementos.ViewHolderElementos>() {

    class ViewHolderElementos(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTextoElemento: TextView = itemView.findViewById(R.id.tvTextoElemento)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderElementos {
        val vista = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_elemento, parent, false)
        return ViewHolderElementos(vista)
    }

    override fun onBindViewHolder(holder: ViewHolderElementos, position: Int) {
        val texto = listaElementos[position]
        holder.tvTextoElemento.text = texto

        // Configuración del evento clic sobre el elemento de la lista
        holder.itemView.setOnClickListener {
            onItemClick(texto)
        }
    }

    override fun getItemCount(): Int {
        return listaElementos.size
    }

    // Método para agregar un nuevo elemento a la lista y notificar al adaptador
    fun agregarElemento(nuevoTexto: String) {
        listaElementos.add(nuevoTexto)
        notifyItemInserted(listaElementos.size - 1)
    }
}
