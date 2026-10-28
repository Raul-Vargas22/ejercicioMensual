package com.example.ejerciciomensual.vista

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.ejerciciomensual.R
import com.example.ejerciciomensual.presentador.RegistroPresentador
import android.widget.Toast
class RegistroActivity : AppCompatActivity() {
    private lateinit var btnRegresar: TextView
    private lateinit var txtTituloCurso: TextView
    private lateinit var txtNombreCurso: TextView
    private lateinit var txtMatricula: EditText
    private lateinit var txtFechaRegistro: EditText
    private lateinit var txtCorreo: EditText
    private lateinit var btnConfirmarInscripcion: Button
    private lateinit var btnCancelar: Button
    private lateinit var  presentador: RegistroPresentador

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registro)
        btnRegresar = findViewById(R.id.btnRegresar)
        txtTituloCurso = findViewById(R.id.txtTituloCurso)
        txtNombreCurso = findViewById(R.id.txtNombreCurso)
        txtMatricula = findViewById(R.id.txtMatricula)
        txtFechaRegistro = findViewById(R.id.txtFechaRegistro)
        txtCorreo = findViewById(R.id.txtCorreo)
        btnConfirmarInscripcion = findViewById(R.id.btnConfirmarInscripcion)
        btnCancelar = findViewById(R.id.btnCancelar)

        presentador = RegistroPresentador(this)

        btnConfirmarInscripcion.setOnClickListener(this::ejecutarAccionInscribirse)
        btnCancelar.setOnClickListener(this::ejecutarAccionCancelar)
        btnRegresar.setOnClickListener{finish()}
        txtMatricula.setOnFocusChangeListener { _, tieneFoco ->
            if (!tieneFoco) {
                val matricula = txtMatricula.text.toString().trim()

                if (matricula.isNotEmpty()) {
                    presentador.buscarAlumno(matricula)
                }
            }
        }

    }

    private fun ejecutarAccionInscribirse(v: View) {
        val matricula = txtMatricula.text.toString()
        val correo = txtCorreo.text.toString()

        presentador.registrarInscripcion(matricula, correo,1)
    }

    private fun ejecutarAccionCancelar(v: View) {
        txtMatricula.text.clear()
        txtCorreo.text.clear()
        txtFechaRegistro.text.clear()
        finish()
    }


    fun mostrarMensaje(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
    }
    fun mostrarCorreo(correo: String) {
        txtCorreo.setText(correo)
    }

}
