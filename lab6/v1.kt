package lab6

import lab6.LeastSquares.findResistance


/**
 * Вариант 1. Задача 2.
 *
 * 2. Списки (стеки, очереди) I(1..n) и U(1..n) содержат
 * результаты n измерений тока и напряжения на неизвестном сопротивлении R.
 * Найти приближенное число R методом наименьших квадратов.
 */
fun main(args: Array<String>) {
    val I: List<Double> = mutableListOf(1.0, 2.0, 3.0, 4.0, 5.0)
    val U: List<Double> = mutableListOf(2.0, 4.0, 6.0, 8.0, 10.0)
    val R = findResistance(I, U)
    println("Resistance: $R")
}


object LeastSquares {
    fun findResistance(I: List<Double>, U: List<Double>): Double {
        val n = I.size
        var sumI = 0.0
        var sumU = 0.0
        var sumIU = 0.0
        var sumI2 = 0.0
        for (i in 0 until n) {
            val iVal = I[i]
            val uVal = U[i]
            sumI += iVal
            sumU += uVal
            sumIU += iVal * uVal
            sumI2 += iVal * iVal
        }
        val denominator = n * sumI2 - sumI * sumI
        if (denominator == 0.0) {
            throw ArithmeticException("Denominator is zero, cannot compute resistance.")
        }
        val numerator = n * sumIU - sumI * sumU
        return numerator / denominator
    }
}
