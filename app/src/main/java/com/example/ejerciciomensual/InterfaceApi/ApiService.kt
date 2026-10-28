package com.example.ejerciciomensual.InterfaceApi

import com.example.ejerciciomensual.modelo.dataCursos
import retrofit2.http.GET

interface ApiService {

    @GET("Catalogo.php")
    suspend fun obtenerCursos(): List<dataCursos>
}