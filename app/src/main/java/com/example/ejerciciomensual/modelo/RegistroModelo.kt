
package com.example.ejerciciomensual.modelo

class RegistroModelo {

    suspend fun buscarAlumno(matricula: String): RespuestaAlumno {
        return RetrofitCliente.apiService.buscarAlumno(
            matricula
        )
    }

    suspend fun registrarInscripcion(matricula: String, idCurso: Int): RespuestaInscripcion {
        return RetrofitCliente.apiService.registrarInscripcion(matricula, idCurso)
    }
}
