package com.example.ejerciciomensual.modelo

class clsMostrarRegistros {

    suspend fun obtenerCategorias(): List<dataCategorias> {
        return RetrofitCliente.apiService.obtenerCategorias()
    }

    suspend fun obtenerRegistros(categoriaId: Int? = null): List<dataMostrarRegistros> {
        return RetrofitCliente.apiService.obtenerRegistros(categoriaId)
    }
}