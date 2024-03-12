package programmers.p12911;

public class Solution {
    public int solution(int n) {
        int answer = n + 1;
        while (!isNextNumber(n, answer)) {
            answer++;
        }
        return answer;
    }

    private boolean isNextNumber(int n, int k) {
        String nStr = Integer.toBinaryString(n);
        String kStr = Integer.toBinaryString(k);
        return countOne(nStr) == countOne(kStr);
    }

    private int countOne(String binaryStr) {
        int count = 0;
        for (char c : binaryStr.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }
        return count;
    }
}
