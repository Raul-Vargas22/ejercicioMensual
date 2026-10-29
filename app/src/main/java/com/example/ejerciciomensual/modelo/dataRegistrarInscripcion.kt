package com.example.ejerciciomensual.modelo

import kotlinx.serialization.Serializable

@Serializable
data class dataRegistrarInscripcion (
    val exito: Boolean,
    val mensaje: String,
    val correo: String? = null
)