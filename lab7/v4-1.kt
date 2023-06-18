package lab7

import java.util.*

/***
 * 2. Ввести текст и список слов. Для каждого слова из заданного списка найти,
 * сколько раз оно встречается в тексте, и рассортировать слова по убыванию количества вхождений.
 *
 * 3. Все слова текста рассортировать в порядке убывания их длин,
 * при этом все слова одинаковой длины рассортировать в порядке возрастания в них количества гласных букв.
 */
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    print("Enter text: ")
    val text = scanner.nextLine().lowercase(Locale.getDefault())

    print("Enter list of words to count (separated by spaces): ")
    val wordsToCount =
        scanner.nextLine().lowercase(Locale.getDefault()).split("\\s+".toRegex()).dropLastWhile { it.isEmpty() }
            .toTypedArray()

    val wordCount: MutableMap<String, Int> = HashMap()
    for (word in wordsToCount) {
        var count = 0
        var index = 0
        while (text.indexOf(word, index).also { index = it } != -1) {
            count++
            index += word.length
        }
        wordCount[word] = count
    }

    val sortedWords: List<Map.Entry<String, Int>> = ArrayList<Map.Entry<String, Int>>(wordCount.entries)
    sortedWords.sortedWith(Collections.reverseOrder(java.util.Map.Entry.comparingByValue<String, Int>()))

    println("Word counts:")
    for ((key, value) in sortedWords) {
        println("$key: $value")
    }
}

