/**
 * Programa principal que demuestra el uso de la clase Persona para representar
 * información sobre el peso, altura y nombre de diferentes personas.
 */
fun main(){
    // Crear una instancia de Persona con peso y altura especificados.
    val persona1 = Persona(90.55, 1.93)

    println("*******************************************")
    // Modificar el nombre y mostrar la descripción de la persona.
    persona1.nombre = pideNombreAlUsuario()
    persona1.mostrarDesc()
    println(persona1.obtenerDesc())
    println(persona1.toString())

    // Modificar el peso y mostrar la descripción de la persona.
    persona1.peso = 84.5
    persona1.mostrarDesc()

    // Modificar la altura y mostrar la descripción de la persona.
    persona1.altura = 1.81
    persona1.mostrarDesc()

    // Crear una instancia de Persona con nombre, peso y altura especificados.
    val persona2 = damePersona()
    persona2.mostrarDesc()

    // Crear una instancia de Persona con nombre, altura y peso especificados.
    // Si cambiamos el orden, debemos especificar el nombre de los parámetros
    // que reciben los argumentos.
    val persona3 = Persona("David", altura = 1.65, peso = 69.50)
    persona3.mostrarDesc()

    println("*******************************************")
    //Cuando mostramos en un print el nombre del objeto de tipo Persona,
    // por defecto lanza el método toString() de la clase
    //Esto ocurre también en el resto de tipos de datos...
    println("Persona 1: $persona1")
    println("Persona 2: $persona2")
    println("Persona 3: $persona3")

    println("*******************************************")
    println("Persona 1")
    println("nombre: ${persona1.nombre}")
    println("peso: ${persona1.peso}")
    println("altura: ${persona1.altura}")
    println("imc: ${persona1.imc}")

    println("*******************************************")
    println("Persona 3")
    println("peso: ${persona3.peso}")
    println("altura: ${persona3.altura}")
    println("imc: ${persona3.imc}")
    println("Modificado altura a 1.80 en P3")
    persona3.altura = 1.80
    println("Persona 3")
    println("peso: ${persona3.peso}")
    println("altura: ${persona3.altura}")
    println("imc: ${persona3.imc}")

    println("*******************************************")
    println("Persona 2")
    println("Modificado altura a 1.80 en P2")
    persona2.altura = 1.80
    println("Persona 2: $persona2")
    println("Persona 3: $persona3")
    println("Persona 2 y 3 ${if (persona3 == persona2) "iguales." else "distintas."}")

}

/**
 * Solicita el nombre de una persona hasta que introduzca un valor distinto de la cadena vacía.
 */
fun pideNombreAlUsuario(): String {
    var nombre:String
    do {
        print("Introduzca el nombre de la persona: ")
        nombre = readln()
    } while (nombre.isBlank())
    return nombre
}

/**
 * Solicita nombre, peso y altura de una persona hasta crear una instancia de Persona válida.
 */
fun damePersona(): Persona {
    var persona: Persona? = null

    do {
        try {
            print("Introduzca el nombre: ")
            val nombre = readln()
            print("Introduzca el peso: ")
            val peso = readln().toDouble()
            print("Introduzca la altura: ")
            val altura = readln().toDouble()
            persona = Persona(nombre, peso, altura)
        }
        catch (e: NumberFormatException) {
            println("**Error** peso y altura deben ser valores numéricos con decimales (Double).")
        }
        catch (e: IllegalArgumentException) {
            println("**Error** ${e.message}")
        }
    } while (persona == null)

    return persona
}