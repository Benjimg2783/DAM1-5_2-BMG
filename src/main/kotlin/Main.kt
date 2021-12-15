interface ArmasFuego {
    var municion: Int
    val municionARestar: Int
    fun disparar() = if (municion >= municionARestar) municion - municionARestar else municion
    fun recargar(r: Int): Int {
        municion += r
        return municion
    }
}

class Casa(private val direccion: String, override var municion: Int,override val municionARestar: Int, ) : ArmasFuego
class Coche(private val matricula: String, override var municion: Int, override val municionARestar: Int) : ArmasFuego
class Bocadillo(private val sabor:String,override var municion: Int,override val municionARestar: Int):ArmasFuego

fun main() {
    val casa = Casa("Avd.Segunda Aguanda 10", 30, 5)
    val coche = Coche("A123", 20, 3)
    val bocadillo=Bocadillo("chorizo",10,2)
    val lista = listOf(casa,coche,bocadillo)
    val disparos = mutableMapOf<String, ArmasFuego>()
    for (i in 0 until 6) {
        disparos["$i"] = lista.random()
    }
    disparos.mapValues { it.value.disparar(); println(it.value) }
}