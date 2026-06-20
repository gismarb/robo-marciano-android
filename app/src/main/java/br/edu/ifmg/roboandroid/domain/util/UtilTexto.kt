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

        val palavras = texto.split(Regex("\\s+"))

        return palavras.any { palavra ->
            val letras = palavra.filter { it.isLetter() }

            letras.length >= 2 && letras.all { it.isUpperCase() }
        }
    }

    fun contemPalavraEu(mensagem: String): Boolean {
        val regex = Regex("\\beu\\b", RegexOption.IGNORE_CASE)
        return regex.containsMatchIn(mensagem)
    }
}