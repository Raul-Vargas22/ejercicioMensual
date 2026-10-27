package com.example.ejerciciomensual.modelo
class RegistroModelo {
    fun validarDatos(matricula: String, correo: String, idCurso: Int): Boolean {
        return  matricula.isNotBlank() && correo.isNotBlank() && idCurso>0
    }


}