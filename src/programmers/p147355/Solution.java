package programmers.p147355;

public class Solution {
    public int solution(String t, String p) {
        long pValue = Long.parseLong(p);
        int answer = 0;
        for (int i = 0; i <= t.length() - p.length(); i++) {
            long tValue = Long.parseLong(t.substring(i, i + p.length()));
            if (tValue <= pValue)
                answer++;
        }
        return answer;
    }
}
