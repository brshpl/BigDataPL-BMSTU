package lab9

/**
 * Вариант 2. Задача 2.
 * Использовать ТОЛЬКО методы Stream API. Циклов и условий быть не должно.
 * Задана коллекция:
 * (Класс People: имя и возраст)
 * Collection<People> peoples = Arrays.asList(
 * new People("Ivan", 16),
 * new People("Petr", 23),
 * new People("Maria", 42)
 * );
 * Отсортировать по имени в обратном алфавитном порядке.
</People> */
fun main(args: Array<String>) {
    // Объявляем коллекуию пиплов
    val peoples: Collection<People> = listOf(
        People("Ivan", 16),
        People("Petr", 23),
        People("Maria", 42)
    )

    // Сортируем по имени в обратном алфавитном порядке через Stream API
    peoples.stream().sorted { p1: People, p2: People ->
        p2.name.compareTo(
            p1.name
        )
    }.forEach { x: People? -> println(x) }
}

// Класс People
internal class People(val name: String, val age: Int) {

    // Оверрайд для строкового представления объекта
    override fun toString(): String {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}'
    }
}
