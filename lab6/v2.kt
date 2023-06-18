package lab6

import lab6.PairwiseSum.pairwiseSum


/**
 * Вариант 1. Задача 6.
 * 3. С использованием множества выполнить попарное суммирование произвольного конечного ряда чисел
 * по следующим правилам:
 * на первом этапе суммируются попарно рядом стоящие числа,
 * на втором этапе суммируются результаты первого этапа и т.д.
 * до тех пор, пока не останется одно число.
 */
fun main() {
    val numbers: List<Double> = mutableListOf(1.0, 2.0, 3.0, 4.0, 5.0)
    val result = pairwiseSum(numbers)
    println("Pairwise sum: $result")
}


object PairwiseSum {
    fun pairwiseSum(numbers: List<Double>): Double {
        var numbers = numbers
        while (numbers.size > 1) {
            val newNumbers: MutableList<Double> = mutableListOf()
            val iter = numbers.iterator()

            var a = iter.next()
            while (iter.hasNext()) {
                if (iter.hasNext()) {
                    val b = iter.next()
                    newNumbers.add(a + b)
                    a = b
                }
            }
            numbers = newNumbers
        }
        return numbers.iterator().next()
    }
}

