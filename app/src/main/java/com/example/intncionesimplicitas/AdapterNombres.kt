package com.example.intncionesimplicitas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Adaptador para la lista de nombres de personas (Ejercicio 1)
class AdapterNombres(private val listaNombres: List<String>) :
    RecyclerView.Adapter<AdapterNombres.ViewHolderNombres>() {

    // Clase ViewHolder que mantiene la referencia al TextView de cada fila
    class ViewHolderNombres(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNombre: TextView = itemView.findViewById(R.id.tvNombre)
    }

    // Método que infla el diseño XML (item_nombre.xml) para cada elemento de la lista
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderNombres {
        val vista = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_nombre, parent, false)
        return ViewHolderNombres(vista)
    }

    // Método que conecta (vincula) los datos del nombre en la posición correspondiente con el TextView
    override fun onBindViewHolder(holder: ViewHolderNombres, position: Int) {
        val nombre = listaNombres[position]
        holder.tvNombre.text = nombre
    }

    // Método que indica la cantidad total de elementos en la lista
    override fun getItemCount(): Int {
        return listaNombres.size
    }
}
