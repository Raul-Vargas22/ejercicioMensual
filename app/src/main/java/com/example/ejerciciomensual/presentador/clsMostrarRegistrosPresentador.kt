package com.example.ejerciciomensual.presentador

import com.example.ejerciciomensual.modelo.clsMostrarRegistros
import com.example.ejerciciomensual.vista.vistaRegistros
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class clsMostrarRegistrosPresentador(private val vista: vistaRegistros) {

    private val modelo = clsMostrarRegistros()

    fun cargarCategorias() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val categorias = modelo.obtenerCategorias()
                vista.mostrarCategorias(categorias)
            } catch (e: Exception) {
                vista.mostrarError("Error al cargar categorías: ${e.message}")
            }
        }
    }

    fun cargarRegistros(categoriaId: Int? = null) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val registros = modelo.obtenerRegistros(categoriaId)
                vista.mostrarRegistros(registros)
            } catch (e: Exception) {
                vista.mostrarError("Error al cargar registros: ${e.message}")
            }
        }
    }
}