package br.edu.ifmg.roboandroid.domain.robot

import br.edu.ifmg.roboandroid.domain.model.TipoRobo

object RoboFactory {

    fun criar(tipoRobo: TipoRobo): Marciano {
        return when (tipoRobo) {
            TipoRobo.BASICO -> Marciano()
            TipoRobo.AVANCADO -> MarcianoAvancado()
            TipoRobo.PREMIUM -> MarcianoPremium()
        }
    }
}
