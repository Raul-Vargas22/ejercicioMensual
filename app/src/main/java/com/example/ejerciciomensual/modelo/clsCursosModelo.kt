package com.example.ejerciciomensual.modelo

class clsCursosModelo {

    suspend fun obtenerCursos(): List<dataCursos> {
        val datos = RetrofitCliente.apiService.obtenerCursos()
        return datos
    }
    suspend fun obtenerDetalleCursos(cursoId: Int): List<dataImagenesCursos> {
        return RetrofitCliente.apiService.detalleCursos(cursoId)
    }
}