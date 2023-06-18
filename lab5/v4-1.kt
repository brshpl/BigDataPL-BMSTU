package lab5

import java.io.*


/**
 * Вариант 4. Задача 2.
 * При выполнении для вывода результатов создавать
 * новую директорию и файл средствами класса File.
 *
 * 2.	Прочитать текст Java-программы и записать в другой файл в обратном порядке символы каждой строки.
 */
fun main(args: Array<String>) {
    // Входной и выходной файлы
    val inputFileName = "lab5/v4-1_in.txt"
    val outputFileName = "lab5/v4-1_out.txt"
    try {
        val inputFile = File(inputFileName)
        val outputFile = File(outputFileName)

        val outputDir = outputFile.parentFile
        if (!outputDir.exists()) {
            outputDir.mkdirs()
        }

        val reader = BufferedReader(FileReader(inputFile))
        val writer = BufferedWriter(FileWriter(outputFile))
        for (line in reader.lines()) {
            val outLine = line.reversed()

            writer.write(outLine)
            writer.write("\n")
        }
        // Закрываем потоки
        reader.close()
        writer.close()
    } catch (e: IOException) {
        e.printStackTrace()
    }
}
