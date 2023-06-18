package lab5

import java.util.*


/**
 * Вариант 3. Задача 3.
 * Требуется ввести последовательность строк из текстового потока и выполнить указанные действия.
 * При этом могут рассматриваться два варианта:
 * - каждая строка состоит из одного слова;
 * - каждая строка состоит из нескольких слов
 *
 * В каждой строке найти слова, начинающиеся с гласной буквы.
 */
val vowels: CharArray = charArrayOf('a', 'o', 'u', 'e', 'i', 'A', 'O', 'U', 'E', 'I')

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    var foundWords = arrayOf<String>()

    var line: String
    while (scanner.nextLine().also { line = it }.isNotEmpty()) {
        val words = line.split("\\s+".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        for (word in words) {
            if (word.first() in vowels) {
                foundWords += word
            }
        }

        println("Words with first vowel letter: ${foundWords.contentToString()}")
        foundWords = arrayOf<String>()
    }
}

