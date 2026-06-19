package br.edu.ifmg.roboandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifmg.roboandroid.databinding.ActivityAnswerBinding

class AnswerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnswerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAnswerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tipoRobo = intent.getStringExtra(EXTRA_TIPO_ROBO).orEmpty()
        val mensagem = intent.getStringExtra(EXTRA_MENSAGEM).orEmpty()

        binding.txtTipoRoboResposta.text = getString(R.string.answer_robot_type, tipoRobo)
        binding.txtMensagemUsuario.text = getString(R.string.answer_user_message, mensagem)
        binding.txtRespostaRobo.text = getString(R.string.answer_temporary_response)

        binding.btnVoltar.setOnClickListener {
            finish()
        }
    }

    companion object {
        const val EXTRA_TIPO_ROBO = "br.edu.ifmg.roboandroid.EXTRA_TIPO_ROBO"
        const val EXTRA_MENSAGEM = "br.edu.ifmg.roboandroid.EXTRA_MENSAGEM"
    }
}
