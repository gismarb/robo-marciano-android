package br.edu.ifmg.roboandroid.domain.robot

import kotlin.random.Random

class MarcianoPremium : MarcianoAvancado() {

    private val frasesTecnologia = listOf(
        "A tecnologia move o mundo, mas as pessoas dão sentido a ela.",
        "Grandes soluções começam com pequenas ideias bem implementadas.",
        "A inovação acontece quando conhecimento e criatividade caminham juntos.",
        "Todo sistema inteligente começa com uma boa regra de negócio.",
        "Programar é transformar lógica em solução.",
        "A tecnologia é mais útil quando aproxima pessoas e resolve problemas reais."
    )

    override fun responder(mensagem: String): String {
        val texto = mensagem.trim()

        if (texto == "agir") {
            return "É pra já!\n\n${obterFraseAleatoria()}"
        }

        return super.responder(mensagem)
    }

    private fun obterFraseAleatoria(): String {
        return frasesTecnologia[Random.nextInt(frasesTecnologia.size)]
    }
}