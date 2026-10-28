package com.example.intncionesimplicitas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Adaptador para mostrar la lista de productos con imágenes (Ejercicio 2)
class AdapterProductos(private val listaProductos: List<Producto>) :
    RecyclerView.Adapter<AdapterProductos.ViewHolderProductos>() {

    class ViewHolderProductos(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgProducto: ImageView = itemView.findViewById(R.id.imgProducto)
        val tvNombreProducto: TextView = itemView.findViewById(R.id.tvNombreProducto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderProductos {
        val vista = LayoutInflater.from(parent.context)
            .inflate(R.layout.elemento_lista, parent, false)
        return ViewHolderProductos(vista)
    }

    override fun onBindViewHolder(holder: ViewHolderProductos, position: Int) {
        val producto = listaProductos[position]
        holder.tvNombreProducto.text = producto.nombre
        holder.imgProducto.setImageResource(producto.imagen)
    }

    override fun getItemCount(): Int {
        return listaProductos.size
    }
}
