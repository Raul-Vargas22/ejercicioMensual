package Modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class dataCategoriasCursos(
    @SerialName(value = "id_carrera") val id_carrera: Int=0,
    @SerialName(value = "nombre") val nombre: String=""
)
{
    override fun toString(): String {
        return nombre
    }
}