package com.example.ejerciciomensual
import kotlinx.serialization.Serializable
@Serializable
data class dataCursos (
    val id_curso: String,
    val codigo_curso: String,
    val nombre_curso: String,
    val descripcion_curso: String,
    val id_carrera: String,
    val edificio: String,
    val salon: String,
    val total_horas: String,
    val cupo_maximo: String,
    val imagen_principal: String?,
    val estado: String,
    val fecha_creacion: String?,

)