package br.edu.ifmg.roboandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifmg.roboandroid.databinding.ActivityAnswerBinding
import br.edu.ifmg.roboandroid.domain.model.TipoRobo
import br.edu.ifmg.roboandroid.domain.robot.RoboFactory

class AnswerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnswerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAnswerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tipoRobo = TipoRobo.fromCodigo(intent.getStringExtra(EXTRA_TIPO_ROBO))
        val mensagem = intent.getStringExtra(EXTRA_MENSAGEM).orEmpty()
        val robo = RoboFactory.criar(tipoRobo)
        val resposta = robo.responder(mensagem)

        binding.txtTipoRoboResposta.text = getString(
            R.string.answer_robot_type,
            obterNomeTipoRobo(tipoRobo)
        )
        binding.txtMensagemUsuario.text = getString(R.string.answer_user_message, mensagem)
        binding.txtRespostaRobo.text = resposta

        binding.btnVoltar.setOnClickListener {
            finish()
        }
    }

    private fun obterNomeTipoRobo(tipoRobo: TipoRobo): String {
        return when (tipoRobo) {
            TipoRobo.BASICO -> getString(R.string.robot_type_basic)
            TipoRobo.AVANCADO -> getString(R.string.robot_type_advanced)
            TipoRobo.PREMIUM -> getString(R.string.robot_type_premium)
        }
    }

    companion object {
        const val EXTRA_TIPO_ROBO = "br.edu.ifmg.roboandroid.EXTRA_TIPO_ROBO"
        const val EXTRA_MENSAGEM = "br.edu.ifmg.roboandroid.EXTRA_MENSAGEM"
    }
}