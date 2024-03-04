import kotlin.math.ceil

class SolutionKt : Solution {
    override fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = intArrayOf()

        val q = progresses
            .mapIndexed { idx, progress -> (100 - progress.toDouble()) / speeds[idx] }
            .map { ceil(it).toInt() }
            .toMutableList()

        var prev = q.removeAt(0)
        var count = 1

        q.forEach { current ->
                if (prev >= current){
                    count++
                }else{
                    answer = answer.plus(count)
                    count = 1
                    prev = current
                }
            }

        answer = answer.plus(count)
        return answer
    }
}
