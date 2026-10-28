package vista

import Modelo.dataCategoriasCursos
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ejerciciomensual.R
import presentador.clsCategoriasCursosPresentador

class vistaEstadoInscripciones: AppCompatActivity(), vistaCategoriasCursos {
    private lateinit var presentador: clsCategoriasCursosPresentador
    private lateinit var spinnerCategoriasCursos: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vista_registros)

        spinnerCategoriasCursos = findViewById(R.id.spnCategorias)
        presentador = clsCategoriasCursosPresentador(this)

        configurarListeners()
        presentador.iniciar()
    }
    private fun configurarListeners(){
        spinnerCategoriasCursos.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                presentador.seleccionarCategoria(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }
    override fun mostrarCategorias(categorias: List<dataCategoriasCursos>){
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categorias)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCategoriasCursos.adapter= adapter
    }
    override fun mostrarError(
        mensaje: String
    ) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
    }
    override fun categoriaSeleccionada(
        id: Int,
        nombre: String
    ){
        Toast.makeText(this,"Categoria seleccionada: $nombre", Toast.LENGTH_SHORT).show()

    }
}