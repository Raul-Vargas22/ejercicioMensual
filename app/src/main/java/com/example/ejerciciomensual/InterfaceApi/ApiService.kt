package com.example.ejerciciomensual.InterfaceApi

import com.example.ejerciciomensual.modelo.dataCursos
import com.example.ejerciciomensual.modelo.dataImagenesCursos
import com.example.ejerciciomensual.modelo.dataBuscarAlumno
import com.example.ejerciciomensual.modelo.dataCategorias
import com.example.ejerciciomensual.modelo.dataInscripciones
import com.example.ejerciciomensual.modelo.dataRegistrarInscripcion
import com.example.ejerciciomensual.modelo.dataMostrarRegistros
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Field

interface ApiService {

    @GET("Catalogo.php")
    suspend fun obtenerCursos(@Query("categoria_id") categoriaId: Int? = null): List<dataCursos>

    @GET("obtener_categorias.php")
    suspend fun obtenerCategorias(): List<dataCategorias>

    @GET("detalle_cursos.php")
    suspend fun detalleCursos(@Query("curso_id") cursoId: Int): List<dataImagenesCursos>

    @GET("buscar_alumno.php")
    suspend fun buscarAlumno(@Query("matricula") matricula: String): dataBuscarAlumno

    @FormUrlEncoded
    @POST("registrar_inscripcion.php")
    suspend fun registrarInscripcion(@Field("matricula") matricula: String, @Field("id_curso") idCurso: Int): dataRegistrarInscripcion

    @GET("obtener_inscripciones.php")
    suspend fun obtenerInscripciones(): List<dataInscripciones>

    @GET("obtener_registros.php")
    suspend fun obtenerRegistros(@Query("categoria_id") categoriaId: Int? = null): List<dataMostrarRegistros>
}