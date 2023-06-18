package lab5

import kotlin.math.sqrt

// Выполнить задания на основе варианта 1 лабораторной работы 3, контролируя состояние потоков ввода/вывода.
// При возникновении ошибок, связанных с корректностью выполнения математических операций,
// генерировать и обрабатывать исключительные ситуации. Предусмотреть обработку исключений,
// возникающих при нехватке памяти, отсутствии требуемой записи (объекта) в файле, недопустимом значении поля и т.д.
fun main() {
    try {
        val vectors = arrayOf(
            Vector(1.0, 1.0, 1.0),
            Vector(1.0, 2.0, 0.0),
            Vector(0.0, -1.0, 1.0),
            Vector(3.0, 3.0, 3.0)
        )
        val coplanarSet = Vector.findCoplanar(vectors)
        coplanarSet.forEach { set -> set.forEach { println(it) } }

        val matrixArray = arrayOf(
            Matrix(
                3,
                arrayOf(doubleArrayOf(1.0, 2.0, 0.0), doubleArrayOf(4.0, 5.0, 6.0), doubleArrayOf(7.0, 8.0, 9.0))
            ),
            Matrix(3, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0),
            Matrix(3, 1.0, 8.0, 7.0, 6.0, 5.0, 4.0, 3.0, 2.0, 1.0),
        )
        println(Matrix.withSmallestFirstNorm(matrixArray))
        println(Matrix.withSmallestSecondNorm(matrixArray))
    } catch (err: IllegalArgumentException) {
        println("bad arguments: $err")
    }
}

class Vector(private val _x: Double = 0.0, private val _y: Double = 0.0, private val _z: Double = 0.0) {
    /** Возвращает скалярное произведение этого вектора на другой */
    fun dot(other: Vector): Double {
        return _x * other._x + _y * other._y + _z * other._z
    }

    /** Возвращает векторное произведение этого вектора на другой */
    fun cross(other: Vector): Vector {
        val cx = _y * other._z - _z * other._y
        val cy = _z * other._x - _x * other._z
        val cz = _x * other._y - _y * other._x
        return Vector(cx, cy, cz)
    }

    /** Возвращает, является ли этот вектор ортогональным с другим */
    fun isOrthogonal(other: Vector): Boolean {
        return dot(other) == 0.0
    }

    /** Возвращает, пересекаются ли этот вектор и другой */
    fun intersects(other: Vector): Boolean {
        return !cross(other).isEqual(Vector(0.0, 0.0, 0.0))
    }

    /** Возвращает, равны ли этот вектор и другой */
    fun isEqual(other: Vector): Boolean {
        return _x == other._x && _y == other._y && _z == other._z
    }

    /** Возвращает, компланарны ли 3 вектора */
    fun isCoplanarWith(v1: Vector, v2: Vector): Boolean {
        val n = v1.cross(v2)
        return n.dot(this) == 0.0
    }

    override fun toString(): String {
        return "(${_x}, ${_y}, ${_z})"
    }

    companion object {
        /** Возвращает, компланарные вектора */
        fun findCoplanar(vectors: Array<Vector>): ArrayList<Set<Vector>> {
            val arr = ArrayList<Set<Vector>>()
            for (i in 0 until vectors.size - 2) {
                for (j in i + 1 until vectors.size - 1) {
                    val coplanarSet = mutableSetOf<Vector>(vectors[i], vectors[j])
                    for (k in j + 1 until vectors.size) {
                        if (vectors[i].isCoplanarWith(vectors[j], vectors[k]))
                            coplanarSet.add(vectors[k])
                    }
                    arr.add(coplanarSet)
                }
            }
            return removeRepeated(arr)
        }

        private fun removeRepeated(arr: ArrayList<Set<Vector>>): ArrayList<Set<Vector>> {
            for (i in 0 until arr.size - 1) {
                for (j in i + 1 until arr.size) {
                    while (j < arr.size && arr[i].containsAll(arr[j])) {
                        arr.removeAt(j)
                    }
                }
            }
            return arr
        }
    }
}

class Matrix {
    private val n: Int

    constructor(n: Int) {
        // Выбрасываем исключение, если размерность матрицы меньше 1
        require(n >= 0) { "Matrix size must be greater than 0" }
        this.n = n
        this.matrix = Array(n) { DoubleArray(n) }
    }

    private val matrix: Array<DoubleArray>

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
        // Выбрасываем исключение, если размерность матрицы меньше 1
        require(n >= 0) { "Matrix size must be greater than 0" }
        for (i in 0 until n) {
            for (j in 0 until n) {
                matrix[i][j] = values[i][j]
            }
        }
    }

    constructor(n: Int, vararg values: Double) : this(n) {
        // Выбрасываем исключение, если размерность матрицы меньше 1
        require(n >= 0) { "Matrix size must be greater than 0" }
        for (i in 0 until n) {
            for (j in 0 until n) {
                matrix[i][j] = values[i * n + j]
            }
        }
    }

    fun add(other: Matrix): Matrix {
        // Выбрасываем исключение, если размерности матриц не равны
        require(other.n == this.n) { "Matrix size must be equal" }
        val result = Matrix(n)
        for (i in 0 until n) {
            for (j in 0 until n) {
                result.matrix[i][j] = this.matrix[i][j] + other.matrix[i][j]
            }
        }
        return result
    }

    fun subtract(other: Matrix): Matrix {
        // Выбрасываем исключение, если размерности матриц не равны
        require(other.n == this.n) { "Matrix size must be equal" }
        val result = Matrix(n)
        for (i in 0 until n) {
            for (j in 0 until n) {
                result.matrix[i][j] = this.matrix[i][j] - other.matrix[i][j]
            }
        }
        return result
    }

    fun multiply(other: Matrix): Matrix {
        // Выбрасываем исключение, если размерности матриц не равны
        require(other.n == this.n) { "Matrix size must be equal" }
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
