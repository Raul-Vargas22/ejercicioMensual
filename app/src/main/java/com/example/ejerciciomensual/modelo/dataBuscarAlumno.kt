package com.example.ejerciciomensual.modelo

import kotlinx.serialization.Serializable

@Serializable
data class dataBuscarAlumno (
    val exito: Boolean,
    val matricula: String? = null,
    val correo: String? = null,
    val mensaje: String? = null
)