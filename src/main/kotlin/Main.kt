interface ArmasFuego {
    var municion: Int
    val municionARestar: Int
    fun disparar() = if (municion >= municionARestar) municion - municionARestar else municion
    fun recargar(r: Int): Int {
        municion += r
        return municion
    }
}

class Casa(val direccion: String, override var municion: Int, override val municionARestar: Int) : ArmasFuego
class Coche(private val matricula: String, override var municion: Int, override val municionARestar: Int) : ArmasFuego

fun main() {
    val casa = Casa("Avd.Segunda Aguanda 10", 30, 5)
    val coche = Coche("A123", 20, 3)
    println(coche.disparar())
    println(casa.disparar())
}