package lab6

import java.util.*

// 1.	На базе коллекций реализовать структуру хранения чисел с поддержкой следующих операций:
//• добавление/удаление числа;
//• поиск числа, наиболее близкого к заданному (т.е. модуль разницы минимален).
fun main() {
    val storage = NumberStorage()
    storage.add(3)
    storage.add(7)
    storage.add(1)
    storage.add(4)
    storage.add(9)
    println("Numbers in storage: " + storage.getNumbers())
    println("Closest to 6: " + storage.findClosest(6))
    println("Closest to 2: " + storage.findClosest(2))
    println("Closest to 8: " + storage.findClosest(8))
    storage.remove(4)
    println("Numbers in storage after removing 4: " + storage.getNumbers())
}

class NumberStorage {
    private val numbers: MutableList<Int>

    init {
        numbers = ArrayList()
    }

    fun add(number: Int) {
        numbers.add(number)
    }

    fun remove(number: Int) {
        numbers.remove(Integer.valueOf(number))
    }

    fun findClosest(number: Int): Int {
        check(numbers.isNotEmpty()) { "Number storage is empty" }
        var closest = numbers[0]
        var minDiff = Math.abs(closest - number)
        for (i in 1 until numbers.size) {
            val diff = Math.abs(numbers[i] - number)
            if (diff < minDiff) {
                closest = numbers[i]
                minDiff = diff
            }
        }
        return closest
    }

    fun getNumbers(): List<Int> {
        return Collections.unmodifiableList(numbers)
    }
}

