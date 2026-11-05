package com.example.ejerciciomensual.Adaptador

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ejerciciomensual.R
import com.example.ejerciciomensual.modelo.dataMostrarRegistros

class mostrarRegistrosAdaptador(
    private var listaRegistros: List<dataMostrarRegistros>
) : RecyclerView.Adapter<mostrarRegistrosAdaptador.RegistrosViewHolder>() {

    class RegistrosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgCurso: ImageView = itemView.findViewById(R.id.imgCurso)
        val txtNombreCurso: TextView = itemView.findViewById(R.id.txtNombreCurso)
        val progresoInscritos: ProgressBar = itemView.findViewById(R.id.progresoInscritos)
        val txtInscritos: TextView = itemView.findViewById(R.id.txtInscritos)
        val txtCupo: TextView = itemView.findViewById(R.id.txtCupo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RegistrosViewHolder {
        val vista = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_mostrar_registros, parent, false)

        return RegistrosViewHolder(vista)
    }

    override fun onBindViewHolder(holder: RegistrosViewHolder, position: Int) {
        val registro = listaRegistros[position]

        holder.txtNombreCurso.text = registro.nombre_curso
        holder.txtInscritos.text = "${registro.total_inscritos} inscritos"
        holder.txtCupo.text = "${registro.total_inscritos}/${registro.cupo_maximo}"

        holder.progresoInscritos.max = registro.cupo_maximo.coerceAtLeast(1)
        holder.progresoInscritos.progress =
            registro.total_inscritos.coerceAtMost(registro.cupo_maximo)

        val imagenCurso = registro.imagen_principal ?: ""

        val baseUrl = "http://10.115.22.102/api_cursos/Imagenes/principal/"

        val urlImagen = if (imagenCurso.startsWith("http")) {
            imagenCurso
        } else {
            baseUrl + imagenCurso.trimStart('/')
        }

        Glide.with(holder.itemView.context)
            .load(urlImagen)
            .placeholder(android.R.drawable.ic_menu_gallery)
            .error(android.R.drawable.ic_menu_report_image)
            .into(holder.imgCurso)
    }

    override fun getItemCount(): Int = listaRegistros.size

    fun actualizarLista(nuevaLista: List<dataMostrarRegistros>) {
        listaRegistros = nuevaLista
        notifyDataSetChanged()
    }
}