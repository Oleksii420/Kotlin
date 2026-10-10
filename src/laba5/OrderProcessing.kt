package laba5

data class OrderItem(
    val name: String,
    val price: Double,
    val quantity: Int
)

class Order(val id: String) {
    var customerName: String = ""
    var deliveryAddress: String = ""
    var discountPercent: Int = 0
    val items: MutableList<OrderItem> = mutableListOf()

    fun addItem(item: OrderItem) {
        items.add(item)
    }
}

fun main(){
    val order = Order("ORD-2026-001").apply {
        customerName = "Олексій Коваленко"
        deliveryAddress = "вул. Хрещатик, 22, Київ"
        discountPercent = 10
        addItem(OrderItem("Клавіатура", 2500.0, 1))
        addItem(OrderItem("Мишка", 1200.0, 1))
        addItem(OrderItem("Килимок", 800.0, 2))
    }.also { println("[LOG] Замовлення ${it.id} успішно налаштовано. Кількість позицій: ${it.items.size}")}

    val finalPrice: Double = order.run {
        val baseTotal = items.sumOf { it.price * it.quantity }
        baseTotal * (1 - discountPercent / 100.0)
    }
    println("Розрахована сума: $finalPrice грн")

    val paymentPayload = finalPrice.let {
        val cent = (it * 100).toLong()
        println("TXN-${order.id}_AMOUNT_${cent}_UAH")
    }
    println(paymentPayload)

    with(order) {
        val itemsText = items.joinToString("\n") { item ->
            " • ${item.name} (${item.quantity} шт.) - ${item.price} грн"
        }

        println(
            "========================================\n" +
                    "ЧЕК ЗАМОВЛЕННЯ: $id\n" +
                    "Отримувач: $customerName\n" +
                    "Адреса доставки: $deliveryAddress\n" +
                    "----------------------------------------\n" +
                    "Товари:\n" +
                    itemsText + "\n" +
                    "----------------------------------------\n" +
                    "Знижка клієнта: $discountPercent%\n" +
                    "Разом до сплати: $finalPrice грн\n" +
                    "========================================"
        )
    }


}