package lab3

/**
 * Определить класс Вектор в R3. Реализовать методы для проверки векторов
 * - на ортогональность,
 * - проверки пересечения не ортогональных векторов,
 * - сравнения векторов.
 * Создать массив из m объектов. Определить, какие из векторов компланарны.
 */
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

fun main() {
    val vectors = arrayOf(
        Vector(1.0, 1.0, 1.0),
        Vector(1.0, 2.0, 0.0),
        Vector(0.0, -1.0, 1.0),
        Vector(3.0, 3.0, 3.0)
    )
    val coplanarSet = Vector.findCoplanar(vectors)
    coplanarSet.forEach { set -> set.forEach { println(it) } }
}
