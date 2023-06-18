package lab5

import java.io.*


object e8 {
    /**
     * Вариант 4. Задача 6.
     * При выполнении для вывода результатов создавать
     * новую директорию и файл средствами класса File.
     *
     * 3.	Прочитать текст Java-программы и в каждом слове длиннее двух символов все строчные символы заменить прописными.
     *
     * Из файла удалить все слова, содержащие от трех
     * до пяти символов, но при этом из каждой строки
     * должно быть удалено только максимальное четное
     * количество таких слов.
     */
    @JvmStatic
    fun main(args: Array<String>) {
        // Входной и выходной файлы
        val inputFileName = "lab5/v4-2_in.txt"
        val outputFileName = "lab5/v4-2_out.txt"
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
                val words: Array<String?> = line.split("\\s+".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()

                var outLine = ""
                for (word in words) {
                    if (word != null) {
                        outLine += if (word.length > 2) {
                            word.uppercase()
                        } else {
                            word
                        }
                        outLine += ' '
                    }
                }

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
}