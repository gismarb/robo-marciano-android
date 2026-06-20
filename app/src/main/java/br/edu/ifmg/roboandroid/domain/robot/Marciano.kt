package br.edu.ifmg.roboandroid.domain.robot

import br.edu.ifmg.roboandroid.domain.util.UtilTexto

open class Marciano {

    open fun responder(mensagem: String): String {
        val texto = mensagem.trim()

        return when {
            texto.isBlank() -> "Não me incomode"
            UtilTexto.ehPergunta(texto) && UtilTexto.ehGrito(texto) -> "Relaxa, eu sei o que estou fazendo!"
            UtilTexto.ehGrito(texto) -> "Opa! Calma aí!"
            UtilTexto.ehPergunta(texto) -> "Certamente"
            UtilTexto.contemPalavraEu(texto) -> "A responsabilidade é sua"
            else -> "Tudo bem, como quiser"
        }
    }
}