package com.example.ejerciciomensual.presentador

import com.example.ejerciciomensual.modelo.clsCursosModelo
import com.example.ejerciciomensual.modelo.dataImagenesCursos
import com.example.ejerciciomensual.vista.detalleCursos
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class clsDetalleCursos(private val vista: detalleCursos) {

    private val modelo = clsCursosModelo()

    fun cargarDetalleCurso(cursoId: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val listaImagenes: List<dataImagenesCursos> =
                    modelo.obtenerDetalleCursos(cursoId)

                vista.mostrarImagenes(listaImagenes)

            } catch (e: Exception) {
                vista.mostrarError(
                    "Error al cargar detalle: ${e.localizedMessage}"
                )
            }
        }
    }
}