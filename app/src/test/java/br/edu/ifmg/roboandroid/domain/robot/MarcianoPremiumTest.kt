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
        assertTrue(resposta.contains("A tecnologia move o mundo"))
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
}

