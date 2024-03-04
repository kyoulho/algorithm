class Solution {
    fun solution(prices: IntArray): IntArray {
        val answer = IntArray(prices.size)
        for (i in prices.indices) {
            for (j in i + 1 until prices.size) {
                answer[i]++
                if (prices[j] < prices[i]) {
                    break
                }
            }
        }
        return answer
    }
}