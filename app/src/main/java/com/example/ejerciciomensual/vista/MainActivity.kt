package com.example.ejerciciomensual.vista

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ejerciciomensual.Adaptador.CursosAdaptador
import com.example.ejerciciomensual.R
import com.example.ejerciciomensual.modelo.dataCursos
import com.example.ejerciciomensual.presentador.clsCursosPresentador

class MainActivity : AppCompatActivity() {

    private lateinit var adapterCursos: CursosAdaptador
    private lateinit var recyclerView: RecyclerView
    private lateinit var presenter: clsCursosPresentador

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val spnCarrera = findViewById<Spinner>(R.id.spnCarrera)

        val carreras = arrayOf(
            "INGENIERÍA EN DESARROLLO DE SOFTWARE"
        )

        val adapterCarreras = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            carreras
        )

        adapterCarreras.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )

        spnCarrera.adapter = adapterCarreras

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapterCursos = CursosAdaptador(this, emptyList())
        recyclerView.adapter = adapterCursos

        presenter = clsCursosPresentador(this)
        presenter.iniciar()

        val btnVerRegistros =
            findViewById<Button>(R.id.btnVerRegistros)

        btnVerRegistros.setOnClickListener {
            val intent = Intent(
                this,
                vistaRegistros::class.java
            )
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

    fun mostrarCursos(cursos: List<dataCursos>) {
        adapterCursos.actualizarLista(cursos)
    }

    fun mostrarError(mensaje: String) {
        Toast.makeText(
            this,
            mensaje,
            Toast.LENGTH_LONG
        ).show()
    }

    fun abrirDetalleCurso(curso: dataCursos) {

        val intent = Intent(
            this,
            detalleCursos::class.java
        )

        intent.putExtra(
            "ID_CURSO",
            curso.id_curso.toIntOrNull() ?: 0
        )

        intent.putExtra(
            "NOMBRE_CURSO",
            curso.nombre_curso
        )

        intent.putExtra(
            "CODIGO_CURSO",
            curso.codigo_curso
        )

        intent.putExtra(
            "DESCRIPCION_CURSO",
            curso.descripcion_curso
        )

        intent.putExtra(
            "LUGAR",
            curso.edificio + " - Salón " + curso.salon
        )

        intent.putExtra(
            "TOTAL_HORAS",
            curso.total_horas
        )

        intent.putExtra(
            "CUPO_MAXIMO",
            curso.cupo_maximo
        )

        startActivity(intent)
    }

    fun abrirRegistroCurso(curso: dataCursos) {

        val intent = Intent(
            this,
            RegistroActivity::class.java
        )

        intent.putExtra(
            "ID_CURSO",
            curso.id_curso.toIntOrNull() ?: 0
        )

        intent.putExtra(
            "NOMBRE_CURSO",
            curso.nombre_curso
        )

        intent.putExtra(
            "CODIGO_CURSO",
            curso.codigo_curso
        )

        startActivity(intent)
    }
}