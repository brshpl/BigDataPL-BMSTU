package lab10

import org.apache.spark.sql.Dataset
import org.apache.spark.sql.Row
import org.apache.spark.sql.SparkSession

fun main(args: Array<String>) {
    val spark: SparkSession = SparkSession
        .builder()
        .appName("Java Spark SQL basic example")
        .config("spark.master", "local")
        .getOrCreate()
    val df: Dataset<Row> =
        spark.read().option("header", "true").csv("rotten_tomatoes_movies.csv")
    df.createOrReplaceTempView("rtm")
    // Выбрать все фильмы с рейтингом > 4
    spark.sql("SELECT * FROM rtm WHERE rating = 5 AND tomatoMeter = 100").show()
    // Выбрать все фильмы с рейтингом > 4 и рейтингом критиков > 90
    spark.sql("SELECT * FROM rtm WHERE rating = 5 AND tomatoMeter = 100 AND audienceScore = 100").show()
    // Выбрать все фильмы с жанром "Comedy"
    spark.sql("SELECT * FROM rtm WHERE genre LIKE '%Comedy%'").show()
    // Аггрегировать по жанрам и посчитать количество фильмов в каждом жанре. Сортировать по убыванию
    spark.sql("SELECT genre, COUNT(*) FROM rtm GROUP BY genre ORDER BY COUNT(*) DESC").show()
    // Вывести жанры 10 самых плохих фильмов
    spark.sql("SELECT genre FROM rtm ORDER BY tomatoMeter ASC LIMIT 10").show()
    // Вывести средний рейтинг фильмов по жанрам
    spark.sql("SELECT genre, AVG(tomatoMeter) FROM rtm GROUP BY genre ORDER BY AVG(tomatoMeter) DESC").show()
    // Вывести средний рейтинг фильмов по жанрам, у которых рейтинг критиков > 90
    spark.sql("SELECT genre, AVG(tomatoMeter) FROM rtm WHERE tomatoMeter > 90 GROUP BY genre ORDER BY AVG(tomatoMeter) DESC")
        .show()
    // Вывести количество фильмов по годам (использовать из releaseDateTheaters первые 4 символа)
    spark.sql("SELECT SUBSTRING(releaseDateTheaters, 1, 4) AS year, COUNT(*) FROM rtm GROUP BY year ORDER BY year")
        .show()
    // Вывести года по убыванию среднего рейтинга фильмов
    spark.sql("SELECT SUBSTRING(releaseDateTheaters, 1, 4) AS year, AVG(tomatoMeter) FROM rtm GROUP BY year ORDER BY AVG(tomatoMeter) DESC")
        .show()
    // Вывести количество фильмов по годам и жанрам
    spark.sql("SELECT SUBSTRING(releaseDateTheaters, 1, 4) AS year, genre, COUNT(*) FROM rtm GROUP BY year, genre ORDER BY year, genre")
        .show()
}
