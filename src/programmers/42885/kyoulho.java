import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int answer = 0;

        int left = 0;  // 가장 가벼운 사람의 인덱스
        int right = people.length - 1;  // 가장 무거운 사람의 인덱스

        while (left <= right) {
            // 가장 가벼운 사람과 가장 무거운 사람을 함께 태울 수 있을 경우
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            answer++;
        }

        return answer;
    }
}