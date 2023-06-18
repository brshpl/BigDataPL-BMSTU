package lab4

/**
 * 3. Создать класс Mobile с внутренним классом,
 * с помощью объектов которого можно хранить информацию о моделях телефонов и их свойствах.
 *
 *
 * Реализовать абстрактные классы или интерфейсы, а также наследование и полиморфизм для следующих классов
 * 3.	interface Сотрудник <- class Инженер <- class Руководитель.
 * 4.	interface Здание <- abstract class Общественное Здание <- class Театр.
 */
class Mobile(
    val models: HashSet<Model> = HashSet(),
) {
    enum class OS(val n: String) {
        ANDROID("Android"),
        IOS("IOS");

        override fun toString(): String {
            return this.n
        }
    }

    fun getOSByName(name: String): OS? {
        return models.firstOrNull() { it.name == name }?.os
    }

    fun getCPUByName(name: String): String? {
        return models.firstOrNull() { it.name == name }?.cpu
    }

    fun getModelsByOS(os: OS): HashSet<Model> {
        return models.filter { it.os == os }.toHashSet()
    }

    inner class Model(
        var brand: String,
        val name: String,
        val os: OS,
        val cpu: String,
    ) {
        init {
            models.add(this)
        }

        override fun toString(): String {
            return "$brand $name: ${os.n} on CPU $cpu"
        }
    }
}

fun main() {
    val mobile = Mobile()
    mobile.Model("Apple", "iPhone 14 Pro MAX", Mobile.OS.IOS, "A16 Bionic")
    mobile.Model("Google", "Pixel 7 Pro", Mobile.OS.ANDROID, "Google Tensor G2")
    mobile.Model("Samsung", "Galaxy S22 Ultra", Mobile.OS.ANDROID, "Snapdragon 8 Gen 1")

    println(mobile.getModelsByOS(Mobile.OS.ANDROID))
}
