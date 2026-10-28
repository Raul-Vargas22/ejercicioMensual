
package com.example.ejerciciomensual.modelo

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.GET
import retrofit2.http.Query

interface RegistroApi {

    @FormUrlEncoded
    @POST("registrar_inscripcion.php")
    suspend fun registrarInscripcion(@Field("matricula") matricula: String,@Field("id_curso") idCurso: Int): RespuestaInscripcion
    @GET("buscar_alumno.php")
    suspend fun buscarAlumno(@Query("matricula") matricula: String): RespuestaAlumno
}
