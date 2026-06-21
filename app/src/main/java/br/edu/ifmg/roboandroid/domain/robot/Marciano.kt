package br.edu.ifmg.roboandroid.domain.robot

import br.edu.ifmg.roboandroid.domain.util.UtilTexto

open class Marciano {

    open fun responder(mensagem: String): String {
        val texto = mensagem.trim()

        return when {
            texto.isBlank() -> RoboRespostas.NAO_ME_INCOMODE
            UtilTexto.ehPergunta(texto) && UtilTexto.ehGrito(texto) ->
                RoboRespostas.RELAXA_EU_SEI_O_QUE_ESTOU_FAZENDO
            UtilTexto.ehGrito(texto) -> RoboRespostas.OPA_CALMA_AI
            UtilTexto.ehPergunta(texto) -> RoboRespostas.CERTAMENTE
            UtilTexto.contemPalavraEu(texto) -> RoboRespostas.RESPONSABILIDADE_SUA
            else -> RoboRespostas.TUDO_BEM_COMO_QUISER
        }
    }
}