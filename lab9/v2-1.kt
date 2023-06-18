package lab9

/**
 * Вариант 2. Задача 1.
 * Использовать ТОЛЬКО методы Stream API. Циклов и условий быть не должно.
 * Задана коллекция строк. Отсортировать значения по алфавиту и убрать повторы.
 */
fun main(args: Array<String>) {
    // Обявляем коллекцию строк
    val list: MutableList<String> = ArrayList()
    list.add("lorem")
    list.add("ipsum")
    list.add("dolor")
    list.add("sit")
    list.add("amet")
    list.add("sit")
    list.add("dolor")
    list.add("dolor")

    // Сортируем значения по алфавиту и убираем повторы
    list.stream().sorted().distinct().forEach { x: String? ->
        println(x)
    }
}
