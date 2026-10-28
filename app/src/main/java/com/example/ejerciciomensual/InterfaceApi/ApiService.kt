package com.example.ejerciciomensual.InterfaceApi

import Modelo.dataCategoriasCursos
import retrofit2.http.GET
interface ApiService {
    @GET(value = "obtenerCategoriasCursos.php")
    suspend fun obtenerCategoriasCursos(): List<dataCategoriasCursos>
}
