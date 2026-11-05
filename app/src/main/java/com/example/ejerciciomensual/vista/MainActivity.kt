package com.example.ejerciciomensual.vista

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ejerciciomensual.Adaptador.CursosAdaptador
import com.example.ejerciciomensual.R
import com.example.ejerciciomensual.modelo.dataCategorias
import com.example.ejerciciomensual.modelo.dataCursos
import com.example.ejerciciomensual.presentador.clsCursosPresentador

class MainActivity : AppCompatActivity() {

    private lateinit var adapterCursos: CursosAdaptador
    private lateinit var recyclerView: RecyclerView
    private lateinit var presenter: clsCursosPresentador
    private var categorias: List<dataCategorias> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        adapterCursos = CursosAdaptador(emptyList(), this)
        recyclerView.adapter = adapterCursos

        presenter = clsCursosPresentador(this)
        presenter.iniciar()
        presenter.cargarCategorias()

        val btnVerRegistros = findViewById<Button>(R.id.btnVerRegistros)

        btnVerRegistros.setOnClickListener {
            val intent = Intent(this, vistaRegistros::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById(R.id.main)
        ) { v, insets ->

            val systemBars = insets.getInsets(
                WindowInsetsCompat.Type.systemBars()
            )

            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )

            insets
        }
    }

    fun mostrarCategorias(categorias: List<dataCategorias>) {
        this.categorias = categorias

        val nombresCategorias = listOf("Todas las categorías") +
                categorias.map { it.categoria }

        val adapterCategorias = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            nombresCategorias
        )

        adapterCategorias.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )

        val spinner = findViewById<Spinner>(R.id.spnCarrera)
        spinner.adapter = adapterCategorias

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (position == 0) {
                    presenter.iniciar()
                } else {
                    val categoriaId = categorias[position - 1].id
                    presenter.iniciar(categoriaId)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
    }

    fun mostrarCursos(cursos: List<dataCursos>) {
        adapterCursos.actualizarLista(cursos)
    }

    fun mostrarError(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
    }

    fun abrirDetalleCurso(curso: dataCursos) {
        val intent = Intent(this, detalleCursos::class.java)

        intent.putExtra("ID_CURSO", curso.id_curso)
        intent.putExtra("NOMBRE_CURSO", curso.nombre_curso)
        intent.putExtra("CODIGO_CURSO", curso.codigo_curso)
        intent.putExtra("DESCRIPCION_CURSO", curso.descripcion_curso)
        intent.putExtra("LUGAR", curso.edificio + " - Salón " + curso.salon)
        intent.putExtra("TOTAL_HORAS", curso.total_horas)
        intent.putExtra("CUPO_MAXIMO", curso.cupo_maximo)
        intent.putExtra("DIAS", curso.Dias)
        intent.putExtra("HORAS", curso.horas)

        startActivity(intent)
    }

    fun abrirRegistroCurso(curso: dataCursos) {
        val intent = Intent(this, RegistroActivity::class.java)

        intent.putExtra("ID_CURSO", curso.id_curso)
        intent.putExtra("NOMBRE_CURSO", curso.nombre_curso)
        intent.putExtra("CODIGO_CURSO", curso.codigo_curso)
        intent.putExtra("IMAGEN_CURSO", curso.imagen_principal)

        startActivity(intent)
    }
}