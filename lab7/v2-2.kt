package lab7

import java.util.*

/***
 * 3. В тексте найти и напечатать n символов (и их количество), встречающихся наиболее часто.
 */
fun main(args: Array<String>) {
    val text = "The quick brown fox jumps over the lazy dog"
    val n = 3
    val freqMap: MutableMap<Char, Int> = HashMap()
    for (c in text.toCharArray()) {
        freqMap[c] = freqMap.getOrDefault(c, 0) + 1
    }
    val pq = PriorityQueue { (key, value): Map.Entry<Char, Int>,
                             (key1, value1): Map.Entry<Char, Int> ->
        if (value != value1)
            value1 - value
        else key.code - key1.code
    }
    pq.addAll(freqMap.entries)
    println("Top $n most frequent characters:")
    var i = 0
    while (i < n && !pq.isEmpty()) {
        val (key, value) = pq.poll()
        println("$key: $value")
        i++
    }
}

