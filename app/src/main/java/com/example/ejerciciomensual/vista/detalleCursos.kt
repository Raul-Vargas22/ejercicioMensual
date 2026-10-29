package com.example.ejerciciomensual.vista

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejerciciomensual.R
import com.example.ejerciciomensual.modelo.dataImagenesCursos

class detalleCursos : AppCompatActivity() {

    private lateinit var txtNombreCurso: TextView
    private lateinit var txtCodigoCurso: TextView
    private lateinit var txtDescripcionCurso: TextView
    private lateinit var txtLugar: TextView
    private lateinit var txtTotalHoras: TextView
    private lateinit var txtCupoMaximo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalle_cursos)

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

        txtNombreCurso =
            findViewById(R.id.txtNombreCurso)

        txtCodigoCurso =
            findViewById(R.id.txtCodigoCurso)

        txtDescripcionCurso =
            findViewById(R.id.txtDescripcionCurso)

        txtLugar =
            findViewById(R.id.txtLugar)

        txtTotalHoras =
            findViewById(R.id.txtTotalHoras)

        txtCupoMaximo =
            findViewById(R.id.txtCupoMaximo)

        val nombreCurso =
            intent.getStringExtra("NOMBRE_CURSO") ?: ""

        val codigoCurso =
            intent.getStringExtra("CODIGO_CURSO") ?: ""

        val descripcionCurso =
            intent.getStringExtra("DESCRIPCION_CURSO") ?: ""

        val lugar =
            intent.getStringExtra("LUGAR") ?: ""

        val totalHoras =
            intent.getStringExtra("TOTAL_HORAS") ?: ""

        val cupoMaximo =
            intent.getStringExtra("CUPO_MAXIMO") ?: ""

        txtNombreCurso.text =
            nombreCurso

        txtCodigoCurso.text =
            "Código: " + codigoCurso

        txtDescripcionCurso.text =
            descripcionCurso

        txtLugar.text =
            "Lugar: " + lugar

        txtTotalHoras.text =
            "Total horas: " + totalHoras

        txtCupoMaximo.text =
            "Cupo máximo: " + cupoMaximo
    }

    fun mostrarImagenes(
        listaImagenes: List<dataImagenesCursos>
    ) {

    }

    fun mostrarError(mensaje: String) {

        Toast.makeText(
            this,
            mensaje,
            Toast.LENGTH_LONG
        ).show()
    }
}