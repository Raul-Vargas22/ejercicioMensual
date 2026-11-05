package com.example.ejerciciomensual.vista

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ejerciciomensual.R
import com.example.ejerciciomensual.presentador.RegistroPresentador
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class RegistroActivity : AppCompatActivity() {

    private lateinit var btnRegresar: TextView
    private lateinit var txtTituloCurso: TextView
    private lateinit var txtNombreCurso: TextView
    private lateinit var imgCurso: ImageView

    private lateinit var txtMatricula: EditText
    private lateinit var txtFechaRegistro: EditText
    private lateinit var txtCorreo: EditText

    private lateinit var btnConfirmarInscripcion: Button
    private lateinit var btnCancelar: Button

    private lateinit var presentador: RegistroPresentador

    private var idCurso: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registro)

        btnRegresar = findViewById(R.id.btnRegresar)
        txtTituloCurso = findViewById(R.id.txtTituloCurso)
        txtNombreCurso = findViewById(R.id.txtNombreCurso)
        imgCurso = findViewById(R.id.imgCurso)

        txtMatricula = findViewById(R.id.txtMatricula)
        txtFechaRegistro = findViewById(R.id.txtFechaRegistro)
        txtCorreo = findViewById(R.id.txtCorreo)

        // Mostrar la fecha actual y evitar que se pueda modificar
        val fechaActual = SimpleDateFormat(
            "dd/MM/yyyy",
            Locale.getDefault()
        ).format(Date())

        txtFechaRegistro.setText(fechaActual)
        txtFechaRegistro.isFocusable = false
        txtFechaRegistro.isFocusableInTouchMode = false
        txtFechaRegistro.isClickable = false
        txtFechaRegistro.isLongClickable = false

        btnConfirmarInscripcion = findViewById(R.id.btnConfirmarInscripcion)
        btnCancelar = findViewById(R.id.btnCancelar)

        presentador = RegistroPresentador(this)

        idCurso = intent.getIntExtra("ID_CURSO", 0)

        val nombreCurso = intent.getStringExtra("NOMBRE_CURSO") ?: ""
        val codigoCurso = intent.getStringExtra("CODIGO_CURSO") ?: ""

        txtTituloCurso.text = nombreCurso
        txtNombreCurso.text = nombreCurso

        val imagenCurso = intent.getStringExtra("IMAGEN_CURSO") ?: ""

        val baseUrl = "http://10.115.22.102/api_cursos/Imagenes/principal/"
        val urlImagenCompleta = baseUrl + imagenCurso.trimStart('/')

        Glide.with(this)
            .load(urlImagenCompleta)
            .placeholder(android.R.drawable.ic_menu_gallery)
            .error(android.R.drawable.ic_menu_report_image)
            .into(imgCurso)

        btnConfirmarInscripcion.setOnClickListener {
            ejecutarAccionInscribirse()
        }

        btnCancelar.setOnClickListener {
            finish()
        }

        btnRegresar.setOnClickListener {
            finish()
        }

        txtMatricula.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                presentador.buscarAlumno(txtMatricula.text.toString())
            }
        }
    }

    private fun ejecutarAccionInscribirse() {
        val matricula = txtMatricula.text.toString()
        val correo = txtCorreo.text.toString()

        presentador.registrarInscripcion(
            matricula,
            correo,
            idCurso
        )
    }

    fun mostrarMensaje(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
    }

    fun mostrarCorreo(correo: String) {
        txtCorreo.setText(correo)
    }
}