package lab3

import kotlin.math.sqrt

class Matrix(private val n: Int) {
    private val matrix: Array<DoubleArray> = Array(n) { DoubleArray(n) }

    override fun toString(): String {
        var s = ""
        for (i in 0 until n) {
            for (j in 0 until n) {
                s += "${matrix[i][j].toString()} "
            }
            s += "\n"
        }
        return s
    }

    constructor(n: Int, values: Array<DoubleArray>) : this(n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                matrix[i][j] = values[i][j]
            }
        }
    }

    constructor(n: Int, vararg values: Double) : this(n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                matrix[i][j] = values[i * n + j]
            }
        }
    }

    fun add(other: Matrix): Matrix {
        val result = Matrix(n)
        for (i in 0 until n) {
            for (j in 0 until n) {
                result.matrix[i][j] = this.matrix[i][j] + other.matrix[i][j]
            }
        }
        return result
    }

    fun subtract(other: Matrix): Matrix {
        val result = Matrix(n)
        for (i in 0 until n) {
            for (j in 0 until n) {
                result.matrix[i][j] = this.matrix[i][j] - other.matrix[i][j]
            }
        }
        return result
    }

    fun multiply(other: Matrix): Matrix {
        val result = Matrix(n)
        for (i in 0 until n) {
            for (j in 0 until n) {
                for (k in 0 until n) {
                    result.matrix[i][j] += this.matrix[i][k] * other.matrix[k][j]
                }
            }
        }
        return result
    }

    fun firstNorm(): Double {
        var norm = 0.0
        for (j in 0 until n) {
            var sum = 0.0
            for (i in 0 until n) {
                sum += Math.abs(matrix[i][j])
            }
            norm = Math.max(norm, sum)
        }
        return norm
    }

    fun secondNorm(): Double {
        var sum = 0.0
        for (i in 0 until n) {
            for (j in 0 until n) {
                sum += matrix[i][j] * matrix[i][j]
            }
        }
        return sqrt(sum)
    }

    companion object {
        fun withSmallestFirstNorm(matrixArray: Array<Matrix>): Matrix {
            var smallestNorm = Double.MAX_VALUE
            var matrixWithSmallestNorm = Matrix(0)

            for (matrix in matrixArray) {
                val norm = matrix.firstNorm()

                if (norm < smallestNorm) {
                    smallestNorm = norm
                    matrixWithSmallestNorm = matrix
                }
            }

            return matrixWithSmallestNorm
        }

        fun withSmallestSecondNorm(matrixArray: Array<Matrix>): Matrix {
            var smallestNorm = Double.MAX_VALUE
            var matrixWithSmallestNorm = Matrix(0)

            for (matrix in matrixArray) {
                val norm = matrix.secondNorm()

                if (norm < smallestNorm) {
                    smallestNorm = norm
                    matrixWithSmallestNorm = matrix
                }
            }

            return matrixWithSmallestNorm
        }
    }
}

fun main() {
    val matrixArray = arrayOf(
        Matrix(3, arrayOf(doubleArrayOf(1.0, 2.0, 0.0), doubleArrayOf(4.0, 5.0, 6.0), doubleArrayOf(7.0, 8.0, 9.0))),
        Matrix(3, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0),
        Matrix(3, 1.0, 8.0, 7.0, 6.0, 5.0, 4.0, 3.0, 2.0, 1.0),
    )

    println(Matrix.withSmallestFirstNorm(matrixArray))
    println(Matrix.withSmallestSecondNorm(matrixArray))
}
