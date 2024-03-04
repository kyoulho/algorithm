import java.util.*

data class Job(val requestTime: Int, val duration: Int)
class Solution {
    fun solution(jobs: Array<IntArray>): Int {
        val toList = jobs.map { Job(it[0], it[1]) }.toList()
        var answer = 0
        var nowTime = 0

        // 소요시간을 기준으로 정렬된 작업 큐
        val workQueue = PriorityQueue<Job>(compareBy { it.duration })
        // 작업 요청 시점을 기준으로 정렬된 큐
        val requestQueue = PriorityQueue<Job>(compareBy { it.requestTime })
            .apply { addAll(toList) }

        while (!requestQueue.isEmpty() || !workQueue.isEmpty()) {
            // 현재 시간에 처리 가능한 작업을 작업 큐에 추가
            while (!requestQueue.isEmpty() && requestQueue.peek().requestTime <= nowTime) {
                workQueue.offer(requestQueue.poll())
            }

            if (workQueue.isEmpty()) {
                // 작업 큐가 비어 있다면 현재 시간을 다음 작업의 요청 시점으로 변경
                nowTime = requestQueue.peek().requestTime
            } else {
                // 가장 짧은 처리 시간을 갖는 작업을 처리
                val job = workQueue.poll()
                answer += nowTime + job.duration - job.requestTime
                nowTime += job.duration
            }
            // 다시 현재 시간을 기준으로 처리 가능한 작업을 확인
        }

        answer /= jobs.size

        return answer
    }
}
