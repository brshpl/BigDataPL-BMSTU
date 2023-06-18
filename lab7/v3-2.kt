package lab7

import java.util.*

/***
 * 3.	Найти такое слово в первом предложении, которого нет ни в одном из остальных предложений.
 */
fun main(args: Array<String>) {
    val text = ("This is the first sentence. "
            + "This is the second sentence. "
            + "The third sentence is different.")
    val sentences = text.split("\\.\\s+".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    val words = sentences[0].split("\\s+".toRegex()).dropLastWhile { it.isEmpty() }
        .toTypedArray()
    val uniqueWords: MutableSet<String> = HashSet(Arrays.asList(*words))
    for (i in 1 until sentences.size) {
        val sentenceWords = sentences[i].split("\\s+".toRegex()).dropLastWhile { it.isEmpty() }
            .toTypedArray()
        for (word in sentenceWords) {
            if (uniqueWords.contains(word)) {
                uniqueWords.remove(word)
            }
        }
    }
    println("The word that is not in any other sentence is: " + uniqueWords.iterator().next())
}

