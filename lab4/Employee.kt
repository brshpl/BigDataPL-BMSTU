package lab4


/**
 * Реализовать абстрактные классы или интерфейсы, а также наследование и полиморфизм для следующих классов
 *  3.	interface Сотрудник <- class Инженер <- class Руководитель.
 */


internal interface Employee {
    fun doTask()
    fun getGrade(): String
}

internal abstract class Engineer : Employee {
    override fun doTask() {
        println("Task done.")
    }

    abstract fun solveProblem()
}

internal class Boss : Engineer() {
    override fun getGrade(): String {
        return "25 Grade"
    }

    override fun solveProblem() {
        println("Problem solved")
    }
}
