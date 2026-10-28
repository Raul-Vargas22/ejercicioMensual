package com.example.ejerciciomensual.vista

import android.os.Bundle
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
import android.widget.ArrayAdapter
import android.widget.Spinner

class MainActivity : AppCompatActivity() {

    private lateinit var adapterCursos: CursosAdaptador
    private lateinit var recyclerView: RecyclerView
    private lateinit var presenter: clsCursosPresentador

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val spnCarrera = findViewById<Spinner>(R.id.spnCarrera)

        val carreras = arrayOf("INGENIERÍA EN DESARROLLO DE SOFTWARE")

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

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
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
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
    }
}