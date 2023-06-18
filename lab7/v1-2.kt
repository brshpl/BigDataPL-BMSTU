package lab7

/***
 * 3. В тексте после буквы Р, если она не последняя в слове,
 * ошибочно напечатана буква А вместо О. Внести исправления в текст.
 */
fun main(args: Array<String>) {
    val text = "Part of students pass exam"
    var correctedText = text.replace("pa".toRegex(), "po")
    correctedText = correctedText.replace("Pa".toRegex(), "Po")
    println("Original text: $text")
    println("Corrected text: $correctedText")
}

