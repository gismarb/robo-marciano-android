package br.edu.ifmg.roboandroid

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifmg.roboandroid.databinding.ActivityMainBinding
import br.edu.ifmg.roboandroid.domain.model.TipoRobo

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val tiposRobo: List<Pair<TipoRobo, String>> by lazy {
        listOf(
            TipoRobo.BASICO to getString(R.string.robot_type_basic),
            TipoRobo.AVANCADO to getString(R.string.robot_type_advanced),
            TipoRobo.PREMIUM to getString(R.string.robot_type_premium)
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
        voltarScrollParaTopo()
    }

    private fun configurarSpinnerTipoRobo() {
        val nomesTiposRobo = tiposRobo.map { it.second }

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            nomesTiposRobo
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerTipoRobo.adapter = adapter
    }

    private fun configurarBotaoEnviar() {
        binding.btnEnviar.setOnClickListener {
            val tipoRoboSelecionado = obterTipoRoboSelecionado()
            val mensagem = binding.editMensagem.text.toString()

            abrirTelaResposta(tipoRoboSelecionado, mensagem)
        }
    }

    private fun obterTipoRoboSelecionado(): TipoRobo {
        val posicaoSelecionada = binding.spinnerTipoRobo.selectedItemPosition
        return tiposRobo.getOrNull(posicaoSelecionada)?.first ?: TipoRobo.BASICO
    }

    private fun abrirTelaResposta(tipoRobo: TipoRobo, mensagem: String) {
        val intent = Intent(this, AnswerActivity::class.java).apply {
            putExtra(AnswerActivity.EXTRA_TIPO_ROBO, tipoRobo.codigo)
            putExtra(AnswerActivity.EXTRA_MENSAGEM, mensagem)
        }

        startActivity(intent)
    }

    private fun limparCampoMensagem() {
        binding.editMensagem.text?.clear()
    }

    private fun voltarScrollParaTopo() {
        binding.scrollTelaPrincipal.post {
            binding.scrollTelaPrincipal.scrollTo(0, 0)
        }
    }
}