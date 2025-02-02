class Persona(peso: Double, altura: Double, var nombre: String? = null) {

    var peso: Double = peso
        private set

    var altura: Double = altura
        private set

    val imc: Double
        get() = peso / (altura * altura)

    init {
        require(peso > 0) { "El peso debe ser mayor a 0." }
        require(altura > 0) { "La altura debe ser mayor a 0." }
    }

    fun saludar(): String = "Hola, mi nombre es ${nombre ?: "Desconocido"}."

    fun alturaEncimaMedia(): Boolean = altura >= 1.75

    fun pesoEncimaMedia(): Boolean = peso >= 70

    private fun obtenerDescImc(): String {
        return when {
            imc < 18.5 -> "peso insuficiente"
            imc < 24.9 -> "peso saludable"
            imc < 29.9 -> "sobrepeso"
            else -> "obesidad"
        }
    }

    fun obtenerDesc(): String {
        val alturaDesc = if (alturaEncimaMedia()) "Por encima de la media" else "Por debajo de la media"
        val pesoDesc = if (pesoEncimaMedia()) "Por encima de la media" else "Por debajo de la media"
        return "$nombre con una altura de ${"%.2f".format(altura)}m ($alturaDesc) y un peso de ${"%.1f".format(peso)}kg ($pesoDesc) tiene un IMC de ${"%.2f".format(imc)} (${obtenerDescImc()})"
    }

    override fun toString(): String {
        return "Persona(nombre=$nombre, peso=$peso, altura=$altura, imc=${"%.2f".format(imc)})"
    }
}

fun main() {
    val personas = listOf(
        Persona(70.5, 1.75),
        Persona(80.0, 1.78, "Juan"),
        Persona(65.0, 1.65, "Ana"),
        Persona(90.0, 1.85, "Carlos"),
        Persona(55.0, 1.60, "Lucia")
    )

    for (persona in personas) {
        println(persona.saludar())
        println(persona.obtenerDesc())
    }
}
