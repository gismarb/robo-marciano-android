package br.edu.ifmg.roboandroid.domain.robot

import org.junit.Assert.assertEquals
import org.junit.Test

class MarcianoAvancadoTest {

    private val robo = MarcianoAvancado()

    @Test
    fun deveSomarDoisNumeros() {
        val resposta = robo.responder("some 2 3")

        assertEquals("Essa eu sei: 5", resposta)
    }

    @Test
    fun deveSubtrairDoisNumeros() {
        val resposta = robo.responder("subtraia 10 4")

        assertEquals("Essa eu sei: 6", resposta)
    }

    @Test
    fun deveMultiplicarDoisNumeros() {
        val resposta = robo.responder("multiplique 3 5")

        assertEquals("Essa eu sei: 15", resposta)
    }

    @Test
    fun deveDividirDoisNumeros() {
        val resposta = robo.responder("divida 10 2")

        assertEquals("Essa eu sei: 5", resposta)
    }

    @Test
    fun deveRetornarErroAoDividirPorZero() {
        val resposta = robo.responder("divida 10 0")

        assertEquals("Erro: não é possível dividir por zero", resposta)
    }

    @Test
    fun deveAceitarNumerosComVirgula() {
        val resposta = robo.responder("some 2,5 3,5")

        assertEquals("Essa eu sei: 6", resposta)
    }

    @Test
    fun deveUsarRegraDoMarcianoBasicoQuandoNaoForOperacaoMatematica() {
        val resposta = robo.responder("Tudo bem?")

        assertEquals("Certamente", resposta)
    }
}

