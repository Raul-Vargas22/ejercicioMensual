package com.example.ejerciciomensual

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ejerciciomensual.Adaptador.CursosAdaptador
import com.example.ejerciciomensual.Presentador.clsCursosPresentador

class MainActivity : AppCompatActivity() {
    private lateinit var adapterCursos: CursosAdaptador
    private lateinit var recyclerView: RecyclerView
    private lateinit var presenter: clsCursosPresentador

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapterCursos = CursosAdaptador(this, emptyList())
        recyclerView.adapter = adapterCursos
        presenter = clsCursosPresentador(this)
        presenter.iniciar()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
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