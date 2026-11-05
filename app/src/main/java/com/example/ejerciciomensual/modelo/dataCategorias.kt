package com.example.ejerciciomensual.modelo

import kotlinx.serialization.Serializable

@Serializable
data class dataCategorias(
    val id: Int,
    val categoria: String
)