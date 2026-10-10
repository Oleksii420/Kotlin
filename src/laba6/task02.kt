package laba6

import kotlin.random.Random

fun generateRandomArray(size: Int, maxValue: Int): IntArray?{
    if (size <= 0 || maxValue <= 0) return null
    val array = IntArray(size){ Random.nextInt(0, maxValue + 1) }
    return array
}

fun main(){
    generateRandomArray(10,50)?.let { array ->
        array.apply { for (i in indices){
            this[i] = if (this[i] % 2 == 0) (this[i] / 2) else this[i] * 2 }
        }
            .also { println("Модифікований масив: ${it.contentToString()}") }
            .run { maxOrNull() }
            .let { println(it) }
    } ?: println("Помилка вхідних даних")
}