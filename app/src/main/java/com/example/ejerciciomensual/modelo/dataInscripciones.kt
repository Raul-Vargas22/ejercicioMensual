package com.example.ejerciciomensual.modelo

import kotlinx.serialization.Serializable

@Serializable
data class dataInscripciones(
    val id_inscripcion: Int,
    val matricula: String,
    val nombre: String,
    val apellidos: String,
    val correo: String,
    val nombre_curso: String,
    val codigo_curso: String,
    val fecha_registro: String,
    val estado: String
)