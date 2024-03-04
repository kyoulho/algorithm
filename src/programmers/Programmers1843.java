package programmers;

public class Programmers1843 {
    /*
       홀수 인덱스에 연산자가 있다.
       최대 a + b => a 최대, b 최대
       최소 a + b => a 최소, b 최소

       최대 a - b => a 최대, b 최소
       최소 a - b => a 최소, b 최대

       최대 값을 얻기 위해서는 최소 값을 알아야한다.
       범위 별로 최대값, 최소값을 저장하고 트래킹하자.

       dp[1] 은 최대, dp[0]은 최소
     */

    public int solution(String[] arr) {
        int[][][] dp = new int[2][arr.length][arr.length];
        // 하나씩 계산할 때 세팅
        for (int i = 0; i < arr.length; i += 2) {
            dp[0][i][i] = Integer.parseInt(arr[i]);
            dp[1][i][i] = Integer.parseInt(arr[i]);
        }

        // i개 씩 계산한다.
        // numCnt는 arr에 담겨있는 숫자의 개수
        int numCnt = (arr.length + 1) / 2;
        for (int i = 2; i <= numCnt; i++) {

            // 숫자를 왼쪽부터 선택한다.
            // lastIdx는 가장 마지막으로 선택될 숫자의 인덱스
            int lastIdx = arr.length - 2 * (i - 1) - 1;
            for (int leftIdx = 0; leftIdx <= lastIdx; leftIdx += 2) {

                // i개 씩 계산했을 때 마지막 숫자의 인덱스
                int rightIdx = leftIdx + (2 * (i - 1));
                // leftIdx 부터 rightIdx까지 계산했을 때 최대값, 최소값
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;

                // leftIdx ~ rightIdx 에서 연산자를 순회하며 최대, 최소 구하기
                for (int operatorIdx = leftIdx + 1; operatorIdx < rightIdx; operatorIdx += 2) {
                    String operator = arr[operatorIdx];

                    if (operator.equals("+")) {
                        max = Math.max(max, dp[0][leftIdx][operatorIdx - 1] + dp[0][operatorIdx + 1][rightIdx]);
                        min = Math.min(min, dp[1][leftIdx][operatorIdx - 1] + dp[1][operatorIdx + 1][rightIdx]);
                    } else if (operator.equals("-")) {
                        max = Math.max(max, dp[0][leftIdx][operatorIdx - 1] - dp[1][operatorIdx + 1][rightIdx]);
                        min = Math.min(min, dp[1][leftIdx][operatorIdx - 1] - dp[0][operatorIdx + 1][rightIdx]);
                    }
                }

                dp[0][leftIdx][rightIdx] = max;
                dp[1][leftIdx][rightIdx] = min;
            }
        }

        return dp[0][0][arr.length - 1];
    }
}