package com.example.appciudades.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.appciudades.data.models.Ciudades
import com.example.appciudades.databinding.HolderListaciudadesBinding

class CiudadesAdapter(private val listener: MyClick
) : RecyclerView.Adapter<CiudadesAdapter.CiudadesHolder>(), Filterable {

    interface MyClick {
        fun onCiudadClick (ciudades: Ciudades)
    }

    var listado = ArrayList<Ciudades>()

    inner class CiudadesHolder(val binding: HolderListaciudadesBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CiudadesHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = HolderListaciudadesBinding.inflate(layoutInflater, parent, false)
        return CiudadesHolder(binding)
    }

    override fun getItemCount(): Int {
        return listado.size
    }

    override fun onBindViewHolder(holder: CiudadesHolder, position: Int) {
        val ciudad = listado[position]

        holder.binding.nombreCiudad.text = ciudad.nombre

        holder.itemView.setOnClickListener {
            listener.onCiudadClick(ciudad)
        }
    }

    fun updateList(contactos: List<Ciudades>) {
        listado.clear()
        listado.addAll(contactos)
        notifyDataSetChanged()
    }

    override fun getFilter(): Filter {
        TODO("Not yet implemented")
    }
}