package lab5

import lab3.Abiturient
import lab3.Patient

// Выполнить задания из варианта 2 лабораторной работы 3,
// реализуя собственные обработчики исключений и исключения ввода/вывода.
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
        require(v > 0) { "ID must be greater than 0" }
        this.id = v
    }

    fun getFirstName(): String {
        return firstName
    }

    fun setFirstName(v: String) {
        require(v != "") { "Name must be not empty" }
        this.firstName = v
    }

    fun getLastName(): String {
        return lastName
    }

    fun setLastName(v: String) {
        require(v != "") { "Name must be not empty" }
        this.lastName = v
    }

    fun getPatronymic(): String {
        return patronymic
    }

    fun setPatronymic(v: String) {
        require(v != "") { "Patronymic must be not empty" }
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
