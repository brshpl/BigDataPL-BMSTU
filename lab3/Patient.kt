package lab3

/**
 * Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы setТип(), getТип(), toString().
 * Определить дополнительно методы в классе, создающем массив объектов.
 * Задать критерий выбора данных и вывести эти данные на консоль.
 * 3. Patient: id, Фамилия, Имя, Отчество, Адрес, Телефон, Номер медицинской карты, Диагноз.
 * Создать массив объектов. Вывести:
 * a) список пациентов, имеющих данный диагноз;
 * b) список пациентов, номер медицинской карты у которых находится в заданном интервале.
 */
class Patient(
    private var id: Int,
    private var firstName: String,
    private var lastName: String,
    private var patronymic: String,
    private var address: String,
    private var phoneNumber: String,
    private var medicalCardNumber: Int,
    private var diagnosis: String
) {

    override fun toString(): String {
        return "Patient(id=$id, lastName='$lastName', firstName='$firstName', patronymic='$patronymic', address='$address', phoneNumber='$phoneNumber', medicalCardNumber=$medicalCardNumber, diagnosis='$diagnosis')"
    }

    fun getId(): Int {
        return id
    }

    fun setId(v: Int) {
        this.id = v
    }

    fun getFirstName(): String {
        return firstName
    }

    fun setFirstName(v: String) {
        this.firstName = v
    }

    fun getLastName(): String {
        return lastName
    }

    fun setLastName(v: String) {
        this.lastName = v
    }

    fun getPatronymic(): String {
        return patronymic
    }

    fun setPatronymic(v: String) {
        this.patronymic = v
    }

    fun getAddress(): String {
        return address
    }

    fun setAddress(v: String) {
        this.address = v
    }

    fun getPhoneNumber(): String {
        return phoneNumber
    }

    fun setPhoneNumber(v: String) {
        this.phoneNumber = v
    }

    fun getMedicalCardNumber(): Int {
        return medicalCardNumber
    }

    fun setMedicalCardNumber(v: Int) {
        this.medicalCardNumber = v
    }

    fun getDiagnosis(): String {
        return diagnosis
    }

    fun setDiagnosis(v: String) {
        this.diagnosis = v
    }
}

fun Array<Patient>.filterByDiagnosis(diagnosis: String): Array<Patient> {
    return this.filter { it.getDiagnosis() == diagnosis }.toTypedArray()
}

fun Array<Patient>.filterByMedicalCardNumber(start: Int, end: Int): Array<Patient> {
    return this.filter { it.getMedicalCardNumber() in start..end }.toTypedArray()
}

fun main() {
    val p = arrayOf(
        Patient(1, "Ivan", "Ivanov", "Ivanovich", "Moscow", "+79999999999", 2343, "cancer"),
        Patient(1, "Alex", "Petrov", "Igorevich", "Saint-Petersburg", "+79889999999", 1324, "hiv"),
        Patient(1, "Kirill", "Sidorov", "Petrivich", "Voronezh", "+79779999999", 5234, "lupus"),
        Patient(1, "Roman", "Lebedev", "Stepanovich", "Rostov", "+79669999999", 4576, "undefined"),
    )
    p.filterByDiagnosis("hiv").forEach { println(it.toString()) }
    println("\n")
    p.filterByMedicalCardNumber(4000, 6000).forEach { println(it.toString()) }

}
