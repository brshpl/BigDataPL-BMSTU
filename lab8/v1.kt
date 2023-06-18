package lab8

import java.util.concurrent.Semaphore

/***
 * 2. Реализовать многопоточное приложение “Робот”. Надо написать робота, который умеет ходить.
 * За движение каждой его ноги отвечает отдельный поток. Шаг выражается в выводе в консоль LEFT или RIGHT.
 */


class Robot {
    private val leftLeg = Semaphore(1)
    private val rightLeg = Semaphore(0)

    @Throws(InterruptedException::class)
    fun walk() {
        val leftLegThread = Thread {
            try {
                while (true) {
                    leftLeg.acquire()
                    println("LEFT")
                    rightLeg.release()
                }
            } catch (e: InterruptedException) {
                Thread.currentThread().interrupt()
            }
        }
        val rightLegThread = Thread {
            try {
                while (true) {
                    rightLeg.acquire()
                    println("RIGHT")
                    leftLeg.release()
                }
            } catch (e: InterruptedException) {
                Thread.currentThread().interrupt()
            }
        }
        leftLegThread.start()
        rightLegThread.start()
        leftLegThread.join()
        rightLegThread.join()
    }
}

fun main() {
    val r = Robot()
    r.walk()
}

