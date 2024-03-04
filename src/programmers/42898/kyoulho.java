class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] memo = new int[n + 2][m + 2];

        // 집 세팅
        memo[1][1] = 1;

        // 퍼들 세팅
        for (int[] puddle : puddles) {
            memo[puddle[1]][puddle[0]] = -1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 학교는 항상 오른쪽 아래다.
                // 왼쪽과 위만 신경쓰면 된다.
                if (memo[i][j] == -1) {
                    memo[i][j] = 0;
                } else if (memo[i][j] == 0) {
                    memo[i][j] = (memo[i - 1][j] + memo[i][j - 1]) % 1_000_000_007;
                }
            }
        }
        return memo[n][m];
    }
}