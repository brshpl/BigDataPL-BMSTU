package lab7

import java.util.*

/***
 * 2. В русском тексте каждую букву заменить ее порядковым номером в алфавите.
 * При выводе в одной строке печатать текст с двумя пробелами между буквами,
 * в следующей строке внизу под каждой буквой печатать ее номер.
 *
 */
fun main(args: Array<String>) {
    val text = "Привет, мир!"
    val textLC = text.lowercase(Locale.getDefault())
    val numbersBuilder = StringBuilder()
    for (element in textLC) {
        if (Character.isLetter(element)) {
            val num = element.code - 'а'.code + 1
            numbersBuilder.append(num).append(" ")
        } else {
            numbersBuilder.append("    ")
        }
    }
    val numbers = numbersBuilder.toString().trim { it <= ' ' }
    println(text.replace("".toRegex(), "  ").trim { it <= ' ' })
    println(numbers) // print the ordinal numbers below each letter
}


