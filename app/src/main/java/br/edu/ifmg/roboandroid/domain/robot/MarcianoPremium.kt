package br.edu.ifmg.roboandroid.domain.robot

import kotlin.random.Random

class MarcianoPremium : MarcianoAvancado() {

    override fun responder(mensagem: String): String {
        val texto = mensagem.trim()

        if (texto == RoboRespostas.COMANDO_AGIR) {
            return "${RoboRespostas.RESPOSTA_AGIR}\n\n${obterFraseAleatoria()}"
        }

        return super.responder(mensagem)
    }

    private fun obterFraseAleatoria(): String {
        return RoboRespostas.FRASES_TECNOLOGIA[
            Random.nextInt(RoboRespostas.FRASES_TECNOLOGIA.size)
        ]
    }
}