package br.edu.ifmg.roboandroid.domain.robot

open class MarcianoAvancado : Marciano() {

    override fun responder(mensagem: String): String {
        val resultadoOperacao = tentarResolverOperacaoMatematica(mensagem)

        return resultadoOperacao ?: super.responder(mensagem)
    }

    private fun tentarResolverOperacaoMatematica(mensagem: String): String? {
        val partes = mensagem.trim().split(Regex("\\s+"))

        if (partes.size != 3) {
            return null
        }

        val operacao = partes[0].lowercase()
        val primeiroNumero = partes[1].replace(",", ".").toDoubleOrNull()
        val segundoNumero = partes[2].replace(",", ".").toDoubleOrNull()

        if (primeiroNumero == null || segundoNumero == null) {
            return null
        }

        val resultado = when (operacao) {
            "some" -> primeiroNumero + segundoNumero
            "subtraia" -> primeiroNumero - segundoNumero
            "multiplique" -> primeiroNumero * segundoNumero
            "divida" -> {
                if (segundoNumero == 0.0) {
                    return RoboRespostas.ERRO_DIVISAO_POR_ZERO
                }
                primeiroNumero / segundoNumero
            }
            else -> return null
        }

        return "${RoboRespostas.PREFIXO_RESULTADO_OPERACAO} ${formatarResultado(resultado)}"
    }

    private fun formatarResultado(valor: Double): String {
        return if (valor % 1.0 == 0.0) {
            valor.toInt().toString()
        } else {
            valor.toString()
        }
    }
}