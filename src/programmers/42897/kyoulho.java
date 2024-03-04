import java.util.Arrays;


class Solution {
     /*
        경우1: 처음 집 포함, 마지막 집 제외
        경우2: 처음 집 제외, 마지막 집 포함

        param
        1000, 10, 10, 2000, 30

        dp
        1000, 0, 0, 0
        1000, 1000, 0, 0
        1000, 1000, 1010, 0
        1000, 1000, 1010, 3000

        dp
        10, 0, 0, 0
        10, 10, 0, 0
        10, 10, 2000, 0
        10, 10, 2010, 2010
     */
    public int solution(int[] money) {
        int[] case1 = Arrays.copyOfRange(money, 0, money.length - 1);
        int[] case2 = Arrays.copyOfRange(money, 1, money.length);
        return Math.max(getMaxMoney(case1), getMaxMoney(case2));
    }

    public int getMaxMoney(int[] linearMoney) {
        int[] dp = new int[linearMoney.length];
        // 0번 인덱스까지 최대
        dp[0] = linearMoney[0];
        // 1번 인덱스까지 최대
        dp[1] = Math.max(linearMoney[0], linearMoney[1]);
        // 2번 인덱스부터
        for (int i = 2; i < linearMoney.length; i++) {
            dp[i] = Math.max(linearMoney[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[dp.length - 1];
    }
}