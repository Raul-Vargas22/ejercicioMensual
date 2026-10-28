
package com.example.ejerciciomensual.modelo

import kotlinx.serialization.Serializable

@Serializable
data class RespuestaInscripcion(val exito: Boolean, val mensaje: String)