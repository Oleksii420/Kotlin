import kotlin.math.sqrt

data class Complex(val real: Double, val imeg: Double)

fun getModel(x: Int): Int {
    return if (x < 0) -x else x
}

fun getModel(x: Float): Float{
    return if (x < 0) -x else x
}

fun getComplex(c: Complex): Double {
    return sqrt(c.real * c.real + c.imeg * c.imeg)
}

fun main(){
    val IntInput = -4
    val FloatInput = -7.5f
    val ComplexInput = Complex(-4.0, 9.0)

    println("Ціле чмсло : $IntInput = ${getModel(IntInput)}")
    println("Дійсне чмсло: $FloatInput = ${getModel(FloatInput)}")
    println("Модуль комплексного числа (3 + 4i) = ${"%.3f".format(getComplex(ComplexInput))}")
}