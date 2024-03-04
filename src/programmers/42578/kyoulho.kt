class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        val frequencyMap = clothes.groupBy { it[1] }.mapValues { it.value.size + 1 }

        return frequencyMap.values.fold(1) { acc, value -> acc * value } - 1
    }
}