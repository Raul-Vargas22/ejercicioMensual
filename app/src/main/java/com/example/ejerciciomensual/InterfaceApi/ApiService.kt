package com.example.ejerciciomensual.InterfaceApi

import com.example.ejerciciomensual.modelo.dataCursos
import com.example.ejerciciomensual.modelo.dataImagenesCursos
import retrofit2.http.GET
import retrofit2.http.Query
import com.example.ejerciciomensual.modelo.dataBuscarAlumno
import com.example.ejerciciomensual.modelo.dataRegistrarInscripcion
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Field

interface ApiService {

    @GET("Catalogo.php")
    suspend fun obtenerCursos(): List<dataCursos>

    @GET("detalle_cursos.php")
    suspend fun detalleCursos(@Query(value="curso_id")cursoId: Int): List<dataImagenesCursos>

    @GET("buscar_alumno.php")
    suspend fun buscarAlumno(@Query("matricula") matricula: String): dataBuscarAlumno
    @FormUrlEncoded @POST("registrar_inscripcion.php") suspend fun registrarInscripcion(@Field("matricula") matricula: String, @Field("id_curso") idCurso: Int): dataRegistrarInscripcion

}