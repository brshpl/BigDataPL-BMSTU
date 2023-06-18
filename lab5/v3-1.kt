package lab5

import java.io.BufferedReader
import java.io.FileInputStream
import java.io.IOException
import java.io.InputStreamReader


/**
 * Вариант 3. Задача 2.
 * Требуется ввести последовательность строк из текстового потока и выполнить указанные действия.
 * При этом могут рассматриваться два варианта:
 * - каждая строка состоит из одного слова;
 * - каждая строка состоит из нескольких слов
 *
 * В каждой строке стихотворения Александра Блока найти и заменить заданную подстроку на подстроку иной длины.
 */
fun main(args: Array<String>) {
    val substr1 = "улица, фонарь"
    val substr2 = "проспект, неон"

    val inputFileName = "lab5/v3-1.txt"
    try {
        val reader = BufferedReader(InputStreamReader(FileInputStream(inputFileName), "UTF-8"))
        for (line in reader.lines()) {
            val parts = line.split(substr1)
            if (parts.size == 1) {
                println(line)
                continue
            }
            var newLine = ""
            newLine += parts[0]
            for (part in parts.drop(1)) {
                newLine += substr2 + part
            }
            println(newLine)
        }
        reader.close()
    } catch (e: IOException) {
        println("Error while reading file: " + e.message)
        return
    }
}