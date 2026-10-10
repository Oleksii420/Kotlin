package laba5

data class Vehicle(var brand: String, var model: String, var year: Int, var licensePlate: String)

fun main(){
    val vehicle = Vehicle("", "", 0, "").apply {
        brand = "BMW"
        model = "M5"
        year = 2023
        licensePlate = "KFASD"
    }.also { println("Створено новий транспортний засіб: $it")}
    println(vehicle)

    with(vehicle){
        println("Марка = $brand")
        println("Модель = $model")
        println("Рік випуску: $year")
        println("Номерний знак: $licensePlate")
    }

}