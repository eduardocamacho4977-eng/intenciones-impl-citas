package com.example.intncionesimplicitas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Adaptador para mostrar la lista de contactos (Ejercicio 6)
class AdapterContactos(
    private val listaContactos: List<Contacto>,
    private val onItemClick: (Contacto, Int) -> Unit
) : RecyclerView.Adapter<AdapterContactos.ViewHolderContactos>() {

    class ViewHolderContactos(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNombre: TextView = itemView.findViewById(R.id.tvNombreContactoItem)
        val tvTelefono: TextView = itemView.findViewById(R.id.tvTelefonoContactoItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderContactos {
        val vista = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_contacto, parent, false)
        return ViewHolderContactos(vista)
    }

    override fun onBindViewHolder(holder: ViewHolderContactos, position: Int) {
        val contacto = listaContactos[position]
        holder.tvNombre.text = contacto.nombre
        holder.tvTelefono.text = contacto.telefono

        holder.itemView.setOnClickListener {
            onItemClick(contacto, position)
        }
    }

    override fun getItemCount(): Int {
        return listaContactos.size
    }
}
