package com.example.ejerciciomensual.Adaptador

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ejerciciomensual.R
import com.example.ejerciciomensual.modelo.dataInscripciones

class InscripcionesAdaptador(
    private var listaInscripciones: List<dataInscripciones>
) : RecyclerView.Adapter<InscripcionesAdaptador.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtAlumno: TextView = itemView.findViewById(R.id.txtAlumno)
        val txtMatricula: TextView = itemView.findViewById(R.id.txtMatricula)
        val txtCurso: TextView = itemView.findViewById(R.id.txtCurso)
        val txtFecha: TextView = itemView.findViewById(R.id.txtFecha)
        val txtEstado: TextView = itemView.findViewById(R.id.txtEstado)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_inscripcion, parent, false)

        return ViewHolder(vista)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val inscripcion = listaInscripciones[position]

        holder.txtAlumno.text = "${inscripcion.nombre} ${inscripcion.apellidos}"
        holder.txtMatricula.text = inscripcion.matricula
        holder.txtCurso.text = inscripcion.nombre_curso
        holder.txtFecha.text = inscripcion.fecha_registro
        holder.txtEstado.text = inscripcion.estado
    }

    override fun getItemCount(): Int = listaInscripciones.size

    fun actualizarLista(nuevaLista: List<dataInscripciones>) {
        listaInscripciones = nuevaLista
        notifyDataSetChanged()
    }
}