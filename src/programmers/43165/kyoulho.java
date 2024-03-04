import java.util.HashMap;
import java.util.Map;

class Solution {
    /*
        numbers 에서 하나씩 빼서 +, - 로 재귀
        마지막 numbers 까지 계산 후에
        target 이 되면 answer++
     */
    int answer = 0;

    public int solution(int[] numbers, int target) {
        DFS(numbers, 0, 0, target);
        return answer;
    }

    private void DFS(int[] numbers, int idx, int result, int target) {
        if (idx == numbers.length) {
            if (result == target) {
                answer++;
            }
        } else {
            DFS(numbers, idx + 1, result + numbers[idx], target);
            DFS(numbers, idx + 1, result - numbers[idx], target);
        }
    }
}