package Modelo

class clsCategoriasCursosModelo {
    suspend fun obtenerCategoriasCursos(): List<dataCategoriasCursos>{
        val datos = retrofit.apiService.obtenerCategoriasCursos()//

        val listaFinal = mutableListOf(dataCategoriasCursos(0, "Seleccione una categoria"))
        listaFinal.addAll(datos)

        return listaFinal
    }
}