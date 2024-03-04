import java.util.*

class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0

        val q: Queue<Pair<Int, Int>> = LinkedList()
        priorities.forEachIndexed { index, priority ->
            q.add(Pair(index, priority))
        }

        while (q.isNotEmpty()) {
            val poll = q.poll()
            if (poll.second < (q.maxByOrNull { it.second }?.second ?: 0)) {
                q.add(poll)
            } else {
                answer++
                if (poll.first == location) break
            }
        }
        return answer
    }

}