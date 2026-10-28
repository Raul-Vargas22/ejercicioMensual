package com.example.ejerciciomensual.vista

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.ejerciciomensual.Adaptador.GaleriaAdaptador
import com.example.ejerciciomensual.R
import com.example.ejerciciomensual.modelo.dataImagenesCursos
import com.example.ejerciciomensual.presentador.clsDetalleCursos

class detalleCursos : AppCompatActivity() {

    private lateinit var presentador: clsDetalleCursos
    private lateinit var vpGaleria: ViewPager2
    private lateinit var txtNombreCurso: TextView
    private lateinit var txtCodigoCurso: TextView
    private lateinit var txtDescripcionCurso: TextView
    private lateinit var txtLugar: TextView
    private lateinit var txtTotalHoras: TextView
    private lateinit var txtCupoMaximo: TextView
    private lateinit var adaptadorGaleria: GaleriaAdaptador

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalle_cursos)

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

        vpGaleria = findViewById(R.id.imgCursos)
        txtNombreCurso = findViewById(R.id.txtNombreCurso)
        txtCodigoCurso = findViewById(R.id.txtCodigoCurso)
        txtDescripcionCurso = findViewById(R.id.txtDescripcionCurso)
        txtLugar = findViewById(R.id.txtLugar)
        txtTotalHoras = findViewById(R.id.txtTotalHoras)
        txtCupoMaximo = findViewById(R.id.txtCupoMaximo)

        adaptadorGaleria = GaleriaAdaptador(emptyList())
        vpGaleria.adapter = adaptadorGaleria

        val id = intent.getIntExtra("ID_CURSO", 0)
        val nombreCurso = intent.getStringExtra("NOMBRE_PRODUCTO") ?: ""
        val codigoCurso = intent.getStringExtra("CODIGO_CURSO") ?: ""
        val descripcionCurso = intent.getStringExtra("DESCRIPCION_CURSO") ?: ""
        val lugar = intent.getStringExtra("LUGAR") ?: ""
        val totalHoras = intent.getStringExtra("TOTAL_HORAS") ?: ""
        val cupoMaximo = intent.getStringExtra("CUPO_MAXIMO") ?: ""

        txtNombreCurso.text = nombreCurso
        txtCodigoCurso.text = codigoCurso
        txtDescripcionCurso.text = descripcionCurso
        txtLugar.text = lugar
        txtTotalHoras.text = totalHoras
        txtCupoMaximo.text = cupoMaximo

        presentador = clsDetalleCursos(this)

        if (id != 0) {
            presentador.cargarDetalleCurso(id)
        } else {
            mostrarError("No se recibió un ID de curso válido")
        }
    }

    fun mostrarImagenes(imagenes: List<dataImagenesCursos>) {
        adaptadorGaleria.actualizarLista(imagenes)
    }

    fun mostrarError(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
    }
}