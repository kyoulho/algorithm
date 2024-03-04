class Solution {
    private val queue = mutableListOf<Int>()

    fun solution(operations: Array<String>): IntArray {
        for (operation in operations) {
            val split = operation.split(" ")
            val command = split.first()
            val number = split.last().toInt()
            when (command) {
                "I" -> queue.add(number)
                "D" -> when (number) {
                    1 -> queue.remove(queue.maxOrNull())
                    -1 -> queue.remove(queue.minOrNull())
                }
            }
        }
        return intArrayOf(queue.maxOrNull() ?: 0, queue.minOrNull() ?: 0)
    }
}