package programmers.p13226

import java.util.*

class Solution {
    fun solution(n: Int, roads: Array<IntArray>, sources: IntArray, destination: Int): IntArray {
        // 거리 배열, index: 위치
        val distance = IntArray(n + 1) { -1 }
        distance[destination] = 0

        // 인접 리스트
        val graph = Array(n + 1) { mutableListOf<Int>() }
        for (road in roads) {
            graph[road[0]].add(road[1])
            graph[road[1]].add(road[0])
        }
        val queue = LinkedList<Int>()
        queue.add(destination)

        while (queue.isNotEmpty()) {
            val current = queue.poll()
            val neighbors = graph[current]
            for (neighbor in neighbors) {
                // 초기화 상태이면
                if (distance[neighbor] == -1) {
                    distance[neighbor] = distance[current] + 1
                    // 다음
                    queue.add(neighbor)
                }
            }
        }

        return sources.map { distance[it] }.toIntArray()
    }
}