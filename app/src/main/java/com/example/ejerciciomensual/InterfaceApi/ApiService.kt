package com.example.ejerciciomensual.InterfaceApi

import com.example.ejerciciomensual.modelo.dataCursos
import com.example.ejerciciomensual.modelo.dataImagenesCursos
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("Catalogo.php")
    suspend fun obtenerCursos(): List<dataCursos>

    @GET("detalle_cursos.php")
    suspend fun detalleCursos(@Query(value="curso_id")cursoId: Int): List<dataImagenesCursos>

}