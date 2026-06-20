package br.edu.ifmg.roboandroid.domain.robot

import org.junit.Assert.assertEquals
import org.junit.Test

class MarcianoTest {

    private val robo = Marciano()

    @Test
    fun deveResponderNaoMeIncomodeQuandoMensagemEstiverVazia() {
        val resposta = robo.responder("")

        assertEquals("Não me incomode", resposta)
    }

    @Test
    fun deveResponderNaoMeIncomodeQuandoMensagemTiverApenasEspacosOuQuebrasDeLinha() {
        val resposta = robo.responder("   \n   ")

        assertEquals("Não me incomode", resposta)
    }

    @Test
    fun deveResponderCertamenteQuandoMensagemForPergunta() {
        val resposta = robo.responder("Tudo bem?")

        assertEquals("Certamente", resposta)
    }

    @Test
    fun deveResponderOpaCalmaAiQuandoMensagemTiverPalavraEmMaiuscula() {
        val resposta = robo.responder("EU quero testar")

        assertEquals("Opa! Calma aí!", resposta)
    }

    @Test
    fun deveResponderResponsabilidadeSuaQuandoMensagemContiverPalavraEuSemGrito() {
        val resposta = robo.responder("Eu quero testar")

        assertEquals("A responsabilidade é sua", resposta)
    }

    @Test
    fun deveResponderRelaxaQuandoMensagemForPerguntaEGrito() {
        val resposta = robo.responder("EU quero testar?")

        assertEquals("Relaxa, eu sei o que estou fazendo!", resposta)
    }

    @Test
    fun deveResponderTudoBemComoQuiserQuandoMensagemNaoCairEmNenhumaRegraEspecial() {
        val resposta = robo.responder("Olá robô")

        assertEquals("Tudo bem, como quiser", resposta)
    }
}

