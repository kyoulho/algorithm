import java.util.*;

class Solution {
     public int solution(int N, int number) {
        int answer = -1;

        List<Set<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }

        // N을 i번 반복한 숫자를 만들어서 집합에 추가
        for (int i = 1; i <= 8; i++) {
            int baseNum = Integer.parseInt(String.valueOf(N).repeat(i));
            dp.get(i).add(baseNum);

            // 2번 사용한 숫자를 구하려면
            // 1번 dp와 1번 dp 끼리 연산한다.
            // 4번 사용한 숫자를 구하려면
            // 1번 dp와 3번 dp의 수와 2번 dp와 2번 dp의 연산이 필요하다.
            for (int j = 1; j < i; j++) {
                for (int operand1 : dp.get(j)) {
                    for (int operand2 : dp.get(i - j)) {
                        dp.get(i).add(operand1 + operand2);
                        dp.get(i).add(operand1 - operand2);
                        dp.get(i).add(operand1 * operand2);
                        if (operand2 != 0) {
                            dp.get(i).add(operand1 / operand2);
                        }
                    }
                }
            }

            // 목표 숫자가 집합에 있으면 최솟값 갱신 후 종료
            if (dp.get(i).contains(number)) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}
