package vista

import Modelo.dataCategoriasCursos

interface vistaCategoriasCursos {
    fun mostrarCategorias(
        categorias: List<dataCategoriasCursos>
    )
    fun mostrarError(
        mensaje: String
    )
    fun categoriaSeleccionada(
        id_carrera : Int,
        nombre: String
    )
}