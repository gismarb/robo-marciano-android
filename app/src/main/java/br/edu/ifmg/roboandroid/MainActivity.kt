package br.edu.ifmg.roboandroid

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifmg.roboandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val tiposRobo: List<String> by lazy {
        listOf(
            getString(R.string.robot_type_basic),
            getString(R.string.robot_type_advanced),
            getString(R.string.robot_type_premium)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configurarSpinnerTipoRobo()
        configurarBotaoEnviar()
    }

    private fun configurarSpinnerTipoRobo() {
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            tiposRobo
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerTipoRobo.adapter = adapter
    }

    private fun configurarBotaoEnviar() {
        binding.btnEnviar.setOnClickListener {
            val tipoRoboSelecionado = binding.spinnerTipoRobo.selectedItem.toString()
            val mensagem = binding.editMensagem.text.toString().trim()

            if (mensagem.isBlank()) {
                Toast.makeText(
                    this,
                    getString(R.string.validation_empty_message),
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            Toast.makeText(
                this,
                getString(R.string.temporary_selected_message, tipoRoboSelecionado, mensagem),
                Toast.LENGTH_LONG
            ).show()
        }
    }
}