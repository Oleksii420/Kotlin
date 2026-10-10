package laba4

class Employee(val firstName: String, val lastName: String, val position: String){

    override fun toString(): String {
        return "$firstName, $lastName, $position"
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Employee) return false
            return firstName == other.firstName && lastName == other.lastName && position == other.position

    }

    override fun hashCode(): Int {
        var result = firstName.hashCode()
        result = result * 31 + lastName.hashCode()
        result = result * 31 + position.hashCode()
        return result
    }
    operator fun component1(): String = firstName
    operator fun component2(): String = lastName
    operator fun component3(): String = position

    fun copy(firstName: String = this.firstName, lastName: String = this.lastName, position: String = this.position): Employee{
        return Employee(firstName, lastName, position)
    }

    var bonus: Int = 0
}

fun main(){
    val emp1 = Employee("Den", "Miller", "director")
    val emp2 = Employee("Den", "Miller", "director")
    val emp3 = emp1
    val (name, surname, pos) = emp1
    val emp4 = emp1.copy(position = "CEO")
    val emp5 = Employee("Den", "Miller", "director")
    emp5.bonus = 100
    val emp6 = Employee("Den", "Miller", "director")
    emp6.bonus = 500
    println(emp5 == emp6)

    println(emp1)
    println("$name $surname $pos")
    println(emp4)
    println(emp1 === emp2)
    println(emp1 == emp2)
    println(emp1 === emp3)
}