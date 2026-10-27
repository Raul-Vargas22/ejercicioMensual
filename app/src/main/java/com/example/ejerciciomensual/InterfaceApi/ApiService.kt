package com.example.ejerciciomensual.InterfaceApi
import com.example.ejerciciomensual.dataCursos
import retrofit2.http.GET

interface ApiService {
    @GET("Catalogo.php")
    suspend fun obtenerCursos(): List<dataCursos>
}