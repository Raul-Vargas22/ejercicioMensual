package com.example.ejerciciomensual.modelo

class clsCursosModelo {

    suspend fun obtenerCursos(): List<dataCursos> {
        val datos = RetrofitCliente.apiService.obtenerCursos()
        return datos
    }
}