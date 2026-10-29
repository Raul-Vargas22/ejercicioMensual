
package com.example.ejerciciomensual.presentador

import com.example.ejerciciomensual.vista.RegistroActivity
import com.example.ejerciciomensual.modelo.RegistroModelo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegistroPresentador(private val vista: RegistroActivity) {

    private val modelo = RegistroModelo()

    fun registrarInscripcion(matricula: String, correo: String, idCurso: Int) {
        if (matricula.isBlank()) {
            vista.mostrarMensaje("Completa todos los campos")
            return
        }

        CoroutineScope(Dispatchers.Main).launch {
            try {
                val respuesta = modelo.registrarInscripcion(matricula,idCurso)

                vista.mostrarMensaje(respuesta.mensaje)

            } catch (e: Exception) {
                vista.mostrarMensaje("Error: ${e.javaClass.simpleName}: ${e.message}")
            }
        }
    }

    fun buscarAlumno(matricula: String) {
        if (matricula.isBlank()) {
            vista.mostrarMensaje("Escribe la matrícula")
            return
        }

        CoroutineScope(Dispatchers.Main).launch {
            try {
                val respuesta = modelo.buscarAlumno(matricula)

                if (respuesta.exito) {
                    vista.mostrarCorreo(respuesta.correo ?: "")
                } else {
                    vista.mostrarCorreo("")
                }

            } catch (e: Exception) {
                vista.mostrarMensaje("Error: ${e.javaClass.simpleName}: ${e.message}")
            }
        }
    }

}
