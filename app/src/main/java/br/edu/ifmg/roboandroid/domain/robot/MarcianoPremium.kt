package br.edu.ifmg.roboandroid.domain.robot

class MarcianoPremium : MarcianoAvancado() {

    override fun responder(mensagem: String): String {
        val texto = mensagem.trim()

        if (texto == "agir") {
            return "É pra já!\n\nA tecnologia move o mundo, mas as pessoas dão sentido a ela."
        }

        return super.responder(mensagem)
    }
}