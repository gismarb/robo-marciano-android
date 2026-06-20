package br.edu.ifmg.roboandroid.domain.util

object UtilTexto {

    fun ehPergunta(mensagem: String): Boolean {
        return mensagem.trim().endsWith("?")
    }

    fun ehGrito(mensagem: String): Boolean {
        val texto = mensagem.trim()

        if (texto.isBlank()) {
            return false
        }

        val letras = texto.filter { it.isLetter() }

        if (letras.isBlank()) {
            return false
        }

        return letras.all { it.isUpperCase() }
    }

    fun contemPalavraEu(mensagem: String): Boolean {
        val regex = Regex("\\beu\\b", RegexOption.IGNORE_CASE)
        return regex.containsMatchIn(mensagem)
    }
}

