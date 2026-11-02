package com.example.ejerciciomensual.modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class dataImagenesCursos(
    @SerialName("id_imagen") val id: Int = 0,
    @SerialName("id_curso") val productoId: Int = 0,
    @SerialName("ruta_imagen") val urlImagen: String = ""
)
