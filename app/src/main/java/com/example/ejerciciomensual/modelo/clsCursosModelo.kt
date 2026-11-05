package com.example.ejerciciomensual.modelo

class clsCursosModelo {

    suspend fun obtenerCategorias(): List<dataCategorias> {
        return RetrofitCliente.apiService.obtenerCategorias()
    }

    suspend fun obtenerCursos(categoriaId: Int? = null): List<dataCursos> {
        return RetrofitCliente.apiService.obtenerCursos(categoriaId)
    }

    suspend fun obtenerDetalleCursos(cursoId: Int): List<dataImagenesCursos> {
        return RetrofitCliente.apiService.detalleCursos(cursoId)
    }

    suspend fun obtenerRegistros(categoriaId: Int? = null): List<dataMostrarRegistros> {
        return RetrofitCliente.apiService.obtenerRegistros(categoriaId)
    }
}