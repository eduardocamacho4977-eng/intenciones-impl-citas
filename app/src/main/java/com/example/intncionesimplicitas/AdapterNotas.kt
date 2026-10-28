package com.example.intncionesimplicitas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Adaptador para mostrar la lista de notas (Ejercicio 7)
class AdapterNotas(
    private val listaNotas: List<Nota>,
    private val onItemClick: (Nota, Int) -> Unit
) : RecyclerView.Adapter<AdapterNotas.ViewHolderNotas>() {

    class ViewHolderNotas(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitulo: TextView = itemView.findViewById(R.id.tvTituloNotaItem)
        val tvContenido: TextView = itemView.findViewById(R.id.tvContenidoNotaItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderNotas {
        val vista = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_nota, parent, false)
        return ViewHolderNotas(vista)
    }

    override fun onBindViewHolder(holder: ViewHolderNotas, position: Int) {
        val nota = listaNotas[position]
        holder.tvTitulo.text = nota.titulo
        holder.tvContenido.text = nota.contenido

        holder.itemView.setOnClickListener {
            onItemClick(nota, position)
        }
    }

    override fun getItemCount(): Int {
        return listaNotas.size
    }
}
