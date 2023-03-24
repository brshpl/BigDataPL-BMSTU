package lab3

/**
 * Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы setТип(), getТип(), toString().
 * Определить дополнительно методы в классе, создающем массив объектов.
 * Задать критерий выбора данных и вывести эти данные на консоль.
 * 4. Abiturient: id, Фамилия, Имя, Отчество, Адрес, Телефон, Оценки. Создать массив объектов. Вывести:
 * a) список абитуриентов, имеющих неудовлетворительные оценки;
 * b) список абитуриентов, средний балл у которых выше заданного;
 * c) выбрать заданное число n абитуриентов, имеющих самый высокий средний балл
 * (вывести также полный список абитуриентов, имеющих полупроходной балл).
 */
class Abiturient(
    private var id: Int,
    private var surname: String,
    private var firstName: String,
    private var patronymic: String,
    private var address: String,
    private var phone: String,
    private var grades: List<Int>
) {
    fun setId(id: Int) {
        this.id = id
    }

    fun setSurname(surname: String) {
        this.surname = surname
    }

    fun setFirstName(firstName: String) {
        this.firstName = firstName
    }

    fun setPatronymic(patronymic: String) {
        this.patronymic = patronymic
    }

    fun setAddress(address: String) {
        this.address = address
    }

    fun setPhone(phone: String) {
        this.phone = phone
    }

    fun setGrades(grades: List<Int>) {
        this.grades = grades
    }

    fun getId(): Int {
        return id
    }

    fun getSurname(): String {
        return surname
    }

    fun getFirstName(): String {
        return firstName
    }

    fun getPatronymic(): String {
        return patronymic
    }

    fun getAddress(): String {
        return address
    }

    fun getPhone(): String {
        return phone
    }

    fun getGrades(): List<Int> {
        return grades
    }

    fun getAverageGrade(): Double {
        return grades.average()
    }

    override fun toString(): String {
        return "Abiturient(id=$id, surname='$surname', firstName='$firstName', patronymic='$patronymic', address='$address', phone='$phone', grades=$grades)"
    }

    companion object {

    }
}

class AbiturArray(var abiturients: Array<Abiturient>) {
    fun filterByUnsatisfactoryGrades(): List<Abiturient> {
        return abiturients.filter { it.getGrades().any { grade -> grade < 3 } }
    }

    fun filterByAverageGradeGreaterThan(average: Double): List<Abiturient> {
        return abiturients.filter { it.getAverageGrade() > average }
    }

    fun getTopNAbiturients(n: Int): List<Abiturient> {
        val semiPassingScore = 3.5
        val sortedAbiturients = abiturients.sortedByDescending { it.getAverageGrade() }
        val topNAbiturients = sortedAbiturients.take(n)
        val semiPassingAbiturients =
            sortedAbiturients.filter { it.getAverageGrade() >= semiPassingScore && it !in topNAbiturients }
        println("Semi-passing abiturients: $semiPassingAbiturients")
        return topNAbiturients
    }
}


fun main() {
    val abit = arrayOf(
        Abiturient(1, "Ivan", "Ivanov", "Ivanovich", "Moscow", "+79999999999", listOf(2, 3, 2, 4, 5)),
        Abiturient(1, "Alex", "Petrov", "Igorevich", "Saint-Petersburg", "+79889999999", listOf(5, 4, 5, 5, 5)),
        Abiturient(1, "Kirill", "Sidorov", "Petrivich", "Voronezh", "+79779999999", listOf(5, 3, 5, 4, 4)),
        Abiturient(1, "Roman", "Lebedev", "Stepanovich", "Rostov", "+79669999999", listOf(4, 5, 2, 4, 5)),
    )

    val abiturs = AbiturArray(abit)
    abiturs.filterByUnsatisfactoryGrades().forEach { println(it.toString()) }
    println("\n")
    abiturs.filterByAverageGradeGreaterThan(3.0).forEach { println(it.toString()) }
    println("\n")
    abiturs.getTopNAbiturients(3).forEach { println(it.toString()) }
}