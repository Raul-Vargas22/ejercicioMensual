package com.example.ejerciciomensual.Adaptador

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ejerciciomensual.vista.MainActivity
import com.example.ejerciciomensual.R
import com.example.ejerciciomensual.modelo.dataCursos

class CursosAdaptador (
    private val activity: MainActivity,
    private var listaCursos: List<dataCursos>
)
    : RecyclerView.Adapter<CursosAdaptador.CursoViewHolder>() {
    class CursoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvNombre: TextView = itemView.findViewById(R.id.txtCurso)
        val tvSalon: TextView = itemView.findViewById(R.id.txtSalon)
        val imgCurso: ImageView = itemView.findViewById(R.id.imgCurso)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CursoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.tarjeta_curso, parent, false)
        return CursoViewHolder(view)
    }

    override fun onBindViewHolder(holder: CursoViewHolder, position: Int) {
        val curso = listaCursos[position]

        holder.tvNombre.text = curso.nombre_curso
        holder.tvSalon.text = "Salón: " + curso.salon

        when (curso.codigo_curso) {
            "IS102" -> holder.imgCurso.setImageResource(R.drawable.programacion)
            "BD201" -> holder.imgCurso.setImageResource(R.drawable.basedatos)
        }
    }

    override fun getItemCount(): Int {
        return listaCursos.size
    }
    fun actualizarLista(nuevaLista: List<dataCursos>) {
        listaCursos = nuevaLista
        notifyDataSetChanged()
    }
}