package lab9

//3.	Задана коллекция чисел. Вернуть сумму нечетных чисел.

fun main(args: Array<String>) {
    val list: MutableList<Int> = ArrayList()
    list.add(5)
    list.add(10)
    list.add(3)
    list.add(8)
    list.add(12)

    println(list.stream()
        .filter { n: Int -> n % 2 != 0 }
        .mapToInt { obj: Int -> obj }
        .sum())
}


