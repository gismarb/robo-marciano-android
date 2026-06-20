package br.edu.ifmg.roboandroid.domain.model

enum class TipoRobo(val codigo: String) {
    BASICO("basico"),
    AVANCADO("avancado"),
    PREMIUM("premium");

    companion object {
        fun fromCodigo(codigo: String?): TipoRobo {
            return entries.firstOrNull { it.codigo == codigo } ?: BASICO
        }
    }
}

