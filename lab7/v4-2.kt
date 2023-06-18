package lab7

import java.util.*

/***
 * 3. Все слова текста рассортировать в порядке убывания их длин,
 * при этом все слова одинаковой длины рассортировать в порядке возрастания в них количества гласных букв.
 */
fun main() {
    val scanner = Scanner(System.`in`)

    print("Enter the text: ")
    val text = scanner.nextLine()

    val words = text.replace("[^a-zA-Z ]".toRegex(), "").lowercase(Locale.getDefault()).split("\\s+".toRegex())
        .dropLastWhile { it.isEmpty() }
        .toTypedArray()

    Arrays.sort(words, Comparator.comparingInt { word: String -> word.length }
        .thenComparing(Comparator.comparingInt { obj: String? -> countVowels(obj!!) }))

    val sortedWords = listOf(*words)
    Collections.reverse(sortedWords)

    println("Sorted words:")
    for (word in sortedWords) {
        println(word)
    }
}

fun countVowels(s: String): Int {
    var count = 0
    for (c in s.toCharArray()) {
        if ("aeiou".indexOf(c) != -1) {
            count++
        }
    }
    return count
}

