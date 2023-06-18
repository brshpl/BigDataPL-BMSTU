package lab4

/**
 * Реализовать абстрактные классы или интерфейсы, а также наследование и полиморфизм для следующих классов
 *  4.	interface Здание <- abstract class Общественное Здание <- class Театр.
 */

internal interface Building {
    fun addToFavorites()
    fun getInfo(): String
}

internal abstract class PublicPlace : Building {
    override fun addToFavorites() {
        println("Added to favorites")
    }

    abstract fun visit()
}

internal class Theater : PublicPlace() {
    override fun getInfo(): String {
        return "Theater"
    }

    override fun visit() {
        println("Theater visited")
    }
}

