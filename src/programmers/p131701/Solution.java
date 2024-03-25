package programmers.p131701;

import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new TreeSet<>();
        int n = elements.length;
        int[] dp = new int[n];

        // 길이
        for (int i = 1; i <= n; i++) {
            // 시작 인덱스
            for (int j = 0; j < n; j++) {
                int idx = (j + i - 1) % n;
                dp[j] += elements[idx];
                set.add(dp[j]);
            }
        }

        return set.size();
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int solution = T.solution(new int[]{7, 9, 1, 1, 4});
        System.out.println(solution);
    }
}
