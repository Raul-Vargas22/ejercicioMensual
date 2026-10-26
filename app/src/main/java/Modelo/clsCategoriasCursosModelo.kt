package Modelo

class clsCategoriasCursosModelo {
    suspend fun obtenerCategoriasCursos():<dataCategorias>{
        val datos = RetrofitCliente.apiService.obtenerCategoriasCursos()//

        val listaFinal = mutableListOf(dataCategorias(0, "Seleccione una categoria"))
        listaFinal.addAll(datos)

        return listaFinal
    }
}