package lab6

import java.util.*


// 2.	Реализовать класс, моделирующий работу N-местной автостоянки.
// Машина подъезжает к определенному месту и едет вправо, пока не встретится свободное место.
// Класс должен поддерживать методы, обслуживающие приезд и отъезд машины.
fun main() {
    val lot = ParkingLot(10)
    val spot1 = lot.park()
    println("Car parked in spot $spot1")
    val spot2 = lot.park()
    println("Car parked in spot $spot2")
    val spot3 = lot.park()
    println("Car parked in spot $spot3")
    lot.leave(spot2)
    println("Car left from spot $spot2")
    val spot4 = lot.park()
    println("Car parked in spot $spot4")
    lot.leave(spot1)
    println("Car left from spot $spot1")
    lot.leave(spot3)
    println("Car left from spot $spot3")
    lot.leave(spot4)
    println("Car left from spot $spot4")
}

class ParkingLot(private val numSpots: Int) {
    private val spots: MutableList<Boolean>

    init {
        spots = ArrayList(Collections.nCopies(numSpots, false))
    }

    fun park(): Int {
        for (i in 0 until numSpots) {
            if (!spots[i]) {
                spots[i] = true
                return i
            }
        }
        return 0
    }

    fun leave(spot: Int) {
        spots[spot] = false
    }
}

