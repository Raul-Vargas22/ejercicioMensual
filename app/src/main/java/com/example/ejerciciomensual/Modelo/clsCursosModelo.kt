package com.example.ejerciciomensual.Modelo
import com.example.ejerciciomensual.dataCursos

class clsCursosModelo {
    suspend fun obtenerCursos(): List<dataCursos> {

        val datos = RetrofitCliente.apiService.obtenerCursos()

        return datos
    }
}