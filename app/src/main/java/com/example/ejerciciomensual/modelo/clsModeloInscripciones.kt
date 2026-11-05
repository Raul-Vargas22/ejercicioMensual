package com.example.ejerciciomensual.modelo

class clsModeloInscripciones {

    suspend fun obtenerInscripciones(): List<dataInscripciones> {
        return RetrofitCliente.apiService.obtenerInscripciones()
    }
}