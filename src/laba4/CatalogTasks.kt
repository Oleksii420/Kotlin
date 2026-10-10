data class Product(
    val id: Int,
    val name: String,
    val category: String,
    val price: Double,
    val rating: Double,
    val inStock: Boolean
)

val products = listOf(
    Product(1, "Google Pixel 9", "Smartphones", 899.0, 4.8, true),
    Product(2, "iPhone 16 Pro", "Smartphones", 1199.0, 4.9, true),
    Product(3, "Galaxy A55", "Smartphones", 399.0, 4.3, false),
    Product(4, "MacBook Air M3", "Laptops", 1299.0, 4.9, true),
    Product(5, "ThinkPad X1 Carbon", "Laptops", 1499.0, 4.6, false),
    Product(6, "Dell XPS 13", "Laptops", 1150.0, 4.4, true),
    Product(7, "Sony WH-1000XM5", "Audio", 349.0, 4.7, true),
    Product(8, "AirPods Pro 2", "Audio", 249.0, 4.8, false),
    Product(9, "Pixel Buds Pro 2", "Audio", 229.0, 4.5, true)
)



fun main(){
    products
        .filter { it.inStock && it.rating >= 4.7 && it.price < 1000  }
        .sortedByDescending{ it.rating }
        .map { "Назва: ${it.name}, | Рейтинг: ${it.rating}| Ціна: \$${it.price}" }
        .forEach { println(it) }

    val laptop = products.find { it.category == "Laptops" &&it.price > 1200 }
    val result = laptop?.name ?: "Товар не знайдено"
    println(result)
    val audioProducts = products.any { it.category == "Audio" && it.price > 300 }
    println(audioProducts)
    val allSmartphone = products.filter { it.category =="Smartphones"}.all { it.rating > 4.0 }
    println(allSmartphone)
    val (available, outOfStock) = products.partition { it.inStock }
    println("В наявності: ${available.size}, немає в наявності: ${outOfStock.size}")
    val byCategory: Map<String, List<Product>> = products.groupBy { it.category }
    for ((category, items) in byCategory) {
        val lead = items.maxByOrNull { it.price }
        println("Категорія $category -> Найдорожчий: ${lead?.name} (\$${lead?.price})")
    }

    fun List<Product>.filterAndTransform(
        predicate: (Product) -> Boolean,
        transform: (Product) -> String
    ): List<String> {
        val result = mutableListOf<String>()
        for (product in this){
            if (predicate(product)){
                result.add(transform(product))
            }
        }
        return result
    }

    val end = products.filterAndTransform({ it.price < 300.0 }) { product ->
        "Акційна ціна на ${product.name}: лише $${product.price}!"
    }

    println(end)
}
