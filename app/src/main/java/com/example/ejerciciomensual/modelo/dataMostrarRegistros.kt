package com.example.ejerciciomensual.modelo

import kotlinx.serialization.Serializable

@Serializable
data class dataMostrarRegistros(
    val id_curso: Int,
    val codigo_curso: String,
    val nombre_curso: String,
    val descripcion_curso: String,
    val id_carrera: Int,
    val categoria_id: Int,
    val edificio: String,
    val salon: String,
    val total_horas: Int,
    val cupo_maximo: Int,
    val imagen_principal: String?,
    val estado: String,
    val total_inscritos: Int
)