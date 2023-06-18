package lab7

import java.util.*

/***
 * 2.	Найти наибольшее количество предложений текста, в которых есть одинаковые слова.
 */
fun main(args: Array<String>) {
    val text = ("This is a sample text. It contains multiple sentences. "
            + "Some sentences may contain the same words as others")
    val sentences =
        text.split("[.?!]".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    val wordCounts: MutableMap<String, Int> = HashMap()
    var maxSentenceCount = 0
    for (sentence in sentences) {
        val words =
            sentence.replace("[^a-zA-Z ]".toRegex(), "").lowercase(Locale.getDefault()).split("\\s+".toRegex())
                .dropLastWhile { it.isEmpty() }
                .toTypedArray()
        val uniqueWords: Set<String> =
            HashSet(listOf(*words))
        for (word in uniqueWords) {
            val count = wordCounts.getOrDefault(word, 0) + 1
            wordCounts[word] = count
        }

        val sentenceCount = Collections.max(wordCounts.values)
        if (sentenceCount > maxSentenceCount) {
            maxSentenceCount = sentenceCount
        }
    }
    println("The largest number of sentences with identical words is: $maxSentenceCount")
}


