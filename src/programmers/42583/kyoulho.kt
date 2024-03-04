class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        val trucks = truck_weights.map {
            Truck(weight = it, bridge_length = bridge_length)
        }.toMutableList()

        val bridgeQueue: MutableList<Truck> = mutableListOf()
        var currentTime = 0

        while (bridgeQueue.isNotEmpty() || trucks.isNotEmpty()) {
            // 하루가 시작된다.
            currentTime++

            // 도착한 트럭을 내린다.
            if (bridgeQueue.firstOrNull()?.isRend() == true) {
                bridgeQueue.removeAt(0)
            }

            // 트럭 하나를 태운다.
            if (trucks.isNotEmpty()) {
                if (bridgeQueue.sumOf { it.weight } + trucks.first().weight <= weight) {
                    val truck = trucks.removeAt(0)
                    bridgeQueue.add(truck)
                }
            }

            // 트럭들 위치를 하나씩 올린다.
            for (truck in bridgeQueue) {
                truck.go()
            }
        }

        return currentTime
    }
}


data class Truck(
    val weight: Int,
    var pos: Int = 0,
    val bridge_length: Int,
) {
    fun go() {
        pos++
    }

    fun isRend(): Boolean {
        return this.pos >= bridge_length
    }

}
