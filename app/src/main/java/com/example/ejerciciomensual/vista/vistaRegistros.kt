package com.example.ejerciciomensual.vista

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ejerciciomensual.Adaptador.mostrarRegistrosAdaptador
import com.example.ejerciciomensual.R
import com.example.ejerciciomensual.modelo.dataCategorias
import com.example.ejerciciomensual.modelo.dataMostrarRegistros
import com.example.ejerciciomensual.presentador.clsMostrarRegistrosPresentador

class vistaRegistros : AppCompatActivity() {

    private lateinit var recyclerRegistros: RecyclerView
    private lateinit var adapterRegistros: mostrarRegistrosAdaptador
    private lateinit var presentador: clsMostrarRegistrosPresentador
    private lateinit var spnCategorias: Spinner
    private lateinit var txtTotalInscritos: TextView
    private lateinit var btnVolverCatalogo: Button

    private var listaCategorias: List<dataCategorias> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_vista_registros)

        spnCategorias = findViewById(R.id.spnCategorias)
        recyclerRegistros = findViewById(R.id.recyclerRegistros)
        txtTotalInscritos = findViewById(R.id.txtTotalInscritos)
        btnVolverCatalogo = findViewById(R.id.btnVolverCatalogo)

        recyclerRegistros.layoutManager = LinearLayoutManager(this)

        adapterRegistros = mostrarRegistrosAdaptador(emptyList())
        recyclerRegistros.adapter = adapterRegistros

        presentador = clsMostrarRegistrosPresentador(this)

        presentador.cargarCategorias()
        presentador.cargarRegistros()

        btnVolverCatalogo.setOnClickListener {
            finish()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun mostrarCategorias(categorias: List<dataCategorias>) {
        listaCategorias = listOf(dataCategorias(0, "Todas las categorías")) + categorias

        val nombres = listaCategorias.map { it.categoria }

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, nombres)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spnCategorias.adapter = adapter

        spnCategorias.onItemSelectedListener =
            object : android.widget.AdapterView.OnItemSelectedListener {

                override fun onItemSelected(parent: android.widget.AdapterView<*>?, view: View?, position: Int, id: Long) {
                    presentador.cargarRegistros(listaCategorias[position].id.takeIf { it > 0 })
                }

                override fun onNothingSelected(parent: android.widget.AdapterView<*>?) {
                }
            }
    }

    fun mostrarRegistros(registros: List<dataMostrarRegistros>) {
        adapterRegistros.actualizarLista(registros)

        val total = registros.sumOf { it.total_inscritos }
        txtTotalInscritos.text = "Total de inscritos: $total"
    }

    fun mostrarError(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
    }
}