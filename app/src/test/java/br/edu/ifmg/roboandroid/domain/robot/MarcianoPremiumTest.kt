package br.edu.ifmg.roboandroid.domain.robot

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class MarcianoPremiumTest {

    private val robo = MarcianoPremium()

    @Test
    fun deveResponderComAcaoQuandoMensagemForAgir() {
        val resposta = robo.responder("agir")

        assertTrue(resposta.contains("É pra já!"))
        assertTrue(resposta.length > "É pra já!".length)
    }

    @Test
    fun deveExecutarOperacaoMatematicaHerdadaDoMarcianoAvancado() {
        val resposta = robo.responder("some 2 3")

        assertEquals("Essa eu sei: 5", resposta)
    }

    @Test
    fun deveUsarRegraDoMarcianoBasicoQuandoNaoForAcaoNemOperacao() {
        val resposta = robo.responder("Tudo bem?")

        assertEquals("Certamente", resposta)
    }

    @Test
    fun deveAplicarPrecedenciaDeGritoMesmoNoMarcianoPremium() {
        val resposta = robo.responder("EU quero testar")

        assertEquals("Opa! Calma aí!", resposta)
    }

    @Test
    fun deveInterpretarAgirMaiusculoComoGrito() {
        val resposta = robo.responder("AGIR")

        assertEquals("Opa! Calma aí!", resposta)
    }
}