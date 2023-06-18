package lab9

//2.	Задана коллекция строк. Вернуть первый элемент коллекции, а также существуют ли все совпадения с шаблоном.
// Шаблон можно выбрать произвольно.

fun main(args: Array<String>) {
    val list: MutableList<String> = ArrayList()
    list.add("loremol")
    list.add("ipsumol")
    list.add("dolol")
    list.add("molol")
    list.add("colol")
    list.add("sitol")
    list.add("ametol")

    println(list.stream().findFirst().get())

    val pattern = ".*ol"

    println(list.stream().allMatch { s: String ->
        s.matches(
            pattern.toRegex()
        )
    })
}

