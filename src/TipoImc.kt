/**
 * Enumeración que representa diferentes tipos de Índice de Masa Corporal (IMC) junto con sus rangos y descripciones asociadas.
 *
 * @property imcMin Valor mínimo del IMC para este tipo.
 * @property imcMax Valor máximo del IMC para este tipo.
 * @property desc Descripción asociada al tipo de IMC.
 */
enum class TipoImc(val imcMin: Double,val imcMax: Double, val desc: String) {
    INSUFICIENTE(0.0, 18.4, "Peso insuficiente"),
    SALUDABLE(18.5, 24.9, "Peso saludable"),
    SOBREPESO(25.0, 29.9,"Sobrepeso"),
    OBESIDAD(30.0, 100.0, "Obesidad");

    companion object {
        /**
         * Función de utilidad para obtener el tipo de IMC basado en un valor dado de IMC.
         *
         * @param imc Valor del Índice de Masa Corporal (IMC) para el cual se desea obtener el tipo de IMC.
         * @return Tipo de IMC correspondiente al valor proporcionado.
         */
        fun obtenerTipoImc(imc: Double) : TipoImc {
            return when {
                imc.compareTo(INSUFICIENTE.imcMax) <= 0 ->  INSUFICIENTE
                imc.compareTo(SALUDABLE.imcMax) <= 0 ->  SALUDABLE
                imc.compareTo(SOBREPESO.imcMax) <= 0 ->  SOBREPESO
                else -> OBESIDAD
            }
        }
    }
}