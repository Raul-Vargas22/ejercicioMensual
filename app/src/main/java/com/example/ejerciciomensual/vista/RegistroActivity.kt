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

    private lateinit var presentador:
            RegistroPresentador

    private var idCurso: Int = 0

    override fun onCreate(
        savedInstanceState: Bundle?
    ) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.registro)

        btnRegresar =
            findViewById(R.id.btnRegresar)

        txtTituloCurso =
            findViewById(R.id.txtTituloCurso)

        txtNombreCurso =
            findViewById(R.id.txtNombreCurso)

        imgCurso =
            findViewById(R.id.imgCurso)

        txtMatricula =
            findViewById(R.id.txtMatricula)

        txtFechaRegistro =
            findViewById(R.id.txtFechaRegistro)

        txtCorreo =
            findViewById(R.id.txtCorreo)

        btnConfirmarInscripcion =
            findViewById(
                R.id.btnConfirmarInscripcion
            )

        btnCancelar =
            findViewById(R.id.btnCancelar)

        presentador =
            RegistroPresentador(this)

        idCurso =
            intent.getIntExtra(
                "ID_CURSO",
                0
            )

        val nombreCurso =
            intent.getStringExtra(
                "NOMBRE_CURSO"
            ) ?: ""

        val codigoCurso =
            intent.getStringExtra(
                "CODIGO_CURSO"
            ) ?: ""

        txtTituloCurso.text =
            nombreCurso

        txtNombreCurso.text =
            nombreCurso

        when (codigoCurso) {

            "IS102" ->
                imgCurso.setImageResource(
                    R.drawable.programacion
                )

            "BD201" ->
                imgCurso.setImageResource(
                    R.drawable.basedatos
                )
        }

        btnConfirmarInscripcion
            .setOnClickListener {

                ejecutarAccionInscribirse()
            }

        btnCancelar.setOnClickListener {
            finish()
        }

        btnRegresar.setOnClickListener {
            finish()
        }
    }

    private fun ejecutarAccionInscribirse() {

        val matricula =
            txtMatricula.text.toString()

        val correo =
            txtCorreo.text.toString()

        val valido =
            presentador.validarInscripcion(
                matricula,
                correo,
                idCurso
            )

        if (valido) {

            Toast.makeText(
                this,
                "Datos válidos",
                Toast.LENGTH_SHORT
            ).show()

        } else {

            Toast.makeText(
                this,
                "Completa los campos, faltan datos",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}