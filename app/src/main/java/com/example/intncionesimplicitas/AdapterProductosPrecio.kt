package com.example.intncionesimplicitas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Adaptador para la lista de selección de productos con precio (Ejercicio 5)
class AdapterProductosPrecio(
    private val listaProductos: List<Producto>,
    private val onItemClick: (Producto) -> Unit
) : RecyclerView.Adapter<AdapterProductosPrecio.ViewHolderProductosPrecio>() {

    class ViewHolderProductosPrecio(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNombre: TextView = itemView.findViewById(R.id.tvNombreProductoItem)
        val tvPrecio: TextView = itemView.findViewById(R.id.tvPrecioProductoItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderProductosPrecio {
        val vista = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_producto_precio, parent, false)
        return ViewHolderProductosPrecio(vista)
    }

    override fun onBindViewHolder(holder: ViewHolderProductosPrecio, position: Int) {
        val producto = listaProductos[position]
        holder.tvNombre.text = producto.nombre
        holder.tvPrecio.text = "$${producto.precio}"

        holder.itemView.setOnClickListener {
            onItemClick(producto)
        }
    }

    override fun getItemCount(): Int {
        return listaProductos.size
    }
}
