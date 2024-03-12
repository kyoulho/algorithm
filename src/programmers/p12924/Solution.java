package programmers.p12924;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + i;
        }

        int left = 1;
        int right = 1;

        while (right <= n) {
            if (dp[right] - dp[left - 1] < n) {
                right++;
            } else if (dp[right] - dp[left - 1] == n) {
                answer++;
                left++;
            } else {
                left++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int solution = T.solution(15);
        System.out.println(solution);
    }
}
