package com.example.ejerciciomensual.vista

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.ejerciciomensual.R
import com.example.ejerciciomensual.modelo.dataImagenesCursos
import com.example.ejerciciomensual.Adaptador.GaleriaAdaptador
import com.example.ejerciciomensual.presentador.clsDetalleCursos

class detalleCursos : AppCompatActivity() {

    private lateinit var txtNombreCurso: TextView
    private lateinit var txtCodigoCurso: TextView
    private lateinit var txtDescripcionCurso: TextView
    private lateinit var txtLugar: TextView
    private lateinit var txtTotalHoras: TextView
    private lateinit var txtDias: TextView
    private lateinit var txtHoras: TextView
    private lateinit var txtCupoMaximo: TextView

    private lateinit var galeriaAdaptador: GaleriaAdaptador

    private lateinit var btnRegresar: ImageButton
    private lateinit var presentador: clsDetalleCursos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalle_cursos)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        txtNombreCurso = findViewById(R.id.txtNombreCurso)
        txtCodigoCurso = findViewById(R.id.txtCodigoCurso)
        txtDescripcionCurso = findViewById(R.id.txtDescripcionCurso)
        txtLugar = findViewById(R.id.txtLugar)
        txtTotalHoras = findViewById(R.id.txtTotalHoras)
        txtDias = findViewById(R.id.txtDias)
        txtHoras = findViewById(R.id.txtHoras)
        txtCupoMaximo = findViewById(R.id.txtCupoMaximo)

        btnRegresar = findViewById(R.id.btnRegresar)

        btnRegresar.setOnClickListener {
            finish()
        }

        val galeria = findViewById<ViewPager2>(R.id.imgCursos)

        galeriaAdaptador = GaleriaAdaptador(emptyList())
        galeria.adapter = galeriaAdaptador

        presentador = clsDetalleCursos(this)

        val idCurso = intent.getIntExtra("ID_CURSO", 0)
        presentador.cargarDetalleCurso(idCurso)

        val nombreCurso = intent.getStringExtra("NOMBRE_CURSO") ?: ""
        val codigoCurso = intent.getStringExtra("CODIGO_CURSO") ?: ""
        val descripcionCurso = intent.getStringExtra("DESCRIPCION_CURSO") ?: ""
        val lugar = intent.getStringExtra("LUGAR") ?: ""

        val totalHoras = intent.getIntExtra("TOTAL_HORAS", 0)
        val cupoMaximo = intent.getIntExtra("CUPO_MAXIMO", 0)

        val dias = intent.getStringExtra("DIAS") ?: ""
        val horas = intent.getStringExtra("HORAS") ?: ""

        txtNombreCurso.text = nombreCurso
        txtCodigoCurso.text = "Código: $codigoCurso"
        txtDescripcionCurso.text = descripcionCurso
        txtLugar.text = "Lugar: $lugar"

        txtTotalHoras.text = "Total de Horas: $totalHoras horas"
        txtDias.text = "Días de atención: $dias"
        txtHoras.text = "Horario de atención: $horas"
        txtCupoMaximo.text = "Cupo máximo: $cupoMaximo alumnos"
    }

    fun mostrarImagenes(listaImagenes: List<dataImagenesCursos>) {
        galeriaAdaptador.actualizarLista(listaImagenes)
    }

    fun mostrarError(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
    }
}