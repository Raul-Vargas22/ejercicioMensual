package com.example.ejerciciomensual.presentador

import com.example.ejerciciomensual.vista.RegistroActivity
import com.example.ejerciciomensual.modelo.RegistroModelo

class RegistroPresentador(private val vista: RegistroActivity) {

    private val modelo = RegistroModelo()

    fun validarInscripcion( matricula: String, correo: String, idCurso: Int): Boolean {
        return modelo.validarDatos(matricula, correo, idCurso)
    }
}