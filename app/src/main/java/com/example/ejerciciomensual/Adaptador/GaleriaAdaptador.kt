package com.example.ejerciciomensual.Adaptador

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.ejerciciomensual.R
import com.example.ejerciciomensual.modelo.dataImagenesCursos
import com.bumptech.glide.Glide

class GaleriaAdaptador(private var listaImagenes: List<dataImagenesCursos>) : RecyclerView.Adapter<GaleriaAdaptador.GaleriaViewHolder>() {

    class GaleriaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgCurso: ImageView = itemView.findViewById(R.id.imgCursos)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GaleriaViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.item_curso, parent, false)
        return GaleriaViewHolder(vista)
    }

    override fun onBindViewHolder(holder: GaleriaViewHolder, position: Int) {

        val imagen = listaImagenes[position]
        val baseUrl = "http://10.226.139.102/api_cursos/"
        val urlImagenCompleta = baseUrl + imagen.urlImagen

        Glide.with(holder.itemView.context)
            .load(urlImagenCompleta)
            .placeholder(android.R.drawable.ic_menu_gallery)
            .error(android.R.drawable.ic_menu_report_image)
            .into(holder.imgCurso)
    }

    override fun getItemCount(): Int = listaImagenes.size

    fun actualizarLista(nuevaLista: List<dataImagenesCursos>) {
        listaImagenes = nuevaLista
        notifyDataSetChanged()
    }
}