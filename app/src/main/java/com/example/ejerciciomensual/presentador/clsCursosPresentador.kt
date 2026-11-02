package com.example.ejerciciomensual.presentador

import com.example.ejerciciomensual.modelo.clsCursosModelo
import com.example.ejerciciomensual.vista.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class clsCursosPresentador(private val vista: MainActivity) {

    private val modelo = clsCursosModelo()

    fun iniciar() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val cursos = modelo.obtenerCursos()
                vista.mostrarCursos(cursos)
            } catch (e: Exception) {
                vista.mostrarError("Error: " + e.localizedMessage)
            }
        }
    }
}