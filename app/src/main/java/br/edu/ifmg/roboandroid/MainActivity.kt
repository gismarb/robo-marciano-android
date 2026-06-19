package br.edu.ifmg.roboandroid

import android.content.Intent
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

    override fun onResume() {
        super.onResume()
        limparCampoMensagem()
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

            abrirTelaResposta(tipoRoboSelecionado, mensagem)
        }
    }

    private fun abrirTelaResposta(tipoRobo: String, mensagem: String) {
        val intent = Intent(this, AnswerActivity::class.java).apply {
            putExtra(AnswerActivity.EXTRA_TIPO_ROBO, tipoRobo)
            putExtra(AnswerActivity.EXTRA_MENSAGEM, mensagem)
        }

        startActivity(intent)
    }

    private fun limparCampoMensagem() {
        binding.editMensagem.text?.clear()
    }
}