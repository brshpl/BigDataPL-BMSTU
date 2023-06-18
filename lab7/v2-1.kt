package lab7

/***
 * 2. Найти и напечатать, сколько раз повторяется в тексте каждое слово, которое встречается в нем.
 */
fun main(args: Array<String>) {
    val text = "This is a sample text with several words. Here are some more words. And here are some more words."

    val words = text.split("[\\s.,]+".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()

    val wordFreq: MutableMap<String, Int> = HashMap()

    for (word in words) {
        if (wordFreq.containsKey(word)) {
            wordFreq[word] = wordFreq[word]!! + 1
        } else {
            wordFreq[word] = 1
        }
    }

    for ((key, value) in wordFreq) {
        println("$key : $value")
    }
}

