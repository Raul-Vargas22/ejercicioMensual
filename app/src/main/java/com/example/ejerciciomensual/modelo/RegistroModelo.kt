
package com.example.ejerciciomensual.modelo

class RegistroModelo {

    suspend fun buscarAlumno(matricula: String): dataBuscarAlumno {
        return RetrofitCliente.apiService.buscarAlumno(matricula)
    }

    suspend fun registrarInscripcion(matricula: String, idCurso: Int): dataRegistrarInscripcion {
        return RetrofitCliente.apiService.registrarInscripcion(matricula, idCurso)
    }
}
