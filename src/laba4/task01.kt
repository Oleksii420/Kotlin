import kotlin.math.sqrt
import kotlin.random.Random


class QuadraticEquation(a: Double, var b: Double, var c: Double) {

    var a: Double = a
        set(value){
            require(value != 0.0) { "Коефіцієнт 'a' не може бути нулем!" }
            field = value
        }

    init {
        require(a != 0.0) { "Коефіцієнт 'a' не може бути нулем!" }
    }
    val discriminant: Double
        get() = b * b - 4 * a * c

    constructor(a: Int, b: Int, c: Int): this(a.toDouble(), b.toDouble(), c.toDouble())

    constructor(b: Double, c: Double): this(1.0, b, c)

    override fun toString(): String {
        return "${a}x^2 + (${b})x + ${c} = 0"
    }
    fun solve(): List<Double>{
        return when{
            discriminant > 0 -> {
                val x1 = (-b + sqrt(discriminant)) / (2 * a)
                val x2 = (-b - sqrt(discriminant)) / (2 * a)
                listOf(x1, x2)
            }

            discriminant == 0.0 -> {
                val x = -b / (2 * a)
                listOf(x)
            }
            else -> emptyList()
        }
    }

}

fun randomNoZero(): Int{
    var value: Int
    do {
        value = Random.nextInt(-50, 51)
    }while (value == 0)
    return value
}

fun main() {

    val equations = List(100){
        QuadraticEquation(randomNoZero(), Random.nextInt(-50, 51), Random.nextInt(-50, 51))
    }

    val twoRootsEquations = equations.filter { it.solve().size == 2 }

    twoRootsEquations.forEach { eq ->
        println("$eq → корені: ${eq.solve()}")
    }
    println("Кількість рівнянь з 2 коренями: ${twoRootsEquations.size}")
}