import kotlin.math.roundToInt

/**
 * Clase que representa a una persona con atributos como peso, altura y nombre.
 * También proporciona métodos para calcular e imprimir el índice de masa corporal (IMC).
 *
 * @property peso Peso de la persona en kilogramos.
 * @property altura Altura de la persona en metros.
 * @property nombre Nombre de la persona.
 * @property imc Índice de Masa Corporal (IMC) de la persona.
 * @constructor Crea una instancia de Persona con peso y altura especificados.
 */
class Persona(peso: Double, altura: Double) {

    /**
     * En Kotlin, un companion object es un objeto que está vinculado a una clase y tiene acceso a sus miembros,
     * aunque no se requiere tener una instancia de la clase para acceder a estos miembros.
     * Es similar a un objeto estático en otros lenguajes de programación, pero con la capacidad de acceder a
     * los miembros no estáticos de la clase.
     *
     * En nuestro caso contiene valores constantes para la altura y el peso medio.
     *
     */
    companion object{
        const val ALTURA_MEDIA = 1.75
        const val PESO_MEDIA = 70.0
    }

    var peso = peso
        set(value) {
            comprobarPeso(value)
            field = value
        }

    var altura = altura
        set(value) {
            comprobarAltura(altura)
            field = value
        }

    var nombre = "Sin Nombre"
        //La inicializamos a "Sin Nombre", ya que aunque por el enunciado del ejercicio es posible crear una persona
        //sin introducir el nombre en el constructor primario, no tiene sentido que permitamos que esté vacío si vamos
        //a requerir lo contrario en el set de la propiedad.
        set(value) {
            comprobarNombre(value)
            field = value
        }

    var imc = 0.0
        get() = calcularImc()
        private set

    init {
        comprobarPeso(peso)
        comprobarAltura(altura)
    }

    /**
     * Constructor secundario que permite crear una instancia de Persona
     * con nombre, peso y altura especificados.
     *
     * @param nombre Nombre de la persona.
     * @param peso Peso de la persona en kilogramos.
     * @param altura Altura de la persona en metros.
     */
    constructor(nombre: String, peso: Double, altura: Double): this(peso, altura) {
        comprobarNombre(nombre)
        this.nombre = nombre
    }

    /**
     * Constructor secundario que permite crear una instancia de Persona
     * con nombre, peso y altura especificados en valores enteros.
     *
     * @param nombre Nombre de la persona.
     * @param peso Peso de la persona en kilogramos (entero).
     * @param altura Altura de la persona en metros (entero).
     */
    constructor(nombre: String, peso: Int, altura: Int): this(peso.toDouble(), altura.toDouble()) {
        comprobarNombre(nombre)
        this.nombre = nombre
    }

    /**
     * Constructor secundario que permite crear una instancia de Persona
     * con peso y altura especificados en valores enteros.
     *
     * @param peso Peso de la persona en kilogramos (entero).
     * @param altura Altura de la persona en metros (entero).
     */
    constructor(peso: Int, altura: Int): this(peso.toDouble(), altura.toDouble())

    // Métodos privados...

    /**
     * Comprueba que el peso proporcionado sea un valor positivo.
     *
     * @param peso Peso a comprobar.
     * @throws IllegalArgumentException Si el peso no es un valor positivo.
     */
    private fun comprobarPeso(peso: Double) {
        require(peso > 0) { "El peso debe ser un valor positivo." }
    }

    /**
     * Comprueba que la altura proporcionada sea un valor positivo.
     *
     * @param altura Altura a comprobar.
     * @throws IllegalArgumentException Si la altura no es un valor positivo.
     */
    private fun comprobarAltura(altura: Double) {
        require(altura > 0) { "La altura debe ser un valor positivo." }
    }

    /**
     * Comprueba que el nombre proporcionado no esté vacío.
     *
     * @param nombre Nombre a comprobar.
     * @throws IllegalArgumentException Si el nombre está vacío.
     */
    private fun comprobarNombre(nombre: String) {
        require(nombre.trim().isNotEmpty()) { "El nombre no puede estar vacío." }
    }

    /**
     * Calcula el índice de masa corporal (IMC) de la persona.
     *
     * @return Índice de Masa Corporal (IMC) redondeado a 2 posiciones decimales.
     */
    private fun calcularImc() = (this.peso / (this.altura * this.altura) * 100.0).roundToInt() / 100.0

    // Métodos públicos...

    /**
     * Muestra la descripción de la persona, incluyendo nombre, peso, altura
     * y el índice de masa corporal (IMC).
     */
    fun mostrarDesc() {
        println(this.obtenerDesc())
    }

    /**
     * Realiza un saludo con el nombre de la persona.
     */
    fun saludar(): String {
        return "Hola!! soy ${this.nombre}. "
    }

    /**
     * Verifica si la altura de la persona está por encima de la media.
     *
     * @return `true` si la altura es mayor que la media, `false` en caso contrario.
     */
    fun alturaEncimaMedia() = this.altura > ALTURA_MEDIA

    /**
     * Verifica si el peso de la persona está por encima de la media.
     *
     * @return `true` si el peso es mayor que la media, `false` en caso contrario.
     */
    fun pesoEncimaMedia() = this.peso > PESO_MEDIA

    /**
     * Obtiene la descripción del Índice de Masa Corporal (IMC) de la persona.
     *
     * @return Descripción del tipo de IMC asociado a la persona.
     */
    fun obtenerDescImc() = TipoImc.obtenerTipoImc(this.imc).desc

    /**
     * Obtiene una descripción detallada de la persona, incluyendo nombre, altura, peso
     * e información sobre el IMC.
     *
     * @return Cadena que describe detalladamente a la persona.
     */
    fun obtenerDesc(): String {
        var desc = "${this.nombre} "
        desc += """con una altura de ${this.altura}m ${if (this.alturaEncimaMedia()) "(por encima de la media)" else "(Por debajo de la media)"}"""
        desc += """ y un peso de ${this.peso}kg ${if (this.pesoEncimaMedia()) "(por encima de la media)" else "(Por debajo de la media)"}"""
        desc += """ tiene un IMC de ${this.imc} ${this.obtenerDescImc()}"""

        return desc
    }

    /**
     * Devuelve una representación de cadena que incluye información clave de la persona.
     * Esta representación incluye el nombre, peso, altura y el Índice de Masa Corporal (IMC) de la persona.
     *
     * @return Cadena que describe la persona.
     */
    override fun toString(): String {
        return "nombre: ${this.nombre},  peso: ${this.peso},  altura: ${this.altura}, imc: ${this.imc}"
    }

    /**
     * Compara esta instancia de Persona con otro objeto para verificar si son iguales.
     *
     * @param other El objeto con el que se compara.
     * @return `true` si las instancias son iguales, `false` en caso contrario.
     */
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Persona) return false

        if (this.nombre != other.nombre) return false
        if (this.altura != other.altura) return false
        if (this.peso != other.peso) return false

        return true
    }
}