package programmers.p12911;

import static java.lang.Integer.bitCount;

public class Solution {
    public int solution(int n) {
        int answer = n + 1;
        while (!isNextNumber(n, answer)) {
            answer++;
        }
        return answer;
    }

    private boolean isNextNumber(int n, int k) {
        return bitCount(n) == bitCount(k);
    }
}
