package presentador

import Modelo.clsCategoriasCursosModelo
import Modelo.dataCategoriasCursos
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import vista.vistaEstadoInscripciones

class clsCategoriasCursosPresentador (private val vista: vistaEstadoInscripciones ) {
    private val modelo = clsCategoriasCursosModelo()
    private var listaCategoria: List<dataCategoriasCursos> = emptyList()

    fun iniciar(){
        CoroutineScope(Dispatchers.Main).launch {
            try {
                listaCategoria = modelo.obtenerCategoriasCursos()
                vista.mostrarCategorias(listaCategoria)
            }
            catch (e: Exception){
                vista.mostrarError(
                    "Error: $ {e.localizedMessage}"
                )
            }
        }
    }
    fun seleccionarCategoria(posicion: Int){
        if(posicion >=0 && posicion < listaCategoria.size){
            val categoria = listaCategoria[posicion]

            vista.mostrarMensajeExito (categoria.id_carrera, categoria.nombre
            )
        }
    }
}