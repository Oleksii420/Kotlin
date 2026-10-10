fun main() {
    // Зчитуємо два числа з одного рядка
    val (aStr, bStr) = readln().trim().split("\\s+".toRegex())
    val a = aStr.toLong()
    val b = bStr.toLong()

    val smoler = if(a < b) a else b
    val biger = if(a > b) a else b

    var result = 0L

    for(i in 1..biger){
        result += smoler
    }
    println(result)
}